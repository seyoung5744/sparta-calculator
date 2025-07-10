package com.example.lv3;

import com.example.lv3.input.InputProvider;
import com.example.lv3.output.OutputReader;

public class App {

    private final InputProvider input;
    private final OutputReader output;
    private final Calculator calculator;

    public App(InputProvider input, OutputReader output, Calculator calculator) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            try {
                output.println("================");
                output.println("1. 계산기");
                output.println("2. 오래된 계산 결과 제거");
                output.println("3. 계산 목록 조회");
                output.println("4. 프로그램 종료");
                output.println("================");
                output.print("선택 : ");
                String option = input.readInput();

                switch (option) {
                    case "1" -> calculate();
                    case "2" -> calculator.removeResult();
                    case "3" -> {
                        output.println("결과 목록");
                        calculator.printResults();
                    }
                    case "4" -> output.println("프로그램을 종료합니다.");
                    default -> output.println("유효하지 않은 선택지입니다.");
                }

            } catch (Exception e) {
                output.println("오류가 발생했습니다: " + e.getMessage() + "\n");
            }
        }

    }

    private void calculate() {
        output.print("첫 번째 숫자를 입력하세요: ");
        int num1 = Integer.parseInt(input.readNumber());
        output.print("두 번째 숫자를 입력하세요: ");
        int num2 = Integer.parseInt(input.readNumber());

        output.print("사칙연산 기호를 입력하세요: ");
        Operator operator = Operator.fromSymbol(input.readInput());

        int result = calculator.calculate(num1, num2, operator);
        calculator.saveResult(result);
        calculator.saveFormula(num1, num2, operator);

        output.println("계산 결과: " + result);
    }

}

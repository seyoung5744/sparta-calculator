package com.example.lv3;

import com.example.lv3.enums.AppStatus;
import com.example.lv3.enums.Operator;
import com.example.lv3.formatter.ResultFormatter;
import com.example.lv3.history.History;
import com.example.lv3.history.HistoryManager;
import com.example.lv3.input.InputProvider;
import com.example.lv3.output.OutputReader;

import java.util.List;

public class App {

    private final InputProvider input;
    private final OutputReader output;
    private final Calculator<Double> calculator;
    private final HistoryManager<Double, Double> historyManager;

    private AppStatus status = AppStatus.IN_PROGRESS;
    private int historyId = 1;

    public App(InputProvider input, OutputReader output, Calculator<Double> calculator, HistoryManager<Double, Double> historyManager) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
        this.historyManager = historyManager;
    }

    public void run() {
        while (status == AppStatus.IN_PROGRESS) {
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
                    case "1" -> {
                        output.print("첫 번째 숫자를 입력하세요: ");
                        double num1 = Double.parseDouble(input.readNumber());
                        output.print("두 번째 숫자를 입력하세요: ");
                        double num2 = Double.parseDouble(input.readNumber());

                        output.print("사칙연산 기호를 입력하세요: ");
                        Operator operator = Operator.fromSymbol(input.readInput());

                        Double result = calculator.calculate(num1, num2, operator);

                        History<Double, Double> history = new History<>(num1, num2, operator, result, historyId++);
                        historyManager.addHistory(history);

                        output.println("계산 결과: " + ResultFormatter.format(result));

                        output.println("\n===[입력된 결과 값보다 큰 History]===");
                        List<History<Double, Double>> resultGreaterThan = historyManager.getHistoriesWithResultGreaterThan(result);
                        for (History<Double, Double> greaterThan : resultGreaterThan) {
                            output.println(greaterThan.toString());
                        }
                        output.println("\n==================================\n");
                    }
                    case "2" -> historyManager.removeOldHistory();
                    case "3" -> {
                        output.println("결과 목록");
                        List<History<Double, Double>> histories = historyManager.getAllHistories();
                        for (History<Double, Double> history : histories) {
                            output.println(history.toString());
                        }
                    }
                    case "4" -> {
                        output.println("프로그램을 종료합니다.");
                        status = AppStatus.FINISH;
                    }
                    default -> output.println("유효하지 않은 선택지입니다.");
                }

            } catch (Exception e) {
                output.println("오류가 발생했습니다: " + e.getMessage() + "\n");
            }
        }
    }
}

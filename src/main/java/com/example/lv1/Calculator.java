package com.example.lv1;

import java.util.Scanner;

public class Calculator {

    private static final Parser parser = new Parser();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = Integer.parseInt(parser.parseNum(sc.nextLine()));
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = Integer.parseInt(parser.parseNum(sc.nextLine()));

                System.out.print("사칙연산 기호를 입력하세요: ");
                String operator = parser.parseOperation(sc.nextLine());

                int result = switch (operator) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> {
                        if (num2 == 0) {
                            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        }
                        yield num1 / num2;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + operator);
                };

                System.out.println("결과: " + result);

                System.out.println("더 계산하시겠습니까? (Y/N)");
                String isExit = sc.nextLine();
                if (isExit.equalsIgnoreCase("n")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("오류가 발생했습니다: " + e.getMessage() + "\n");
            }
        }

        sc.close();
    }
}

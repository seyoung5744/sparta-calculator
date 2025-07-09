package com.example.lv1;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            sc.nextLine();
            System.out.print("사칙연산 기호를 입력하세요: ");
            String operator = sc.nextLine();
            if (operator.length() > 1) {
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
            }
            System.out.println(num1 + " ," + num2);
            int result = 0;

            switch (operator) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    result = num1 / num2;
                }
            }

            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (Y/N)");
            String isExit = sc.nextLine();
            if (isExit.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}

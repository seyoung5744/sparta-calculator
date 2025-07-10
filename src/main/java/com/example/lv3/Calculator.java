package com.example.lv3;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<String> formula;
    private final List<Integer> results;

    public Calculator() {
        this.formula = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public int calculate(int operand1, int operand2, String operator) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    public void saveFormula(int operand1, int operand2, String operator) {
        String calculationFormula = operand1 + operator + operand2;
        formula.add(calculationFormula);
    }

    public void saveResult(int result) {
        results.add(result);
    }

    public void printResults() {
        for (int i = 0; i < formula.size(); i++) {
            System.out.println(formula.get(i) + " = " + results.get(i));
        }
    }

    public void removeResult() {
        if (results.isEmpty()) {
            System.out.println("계산 결과가 존재하지 않습니다.");
            return;
        }

        formula.remove(0);
        results.remove(0);
    }
}

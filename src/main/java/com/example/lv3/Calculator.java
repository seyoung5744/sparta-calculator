package com.example.lv3;

import com.example.lv3.enums.Operator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<String> formula;
    private final List<Integer> results;

    public Calculator() {
        this.formula = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public int calculate(int operand1, int operand2, Operator operator) {
        return operator.apply(operand1, operand2);
    }

    public void saveFormula(int operand1, int operand2, Operator operator) {
        String calculationFormula = operand1 + " " + operator.getSymbol() + " " + operand2;
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

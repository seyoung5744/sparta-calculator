package com.example.lv3.history;

import com.example.lv3.enums.Operator;
import com.example.lv3.formatter.ResultFormatter;

public class History<T extends Number, R> {

    private final T operand1;
    private final T operand2;
    private final Operator operator;
    private final R result;

    private int id;

    public History(T operand1, T operand2, Operator operator, R result, int id) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.result = result;
        this.id = id;
    }

    public T getOperand1() {
        return operand1;
    }

    public T getOperand2() {
        return operand2;
    }

    public Operator getOperator() {
        return operator;
    }

    public R getResult() {
        return result;
    }

    @Override
    public String toString() {
        return id + ") " + ResultFormatter.format((Double) operand1) + " " + operator.getSymbol() + " " + ResultFormatter.format((Double) operand2) + " = " + ResultFormatter.format((Double) result);
    }
}

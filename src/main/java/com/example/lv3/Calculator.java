package com.example.lv3;

import com.example.lv3.enums.AbstractOperator;

public class Calculator<T extends Number> {

    public T calculate(T operand1, T operand2, AbstractOperator<T> operator) {
        return operator.apply(operand1, operand2);
    }
}

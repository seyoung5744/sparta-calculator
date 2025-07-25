package com.example.lv3.enums;

import com.example.lv3.exception.InvalidOperationInputException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator implements AbstractOperator<Double> {

    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0.0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });


    private final String symbol;
    private final BiFunction<Double, Double, Double> operation;

    Operator(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double apply(Double a, Double b) {
        return operation.apply(a, b);
    }

    public static Operator fromSymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(s -> s.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new InvalidOperationInputException(symbol + "은 유효하지 않은 연산자입니다."));
    }
}

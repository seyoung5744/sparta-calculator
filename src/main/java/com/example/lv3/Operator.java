package com.example.lv3;

import com.example.lv3.exception.InvalidOperationInputException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        return a / b;
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int apply(int a, int b) {
        return operation.apply(a, b);
    }

    public static Operator fromSymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(s -> s.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new InvalidOperationInputException(symbol + "은 유효하지 않은 연산자입니다."));
    }
}

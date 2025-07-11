package com.example.lv3.enums;

public interface AbstractOperator<T extends Number> {
    T apply(T a, T b);
}

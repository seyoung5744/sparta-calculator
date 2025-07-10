package com.example.lv3;

import com.example.lv3.exception.InvalidNumberInputException;
import com.example.lv3.exception.InvalidOperationInputException;

import java.util.regex.Pattern;

public class Parser {
    private static final Pattern OPERATOR_PATTEN = Pattern.compile("[+\\-*/]*");
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    public String parseNum(String input) {
        boolean isNum = NUMERIC_PATTERN.matcher(input).matches();
        if (!isNum) {
            throw new InvalidNumberInputException("숫자가 아닙니다.");
        }

        return input;
    }

    public String parseOperation(String input) {
        boolean isOperation = OPERATOR_PATTEN.matcher(input).matches();
        if (!isOperation) {
            throw new InvalidOperationInputException("유효하지 않은 연산자입니다.");
        }

        return input;
    }
}

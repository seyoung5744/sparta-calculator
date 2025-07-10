package com.example.lv2.input;

import com.example.lv2.Parser;
import com.example.lv2.exception.InvalidNumberInputException;
import com.example.lv2.exception.InvalidOperationInputException;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {

    private final Scanner scanner;
    private final Parser parser;

    public ConsoleInputProvider(Parser parser) {
        this.scanner = new Scanner(System.in);
        this.parser = parser;
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }

    @Override
    public String readNumber() {
        while (true) {
            try {
                return parser.parseNum(scanner.nextLine());
            } catch (InvalidNumberInputException e) {
                throw new InvalidNumberInputException("InvalidNumberInputException: " + e.getMessage() + "\n");
            }
        }
    }

    @Override
    public String readOperation() {
        while (true) {
            try {
                return parser.parseOperation(scanner.nextLine());
            } catch (InvalidOperationInputException e) {
                throw new InvalidNumberInputException("InvalidOperationInputException: " + e.getMessage() + "\n");
            }
        }
    }
}

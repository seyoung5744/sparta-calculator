package com.example.lv3.input;

import com.example.lv3.Parser;
import com.example.lv3.exception.InvalidNumberInputException;
import com.example.lv3.exception.InvalidOperationInputException;

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
                String input = scanner.nextLine();
                return parser.parseNum(input);
            } catch (InvalidNumberInputException e) {
                throw new InvalidNumberInputException("InvalidNumberInputException: " + e.getMessage() + "\n");
            }
        }
    }

    @Override
    public String readOperation() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return parser.parseOperation(input);
            } catch (InvalidOperationInputException e) {
                throw new InvalidNumberInputException("InvalidOperationInputException: " + e.getMessage() + "\n");
            }
        }
    }
}

package com.example.lv2;

import com.example.lv2.input.ConsoleInputProvider;
import com.example.lv2.output.ConsoleOutputReader;

public class Main {

    public static void main(String[] args) {
        App app = new App(
                new ConsoleInputProvider(new Parser()),
                new ConsoleOutputReader(),
                new Calculator()
        );
        app.run();
    }
}

package com.example.lv3;

import com.example.lv3.input.ConsoleInputProvider;
import com.example.lv3.output.ConsoleOutputReader;

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

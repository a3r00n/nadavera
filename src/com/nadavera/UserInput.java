package com.nadavera;

import java.util.Scanner;
import java.util.Arrays;

public class UserInput {
    final private Scanner scanner = new Scanner(System.in);

    private String getString(String prompt) {
        System.out.print(prompt + ' ');
        return this.scanner.nextLine();
    }

    private Integer getInteger(String prompt) {
        final String rawInput = this.getString(prompt);
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException _) {
            System.out.println("Not a valid integer.");
            return 0;
        }
    }

    private Float getFloat(String prompt) {
        final String rawInput = this.getString(prompt);
        try {
            return Float.parseFloat(rawInput);
        } catch (NumberFormatException _) {
            System.out.println("Not a valid float.");
            return 0f;
        }
    }

    public boolean getBool(String prompt, String[] trueCondition) {
        final String rawInput = this.getString(prompt);
        return Arrays.asList(trueCondition).contains(rawInput);
    }

    @SuppressWarnings("unchecked")
    public <T> T getInput(String prompt, InputType type) {
        switch (type) {
            case STRING:
                return (T) this.getString(prompt);
            case INTEGER:
                return (T) this.getInteger(prompt);
            case FLOAT:
                return (T) this.getFloat(prompt);
        }
        return null;
    }

    public void close() {
        this.scanner.close();
    }
}

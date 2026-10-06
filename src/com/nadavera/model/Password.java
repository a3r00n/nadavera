package com.nadavera.model;

import java.util.Random;
import java.util.stream.Stream;

public class Password {
    private String lowercase = "",
            uppercase = "",
            numbers = "",
            symbols = "";

    private int length = 10;
    private static final Random random = new Random();

    public Password() {
        for (char c = 'a'; c <= 'z'; c++) {
            lowercase += c;
            uppercase += Character.toUpperCase(c);
        }
        numbers = "0123456789";
        symbols = "!@#$%^&*()_+-=";
    }

    public void onlyChars(String validChars) {
        lowercase = "";
        uppercase = "";
        numbers = "";
        symbols = "";
        validChars.chars().forEach(c -> {
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c))
                    lowercase += (char) c;
                else
                    uppercase += (char) c;
            } else if (Character.isDigit(c)) {
                numbers += (char) c;
            } else {
                symbols += (char) c;
            }
        });
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String generate() {
        final String[] validChars = Stream.of(
                lowercase,
                uppercase,
                numbers,
                symbols).filter(s -> !s.isEmpty()).toArray(String[]::new);
        String password = "";
        for (int i = 0; i < length; i++) {
            final String chars = validChars[random.nextInt(validChars.length)];
            password += chars.charAt(random.nextInt(chars.length()));
        }
        return password;
    }
}

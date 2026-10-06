package com.nadavera;

import java.util.stream.IntStream;
import com.nadavera.model.Password;

public class Main {
    public static void main(String[] args) {
        final Password password = new Password();
        int times = 1;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-only":
                    if (i + 1 < args.length)
                        password.onlyChars(args[++i]);
                    break;
                case "-length":
                    if (i + 1 < args.length)
                        password.setLength(
                                Integer.parseInt(args[++i]));
                    break;
                case "-times":
                    if (i + 1 < args.length)
                        times = Integer.parseInt(args[++i]);
                    break;
            }
        }
        System.out.println("[\tPassword Generated\t]\n" + String.join("\n",
                IntStream.range(0, times)
                        .mapToObj(i -> " => " + password.generate())
                        .toList()));
    }
}

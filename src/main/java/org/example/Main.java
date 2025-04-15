package org.example;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    // Create a logger
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        int x = 10;
        int y = 2;
        int result = x / y;
        // Log the result using the logger with built-in formatting
        logger.log(Level.INFO, () -> "Result: " + result);

        System.out.println("Result: " + result);


    }
}


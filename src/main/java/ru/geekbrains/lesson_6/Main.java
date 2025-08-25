package ru.geekbrains.lesson_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        UncheckedEx uncheckedEx = new UncheckedEx();
        Cat cat = null;

        try {
            generateFileNotFoundEx("/path/to/Exception");  // Структура не оптимальная, создана в виде эксперимента
        }
        catch (FileNotFoundException ex0) {
            System.out.println("FileNotFoundException");
            try {
                uncheckedEx.generateArithneticEx(5);
            }
            catch (ArithmeticException ex1) {
                System.out.println("ArithmeticException");
                try {
                    uncheckedEx.generateArrayEx(5);
                }
                catch (ArrayIndexOutOfBoundsException ex2) {
                    System.out.println("ArrayIndexOutOfBoundsException");
                    try {
                        uncheckedEx.generateArrayEx(-5);
                    }
                    catch (NegativeArraySizeException ex3) {
                        System.out.println("NegativeArraySizeException");
                        try {
                            uncheckedEx.generateClassCastEx();
                        }
                        catch (ClassCastException ex4) {
                            System.out.println("ClassCastException");
                            try {
                                uncheckedEx.generateNullPointerEx();
                            }
                            catch (NullPointerException ex5) {
                                System.out.println("NullPointerException");
                                try {
                                    uncheckedEx.generateNumberFormatEx();
                                }
                                catch (NumberFormatException ex6) {
                                    System.out.println("NumberFormatException");
                                    if (cat == null) {
                                        try {
                                            throw new NullPointerException ("Cat does not exist!");
                                        }
                                        catch (NullPointerException ex7) {
                                            System.out.println("Cat does not exist!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        finally {
            System.out.println("\nFinally, we are here!");
        }
    }

    // Checked Exception

    public static FileReader generateFileNotFoundEx (String path) throws FileNotFoundException {
        return new FileReader(new File(path));
    }
}

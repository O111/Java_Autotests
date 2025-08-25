package ru.geekbrains.lesson_6;

public class UncheckedEx {

    public int generateArithneticEx (int a) throws ArithmeticException {
        return a / 0;
    }

    public int generateArrayEx (int a) throws ArrayIndexOutOfBoundsException, NegativeArraySizeException {
        int[] b = new int[a];
        return b[a + 1];
    }

    public String generateClassCastEx () throws ClassCastException {
        Object object = 1;
        return (String) object;
    }

    public int generateNullPointerEx () throws  NullPointerException {
        Object object = null;
        return object.hashCode();
    }

    public int generateNumberFormatEx () throws NumberFormatException {
        String string = "исключение";
        return Integer.parseInt(string);
    }
}

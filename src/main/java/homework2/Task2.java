package homework2;

public class Task2 {
    public static void main(String[] args) {
        /* Если необходимо, исправьте данный код:

        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

        */

        // Исправленный вариант:
        // добавлено объявление массива и ошибку деления на 0 проверяем через if
        int d = 0;
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};

        if (d != 0) {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } else {
            System.out.println("Ошибка: деление на ноль.");
        }

    }
}

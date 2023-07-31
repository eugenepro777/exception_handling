package homework2;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        // используем первый метод
        float number = getFloatNumber();
        System.out.println("Вы ввели число: " + number);

        // используем второй метод
        float number2 = getFloatNumber2();
        System.out.println("Вы ввели число: " + number2);

    }

    /*
    * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    *  и возвращает введенное значение.
    *  Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
    *  необходимо повторно запросить у пользователя ввод данных.
    * */

//    используем проверку на регулярное выражение (также и для отрицательных чисел)
    public static float getFloatNumber(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите любое дробное число (через точку): ");
            String inputValue = scanner.nextLine();
            if (inputValue.matches("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))")){
                float result = Float.parseFloat(inputValue);
                return result;
            } else {
                System.out.println("Некорректный ввод. Введите дробное число.");
            }
        }
    }

// используем блок try - catch
    public static float getFloatNumber2() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите любое дробное число: ");
            String inputNumber = scanner.nextLine();
            try {
                float result = Float.parseFloat(inputNumber);
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите дробное число.");
            }
        }
    }




}

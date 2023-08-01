package homework2;

import java.util.Scanner;

public class Task4 {

    /*
    * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    *  Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    * */

    public static void main(String[] args) {
        String text = getText();
        System.out.println("Вы ввели следующий текст: " + text);

        // второй метод требует обработки исключения
        String text2;
        try {
            text2 = getText2();
            System.out.println("Вы ввели следующий текст: " + text2);
        } catch (RuntimeException e){
            System.out.println("Некорректный ввод. Пустую строку вводить нельзя.");
        }

    }

    // первый метод, обработка исключения через if
    public static String getText(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите ваш текст: ");
            String inputText = scanner.nextLine();
            if (inputText.length() != 0){
                return inputText;
            } else {
                System.out.println("Некорректный ввод. Пустую строку вводить нельзя.");
            }
        }
    }

    // второй метод выбрасывает исключение
    public static String getText2() throws RuntimeException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваш текст: ");
        String inputText = scanner.nextLine();
        if (inputText.isEmpty()){
            throw new RuntimeException();
        }
        return inputText;
    }
}

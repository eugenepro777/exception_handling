package homework2;

public class Task3 {
    /*
    Дан следующий код, исправьте его там, где требуется:

    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

     */

    // Исправлено:
    // 1. метод printSum(Integer a, Integer b) не должен выбрасывать исключение FileNotFoundException
    // 2. метод main не должен пробрасывать исключения - убрали throws Exception
    // 3. Нужно изменить блок catch:
    // поменять порядок исключений;
    // Throwable лучше изменить на Exception, всё равно Error не отлавливаются и вообще подумать понадобится ли
    // нам отлавливать Exception
    // 4. Продумать код методов, которые будут работать с массивом так, чтобы избежать IndexOutOfBoundsException и
    // NullPointerException, используя if. Так как все они наследники RuntimeException, то есть Unchecked
    // 5. Обработку ArithmeticException сделаем через if
    // 6. Метод printSum(Integer a, Integer b) выбрасывает NullPointerException, но лучше
    //  в метод добавить обработку через if
    // 7. abc[3] = 9; всё-таки зададим индекс правильно, чтобы не раздражала выпадающая ошибка)

    public static void main(String[] args){
            int a = 90;
            int b = 3;
            if (b != 0) {
                int result = a / b;
                System.out.println("Результат деления: " + result);
            } else {
                System.out.println("Ошибка: деление на ноль");
            }
            printSum(23, 234);
        try {
            int[] abc = { 1, 2 };
            abc[1] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b){
        if (a != null && b != null) {
            System.out.println(a + b);
        } else {
            System.out.println("Ошибка: один из операндов равен null");
        }

    }



}

package homework3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputConsoleReader implements InputReader {

    private Scanner scanner;

    public InputConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Person readPersonData() throws InvalidDataException {
        while (true) {
            System.out.println("Введите данные в следующем порядке, разделяя их пробелом: " +
                    "Фамилия Имя Отчество Дата рождения (dd.mm.yyyy) Номер телефона Пол (f или m)");

            try {
                String input = scanner.nextLine();
                String[] data = input.split(" ");

                if (data.length != 6) {
                    decoder(validateLengthData(data));
                    throw new InvalidDataException("Введено неверное количество данных");
                }
                if (!data[0].matches("^\\p{L}+$") || !data[1].matches("^\\p{L}+$")) {
                    throw new ParseException("Фамилия и имя должны состоять из символов алфавита");
                }

                LocalDate dateOfBirth = validateDateOfBirth(data[3]);
                long phoneNumber = validatePhoneNumberFormat(data[4]);
                Gender gender = validateGender(data[5]);

                return new Person(data[0], data[1], data[2], dateOfBirth, phoneNumber, gender);
            } catch (ParseException | NumberFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private Gender validateGender(String gender) throws ParseException {
        if (gender.equalsIgnoreCase("m")) {
            return Gender.Male;
        } else if (gender.equalsIgnoreCase("f")) {
            return Gender.Female;
        } else {
            throw new ParseException("Неверно задан пол, должно быть f или m");
        }
    }

    private static long validatePhoneNumberFormat(String phoneStr) throws ParseException {
        if (!phoneStr.matches("[0-9]+")) {
            throw new ParseException("Неверный формат номера телефона");
        } else if (phoneStr.length() < 2) {
            throw new ParseException("Количество цифр номера должно быть не меньше двух");
        }
        return Long.parseLong(phoneStr);

    }

    private LocalDate validateDateOfBirth(String dateOfBirth) throws ParseException {
        try {
            return LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new ParseException("Неверный формат даты рождения");
        }
    }

    private static int validateLengthData(String[] array) {
        int minLength = 6;

        if (array.length < minLength) {
            return -1;
        }
        if (array.length > minLength) {
            return -2;
        }
        return array.length;
    }

    static void decoder(int code) {
        switch (code) {
            case -1 -> System.out.println("Введено меньшее количество полей");
            case -2 -> System.out.println("Введено большее количество полей");
            default -> System.out.println();
        }
    }
}

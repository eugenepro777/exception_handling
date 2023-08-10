package homework3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class PersonDataWriter implements PersonFileWriter {
    @Override
    public void writeData(Person personData) throws WriteInFileException {
        String fileName = personData.getLastName() + ".txt";
        StringBuilder builder = new StringBuilder();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            builder.append(personData.getLastName()).append(" ");
            builder.append(personData.getFirstName()).append(" ");
            builder.append(personData.getPatronomic()).append(", ");
            builder.append(personData.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            builder.append(", ").append(personData.getPhoneNumber());
            builder.append(", ").append(personData.getGender().toString());
            writer.write(builder + "\n");
        } catch (IOException e) {
            throw new WriteInFileException("Ошибка сохранения файла", e);
        }
        System.out.println("Данные успешно записаны в файл: " + fileName);
    }
}


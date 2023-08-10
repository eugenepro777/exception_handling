package homework3;

import java.io.IOException;

public interface PersonFileWriter {

    void writeData(Person personData) throws WriteInFileException;
}

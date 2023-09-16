import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void readFile() throws IOException {
        FileUtil.readFile("D:\\\\a.txt");
    }

    @Test
    void writeFile() throws IOException {
        FileUtil.writeFile("dshjc");
    }
}
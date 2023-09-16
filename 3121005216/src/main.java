import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println(FileUtil.readFile("C:\\a.txt"));
        FileUtil.writeFile("100");
    }
}

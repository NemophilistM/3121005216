import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 此工具类用于读取和写入文件
 */
public class FileUtil {
    /**
     *
     * 该函数为读取文件并返回文件内容字符串，可能抛出文件不存在或内容为空，记得try/catch处理
     *
     * @param filePath 要读取的文件的绝对路径
     * @return 返回该文件的读取到的字符串
     */
    public static String readFile(String filePath) throws IOException {
        //1.读取文件转换为byte数组
        File file=new File(filePath);
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        int size=fileInputStream.available();
        char[] chatBuffer=new char[size];
        isr.read(chatBuffer);
        String stringBuilder = String.valueOf(chatBuffer);
        fileInputStream.close();//记得关闭输入流
        return stringBuilder;
    }

    public static void writeFile(String content) throws IOException {
        File file=new File("D:\\result.txt");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        if(!file.exists()){
            file.createNewFile();
        }
        byte[] contentInBytes = content.getBytes();
        fileOutputStream.write(contentInBytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
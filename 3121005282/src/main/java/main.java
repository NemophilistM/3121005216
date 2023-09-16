import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        //"D:\\a.txt"
        while (true) {
            while (true) {
                String simHash0;
                String simHash1;
                System.out.println("请输入被查询文件1的绝对地址，按回车确定");
                Scanner scanner = new Scanner(System.in);
                try {
                    String str0 = FileUtil.readFile(scanner.next());
                    simHash0 = SimHashUtil.getSimHash(str0);
                } catch (IOException e) {
                    System.out.println("系统找不到指定文件，请检查路径.按回车结束");
                    enterToBreak();
                    break;
                }
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("请输入被查询文件2的绝对地址");
                try {
                    String str1 = FileUtil.readFile(scanner1.next());
                    simHash1 = SimHashUtil.getSimHash(str1);
                } catch (IOException e) {
                    System.out.println("系统找不到指定文件，请检查路径，按回车结束");
                    enterToBreak();
                    break;
                }

                // 由 simHash值求出相似度
                double similarity = SimHashUtil.getSimilarity(simHash0, simHash1);
                System.out.print("两份文件重复率为：");
                System.out.println(similarity);
                try {
                    FileUtil.writeFile(String.valueOf(similarity));
                    System.out.println("结果已写入result文件");
                } catch (IOException e) {
                    //暂时不处理
                }
                System.out.println("程序执行完毕，请按回车");
                enterToBreak();
                clearCmd();
            }
        }
    }

    private static void enterToBreak() {
        Scanner scanner = new Scanner(System.in);
        String ii = scanner.nextLine();
    }

    private static void clearCmd() {
        try {//使用命令的过程可能会出现失败，需要捕获异常
            //   Process process = Runtime.getRuntime().exec("cls");
            new ProcessBuilder("cmd", "/c", "cls")
                    // 将 ProcessBuilder 对象的输出管道和 Java 的进程进行关联，这个函数的返回值也是一个
                    // ProcessBuilder
                    .inheritIO()
                    // 开始执行 ProcessBuilder 中的命令
                    .start()
                    // 等待 ProcessBuilder 中的清屏命令执行完毕
                    // 如果不等待则会出现清屏代码后面的输出被清掉的情况
                    .waitFor(); // 清屏命令
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

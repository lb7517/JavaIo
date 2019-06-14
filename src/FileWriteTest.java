import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {
    public static void main(String args[]){
        String inPath = "C:\\Users\\lb\\Desktop\\my\\1.txt";
        String outPath = "C:\\Users\\lb\\Desktop\\my\\2.txt";
//        t1(inPath, outPath); //通过fileWriter复制
//        t2(outPath); //追加内容
        t3(outPath); //通过fileReader读取
    }

    public static void t1(String inPath, String outPath){
        try {
            FileReader fr = new FileReader(inPath);
            FileWriter fw = new FileWriter(outPath);
            char[] ch = new char[1024];
            int len;
            //方式一
            /*while ((len = fr.read()) != -1){
                fw.write(len);
            }*/

            //方式二
            while ((len = fr.read(ch)) != -1){
                fw.write(ch, 0, len);
            }
            fw.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //追加内容到文件
    public static void t2(String outPath){
        try {
            FileWriter fw = new FileWriter(outPath, true);
            fw.write("\n这是测试用例");
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void t3(String inPath) {
        try {
            FileReader fr = new FileReader(inPath);
            char[] ch = new char[1024];
            int len;
            while((len = fr.read(ch)) != -1){
                System.out.println("-----------");
                System.out.println(new String(ch, 0, len));
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

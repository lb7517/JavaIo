import java.io.*;

public class OutputStreamWriteTest {
    public static void main(String args[]){
        String inPath = "C:\\Users\\lb\\Desktop\\my\\1.txt";
        String outPath = "C:\\Users\\lb\\Desktop\\my\\2.txt";
//        t1(inPath, outPath); //通过字符流复制，注意和字节流复制差别
//        t2(outPath); //向文件写入数据
        t3(outPath); //通过字符流读取文件
    }

    //复制文件
    public static void t1(String inPath, String outPath){
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(inPath));
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outPath));
            int len;
            //方式一
            /*while ((len = isr.read()) != -1){
                osw.write(len);
            }*/

            //方式二
            char[] ch = new char[1024]; //注意和FileInputStream字节流读取的区别，字节是byte[] = new byte[1024]
            while ((len = isr.read(ch)) != -1){
                osw.write(ch, 0, len);
            }
            osw.close();
            isr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向文件写数据
    public static void t2(String outPath){
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outPath, true),
                    "UTF-8");
            //注意和字节流写 osw.write(" I am fine.".getBytes()); 区别
            osw.write(" \n这是测试用例.");
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过字符读取文件
    public static void t3(String outPath){
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(outPath),
                    "utf-8");
            char[] ch = new char[1024];
            int len;
            while ((len = isr.read(ch)) != -1){
                System.out.println(new String(ch, 0, len));
            }
            isr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;

public class BufferedReaderTest {
    public static void main(String args[]){
        String inPath = "C:\\Users\\lb\\Desktop\\my\\1.txt";
        String outPath = "C:\\Users\\lb\\Desktop\\my\\2.txt";
//        String outPath = "C:\\Users\\lb\\Desktop\\test.png";

//        t1(inPath, outPath); // 通过buffered缓存复制
//        t2(outPath); //追加内容
        t3(outPath);  //通过BufferReader读取文件
    }

    //复制
    public static void t1(String inPath, String outPath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(inPath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outPath));
            int len;
            while ((len = br.read()) != -1){
                bw.write(len);
            }
            System.out.println("--------");
            bw.close();
            br.close();
            System.out.println("复制完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //追加
    public static void t2(String outPath){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outPath, true));
            bw.write("这是测试用例");
            System.out.println("--------");
            bw.close();
            System.out.println("复制完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取
    public static void t3(String inPath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(inPath));
            int len;
            char[] ch = new char[1024];
            while((len = br.read(ch)) != -1){
                System.out.println(new String(ch, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

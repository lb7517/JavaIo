import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest {
    public static void main(String args[]){
        String path1 = "C:\\Users\\lb\\Desktop\\my\\1.txt";
        String path2 = "C:\\Users\\lb\\Desktop\\my\\2.txt";
//        t2(path1, path2);  //复制
//        t3(path2);         //会覆盖源文件写
//        t4(path2);         // 不会覆盖源文件写
        t5(path2); //读文件
    }

    //复制 方法一
    public static void t1(String path1, String path2){
        try {
            FileInputStream fis = new FileInputStream(path1);
            FileOutputStream fos = new FileOutputStream(path2);
            int n;
            while ((n = fis.read()) != -1){
                fos.write(n);
            }
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //复制 方法二
    public static void t2(String path1, String path2){
        try {
            FileInputStream fis = new FileInputStream(path1);
            FileOutputStream fos = new FileOutputStream(path2);
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1){
                fos.write(b, 0, len);
            }
            System.out.println("copy完成");
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //会覆盖原来文件内容
    public static void t3(String path2){
        try {
            FileOutputStream fos = new FileOutputStream(path2);
            fos.write(98);  //会覆盖原来文件内容
            fos.write(" I am fine".getBytes());
            System.out.println("t3 写操作结束");
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //写不会覆盖原来文件，在文件后追加
    public static void t4(String path2){
        try {
            FileOutputStream fos = new FileOutputStream(path2, true);//添加true 写不会覆盖
            fos.write(98);
            fos.write(" I am fine".getBytes());
            System.out.println("t4 写操作结束");
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //对文件的读取
    public static void t5(String path2){
        try {
            FileInputStream fis = new FileInputStream(path2);
            int len;
            while ((len = fis.read()) != -1){
                System.out.println((char) len);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

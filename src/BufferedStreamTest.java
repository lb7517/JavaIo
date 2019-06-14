import java.io.*;

public class BufferedStreamTest {
    public static void main(String args[]){
        String inPath = "C:\\Users\\lb\\Desktop\\my\\1.txt";
        String outPath = "C:\\Users\\lb\\Desktop\\my\\2.txt";
//        String outPath = "C:\\Users\\lb\\Desktop\\test.png";

//        t2(inPath, outPath); //复制
//        t3(outPath);//对文件追加
        t4(outPath); // 读取
    }

    //单字节复制
    public static void t1(String inPath, String outPath){
        try {
            FileInputStream fis = new FileInputStream(inPath);
            FileOutputStream fos = new FileOutputStream(outPath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int len;
            while ((len = bis.read()) != -1){
                bos.write(len);
            }
            System.out.println("cpByBuffer1 完成");
            bos.close();
            bis.close();
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //多字节复制
    public static void t2(String inPath, String outPath){
        try {
            FileInputStream fis = new FileInputStream(inPath);
            FileOutputStream fos = new FileOutputStream(outPath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] b = new byte[1024*2];
            int len;
            while ((len = bis.read(b)) != -1){
                bos.write(b, 0, len);
            }
            System.out.println("cpByBuffer2 完成");
            bos.close();
            bis.close();
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //对文件追加
    public static void t3(String outPath){
        try {
            FileOutputStream fos = new FileOutputStream(outPath, true);//true表示末尾追加
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(" I am fine.".getBytes());
            System.out.println("对文件追加 完成");
            bos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取文件
    public static void t4(String outPath){
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(outPath));//true表示末尾追加
            byte[] b = new byte[2048];
            int len;
            while ((len = bis.read(b)) != -1){
                System.out.println(new String(b, 0, len));
            }
            System.out.println("读取结束----");
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

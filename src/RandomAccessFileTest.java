import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String args[]){
        String inPath = "C:\\Users\\lb\\Desktop\\test.mp4";
        String outPath = "C:\\Users\\lb\\Desktop\\下载.mp4";
        t1(inPath, outPath);
    }

    public static void t1(String inPath, String outPath){
        try {
            RandomAccessFile r = new RandomAccessFile(inPath, "r");
            File file = new File(outPath);
            RandomAccessFile w = new RandomAccessFile(outPath, "rw");
            r.seek(file.length());
            w.seek(file.length());
            byte[] b = new byte[100];
            int len;
            while ((len = r.read(b)) != -1){
                w.write(b, 0, len);
            }

            /*r.read(b);
            w.write(b, 0, 100);*/

            System.out.println("---");

            w.close();
            r.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

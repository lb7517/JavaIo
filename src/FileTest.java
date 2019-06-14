import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String args[]) throws IOException {
        File file = new File("C:\\Users\\lb\\Desktop\\my\\child\\my2.txt");

        //创建目录和文件
        /*File f1 = file.getParentFile();
        if(!f1.exists()){
            System.out.println("my 目录不存在，创建");
            f1.mkdirs();
        }
        System.out.println(f1);
        if(!file.exists()){
            System.out.println("my.txt 文件不存在, 创建");
            file.createNewFile();
        }*/

        //删除文件和目录
        /*file.delete();
        File f2 = file.getParentFile();
        f1.delete();*/

        //遍历文件
        /*File f3 = new File("C:\\Users\\lb\\Desktop\\my");
        String[] list = f3.list();
        for(String st: list){
            System.out.println("file: "+st);
        }
        System.out.println("--------------------");

        File[] tmp = f3.listFiles();
        for(File t:tmp){
            System.out.println("name: "+t.getName()+"----"+t.getAbsolutePath());
        }*/

        //递归删除文件
//        String pathName = "C:\\Program Files (x86)\\Internet Explorer";
        String pathName = "C:\\Users\\lb\\Desktop\\my";
        File f4 = new File(pathName);
        deleteRecursionFile(f4);
        f4.delete();
    }

    //递归删除文件
    public static void deleteRecursionFile(File file){
        File[] list = file.listFiles(); //获取当前文件下的所有文件
        for(File tmp:list){
            System.out.println(tmp);
            if(tmp.isFile()){
                boolean result = tmp.delete();
                System.out.println("结果: "+result);
            }else{
                deleteRecursionFile(tmp);
                tmp.delete();
            }
        }
    }
}

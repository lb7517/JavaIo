import java.io.*;

public class ObjectStreamTest {
    public static void main(String args[]){
        String inPath = "C:\\Users\\lb\\Desktop\\my\\1.txt";
        String outPath = "C:\\Users\\lb\\Desktop\\my\\object.txt";
//        t1(outPath); //写入对象
//        t2(outPath); //读取普通对象
//        t3(outPath); // 写Student对象
        t4(outPath); //读取对象
    }

    //写入对象
    public static void t1(String outPath){
        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(outPath));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outPath, true));
            oos.writeInt(11);
            oos.writeObject(new String("对象流测试用例"));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取对象
    public static void t2(String outPath){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(outPath));
            int readInt = ois.readInt();
            Object obj = ois.readObject();
            System.out.println(readInt);
            System.out.println(obj);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //写入一个student对象
    public static void t3(String outPath){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outPath, true));
            oos.writeObject(new Student("测试", 17, "信息1", "信息2"));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取文件对象
    public static void t4(String outPath){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(outPath));
            Student obj = (Student) ois.readObject();
            System.out.println(obj);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

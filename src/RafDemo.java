import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

// RamdomAccessFile
public class RafDemo {
    public static void main(String[] args) throws IOException {
        File demo = new File("src/test");
        if(!demo.exists()){
            demo.mkdir();
        }
        File file = new File(demo, "raf.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
//        System.out.println(randomAccessFile.getFilePointer());
//        randomAccessFile.write('A');
//        randomAccessFile.writeInt(1);
//        int i = 0x7fffffff;
//        randomAccessFile.write(i >>> 24); // 高8位
//        randomAccessFile.write(i >>> 16);
//        randomAccessFile.write(i >>> 8);
//        randomAccessFile.write(i);

        String s = "中";
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
        randomAccessFile.write(s.getBytes());
        //读文件， 必须把指针移到头部
        //一次性把文件内容读到字节数组里
        byte[] buf = new byte[(int)randomAccessFile.length()];
        randomAccessFile.close();
    }
}

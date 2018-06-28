import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 读取文件内容， 按照16进制输出到控制台
// 每输出10个byte换行
public class IOUtil {
    public static void printHex(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while((b = in.read()) != -1) {
            if(b < 0xf) {
                //单位数前面补0
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            if(i++%10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    public static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[20*1024]; // 20K

        // 从in中批量读取字节， 放入到buf这个字节数组中，
        // 从0这个位置开始放， 最多放buf.length个
        // 返回读到的字节的个数

        int bytes = in.read(buf, 0, buf.length); // 一次性读完， 说明字节数组足够大
        int j = 1;
        for(int i = 0; i < bytes; i++) {
            if(buf[i] <= 0xf){
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(buf[i])+" ");
            if(j++%10 == 0) {
                System.out.println();
            }
        }
        in.close();

        //如果一次读不满
        int bytes1 = 0;
        while((bytes1 = in.read(buf, 0, buf.length)) != -1){
            for(int i = 0; i < bytes1; i++) {
                System.out.println(Integer.toHexString(buf[i] & 0xff)+" ");
            }
        }


    }
}

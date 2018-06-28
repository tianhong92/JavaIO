import java.io.UnsupportedEncodingException;

public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "慕课ABC1";
        byte[] byte1 = s.getBytes();
        for(byte b : byte1) {
            // 把字节（转换为int）以16进制的方式显示
            // utf-8中文3个字节， 英文一个字节
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }
        System.out.println();
        byte[] byte2 = s.getBytes("gbk");
        for(byte b : byte2) {
            // gbk中文2个字节， 英文一个字节
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }
        System.out.println();
        //java是双字节编码 utf-16be
        byte[] byte3 = s.getBytes("utf-16be");
        for(byte b : byte3) {
            // utf-16be中英文都是两个字节
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();
        // gbk编码 utf-8解码
        String str = new String(byte2);
        System.out.println(str);
        String str1 = new String(byte2, "gbk");
        System.out.println(str1);

        /*
            文本文件就是  字节序列
            可以是任意编码的字节序列
         */
    }
}

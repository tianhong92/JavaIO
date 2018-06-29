import java.io.*;

public class IsrAndOswDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("src/字节流字符流");
        InputStreamReader isr = new InputStreamReader(in);

        FileOutputStream out = new FileOutputStream("src/dest", true);
        OutputStreamWriter osw = new OutputStreamWriter(out);

        char[] temp = new char[8*1024];
        int size;

        while((size = isr.read(temp, 0, temp.length)) != -1) {
            String str = new String(temp, 0, size);
            System.out.println(str);
            osw.write("\n");
            osw.write(str);
        }
        osw.close();
        isr.close();

    }
}

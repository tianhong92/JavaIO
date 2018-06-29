import java.io.*;

public class FrAndFwDemo {
    public static void main(String[] args) throws IOException {
        File from = new File("src/from.txt");
        if(!from.exists()){
            from.createNewFile();
        }
        FileReader fr = new FileReader(from);
        FileWriter fw = new FileWriter("src/dest");

        char[] buffer = new char[2056];
        int c;
        while((c=fr.read(buffer, 0, buffer.length)) != -1) {
            fw.write(buffer, 0, c);
            fw.flush();
        }
        fr.close();
        fw.close();

    }
}

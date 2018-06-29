import java.io.*;

public class BufRead {
    public static void bufRead(File file, File to) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(to);
            BufferedWriter bw = new BufferedWriter(fw);

            //PrintWriter pw = new PrintWriter(fw);

            String s;
            while((s = br.readLine()) != null) {
                stringBuilder.append(s+"\n");
                bw.write(s);
                bw.newLine();
                bw.flush();
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        //System.out.print(bufRead(new File("src/dest")));
        bufRead(new File("src/dest"), new File("src/from.txt"));
    }
}

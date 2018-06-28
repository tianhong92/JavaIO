import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("src/test");
//        if(!file.exists()){
//            file.mkdir();
//        }
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());

    }
}

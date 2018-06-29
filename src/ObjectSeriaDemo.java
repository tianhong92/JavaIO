import java.io.*;
import java.util.ArrayList;

public class ObjectSeriaDemo {

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("src/test/student.dat");
            ObjectOutputStream out = new ObjectOutputStream(fos);

            FileInputStream fis = new FileInputStream("src/test/student.dat");
            ObjectInputStream in = new ObjectInputStream(fis);

            Student student = new Student("迁就", 121);
            out.writeObject(student);
            out.flush();
            out.close();
            fos.close();

            Student result  = (Student)in.readObject();
            System.out.println(result.getName());
            in.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


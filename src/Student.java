import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
    private transient String name;
    private int age;
    public Student() {

    }
    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
            s.defaultWriteObject(); //把jvm默认序列化的元素进行序列化操作
            s.writeObject(name);  //自己完成name序列化
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject(); //把jvm默认反序列化的元素进行序列化操作
        this.name = (String) s.readObject();
    }
}

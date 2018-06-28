import java.io.File;
import java.io.IOException;

// 列出File的一些常用操作， 比如过滤， 遍历等操作
public class FileUtils {
    /**
     * 列出制定目录下（包括其子目录）等所有文件
     * @param dir
     * @throws IOException
     */
    public static void listDirctory(File dir) throws IOException{
        if(!dir.exists()){
            throw new IllegalArgumentException("目录： "+dir+"不存在.");
    }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录.");
        }
        File[] files = dir.listFiles();
        if(files != null && files.length > 0)
        for(File file : files) {
            if(file.isDirectory()) {
                listDirctory(file);
            } else {
                System.out.println(file);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        listDirctory(new File("src"));
    }

}

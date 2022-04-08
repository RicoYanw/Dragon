import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest03 {
    public static void main(String[] args) {
        FileInputStream fis =null;
        try {
            fis=new FileInputStream("src/tempfile2");
            byte[] bytes =new byte[4];
            while(true){
                int readCount=fis.read(bytes);
                if(readCount == -1){
                    break;
                }
                System.out.print(new String(bytes,0,readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

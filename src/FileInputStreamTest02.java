import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream fis=null;
        try{
            //IDEA默认当前路径为工程Project的根

            fis=new FileInputStream("D:/Desktop/temp.txt");
            byte[] bytes=new byte[4];
            int readCount= fis.read(bytes);
            System.out.println(readCount);  // 4
            System.out.println(new String(bytes,0,readCount));

            readCount = fis.read(bytes);
            System.out.println(readCount);  // 2
            System.out.println(new String(bytes,0,readCount));

            readCount=fis.read(bytes);
            System.out.println(readCount); // -1
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

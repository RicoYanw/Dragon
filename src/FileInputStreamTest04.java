import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest04 {
    /*
    int available():返回流当中剩余的没有读到的字节数量
    long skip(long n):跳过几个字节不读
     */
    public static void main(String[] args) {
        FileInputStream fis=null;
        try {
            fis=new FileInputStream("tempfile");
            System.out.println("总字节数量："+ fis.available());

//            byte[] bytes=new byte[fis.available()]; //不适合大文件
//
//            int readCount=fis.read(bytes); //6
//            System.out.println(new String(bytes)); //abcdef

            //skip跳过几个季节不读取
            fis.skip(3);
            System.out.println(fis.read());

            //System.out.println("剩下多少字节没读："+fis.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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

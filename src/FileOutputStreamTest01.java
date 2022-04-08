import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest01 {
    public static void main(String[] args) {
        FileOutputStream fos=null;
        try {
//            这种方式会将源文件清空，然后重新写入。
//            fos=new FileOutputStream("myfile");

            fos =new FileOutputStream("src/tempfile2",true);
            byte[] bytes={97,98,99,100};
            fos.write(bytes);   //abcd
            fos.write(bytes,0,2); //ab

            String s="我是一个中国人，我骄傲！!";
            //将字符串转成byte数组
            byte[] bs=s.getBytes();
            fos.write(bs);

            //刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

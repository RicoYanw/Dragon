import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest01 {
    /*
    1.文件字节输入流，万能的，任何类型的文件都可以采用这个流来读
    2.字节的方式，完成输入的操作，完成读的操作（硬盘 -->内存）
    3
     */

    public static void main(String[] args) {
        //文件路径 D:\Desktop\temp.txt（自动 \ 变成 \\ ，因为java中 \ 表示转义）
        //"D:/Desktop/temp.txt"也可以

        FileInputStream fis=null;

        try {

            fis=new FileInputStream("D:\\Desktop\\temp.txt");
            int readData=0;
            while((readData= fis.read())!=-1){
                System.out.println(readData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //关闭流的前提是 流不是空
            if(fis !=null){ //避免空指针异常
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        ArrayQueue queue=new ArrayQueue(3);
        char key=' ';
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        //输出一个菜单
        System.out.println("s(show):显示队列");
        System.out.println("e(exit):退出程序");
        System.out.println("a(add):添加数据队列");
        System.out.println("g(get):从队列取出数据");
        System.out.println("h(head):查看队列头的数据");
        while(loop){
            key=sc.next().charAt(0);
            switch (key){
                case 's'://显示所有数据
                    queue.showQueue();
                    break;
                case 'a'://加数据
                    int value=sc.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g'://取出数据
                    try{
                        int res=queue.getQueue();
                        System.out.println("取出的数据是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看头数据
                    try{
                        int res=queue.headQueue();
                        System.out.println("取出的头数据是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列，编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;//表示数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;//指向队列头部，分析出front是指向队列的前一个位置
        rear=-1;//指向队列尾部，指向队列尾的数据(即就是队列的最后一个数据)
    }

    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++;
        arr[rear]=n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否空
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列空，无数据~~");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+'\t');
        }
    }
    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，无数据~~");
        }
        return arr[front+1];
    }
}
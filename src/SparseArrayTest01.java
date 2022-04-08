public class SparseArrayTest01 {
    public static void main(String[] args) {
        //创建一个原视的二为数组11*11
        //0表示没有棋子 1表示黑子 2表示蓝子
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        //输出原始二维数组
        System.out.println("原始二维数组~~");
        for(int[] row1:chessArr1){
            for(int data:row1){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转变为稀疏数组
        int sum=0;
        //遍历二维数组
        for(int i=0;i< 11;i++){
            for(int j=0;j< 11;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //遍历二维数组，将非0值存入到稀疏数组
        int count=0; //记录第几个非0数据
        for(int i=0;i< 11;i++){
            for(int j=0;j< 11;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];

                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~");
        for(int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组恢复为二维数组
        //根据稀疏数组第一行创建二维数组
        int col=sparseArr[0][0];
        int row=sparseArr[0][1];
        int chessArr2[][]=new int[col][row];
        //从稀疏数组第二行开始读取数据赋给二维数组
        for (int i = 1; i <sparseArr.length ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //输出恢复二维数组
        System.out.println();
        System.out.println("恢复后二维数组~~");
        for(int[] row2:chessArr2){
            for(int data:row2){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}


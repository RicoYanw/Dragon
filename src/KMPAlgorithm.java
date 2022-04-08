public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1="BBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABD";

        int[] next=kmpNext("ABCDABD");//[0,1,2,0]
        int index=kmpSearch(str1,str2,next);
        System.out.println("index="+index);
    }

    //kmp搜索算法
    public static int kmpSearch(String str1,String str2,int[] next){
        for(int i=0,j=0;i<str1.length();i++){
            while(j>0 && str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    //获取到一个字符串（字串）的部分匹配表
    public static int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next=new int[dest.length()];
        next[0]=0;
        for(int i=1,j=0;i<dest.length();i++){
            //当dest.charAt(i)!=dest.charAt(j),需要从next[j-1]获取新的j
            //直到满足dest.charAt(i)==dest.charAt(j)退出
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j = next[j-1];
            }

            //当dest.charAt(i)==dest.charAt(j)满足时，部分匹配值就+1
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}

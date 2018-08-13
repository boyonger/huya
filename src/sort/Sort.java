package sort;

import java.io.IOException;
//all in small to big
public class Sort {

    //快排
    //xposition表示移动后的比较数位置 i表示xposition跟不上小于他的数的位置 需交换
    public static int slip(int start,int end,int[] numberList){ //从0开始，end结束（不包括end）
        int x=numberList[start];
        int xPosition=start;
        for (int i=start+1;i<end;i++){
            if (numberList[i]<x){
                xPosition++;
                if (i!=xPosition){
                    int mid=numberList[i];
                    numberList[i]=numberList[xPosition];
                    numberList[xPosition]=mid;
                }
            }
        }
        int mid=numberList[start];
        numberList[start]=numberList[xPosition];
        numberList[xPosition]=mid;
        return xPosition;
    }

    public static void quickSort(int start,int end,int[] numberList){
        if (start<end){
            int mid=slip(start,end,numberList);
            quickSort(start,mid,numberList);
            quickSort(mid,end,numberList);
        }
    }

    //megersort small to big
    public static void bubbleSort(int[] numberList){
        for (int i=0;i<numberList.length;i++){
            for (int j=i+1;j<numberList.length;j++){
                if (numberList[i]>numberList[j]){
                    int mid=numberList[i];
                    numberList[i]=numberList[j];
                    numberList[j]=mid;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

    }

}

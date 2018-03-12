/**
 * Description:快速排序
 * Author:acong
 * Date:2018/03/12
 */

public class QuickSort
{
    public static void quickSort(int[] arr, int low, int high)
    {
        //这里要先判断不然就出错了
        if(low>high)
        {
            return;
        }
        //定义两个哨兵和一个基准值
        int i = low;
        int j = high;
        int base = arr[low];
        while (i < j)
        {
            //从右边开始找小于等于base的值
            while(arr[j]>=base && i<j)
            {
                j--;
            }
            //从左边开始找大于base的数
            while (arr[i]<=base && i<j)
            {
                i++;
            }
            //满足条件交换
            if(i<j)
            {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //扫面一趟后交换i位置值和base值
        arr[low] = arr[i];
        arr[i] = base;
        //然后重复上面递归排序左端和右端
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);
    }

    //测试
    public static void main(String[] args)
    {
        int[] testArr={9,2,3,7,5,8,4,7,20,17,23,0};
        quickSort(testArr,0,testArr.length-1);
        for(int value:testArr)
            System.out.println(value);
    }
}

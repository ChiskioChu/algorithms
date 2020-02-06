package Sort;

import java.util.Scanner;

/**
 * @Author:
 */
public class Example {

    public static void bubbleSort(Comparable[] a)
    {   /** 冒泡排序 **/
        int N = a.length;
        if (N <= 1) return;

        for (int i = 0; i < N; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < N - i - 1; ++j) {
                if (less(a[j+1],a[j])) { // 交换
                    exch(a,j,j+1);//一次交换，三次赋值操作
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    public static void insertionSort(Comparable[] a)
    {   /** 插入排序 **/
        int N = a.length;
        if (N <= 1) return;

        for (int i = 1; i < N; ++i) {
            Comparable value = a[i];//一定要先取值
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (less(value,a[j])) {//一定要把j+1下标的值取出来再做比较
                    a[j+1] = a[j];  // 数据移动,每次移动为一次赋值
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }
    public static void selectionSort(Comparable[] a)
    {
        /** 选择排序 **/
        //将a[]按升序排序
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);//一次交换，三次赋值操作
        }
    }
    public static void quickSort(Comparable[] a,int l,int r)
    {
        /** 快速排序
         * 双指针做法
         * l，r为处理的边界
         * **/
        if(l >= r) return;
        Comparable pivot = a[l];
        int i = l - 1;
        int j = r + 1;
        while(i < j){
            do i++; while(less(a[i],pivot));
            do j--; while(less(pivot,a[j]));
            if(i < j) exch(a,i,j);
        }
        quickSort(a,l,j);
        quickSort(a,j+1,r);
    }
    public static void mergeSort(Comparable[] a,int l,int r)
    {
        /** 归并排序
         * l，r为处理的边界
         * **/
        Comparable[] temps = new Comparable[r - l + 1];
        if(l >= r) return;
        //1.确定分界点
        int mid = (l + r) / 2;
        //2.对左右两边进行递归
        mergeSort(a,l,mid);
        mergeSort(a,mid+1,r);
        //3.归并
        int i = l;
        int j = mid + 1;
        int k = 0;
        //比较后放入到temps中
        while(i <= mid && j <= r){
            if(less(a[i],a[j])) temps[k++] = a[i++];
            else temps[k++] = a[j++];
        }
        //多余的按序全部拷贝
        while(i <= mid) temps[k++] = a[i++];
        while(j <= r) temps[k++] = a[j++];

        for(i = l,j = 0;i <= r;i++,j++) a[i] = temps[j];//拷贝
    }
    private static boolean less(Comparable v,Comparable w)
    { return v.compareTo(w) < 0;}
    private static void exch(Comparable[] a,int i,int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t;}
    private static void show(Comparable[] a)
    {   //在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a)
    {   //测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String[] s2 = s1.split(",");
        mergeSort(s2,0,s2.length-1);
        assert isSorted(s2);
        show(s2);
    }
}
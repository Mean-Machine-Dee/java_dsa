package sorting;

import java.util.Arrays;

public class Sorting {

   private static void bubbleSort(int[] arr){
        int n = arr.length;
     for (int i=0; i < n; i++){
         // 4-0-1, 4-1-1, 4-2-1,4-3-1
         for (int j =0; j < n-i-1; j++){
             if(arr[j] > arr[j+1]){
                  int temp = arr[j];
                  arr[j] = arr[j+1];
                  arr[j+1] = temp;
              }
         }
     }
    }

    private static void selectionSort(int[] arr){
       int size = arr.length;
       int temp = 0;
       int minIndex = 0;

       for (int i= 0; i < size-1; i ++){
           minIndex =i;
           for (int j=i+1; j< size; j++){
               if(arr[minIndex] > arr[j]){
                   minIndex = j;
               }
           }
           temp = arr[minIndex];
           arr[minIndex] = arr[i];
           arr[i] = temp;
       }
    }

    private static void insertionSort(int[] arr){
       for (int i=0; i < arr.length; i++){
           int key = arr[i];
           int j = i-1;

           while(j >=0 && arr[j] > key){
               arr[j+1] = arr[j];
               j--;
           }
           arr[j+1] = key;
       }
    }

//    private static void swap



    public static void main(String[] args) {
        int[] arr = {8,7,5,2,10,1,-5,45};
//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

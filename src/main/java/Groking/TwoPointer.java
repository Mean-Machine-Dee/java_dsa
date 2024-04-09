package Groking;

import java.util.Arrays;
import java.util.HashMap;

public class TwoPointer {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 11};
//        bruteForce(arr,6);
        //System.out.println(Arrays.toString(twoSum(arr,6)));
        System.out.println(removeDuplicates(arr));
    }

    //sum target
    public static int[] bruteForce(int[] arr, int target){

        for (int i=0; i < arr.length; i++){
            for (int j=i+1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }


    public static int[] twoSum(int[] arr, int target){
        int left =0;
        int right = arr.length -1;//indexing format
        while(left < right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == target){
                return new int[] { left, right};
            }
            if(target > currentSum){
                left ++;
            }else{
                right--;
            }
        }

        return new int[] {};
    }

    public static int[] twoSumHash(int[] arr, int target){
        //{1, 2, 3, 4, 6};
        HashMap<Integer, Integer> num = new HashMap<>();
        for (int i=0; i < arr.length; i++){
            if(num.containsKey(target-arr[i])){
                return new int[] { num.get(target-arr[i]),i};
            }else{
                num.put(arr[i],i);
            }
        }
        return new int[] {};
    }

    public static int removeDuplicates(int[] arr){
        int nextNoIndex = 1; //2-3, 2-6, 3-6 4-9
        for (int i=1; i < arr.length; i++){
            if(arr[nextNoIndex-1] != arr[i]){
                arr[nextNoIndex] = arr[i];
                nextNoIndex++;
            }

        }
        return nextNoIndex ;
    }
}

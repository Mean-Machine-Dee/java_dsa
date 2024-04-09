package Groking;

import java.util.*;

public class SlidingWindow {

    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
//        int[] arr2 = {3,4,6,2,-1};
//        System.out.println(Arrays.toString(  bruteForce(arr,5)));
//        System.out.println(Arrays.toString(slidingWindow(arr,5)));
//        System.out.println(maxSumSubArray(arr2,3));
//        List<Integer> v = List.of(-4, 3, -9, 0, 4, 1);
//        plusMinus(v);

//        miniMAx(arr2);

        System.out.println(longestDistinctK("araaci",2));
    }

    //find average of k consequtive numbers

    public static double[] bruteForce(int[] arr, int k){
        double[] results = new double[arr.length - k+1];
        for (int i=0; i < arr.length -k+1; i++){ //always loop first five numbers
            double sum = 0;
            for (int j=i; j < i+k; j++){ //take the next 5 numbers from where i is
                sum += arr[j];
            }
            results[i] = sum /k;
        }
        return results;
    }

    public static double[] slidingWindow(int[] arr, int k){
        double[] results = new double[arr.length - k+1];
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd]; //add next element
            //slide the window don't if not size of k
            if(windowEnd >= k -1){
                System.out.println(windowSum + " True : " + windowSum / k + " windowstart " + arr[windowStart] + " end " + arr[windowEnd] );
                results[windowStart] = windowSum / k; //calculate avarage
                windowSum -= arr[windowStart];
                windowStart++;
            }


        }

        return results;
    }

    public static int maxSumSubArray(int[] arr, int k){
        //{3,4,6,2,-1}
        int windowSum =0, maxSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd ++){
            windowSum += arr[windowEnd];
            //don't slide till you hit subarr length so that we can have proper sum
            if(windowEnd >= k-1){ //windowSum =13,12,
                maxSum = Math.max(maxSum, windowSum); //13,
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return  maxSum;
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float x =0,y=0,z = 0;
        int arrLen = arr.size();
        for(int i: arr){
            if(i > 0){
                x++;
            }else if(i < 0){
                y++;
            }else{
                z++;
            }
        }

        System.out.println(x + " " + y + " "+z);
        System.out.println(x/arrLen);
        System.out.println(y/arrLen);
        System.out.println(z/arrLen);


    }

    public static void miniMAx(int[] arr){
        System.out.println("minmax");
        //3,4,6,2,-1
        long[] temp = new long[arr.length];
        long sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }

        for(int i = 0; i < arr.length; i++){
            temp[i] = sum - arr[i];
        }

        long min = temp[0];
        long max = temp[0];
        for(int k=1;k<arr.length;k++){
            if(temp[k]<min){
                min=temp[k];
            }
            if(temp[k]>max){
                max=temp[k];
            }
        }
        System.out.print(min + " " + max);
    }

    public static int longestDistinctK(String srt, int k){
        if(srt == null || srt.length() == 0 || srt.length() < k)
            throw new IllegalArgumentException();
        int windowStart=0, maxLength=0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int windowEnd=0; windowEnd < srt.length(); windowEnd++){
            char rightChar = srt.charAt(windowEnd);
            frequencyMap.put(rightChar,frequencyMap.getOrDefault(rightChar, 0)+1);
            System.out.println("Frequency and i " + frequencyMap + " " + windowEnd);
            //shrink till we left with k characters
            while(frequencyMap.size() >k){

                char charLeft =srt.charAt(windowStart);
                System.out.println("=========" + charLeft + " " + frequencyMap);
                frequencyMap.put(charLeft,frequencyMap.get(charLeft)-1);
                if(frequencyMap.get(charLeft) == 0){
                    frequencyMap.remove(charLeft);
                }

                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart+1);
        }

        return maxLength;
    }


}

package Groking;

public class AllAlgorithms {

    public static void main(String[] args) {
        int[] nums = { -2,-3,4,-1,-2,1,5,-3};
        int[] arr = {100, 180, 260, 310, 40, 535, 695};

        System.out.println("Dev " + maxProfit(arr, arr.length));
//        System.out.println(bruteForceLargestSum(nums) + " Kadanes " + kadane(nums));
    }

    static int maxProfit(int prices[], int size)
    {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i=0; i < size; i++){
            minPrice = Math.min(minPrice, prices[i]);

            int potential = prices[i] - minPrice;
            maxProfit = Math.max(potential, maxProfit);
            System.out.println("Min is "+ minPrice + " max " + maxProfit);
        }

        return  maxProfit;
//
//        // maxProfit adds up the difference between
//        // adjacent elements if they are in increasing order
//        int maxProfit = 0;
//
//        // The loop starts from 1
//        // as its comparing with the previous
//        for (int i = 1; i < size; i++)
//            if (prices[i] > prices[i - 1])
//                maxProfit += prices[i] - prices[i - 1];
//        return maxProfit;
    }

    public static int removeDuplicates(int[] nums){
        if(nums.length == 0) return 0;

        int nonDupIndex = 1;

        for(int i=1; i< nums.length; i++){

            if(nums[nonDupIndex-1] != nums[i]){
                nums[nonDupIndex] = nums[i];
                nonDupIndex++;
            }
        }

        return nonDupIndex;
    }

    public static String findLongestString(String[] items){
        if(items.length ==0 ) return null;

        int max = Integer.MIN_VALUE, index = 0;
        for (int i=0; i < items.length; i++){
            char[] chars = items[i].toCharArray();
            if(chars.length > max){
                max = chars.length;
                index = i;
            }
        }

        return items[index];
    }

    public static int kadane(int[] nums){
        int size = nums.length;
        
        int maxSoFar = Integer.MIN_VALUE, maxEnding = 0;
        for(int i=0; i < size; i++){
            maxEnding = maxEnding + nums[i];
            if(maxSoFar < maxEnding){
                maxSoFar = maxEnding;
            }
            if(maxEnding < 0){
                maxEnding = 0;
            }


        }


        return  maxSoFar;

    }

    public static int bruteForceLargestSum(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int len = nums.length;
        for( int i=0; i< len; i++){
            int curSum = 0;
            for (int j=i; j <len; j++){
                curSum += nums[j];
                maxSum = Math.max(maxSum, curSum);
            }
        }

        return maxSum;

//        runtime = O(n*2)
    }
}

package Groking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums){

        List<List<Integer>> resultList = new ArrayList<>();

        backTrack(resultList, new ArrayList<>(), nums);
        return  resultList;
    }

    private static void backTrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
        }
        for (int num: nums){

            if(tempList.contains(num)) continue;
            tempList.add(num);
            backTrack(resultList, tempList, nums);
            //remove the element
            tempList.remove(tempList.size()-1);
        }
    }
}

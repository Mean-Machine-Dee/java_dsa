package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.set("nails",450);
        hashTable.set("tiles",450);
        hashTable.set("lumber",200);

        hashTable.printTable();

        System.out.println(hashTable.get("lumber"));
        System.out.println(hashTable.get("bolts"));
        System.out.println(hashTable.keys());

        int[] array1 = {1, 3, 54};
        int[] array2 = {2, 4, 5};
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1, 1,1,1,1};

//        System.out.println(duplicates(nums));

        System.out.println(firstNonRepeatingChar("hello"));
    }
    public static boolean itemInCommon(int[] array1, int[] array2){
        if(array1.length == 0 || array2.length == 0) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i< array1.length;i++ ){
            map.put(array1[i], i);
        }

        for (int i=0; i< array2.length;i++ ){
           if(map.get(array2[i]) != null){
               return true;
           }
        }

        return false;
    }

    public static List<Integer> duplicates(int[] nums){
        List<Integer> ans = new ArrayList<>();
        if(nums.length ==0) return ans;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i: nums){
            if(map.get(i) == null){
                map.put(i,0);
            }else{
               if(!ans.contains(i)){
                   ans.add(i);
               }
            }


        }
        return ans;
    }

    public static Character firstNonRepeatingChar(String str) {
        if (str.isEmpty()) return null;
        Map<Character, Integer> count = new HashMap<>();
        for (char c : str.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c: str.toCharArray()){
            if(count.get(c) == 1){
                return c;
            }
        }
        return null;
    }


    

}

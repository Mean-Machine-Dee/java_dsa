package Groking;

import java.util.*;

public class HackerRank {

    public static void main(String[] args) {

//        List<Integer> arr = Arrays.asList(1,-2,-7,9,1,-8,-5);
//        List<Integer> integers = Arrays.asList(1, 1 ,2);
////        System.out.println( lonelyInteger(integers));;
//        System.out.println(lonely2(integers));
//        System.out.println(" MAx and Min are: " + maxMin(arr));
//        plusMinus(arr);
//        System.out.println(timeConversion("07:05:45PM"));

//        List<String> strings = Arrays.asList("aba",
//                "baba",
//                "aba",
//                "xzxb");
//
//        List<String> queries = Arrays.asList("ab",
//                "aba",
//                "xzxb");
//
//        System.out.println(matchingStrings(strings,queries));
        List<Integer> bob = Arrays.asList(17,28,30);
        List<Integer> alice = Arrays.asList(99,16,8);

//        System.out.println(triplets(bob,alice));

//        System.out.println(Tester(15));

        String[] arr = {"67 78 89", "56 45 57"};
        List<String> m = new ArrayList<>();
        m.add("67 78 89");
        m.add("67 45 57");

        processLogs(m,2);
    }

    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(int i=0; i < logs.size(); i++){
            String[] log = logs.get(i).split(" ");
            System.out.println(log[0] + " " + log[1]);
            System.out.println(map);
            if(map.containsKey(log[0])){
                map.put(log[0],map.get(log[0]) +1);
            }else{
                map.put(log[0],1);
            }
            if(map.containsKey(log[1])){
                map.put(log[1],map.get(log[1]) +1);
            }else{
                map.put(log[1],1);
            }

        }
        System.out.print(map);
        System.out.println("here");

        for(String key: map.keySet()){
            System.out.println(map.get(key));
            if(map.get(key) >= 2){
                System.out.println(key);
                ans.add(key);
            }
        }

        System.out.println(ans);

        return null;

    }



    private static boolean Tester(int n) {



//        for (int i=0; i < arr.length; i++){
//            String[] arf = arr[i].split(" ");
//            System.out.println(arf[0]);
//        }


        return false;
    }


    private static List<Integer> triplets(List<Integer> boob, List<Integer> alice){
//        List<Integer> result = new ArrayList<>(boob.size());
        int bob = 0;
        int al=0;
        for (int i=0; i< boob.size(); i++){
            if(boob.get(i) < alice.get(i)){
                al+=1;
            }else if(Objects.equals(boob.get(i), alice.get(i))){
                continue;
            }else{
                bob+=1;
            }
        }

        return Arrays.asList(bob,al);
    }

    private static int lonely2(List<Integer> nums){

        List<Long> n = Arrays.asList(23L,323232L);
        n.stream().reduce(0L,(f,g)->g+f);
//        return nu.stream().reduce(0,(a,b)->a+b);
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(a +b);

        Collections.sort(nums);
        int unique = nums.get(0);
        for (int i =1; i < nums.size(); i++){

            if(nums.get(i) == unique){
                unique =0;
            }else{
                unique = nums.get(i);
            }


        }


        return unique;
    }

    private static int lonelyInteger(List<Integer> nums) {
      Map<Integer, Integer> freq = new HashMap<>();
      for (int num : nums){
          if(freq.containsKey(num)){
              freq.put(num, freq.get(num) +1);
          }else {
              freq.put(num,1);
          }
      }

      for (Map.Entry<Integer,Integer> entry: freq.entrySet()){
          if(entry.getValue() == 1){
              return entry.getKey();
          }
      }

      return -1;
    }

    private static List<Integer>  matchingStrings(List<String> strings, List<String> queries){
        Map<String, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>(queries.size());
        for (String string: strings){
            if(map.containsKey(string)){
                map.put(string, map.get(string)+1);
            }else{
                map.put(string,1);
            }
        }

        for (int i=0; i < queries.size(); i++){
            String current = queries.get(i);
            if(map.containsKey(current)){
                ans.add(map.get(current));
            }else{
                ans.add(0);
            }
        }

        return ans;
    }

    private static String  timeConversion(String s){

//        12:00:12PM
        if(s.charAt(8) == 'P'){
            String time = s.substring(0,8);
            String[] intervals = time.split(":");
            if(!intervals[0].matches("12")){
                intervals[0] = String.valueOf(Integer.valueOf(intervals[0]) + 12);
            }
            return intervals[0] + ":"+ intervals[1]+":"+ intervals[2];
        }else{
            String time = s.substring(0,8);
            String[] intervals = time.split(":");
            if(intervals[0].matches("12")){
                intervals[0] = "00";
                return intervals[0] + ":"+ intervals[1]+":"+ intervals[2];
            }
            return s.substring(0,8);
        }


    }


    private static void  plusMinus(List<Integer> arr){

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
        System.out.println(x/arrLen);
        System.out.println(y/arrLen);
        System.out.println(z/arrLen);

    }

    private static String maxMin(List<Integer> arr) {


        if(arr.size() < 0) System.out.println(" ");
        int minVal=arr.get(0), maxVal = arr.get(0);
        long sum = 0;

        for (int num: arr){
            if(num < minVal) minVal= num;
            if(num > maxVal ) maxVal = num;
            sum += num;

        }
        System.out.println("max " + maxVal + " " + minVal);
        System.out.println((sum-maxVal) + " " + (sum -minVal) );


        return "me";

        }


}

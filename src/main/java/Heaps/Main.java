package Heaps;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
//        heap.insert(99);
//        heap.insert(72);
//        heap.insert(61);
//        heap.insert(58);
//
//        System.out.println(heap.getHeap());
//
//        heap.insert(100);
//        System.out.println(heap.getHeap());

        int[] arr = {1, 5, 2, 9, 3, 6, 8};
        //2,3,4,5,6,10,10,33,48,53


//        System.out.println(streamMax(arr));

//        System.out.println(kthSmallest(arr,3));

        String[] items = {"flower","flow","flight"};
        System.out.println(longestPref(items));

    }

    //["flower","flow","flight"]
    public static String longestPref(String[] arr){
        int n = arr.length;
        String result = arr[0];
        for (int i=1; i < n; i++){

            while(arr[i].indexOf(result) != 0){ //meaning if they are not a match
                System.out.println(arr[i].indexOf(result) + " current item " + arr[i]  + " indexOF " + result );
                result = result.substring(0, result.length()-1);
                if(result.isEmpty()){
                    return "-1";
                }
                System.out.println(result);
            }
        }

        return result;
    }

    public static List<Integer> streamMax(int[] arr){
        Heap maxHeap = new Heap();
        List<Integer> maxStream = new ArrayList<>();

        for (int num : arr) {
            maxHeap.insert(num);
            maxStream.add(maxHeap.getHeap().get(0));
        }

        return maxStream;
    }


    public static int kthSmallest(int[] arr, int k){
        Heap heap = new Heap();
        for (int j: arr){
            heap.insert(j);
            System.out.println("B: " + heap.getHeap());
            if(heap.getHeap().size() > k){
                heap.remove();
            }
            System.out.println("A: " + heap.getHeap());
        }

        System.out.println(heap.getHeap());

        return heap.getHeap().get(0);
    }



//    public static int kthSmallest(int[] arr, int k){
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
//
////      [6, 4, 2, 1]
//        if(arr.length ==0) return 1;
//        for (int j : arr) {
//            pq.offer(j);
//            System.out.println("Before: " + pq);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//            System.out.println("After: "+ pq);
//        }
//
//        System.out.println(pq);
//
//        return pq.peek();
//    }




}

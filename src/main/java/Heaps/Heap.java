package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Heap {

    private List<Integer> heap;

    public Heap(){
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap(){
        return  new ArrayList<>(heap);
    }

    public int leftChild(int index){
        return 2 * index + 1;
    }

    public int rightChild(int index){
        return 2 * index + 2;
    }

    public int parent(int index){
        return (index -1) / 2;
    }

    public void swap(int a, int b){
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    public void insert( int val){
        //add it to the last
        heap.add(val);
        int current = heap.size() -1;
        while(current > 0 && heap.get(current) > heap.get(parent(current))){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove(){
        if(heap.size() == 0){
            return null;
        }

        if(heap.size() == 1){
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() -1));
        sinkDown(0);
        return maxValue;
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while(true){
            int left = leftChild(index);
            int right = rightChild(index);
            if(left < heap.size() && heap.get(left) > heap.get(maxIndex)){
               maxIndex = left;
            }
            if(right < heap.size() && heap.get(right) > heap.get(maxIndex)){
                maxIndex = right;
            }
            if(maxIndex != index){
                swap(index, maxIndex);
                index = maxIndex;
            }else{
                return;
            }


        }
    }


}

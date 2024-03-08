package Graphs;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void print(){
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex){
        if(adjList.get(vertex) == null){
            adjList.put(vertex, null);
            return true;
        }else{
            return false;
        }
    }

    public boolean addEdge(String vertext1, String vertex2){
        if(adjList.get(vertex2) != null && adjList.get(vertext1) != null){
            adjList.get(vertext1).add(vertex2);
            adjList.get(vertex2).add(vertext1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertext1, String vertex2){
        if(adjList.get(vertex2) != null && adjList.get(vertext1) != null){
            adjList.get(vertext1).remove(vertex2);
            adjList.get(vertex2).remove(vertext1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex){
        if(adjList.get(vertex) == null) return  false;
        for (String otherVertex: adjList.get(vertex)){
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }
}

package day6;

import day5.Computer;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
/*
public class Main {

    public static void DFS(HashMap<String, ArrayList<String>> adjList, HashMap<String, Integer> indexes) {
        int vertices = adjList.size();
        boolean [] visited = new boolean[vertices];
        for (Map.Entry<String, ArrayList<String>> entry : adjList.entrySet()) {
            String source = entry.getKey();
            if(!visited[indexes.get(source)]){
                DFSUtil(source, visited, indexes, adjList);
            }
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    public static void DFSUtil(String source, boolean[] visited, HashMap<String, Integer> indexes, HashMap<String, ArrayList<String>> adjList){

        //mark this visited
        visited[indexes.get(source)] = true;

        System.out.print(source + " ");
        ArrayList<String> list = adjList.get(source);
        for (int i = 0; i <list.size() ; i++) {
            String destination = list.get(i);
            System.out.println(destination);
            if(if(!visited[indexes.get(destination)])
                DFSUtil(destination,visited, indexes,adjList);
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\chewb\\Downloads\\IntelIJ-Projects\\AdventOfCode3\\src\\day6\\input.txt");
            Scanner in = new Scanner(file).useLocale(Locale.US);
            HashMap<String, ArrayList<String>> graph=new HashMap<String, ArrayList<String>>();
            HashMap<String, Integer> indexes = new HashMap<String, Integer>();
            in.useDelimiter("\n");
            int i=0;
            while (in.hasNext()) {
                String[] keyVal = in.next().split("\\)");
                //System.out.println(keyVal[0] + " : " + keyVal[1]);
                if (!graph.containsKey(keyVal[0])) {
                    graph.put(keyVal[0], new ArrayList<String>());
                    indexes.put(keyVal[0], i);
                    i++;
                    graph.get(keyVal[0]).add(keyVal[1]);
                }
                else graph.get(keyVal[0]).add(keyVal[1]);
                //System.out.println(i);
            }
            for(String s : indexes.keySet()) System.out.println(indexes.get(s));
            System.out.println(graph.size());
            int sum=0;
            DFS(graph,indexes);
            //System.out.println(sum);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

*/


package com.company;

import java.util.ArrayList;

public class Node {
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public ArrayList<Node> nodes = new ArrayList<>();
    public final int x, y;

    public Node[] findPath(Node start, Node finish) throws Exception{
        var allPaths = new ArrayList<Node[]>();
        var temp = new ArrayList<Node>();
        temp.add(start);
        RecMove( temp, start, allPaths, finish);
        if (allPaths.size() == 0)
            throw new Exception("Paths not found");
        int bestInd = Integer.MAX_VALUE;
        for (int i = 0; i < allPaths.size(); i++)
            if (allPaths.get(i).length < bestInd)
                bestInd = i;
        return allPaths.get(bestInd);
    }
    private void RecMove(ArrayList<Node> visited, Node current, ArrayList<Node[]> allPaths,
                         Node finish){
        for (Node next: current.nodes) {
            if (!visited.contains(next)){
                if (next == finish){
                    visited.add(next);
                    allPaths.add(visited.toArray(new Node[visited.size()]));
                }
                else{
                    var cloneVisited = (ArrayList<Node>)visited.clone();
                    cloneVisited.add(next);
                    RecMove(cloneVisited, next, allPaths, finish);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}

package com.company;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class Converter {

    public static final char[] notWall = {'f','s','.'};//"fs.";
    public static final char start = 's';
    public static final char finish = 'f';
    public static final char path = '.';
    public static void toNode(char[][] map, Wrapper returnStartFinish){
        Node[][] mapNode = new Node[map.length][];
        for (int v = 0; v < map.length; v++){
            mapNode[v] = new Node[map[v].length];
            for(int h = 0; h < mapNode[v].length; h++){
                mapNode[v][h] = new Node(h, v);
                if (map[v][h] == start)
                    returnStartFinish.item1 = mapNode[v][h];
                else if (map[v][h] == finish)
                    returnStartFinish.item2 = mapNode[v][h];
            }
        }

        for (int v = 0; v < mapNode.length; v++){
            for(int h = 0; h < mapNode[v].length; h++){
                tryAddNeighbour(mapNode, map, h, v, h + 1, v);
                tryAddNeighbour(mapNode, map, h, v, h - 1, v);
                tryAddNeighbour(mapNode, map, h, v, h, v + 1);
                tryAddNeighbour(mapNode, map, h, v, h, v - 1);
            }
        }
    }
    private static void tryAddNeighbour(Node[][] nodeMap, char[][] map, int curX, int curY, int x, int y){
        if (y >= 0 && y < nodeMap.length
                && x >= 0 && x < nodeMap[y].length
                && new String(notWall).contains(Character.toString(map[y][x])))
            nodeMap[curY][curX].nodes.add(nodeMap[y][x]);
    }
}

package com.company;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileWorker {
    public static char[][] readMap(String path) throws Exception{
        File file = new File(path);
        FileReader reader;

        var list = new ArrayList<String>();
        reader = new FileReader(file);
        BufferedReader bf = new BufferedReader(reader);

        String line = bf.readLine();
        while (line != null) {
            list.add(line);
            line = bf.readLine();
        }

        var result = new char[list.size()][];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i).toCharArray();
        return result;
    }
    public static void writeMap(Node[] nodePath, char[][] map, String path) throws Exception{
        var newMap = (char[][])map.clone();
        for (var n:
             nodePath) {
            if (map[n.y][n.x] == Converter.path)
                newMap[n.y][n.x] = '*';
        }
        var writer = new FileWriter(path);
        for (var chArr:
             newMap) {
            writer.write(chArr);
            writer.write('\n');
        }
        writer.close();
    }
}

package com.company;

public class Main {

    public static void main(String[] args) throws Exception{
        var map = FileWorker.readMap("map.txt");
        var startFinish = new Wrapper();
        Converter.toNode(map, startFinish);
        var path = ((Node)startFinish.item1).findPath((Node)startFinish.item1, (Node)startFinish.item2);
        FileWorker.writeMap(path, map, "solvedMap.txt");
    }
}

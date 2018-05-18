package com.tsconsulting.join.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static com.tsconsulting.join.manager.ConvertCollections.arrListToLinked;
import static com.tsconsulting.join.manager.ConvertCollections.arrListToMap;

public final class Manager {
    private static Manager manager = null;
    private String path1;
    private String path2;


    private Manager(String path1, String path2){
        this.path1=path1;
        this.path2=path2;
    }

    public static void initManager(String pathOfFile1, String pathOfFile2) throws IOException {
        if(manager==null) manager = new Manager(pathOfFile1, pathOfFile2);
        manager.controller();
    }

    public void controller() throws IOException, NullPointerException {
        ArrayList<TwinValue> arrListOfRows1 = formArrayList(FileManager.readFile(path1), path1);
        ArrayList<TwinValue> arrListOfRows2 = formArrayList(FileManager.readFile(path2), path2);

        writeInConsole(Join.join(arrListOfRows1, arrListOfRows2)
                , "ArrayList");

        writeInConsole(Join.join(arrListToLinked(arrListOfRows1), arrListToLinked(arrListOfRows2))
                , "LinkedList");

        writeInConsole(Join.join(arrListToMap(arrListOfRows1), arrListToMap(arrListOfRows2))
                , "HashMap");
    }

    /**
     * This method forms ArrayList of TwinValue from File
     */
    private ArrayList<TwinValue> formArrayList(BufferedReader reader, String pathName) throws IOException {
        ArrayList<TwinValue> list = new ArrayList<>();

        Iterator<TwinValue> readerIterator = new BufferedReaderIterator(reader, new LineParser()).iterator();
        while(readerIterator.hasNext()) {
            try {
                list.add(readerIterator.next());
            } catch (IllegalLineFormatException e) {
                System.out.println(e.getMessage()+" in file: "+pathName+"\r\n");
            }
        }
        return list;
    }

    private void writeInConsole(Iterator<TripleValue> iterator, String typeOfCollection){
        System.out.println("____________________________________________________________");
        System.out.println("Операция INNER JOIN выполнена с использованием " + typeOfCollection);
        System.out.println("____________________________________________________________");
        System.out.println(String.format("%5s | %10s | %10s", "ID", "VALUE.A", "VALUE.B"));
        System.out.println("____________________________________________________________");
        while(iterator.hasNext()) {
            TripleValue temp = iterator.next();
            System.out.println(String.format("%5s | %10s | %10s", temp.getId(), temp.getValue1(),
                    temp.getValue2()));
        }
        System.out.println("____________________________________________________________\r\n\r\n");
    }




}

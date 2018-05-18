package com.tsconsulting.join.manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class FileManager {

    public static BufferedReader readFile(String name) throws NullPointerException {
        try{
            return new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(name)));
        } catch (NullPointerException e){
            throw new NullPointerException(name);
        }
    }

    public static void writeFile(Iterator<TripleValue> iterator){ }
}

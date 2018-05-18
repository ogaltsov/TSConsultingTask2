package com.tsconsulting.join.manager;

import java.util.*;

/**
 * Class with static util methods witch uses to convert different types
 * of collections to each-other with some specify additions(sort)
 */
public class ConvertCollections {

    public static LinkedList<TwinValue> arrListToLinked(ArrayList<TwinValue> list){
        LinkedList<TwinValue> linkedList = new LinkedList<>(list);
        Collections.sort(linkedList, new Comparator<TwinValue>() {
            public int compare(TwinValue o1, TwinValue o2) {
                if(o1.getId()==o2.getId()) return 0;
                return o1.getId() > o2.getId() ? 1:-1;
            }
        });
        return linkedList;
    }

    public static Map<Integer,ArrayList<String>> arrListToMap(ArrayList<TwinValue> list){
        Map<Integer,ArrayList<String>> mapOfRows = new HashMap<>();
        ArrayList<String> tempList;

        for(TwinValue pair : list)
            if(mapOfRows.containsKey(pair.getId())){
            tempList = mapOfRows.get(pair.getId());
            tempList.add(pair.getValue());
            } else {
            tempList = new ArrayList<>();
            tempList.add(pair.getValue());
            mapOfRows.put(pair.getId(), tempList);
            }


        return mapOfRows;
    }

}

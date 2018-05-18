package com.tsconsulting.join.manager;

import java.util.*;

/**
 * Performs a merge similarly SQL INNER JOIN
 */
public class Join {

    public static Iterator<TripleValue> join(ArrayList<TwinValue> list1, ArrayList<TwinValue> list2) {   //вернуть итератор
        List<TripleValue> totalJoin = new ArrayList<>();
        for(TwinValue pair1 : list1){
            for(TwinValue pair2 : list2){
                if(pair1.getId() == pair2.getId()){
                    totalJoin.add(new TripleValue(pair1.getId(), pair1.getValue(), pair2.getValue()));
                }
            }
        }
        return totalJoin.iterator();
    }

    public static Iterator<TripleValue> join(LinkedList<TwinValue> list1, LinkedList<TwinValue> list2) {   //вернуть итератор
        List<TripleValue> totalJoin = new ArrayList<>();

        int count=0;
        ListIterator<TwinValue> iterator = list2.listIterator();
        for(TwinValue pair : list1){
            for(int i=count; i>0; i--){
                iterator.previous();
            }
            count=0;
            while (true) {
                if (iterator.hasNext()) {
                    TwinValue tempPair = iterator.next();
                    if (pair.getId() < tempPair.getId() && iterator.hasPrevious()){
                        iterator.previous();
                        break;
                    }
                    if (pair.getId() == tempPair.getId()){
                        totalJoin.add(new TripleValue(pair.getId(), pair.getValue(), tempPair.getValue()));
                        count++;
                    }
                }
                else break;
            }

        }
        return totalJoin.iterator();
    }

    public static Iterator<TripleValue> join(Map<Integer,ArrayList<String>> map1, Map<Integer,ArrayList<String>> map2) {   //вернуть итератор
        List<TripleValue> totalJoin = new ArrayList<>();

        if(map1.size()<= map2.size()){
            for(Map.Entry<Integer,ArrayList<String>> entry : map1.entrySet()) {
                if(map2.containsKey(entry.getKey())){
                    for(String pair1Value: entry.getValue()) {
                        for(String pair2Value: map2.get(entry.getKey()))
                        totalJoin.add(new TripleValue(entry.getKey(), pair1Value, pair2Value));
                    }
                }
            }
        }
        else {
            for(Map.Entry<Integer,ArrayList<String>> entry : map2.entrySet()) {
                if(map1.containsKey(entry.getKey())){
                    for(String pair1Value: entry.getValue()) {
                        for(String pair2Value: map1.get(entry.getKey()))
                            totalJoin.add(new TripleValue(entry.getKey(), pair1Value, pair2Value));
                    }
                }
            }
        }
        return totalJoin.iterator();
    }
}

package com.srione.cms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@RestController
@RequestMapping(value = "/collections")
public class CollectionsController {

    @GetMapping("/doublelinkedlist")
    public static List<Integer> getIntegerList(){
        Integer[] intArray = {1,3,2,  4,2,  5};
        List<Integer> integerList = Arrays.asList(intArray);
        System.out.println("The result will have duplicates and un-ordered" +
                "doublelinkedlist keeps the reference of both prev.item and next.item." +
                "better performance for manipulating values" +
                "duplicate values are allowed");
        return integerList;
    }
    @GetMapping("/linkedlist")
    public static LinkedList<Integer> getLinkedListOfNames(){
        Integer[] intArray = {1,2,3, 4, 5};
        List<Integer> integerList = Arrays.asList(intArray);
        System.out.println("uses dynamic array mechanism where its easy for inserting and searching large volumes"+
                "duplicate values are allowed");
        return (LinkedList<Integer>) integerList;
    }
    @GetMapping("/hashset")
    public static Set<Integer> getSetOfNames(){
        Integer[] intArray = {1,3, 2,2, 4, 5};
        List<Integer> integerList = Arrays.asList(intArray);
        HashSet<Integer> integerHashSet = new HashSet<>(integerList);
        integerHashSet.add(11);
        integerHashSet.add(3);
        integerHashSet.add(4);
        System.out.println("Hash set uses unique hash calculations for value and stores. " +
                "So if we provide duplicate value it will generate same hash result for duplicate value" +
                "And will save only unique values and in default order. " +
                "Alphabetical for strings and ascending for numeric");
        return integerHashSet;
    }

    @GetMapping("/treeset")
    public static SortedSet<Integer> getSetOfSortedNames(){
        Integer[] intArray = {1,3,2, 5,4};
        List<Integer> integerList = Arrays.asList(intArray);
        System.out.println("TreeSet uses TreeMap internally and return results in the default order unique vals");
        return new TreeSet<>(integerList);
    }

    @GetMapping("/linkedhashset")
    public static LinkedHashSet<Integer> getLinkedHashSetNumbers(){
        Integer[] intArray = {1,3,2, 5,4,9,6};
        List<Integer> integerList = Arrays.asList(intArray);
        System.out.println("Linked hashset uses Linked hashmap internally. which maintains order of insertion with " +
                "Linkedhashmap.entry head and linkedhashmap.entry tail");
        return new LinkedHashSet<>(integerList);
    }

    @GetMapping("/map")
    public static Map<Integer, Integer> getSetOfMaps(){
        Integer[] intArray = {1,2,3, 4, 5};
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (Integer i: intArray) {
            integerIntegerMap.put(i, i);
        }
        System.out.println("Hashmap uses hashcode and key value for storing, .put will put the item at a node after" +
                "calculating the index based on hashcode for that key and if any of 2 items leads to same index value" +
                "then the item inserted later will be linked to the earlier node which points to next node");
        return integerIntegerMap;
    }

}

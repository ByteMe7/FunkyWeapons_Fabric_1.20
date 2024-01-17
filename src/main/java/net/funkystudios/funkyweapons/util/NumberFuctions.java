package net.funkystudios.funkyweapons.util;

import com.ibm.icu.impl.Pair;

import java.util.*;

public class NumberFuctions {
    private static final List<Map<String,Integer>> HEX_INT_PAIRS = new ArrayList<>();

    public static int random(int min, int max){
        return (int) ((Math.random()) * (max - min) +min);
    }

    public static int hexToInt(String hex){
        int val = 0;
        String[] splitHex = hex.split("");
        int i = splitHex.length - 1;
        for (String s : splitHex) {
            for(Map<String,Integer> pair: HEX_INT_PAIRS){
                if(pair.containsKey(s)){
                    val += (int) (pair.get(s) * Math.pow(16,i));
                }
            }
            i--;
        }
        return val;
    }

    static {
        addHexIntPairs("0",0);
        addHexIntPairs("1",1);
        addHexIntPairs("2",2);
        addHexIntPairs("3",3);
        addHexIntPairs("4",4);
        addHexIntPairs("5",5);
        addHexIntPairs("6",6);
        addHexIntPairs("7",7);
        addHexIntPairs("8",8);
        addHexIntPairs("9",9);
        addHexIntPairs("a",10);
        addHexIntPairs("b",11);
        addHexIntPairs("c",12);
        addHexIntPairs("d",13);
        addHexIntPairs("e",14);
        addHexIntPairs("f",15);

    }


    private static void addHexIntPairs(String hex, int value){
        Map<String,Integer> pair = new HashMap<>();
        pair.put(hex,value);
        HEX_INT_PAIRS.add(pair);
    }

}

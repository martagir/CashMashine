package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;


/**
 * Created by Марат on 08.02.2016.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new TreeMap();

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        boolean found = false;
        TreeMap<Integer, Integer> temp = (TreeMap)denominations;
        NavigableMap<Integer, Integer> nmap = temp.descendingMap();
        Iterator<Map.Entry<Integer, Integer>> iter = nmap.entrySet().iterator();

        while (iter.hasNext()){
            Integer value = iter.next().getValue();
            if(value <= 0){
                iter.remove();
            }
        }

        Map<Integer, Integer> outputMap = new HashMap<>();

        int mapSize = nmap.size();
        if (expectedAmount % nmap.firstKey() == 0){
            found = true;
            outputMap.put(nmap.firstKey(), expectedAmount / nmap.firstKey());
        } else {

        }

        /**
         1000
         */
        System.out.println(outputMap.toString());
        return outputMap;
    }

    public  boolean isAmountAvailable(int expectedAmount){
       return expectedAmount <= this.getTotalAmount();
    }

    public boolean  hasMoney()
    {
        boolean result = true;
        if (denominations.isEmpty()) result = false;
        else {
            int zerosCount = 0;
            for (Map.Entry<Integer,Integer> pair : denominations.entrySet()){
                if (pair.getValue()==0) zerosCount++;
            }
            if (zerosCount==denominations.size()) result=false;
        }
        return result;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public int getTotalAmount(){
        int result = 0;
        for (Map.Entry<Integer,Integer> pair : denominations.entrySet()){
            result += pair.getKey() * pair.getValue();
        }
        return  result;
    }

    public  void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination)){
            denominations.put(denomination,denominations.get(denomination) + count);
        } else {
            denominations.put(denomination,count);
        }
    }
}
package com.javarush.test.level26.lesson15.big01.CashMachineTest;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by Марат on 30.09.2016.
 */
public class Test {
    public static TreeMap<Integer, Integer> money = new TreeMap<>();


    public static void main(String[] args) {

        money.put(1000, 0);
        money.put(500, 2);
        money.put(200, 1);
        money.put(100, 1);
        money.put(50, 12);

        for (int i = 50; i <= 3000; i += 50) {
            System.out.println("Размен " + i + " " + calculate(i));
        }
    }

    public static Map calculate(int amount){
        NavigableMap <Integer, Integer> workMap =  money.descendingMap();
        TreeMap<Integer, Integer> forOutput = new TreeMap<>();
        int chast = 1;
        int ost = 1;
        int i = 0;
        int j = 0;

        for(Iterator<Map.Entry<Integer, Integer>> it = workMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = it.next();
            if(entry.getValue() == 0) {
                it.remove();
            }
        }
//        System.out.println(workMap);

        while(ost != 0) {
            if(j > 0){
                workMap.pollFirstEntry();
            }
//            System.out.println(workMap);
            for(Map.Entry<Integer, Integer> pair: workMap.entrySet()){
                    if(amount < pair.getKey()){
                        i++;
                        continue;
                    }
                    chast = amount / pair.getKey();
                    ost = amount % pair.getKey();
                    if(chast <= pair.getValue()) {
                       amount -= chast * pair.getKey();
                       forOutput.put(pair.getKey(), chast);
                       if(ost == 0) break;
                    }
                    else {
                        amount -= pair.getValue() * pair.getKey();
                        forOutput.put(pair.getKey(), pair.getValue());
//                        if(ost == 0) break;
                    }

                i++;
            }
            if(ost == 0) break;
            if (i >= workMap.size()){
                for(Map.Entry<Integer, Integer> pair: forOutput.entrySet()){
                 amount += pair.getKey() * pair.getValue();
                }
                forOutput.clear();
                j++;
                System.out.println("За " + j + " проход способ выдачи найти не получилось.");
                if (workMap.isEmpty()) break;
            }
        }
        return forOutput.descendingMap();

    }

}

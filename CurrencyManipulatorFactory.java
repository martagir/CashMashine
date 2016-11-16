package com.javarush.test.level26.lesson15.big01;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Марат on 08.02.2016.
 */
public  class CurrencyManipulatorFactory {
    private CurrencyManipulatorFactory(){}
    private static ArrayList<CurrencyManipulator> list = new ArrayList<CurrencyManipulator>();

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        Collection <CurrencyManipulator> currencyManipulatorMap = new ArrayList<>();
        for (CurrencyManipulator cm : list){
        currencyManipulatorMap.add(cm);
        }
        return  currencyManipulatorMap;
    }
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
            CurrencyManipulator manipulator = null;
            for (CurrencyManipulator i : list){
                if (i.getCurrencyCode().equals(currencyCode)){
                    manipulator = i; break;
                }
            }
            if (manipulator == null){
                manipulator = new CurrencyManipulator(currencyCode);
                list.add(manipulator);
            }
        return  manipulator;
    }
}


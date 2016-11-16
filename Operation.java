package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Марат on 07.02.2016.
 */
public enum Operation
{
    INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        Operation askedOper;
        switch (i) {
            case 1: askedOper = Operation.INFO; break;
            case 2: askedOper = Operation.DEPOSIT; break;
            case 3: askedOper = Operation.WITHDRAW; break;
            case 4: askedOper = Operation.EXIT; break;
            default:{
                throw new IllegalArgumentException();

            }
        }
        return askedOper;
    }
}

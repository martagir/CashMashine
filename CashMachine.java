package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Марат on 07.02.2016.
 */
public class CashMachine {
        public static void main (String[]args)throws IOException
        {
            try {
                Locale.setDefault(Locale.ENGLISH);
                Operation oper;
                do
                {
                    oper = ConsoleHelper.askOperation();
                    CommandExecutor.execute(oper);
                }
                while (oper != Operation.EXIT);
            } catch (InterruptOperationException e){
                ConsoleHelper.writeMessage("Goodbye!");
            }
        }
}


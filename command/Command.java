package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

/**
 * Created by Марат on 05.08.2016.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}

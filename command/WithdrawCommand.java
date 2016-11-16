package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;

/**
 * Created by Марат on 05.08.2016.
 */
 class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String currencyName = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyName);
        int amount = 0;

        while (true) {
            try {
                ConsoleHelper.writeMessage("Enter amount of money");
                amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0) {
                    ConsoleHelper.writeMessage("Incorrect input. Please, try again");
                    continue;
                }

                if (!currencyManipulator.isAmountAvailable(amount)) {
//                ConsoleHelper.writeMessage();
                    continue;
                }
                Map<Integer, Integer> moneyForWithdrawal = currencyManipulator.withdrawAmount(amount);
                break;
            }
            catch (IllegalArgumentException IAE) {
                ConsoleHelper.writeMessage("Incorrect input. Please, try again");
                continue;
            }
            catch (NotEnoughMoneyException NEME) {
                ConsoleHelper.writeMessage("Not enough banknotes");
            }
        }
    }
}
package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Марат on 07.02.2016.
 * Класс, обеспечивающий единую точку ввода и вывода информации
 */
 public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static String line = null;

    public static void writeMessage(String message){
                 System.out.println(message);
            }

    public static Operation askOperation() throws  InterruptOperationException
    {
        Operation oper;
        while (true) {
            System.out.println("Enter operation code: ");
            String input = readString();
            try {
               oper = Operation.getAllowableOperationByOrdinal(Integer.parseInt(input));
            }
            catch (IllegalArgumentException e) {
                continue;
            }
            break;
        }
        return oper;
    }




    public static  String readString() throws InterruptOperationException {
                 try {
                     line = reader.readLine();
                     if(line.toUpperCase().equals("EXIT"))
                        throw new InterruptOperationException();
                     }
                 catch (IOException e){}
                 return line;
             }

    public static String askCurrencyCode() throws InterruptOperationException{
                String askCode;
                 writeMessage("Input currency code:");
                askCode = readString();
                 while (askCode.length() != 3) // Проверка на корректность
                 {
                        writeMessage("Wrong currency code. Input currency code:");
                       askCode = readString();
                     }
                return askCode.toUpperCase(); }


    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
               writeMessage("Input your denomination and count money:");
               String massive = "55 ";
               String[] arg = massive.split(" ");
               while (true){
                    try{
                            massive = readString();
                            arg = massive.split(" ");
//                            if (arg[0].toUpperCase().equals("EXIT")){
//                                throw new InterruptOperationException();
//                            }
                            Integer currency = Integer.valueOf(arg[0]);
                            Integer number = Integer.valueOf(arg[1]);

                            if(arg.length != 2 || currency <= 0 || number <= 0) {
                                    writeMessage("try again");
                                    continue;
                                } else
                                  break;

                        }
                        catch (InterruptOperationException ioe){
                            throw new InterruptOperationException();
                        }
                        catch (Exception o){
                            writeMessage("try again");
                          continue;
                        }
                   }


              return arg;
    }
}
package com.luxoft.commandLineCalculator.Calc;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dvorak on 29.12.15.
 */
public class CalculatorImp {

    private boolean verifyInput(String inputArray) {
        boolean resul = true;
        boolean flag = true;
        int index = 0;
        String[] pattern = new String[5];

        String temp = "[a-zA-z][=][[0-9][+]]*";
        pattern[0] = "help";
        pattern[1] = "list";
        pattern[2] = "clear";
        pattern[3] = "[a-zA-z][-]";
        pattern[4] = "[0-9][\\+]||[\\-]||[\\*]||[\\/]";

//        while(flag && index < inputArray.length()) {
//            if(!inputArray[index].matches(temp)) {
//                resul = false;
//                flag = false;
//            }
//            index++;
//        }
        return resul;
    }

    public void test(String args) {
//        String[][] tab = new String[args.length][2];
//        Map<String, char[] > calculatorMap = new HashMap<>();
//        boolean flag = true;
//        int index = 0;
//        while(flag && index < args.length) {
//            if(args[index].equals("+") || args[index].equals("-") || args[index].equals("*") || args[index].equals("/")) {
//                tab[index-1][0] = args[index-1];
//                tab[index-1][1] = args[index+1];
//                //calculatorMap.put(args[index], tab[0] = args[index-1].charAt(0) )
//            }
//        }
//
//        if(verifyInput(args)) {
//            System.out.println("He's alive ");
//        }else {
//            System.out.println("He's dead ");
//        }

    }
}

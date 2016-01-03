package com.luxoft.commandLineCalculator.Calc;

import java.util.Map;

/**
 * Created by dvorak on 29.12.15.
 */
public class CalculatorImp {
    String patternTemp3 = "[a-zA-Z0-9+-=/*()]*";
    String patternTemp2 = "[a-zA-Z]*[=][a-zA-Z0-9+-=/*()]*";
    public boolean verifyInput(String inputArray) {
        boolean result = false;
        boolean flag = true;
        int index = 0;
        String pattern1;

        String temp = "[a-zA-z][=][[0-9][+]]*";
        String patterntemp = "[a-zA-z][-]";
        pattern1 = "[0-9][\\+]||[\\-]||[\\*]||[\\/]";


        if(inputArray.matches(patternTemp2) || inputArray.matches(patternTemp3)) {
            result = true;
        }
        return result;
    }

    public <K,V> void parseAndCalculate(String args, Map<String,Float> map, String objectSaveName) {
        Save save = new Save();
        String variableName = null;
        Float finalResult = null;
        StartCalculations orderOfOpeations = new StartCalculations();
        if(args.matches(patternTemp2)) {
            String formula = null;
            int indexOfEqualsSign = 0;
            if(args.contains("=")) {
                indexOfEqualsSign= args.indexOf("=");
                formula= args.substring(indexOfEqualsSign+1, args.length());
            }else {
                formula = args;
            }
            variableName = args.substring(0,indexOfEqualsSign);
            finalResult = Float.valueOf(orderOfOpeations.calculate(formula));
            System.out.println(variableName + " = " + finalResult);
            map.put(variableName, finalResult);
            save.saveState(map, objectSaveName);
        }
        else {

            int i=0;
            String variableName2 = "temp_"+i;
            boolean flag = true;
            while(flag) {
                if(!map.containsKey(variableName2)) {
                    flag = false;
                }else {
                    i++;
                    variableName2 = "temp_"+i;
                }
            }
            finalResult=Float.valueOf(orderOfOpeations.calculate(args));
            System.out.println(variableName2 + " = " + finalResult);
            map.put(variableName2, finalResult);
            save.saveState(map, objectSaveName);
        }
    }
}

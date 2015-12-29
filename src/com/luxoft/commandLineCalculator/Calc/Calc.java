package com.luxoft.commandLineCalculator.Calc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dvorak on 29.12.15.
 */
public class Calc {
    final String OBJECT_NAME = "data.obj";
    public static Map<String, Float> map;

    public static void main(String[] args) {
        CalculatorImp cImpl = new CalculatorImp();


        if(args.length == 0) {
            System.out.println("Sorry this is command line app. You need to provide arguments to calculate ");
        }else {
            cImpl.test(args);
            switch (args[0]) {
                case "help":

            }
        }

    }
    public static void init() {
        map = new HashMap<>();
        Command clearCommand = new ClearCommand(OBJECT_NAME);
        Command listCommand = new ListCommand<>(map);
        Command helpCommand = new HelpCommand();
    }
}

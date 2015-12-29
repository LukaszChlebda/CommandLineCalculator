package com.luxoft.commandLineCalculator.Calc;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dvorak on 29.12.15.
 */
public class Calc {
    public static final String OBJECT_NAME = "data.obj";
    public static Map<String, Float> map;

    public static void main(String[] args) {
        map = new HashMap<>();
        CalculatorImp cImpl = new CalculatorImp();
        Command clearCommand = new ClearCommand(OBJECT_NAME);
        Command listCommand = new ListCommand(map);
        Command helpCommand = new HelpCommand();
        Save save = new Save();
        Load load = new Load();
        File file = new File(OBJECT_NAME);
        if(!file.exists()) {
            save.saveState(map, OBJECT_NAME);
        }



        if (args.length == 0) {
            System.out.println("Sorry this is command line app. You need to provide arguments to calculate ");
        } else {
            cImpl.test(args[0]);
            switch (args[0]) {
                case "help":

            }
        }

    }
}

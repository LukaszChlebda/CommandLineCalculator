package com.luxoft.commandLineCalculator.Calc;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dvorak on 29.12.15.
 */
public class Calc {
    public static final String OBJECT_NAME = "data.obj";
    public static Map<String, Float> map = new HashMap<String, Float>();

    public static void main(String[] args) {
        Save save = new Save();
        Load load = new Load();
        File file = new File(OBJECT_NAME);
        if(!file.exists()) {
            save.saveState(map, OBJECT_NAME);
        }else {
            map = load.loadState(OBJECT_NAME);
        }
        Command clearCommand = new ClearCommand(OBJECT_NAME, map);
        Command listCommand = new ListCommand(map);
        Command helpCommand = new HelpCommand();
        Command versionCommand = new VersionCommand();
        Command noOptionCommand = new NoOptionCommand();
        CalculatorImp cImpl = new CalculatorImp();
        if (args.length == 0) {
            noOptionCommand.execute();
        } else if(args.length == 1){

            switch (args[0]) {
                case "help":
                    helpCommand.execute();
                    break;
                case "list":
                    listCommand.execute();
                    break;
                case "clear":
                    clearCommand.execute();
                    break;
                case "version":
                    versionCommand.execute();
                    break;
                default:
                    if(cImpl.verifyInput(args[0])) {
                        cImpl.parseAndCalculate(args[0], map, "data.obj");
                    }else {
                        noOptionCommand.execute();
                    }
                    break;
            }
        }else if(args.length > 1){
            noOptionCommand.execute();
        }
    }
}

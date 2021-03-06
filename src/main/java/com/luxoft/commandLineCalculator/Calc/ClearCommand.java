package com.luxoft.commandLineCalculator.Calc;

import java.io.File;
import java.util.Map;

/**
 * Created by dvorak on 29.12.15.
 */
public class ClearCommand <K,V> implements Command {
    private String objectName;
    private Save save = new Save();
    private Map<K,V> map = null;

    public ClearCommand(String name, Map<K,V> map) {
        this.objectName = name;
        this.map = map;
    }

    @Override
    public void execute() {
//        File file = new File(objectName);
//        if(file.exists()) {
//            file.delete();
//        }
        map.clear();
        save.saveState(map, objectName);

    }
}

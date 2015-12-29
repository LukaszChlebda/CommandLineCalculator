package com.luxoft.commandLineCalculator.Calc;

import java.io.File;
import java.util.Map;

/**
 * Created by dvorak on 29.12.15.
 */
public class ClearCommand implements Command {
    private String objectName = null;
    public ClearCommand(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public void execute() {
        File file = new File(objectName);
        if(file.exists()) {
            file.delete();
        }
    }
}

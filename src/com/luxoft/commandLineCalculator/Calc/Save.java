package com.luxoft.commandLineCalculator.Calc;

import java.io.*;
import java.util.Map;

public class Save <K,V> implements Serializable {

    public boolean saveState(Map<K,V> map, String objectName) {
        boolean result = false;
        File file = new File(objectName);
        try(FileOutputStream fileOutputStream = new FileOutputStream(objectName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(map);
        }catch (IOException e) {
            e.printStackTrace();
        }
        if(file.exists()) {
            return true;
        }

        return result;
    }

}

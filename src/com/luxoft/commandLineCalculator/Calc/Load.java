package com.luxoft.commandLineCalculator.Calc;

import java.io.*;
import java.util.Map;

/**
 * Created by dvorak on 29.12.15.
 */
public class Load <K,V> implements Serializable{

    public Map<K,V> loadState(String objectName) {
        boolean result = false;
        File file = new File(objectName);
        if(file.exists()) {
            try(FileInputStream fileInputStream = new FileInputStream(objectName);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                return (Map)objectInputStream.readObject();
            }catch (IOException e) {
                System.out.println("Data not found ");
            }catch (ClassNotFoundException f) {
                System.out.println("Class not found ");
            }
        }else {
            System.out.println("File Not found ");
        }
        return null;
    }

}

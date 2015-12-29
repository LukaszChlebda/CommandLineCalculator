package com.luxoft.commandLineCalculator.Test;

import com.luxoft.commandLineCalculator.Calc.ClearCommand;
import com.luxoft.commandLineCalculator.Calc.ListCommand;
import com.luxoft.commandLineCalculator.Calc.Load;
import com.luxoft.commandLineCalculator.Calc.Save;
import com.sun.istack.internal.NotNull;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.*;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by dvorak on 29.12.15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalcTest <K,V> {

    Map<String, Float> calcMap;
    Save save = new Save();
    Load load = new Load();
    ClearCommand clearCommand = new ClearCommand("data2.obj");
    Map<K, V> temp = null;
    @Before
    public void testPreperation() {


        calcMap = new HashMap<>();
        calcMap.put("d", 3f);
        calcMap.put("s", 5f);
        calcMap.put("a", 2f);
        calcMap.put("temp0", 2f);
        calcMap.put("temp1", 2f);




    }

    @Test
    public void test1Calculate() {
        String[] resultString = new String[calcMap.size()];
        Iterator<Map.Entry<String, Float>> iterator = calcMap.entrySet().iterator();
        int i=0;
        while (iterator.hasNext()) {
            resultString[i] = iterator.next().toString();
            i++;
        }
        //System.out.println(Arrays.toString(calcMap.entrySet().toArray()));
        printArray(resultString);
    }

    @Test
    public void test2AddNewNumberToMap() {
        Float add = Float.valueOf(5);
        Float result = Float.valueOf(8);

        add +=  calcMap.get("d");

        assertEquals(result, add);
    }

    private void printArray(String[] arrayToPrint) {
        StringBuilder sb = new StringBuilder();
        for(String s: arrayToPrint) {
            sb.append(s+"\n");
        }
        System.out.println(sb);
    }

    private void mapToString(Map<String,Float> map, String[] stringArray) {
        //String[] resultString = new String[map.size()];
        Iterator<Map.Entry<String, Float>> iterator = map.entrySet().iterator();
        int i=0;
        while (iterator.hasNext()) {
            stringArray[i] = iterator.next().toString();
            i++;
        }
    }

//    @Test
//    public void testCSerialize() {
//        try(FileOutputStream fileOutputStream = new FileOutputStream("data.obj");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
//            objectOutputStream.writeObject(calcMap);
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void test4Deserialization() {
        temp = new HashMap<>();// = new HashMap<>();
        String[] stringArray = new String[calcMap.size()];
//        try(FileInputStream fileInputStream = new FileInputStream("data.obj");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
//            temp = (Map)objectInputStream.readObject();
//        }catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        temp = (load.loadState("data.obj"));

        //mapToString(temp, stringArray);
        //printArray(stringArray);
    }
    @Test
    public void test3Serialize() {
        assertEquals(true, save.saveState(calcMap, "data2.obj"));

    }

    @Test
    public void test5DeleteObject() {
        Map<K,V> map = load.loadState("data.obj");
        ClearCommand clearCommand1 = new ClearCommand("data2.obj");
        File file = new File("data2.obj");
        assertEquals(true, file.exists());
        clearCommand1.execute();
        assertEquals(true, file.exists());
        assertNotEquals(null, map);
        map = load.loadState("data2.obj");
        assertEquals(null, map);
    }

//    @Test
//    public void test6ListCommandTest() {
//        temp = new HashMap<>();
//        temp = load.loadState("data2.obj");
//        ListCommand listCommand = new ListCommand(temp);
//        listCommand.execute();
//    }

}

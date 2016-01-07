package com.luxoft.commandLineCalculator.Test;

import com.luxoft.commandLineCalculator.Calc.*;
import com.sun.istack.internal.NotNull;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by dvorak on 29.12.15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalcTest <K,V> {

    Map<String, Float> calcMap;
    Map<String, Float> storingMap;
    Save save = new Save();
    Load load = new Load();

    Map<K, V> temp = null;
    ClearCommand clearCommand;
    CalculatorImp calculatorImp;
    @Before
    public void testPreperation() {
        calculatorImp = new CalculatorImp();
        clearCommand = new ClearCommand("dataTest.obj", temp);
        calcMap = new HashMap<>();
        storingMap = new HashMap<>();
        storingMap.put("d", 4f);
        storingMap.put("c", 6f);
        storingMap.put("temp_0", 4f);
        storingMap.put("temp_1", 6f);
        storingMap.put("temp_2", 8f);
        storingMap.put("was", 8f);
    }

    @Test
    public void test1veryfiCalculateInput() {
        String input1 = "d=23*43";
        String input2 = "32+11";

        assertEquals(true, calculatorImp.verifyInput(input1));
        assertEquals(true, calculatorImp.verifyInput(input2));
    }

    @Test
    public void test2CalculateFormulaAndSerialize() {
        String[] formula1 = new String[6];
        formula1[0] = "d=2+2";
        formula1[1] = "c=2+2*2";
        formula1[2] = "2+2";
        formula1[3] = "2+2*2";
        formula1[4] = "(2*2)+4";
        formula1[5] = "was=(2*2)+4";

        calculatorImp.parseAndCalculate(formula1[0], calcMap, "dataTest.obj");
        calculatorImp.parseAndCalculate(formula1[1], calcMap, "dataTest.obj");
        calculatorImp.parseAndCalculate(formula1[2], calcMap, "dataTest.obj");
        calculatorImp.parseAndCalculate(formula1[3], calcMap, "dataTest.obj");
        calculatorImp.parseAndCalculate(formula1[4], calcMap, "dataTest.obj");
        calculatorImp.parseAndCalculate(formula1[5], calcMap, "dataTest.obj");

        save.saveState(calcMap, "dataTest.obj");

        File file = new File("dataTest.obj");
        assertTrue(file.exists());

    }

    @Test
    public void test3DeserializeObject() {
        Map<String, Float> tempMap = null;
        tempMap = (Map)load.loadState("dataTest.obj");
        assertNotNull(tempMap);
    }

    @Test
    public void test4CheckPerformedCalculations() {
        Map<String, Float> tempMap = new HashMap<>();
        tempMap.put("d", 4f);
        tempMap.put("c", 6f);
        tempMap.put("temp_0", 4f);
        tempMap.put("temp_1", 6f);
        tempMap.put("temp_2", 8f);
        tempMap.put("was", 8f);

        assertEquals(storingMap, tempMap);
    }
}

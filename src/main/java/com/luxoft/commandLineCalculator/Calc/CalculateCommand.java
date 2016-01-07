package com.luxoft.commandLineCalculator.Calc;

import java.util.Map;

/**
 * Created by dvorak on 29.12.15.
 */
public class CalculateCommand implements Command{
    private CalculatorImp calculatorImp = new CalculatorImp();
    private String argumetToCalculate = null;
    private Map<String,Float> map = null;

    public CalculateCommand(String argumetToCalculate, Map<String,Float> map) {
        this.argumetToCalculate = argumetToCalculate;
        this.map = map;
    }


    public void execute() {
        calculatorImp.parseAndCalculate(argumetToCalculate, map, "data.obj");
    }
}

package com.luxoft.commandLineCalculator.Calc;

/**
 * Created by dvorak on 29.12.15.
 */
public class CalculateCommand implements Command{
    private CalculatorImp calculatorImp = new CalculatorImp();
    private String argumetToCalculate = null;

    public CalculateCommand(String argumetToCalculate) {
        this.argumetToCalculate = argumetToCalculate;
    }

    @Override
    public void execute() {
        calculatorImp.test(argumetToCalculate);
    }
}

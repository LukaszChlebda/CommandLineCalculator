package com.luxoft.commandLineCalculator.Calc;

/**
 * Created by dvorak on 29.12.15.
 */
public class HelpCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Help here ");
    }
}

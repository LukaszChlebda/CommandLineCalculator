package com.luxoft.commandLineCalculator.Calc;

/**
 * Created by dvorak on 30.12.15.
 */
public class NoOptionCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Sorry this is command line app. You need to provide arguments to calculate. Use help to see more");
    }
}

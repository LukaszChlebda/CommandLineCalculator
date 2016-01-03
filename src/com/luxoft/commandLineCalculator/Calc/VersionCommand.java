package com.luxoft.commandLineCalculator.Calc;

/**
 * Created by dvorak on 30.12.15.
 */
public class VersionCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Command line calculator Version 1.0 ");
    }
}

package com.luxoft.commandLineCalculator.Calc;

/**
 * Created by dvorak on 29.12.15.
 */
public class HelpCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Help:\nAvailable commands:\n" +
                "     *list - to see stored calculations\n     *clear - to clear previous calculations\n     *version - to see actual version of application" +
                "\n" +
                "     *help - to see help\n----------------------------------------------------------" +
                "\nHow to use an app:\nThis is a command line calculator which takes as parameter formula that will " +
                "be calculated.\ne.g 2+2*2 and result will be signed to temp variable, d=2*2*2 and result will be signed to d variable and saved on local disc for history ");
    }
}

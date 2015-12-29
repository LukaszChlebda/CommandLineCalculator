package com.luxoft.commandLineCalculator.Calc;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by dvorak on 29.12.15.
 */
public class ListCommand <K,V> implements Command {
    private Map<K,V> map = null;
    private String[] resultString = null;

    public ListCommand(Map<K,V> map) {
        this.map = map;
         resultString = new String[map.size()];
    }

    @Override
    public void execute() {
        mapToString();
        printArray();
    }

    private void mapToString() {

        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            resultString[i] = iterator.next().toString();
            i++;
        }
    }
    private void printArray() {
        StringBuilder sb = new StringBuilder();
        for(String s: resultString) {
            sb.append(s+"\n");
        }
        System.out.println(sb);
    }
}

package com.tsconsulting.join.manager;

public class LineParser {

    public TwinValue getValue(String line) throws IllegalLineFormatException {
        String[]tokens = line.split(",\\s{0,10}");
        if(tokens.length!=2)
            throw new IllegalLineFormatException(line);
        try {
            TwinValue twinValue = new TwinValue(Integer.parseInt(tokens[0]), tokens[1]);
            return twinValue;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalLineFormatException(line);
        }
    }
}

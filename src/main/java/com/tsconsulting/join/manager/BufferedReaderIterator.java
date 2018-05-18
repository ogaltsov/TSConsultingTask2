package com.tsconsulting.join.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * An iterator over a BufferedReader
 * Wraps BufferedReader and use Parser to parse lines from reader
 */
public class BufferedReaderIterator implements Iterable<TwinValue> {
    private BufferedReader reader;
    private LineParser parser;

    public BufferedReaderIterator(BufferedReader reader, LineParser parser){
        this.reader=reader;
        this.parser=parser;
    }


    @Override
    public Iterator<TwinValue> iterator() {
        return new Itr();
    }


    class Itr implements Iterator<TwinValue> {

        @Override
        public boolean hasNext() {
            try {
                reader.mark(1);
                if (reader.read() < 0) {
                    return false;
                }
                reader.reset();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        @Override
        public TwinValue next() throws IllegalLineFormatException {
            try {
                return parser.getValue(reader.readLine());
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Не существующая комманда");
        }
    }
}

package a14n.devoxx.codestory.foobarqix;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class FooBarQix {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private static final int MAX_NUMBER = 100;

    static final Map<Integer, String> CORRESPONDANCIES;
    static {
        final Map<Integer, String> correspondancies = new LinkedHashMap<Integer, String>();
        correspondancies.put(3, "Foo");
        correspondancies.put(5, "Bar");
        correspondancies.put(7, "Qix");
        CORRESPONDANCIES = Collections.unmodifiableMap(correspondancies);
    }

    private final Transformer transformer = new Transformer(FooBarQix.CORRESPONDANCIES);

    private String getResult()
    {
        final StringBuilder result = new StringBuilder();
        for (int i = 1; i < MAX_NUMBER; i++) {
            transformer.transform(i, result);
            result.append(LINE_SEPARATOR);
        }
        return result.toString();
    }

    String transform(int number)
    {
        return transformer.transform(number);
    }

    public static void main(final String[] args)
    {
        final FooBarQix fooBarQix = new FooBarQix();

        final long start = System.nanoTime();
        System.out.print(fooBarQix.getResult());
        System.out.printf("%d ns. for %d elements.%n", System.nanoTime() - start, MAX_NUMBER);
    }
}

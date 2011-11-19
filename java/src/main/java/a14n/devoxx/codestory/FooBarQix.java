package a14n.devoxx.codestory;

import a14n.devoxx.codestory.matcher.Matcher;
import a14n.devoxx.codestory.matcher.contains.ContainsMatcher;
import a14n.devoxx.codestory.matcher.contains.EuclidianContainsMatcher;
import a14n.devoxx.codestory.matcher.multiple.MultipleMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FooBarQix {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    static final Map<Integer, String> CORRESPONDANCIES;
    static {
        final Map<Integer, String> correspondancies = new LinkedHashMap<Integer, String>();
        correspondancies.put(3, "Foo");
        correspondancies.put(5, "Bar");
        correspondancies.put(7, "Qix");
        CORRESPONDANCIES = Collections.unmodifiableMap(correspondancies);
    }

    static final List<Matcher> MATCHERS;
    static {
        final List<MultipleMatcher> multipleMatchers = new ArrayList<MultipleMatcher>();
        final List<ContainsMatcher> containsMatchers = new ArrayList<ContainsMatcher>();
        for (final Entry<Integer, String> entry : CORRESPONDANCIES.entrySet()) {
            final Integer num = entry.getKey();
            final String value = entry.getValue();
            multipleMatchers.add(new MultipleMatcher(num, value));
            containsMatchers.add(new EuclidianContainsMatcher(num, value)); // 2305249111 ns for 10_000_000.
            // containsMatchers.add(new StringContainsMatcher(num, value)); // 3824400391 ns for 10_000_000.
            // containsMatchers.add(new RegExpStringContainsMatcher(num, value)); // 7315167751 ns for 10_000_000.
        }
        final List<Matcher> matchers = new ArrayList<Matcher>();
        matchers.addAll(multipleMatchers);
        matchers.addAll(containsMatchers);
        MATCHERS = Collections.unmodifiableList(matchers);
    }

    public static void main(final String[] args)
    {
        final long start = System.nanoTime();
        final Transformer transformer = new Transformer(FooBarQix.MATCHERS);
        final StringBuilder result = new StringBuilder();
        int maxNumber = 100;
        for (int i = 1; i < maxNumber; i++) {
            transformer.transform(i, result);
            result.append(LINE_SEPARATOR);
        }
        System.out.print(result);
        System.out.printf("%d ns. for %d elements.%n", System.nanoTime() - start, maxNumber);
    }
}

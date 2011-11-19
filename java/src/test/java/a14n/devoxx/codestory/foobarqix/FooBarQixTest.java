package a14n.devoxx.codestory.foobarqix;

import junit.framework.TestCase;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FooBarQixTest extends TestCase {
    @Test
    public void testTransform()
    {
        final Map<Integer, String> spec = new LinkedHashMap<Integer, String>();
        spec.put(1, "1");
        spec.put(2, "2");
        spec.put(3, "FooFoo");
        spec.put(4, "4");
        spec.put(5, "BarBar");
        spec.put(6, "Foo");
        spec.put(7, "QixQix");
        spec.put(8, "8");
        spec.put(9, "Foo");
        spec.put(10, "Bar");
        spec.put(21, "FooQix");
        spec.put(13, "Foo");
        spec.put(15, "FooBarBar");
        spec.put(33, "FooFooFoo");
        spec.put(51, "FooBar");
        spec.put(53, "BarFoo");

        final FooBarQix fooBarQix = new FooBarQix();
        for (final Entry<Integer, String> entry : spec.entrySet()) {
            final int number = entry.getKey();
            final String expected = entry.getValue();
            assertThat("bad transformation for " + number, fooBarQix.transform(number), is(expected));
        }
    }
}

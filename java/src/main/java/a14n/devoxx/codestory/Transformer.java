package a14n.devoxx.codestory;

import java.util.Map;
import java.util.Map.Entry;

public class Transformer {
    private final Map<Integer, String> correspondancies;

    public Transformer(Map<Integer, String> correspondancies)
    {
        this.correspondancies = correspondancies;
    }

    public String transform(int number)
    {
        final StringBuilder result = new StringBuilder();
        transform(number, result);
        return result.toString();
    }

    public void transform(int number, StringBuilder result)
    {
        boolean matches = false;
        matches |= appendTextIfMultiple(number, result);
        matches |= appendTextIfContains(number, result);
        if (!matches) {
            result.append(number);
        }
    }

    private boolean appendTextIfMultiple(int number, StringBuilder result)
    {
        boolean isMultiple = false;
        for (Entry<Integer, String> e : correspondancies.entrySet()) {
            if (number % e.getKey() == 0) {
                result.append(e.getValue());
                isMultiple = true;
            }
        }
        return isMultiple;
    }

    private boolean appendTextIfContains(int number, StringBuilder result)
    {
        final boolean contains;
        final int lastDigit;
        if (number >= 10) {
            contains = appendTextIfContains(number / 10, result);
            lastDigit = number % 10;
        } else {
            contains = false;
            lastDigit = number;
        }
        for (Entry<Integer, String> e : correspondancies.entrySet()) {
            if (lastDigit == e.getKey()) {
                result.append(e.getValue());
                return true;
            }
        }
        return contains;
    }
}

package a14n.devoxx.codestory;

import a14n.devoxx.codestory.matcher.Matcher;

import java.util.List;

public class Transformer {
    private final List<Matcher> matchers;

    public Transformer(final List<Matcher> matchers)
    {
        this.matchers = matchers;
    }

    public String transform(final int number)
    {
        final StringBuilder result = new StringBuilder();
        transform(number, result);
        return result.toString();
    }

    public void transform(final int number, final StringBuilder result)
    {
        boolean hasMatch = false;
        for (final Matcher matcher : this.matchers) {
            if (matcher.match(number)) {
                hasMatch = true;
                result.append(matcher.getValue());
            }
        }
        if (!hasMatch) {
            result.append(number);
        }
    }
}

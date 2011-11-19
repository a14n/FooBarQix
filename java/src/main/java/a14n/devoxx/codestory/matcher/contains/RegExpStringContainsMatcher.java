package a14n.devoxx.codestory.matcher.contains;

import java.util.regex.Pattern;

public class RegExpStringContainsMatcher extends ContainsMatcher {
    private final Pattern pattern;

    public RegExpStringContainsMatcher(int num, String value)
    {
        super(num, value);
        this.pattern = Pattern.compile(Integer.toString(num));
    }

    @Override
    public boolean match(int number)
    {
        return pattern.matcher(Integer.toString(number)).find();
    }
}

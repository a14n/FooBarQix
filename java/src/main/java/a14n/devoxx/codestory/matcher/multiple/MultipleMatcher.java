package a14n.devoxx.codestory.matcher.multiple;

import a14n.devoxx.codestory.matcher.Matcher;

public class MultipleMatcher implements Matcher {
    private final int num;

    private final String value;

    public MultipleMatcher(int num, String value)
    {
        assert num > 0;
        this.num = num;
        this.value = value;
    }

    @Override
    public boolean match(int number)
    {
        return number % num == 0;
    }

    @Override
    public String getValue()
    {
        return value;
    }

}

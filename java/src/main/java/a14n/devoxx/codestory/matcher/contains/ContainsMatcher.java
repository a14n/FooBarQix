package a14n.devoxx.codestory.matcher.contains;

import a14n.devoxx.codestory.matcher.Matcher;

public abstract class ContainsMatcher implements Matcher {
    protected final int num;

    private final String value;

    public ContainsMatcher(int num, String value)
    {
        assert num >= 0;
        this.num = num;
        this.value = value;
    }

    @Override
    public String getValue()
    {
        return value;
    }
}

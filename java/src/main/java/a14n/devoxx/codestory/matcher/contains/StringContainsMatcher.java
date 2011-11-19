package a14n.devoxx.codestory.matcher.contains;

public class StringContainsMatcher extends ContainsMatcher {
    private final String num;

    public StringContainsMatcher(int num, String value)
    {
        super(num, value);
        this.num = Integer.toString(num);
    }

    @Override
    public boolean match(int number)
    {
        return Integer.toString(number).indexOf(num) != -1;
    }
}

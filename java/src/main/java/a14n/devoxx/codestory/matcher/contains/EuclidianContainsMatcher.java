package a14n.devoxx.codestory.matcher.contains;

public class EuclidianContainsMatcher extends ContainsMatcher {

    public EuclidianContainsMatcher(int num, String value)
    {
        super(num, value);
    }

    @Override
    public boolean match(int number)
    {
        if (number == 0) {
            return false;
        }
        final int lastDigit = number % 10;
        if (lastDigit == num) {
            return true;
        } else {
            return match(number / 10);
        }
    }
}

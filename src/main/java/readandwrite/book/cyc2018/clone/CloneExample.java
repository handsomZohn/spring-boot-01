package readandwrite.book.cyc2018.clone;

public class CloneExample implements Cloneable{
    private int a;
    private int b;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

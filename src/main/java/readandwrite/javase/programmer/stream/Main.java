package readandwrite.javase.programmer.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Long> s1 = Stream.generate(new NatualSupplier());
        Stream<Long> s2 = s1.map(n -> n * n);
        Stream<Long> s3 = s2.map(n -> n - 1);
        System.out.println("======^_^======����s3ֵΪ: " + s3 + ", " + "��ǰ���Լ�����������: Main.main()");
    }
}

class NatualSupplier implements Supplier<Long> {
    long n = 0;
    @Override
    public Long get(){
        n++;
        return n;
    }
}
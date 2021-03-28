package readandwrite.book.effectivejava.disanshiliutiao;

import java.util.HashSet;
import java.util.Set;

// Can you spot the bug?
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    // 没有覆盖equals 而是将equals方法给重载了，想要覆盖Object的equals方法，那就必须定义一个参数为Object的equals方法；
    // 这个equals方法是测试对象的同一性 类似于==。
    //
    /*public boolean equals(Bigram bigram){
        return bigram.first == first && bigram.second == second;
    }*/

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Bigram)) {
            return false;
        }
        Bigram bigram = (Bigram) o;
        return bigram.first == first && bigram.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> set = new HashSet<Bigram>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                set.add(new Bigram(ch,ch));

            }
        }
        System.out.println(set.size());
    }

}

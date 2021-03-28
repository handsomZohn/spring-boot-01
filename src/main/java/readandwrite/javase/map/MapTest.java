package readandwrite.javase.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Objects;

public class MapTest {
    public static void main(String[] args) {
        HashMap<Person, String> hashMap = new HashMap<>();
        hashMap.put(new Person("why"), "16岁-长得帅");
        hashMap.put(new Person("why"), "17岁-成绩好");
        hashMap.put(new Person("why"), "18岁-处对象");

        System.out.println("hashMap = " + hashMap);

        IdentityHashMap<Person, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(new Person("why"), "16岁-长得帅");
        identityHashMap.put(new Person("why"), "17岁-成绩好");
        identityHashMap.put(new Person("why"), "18岁-处对象");

        System.out.println("identityHashMap = " + identityHashMap);

        String why = identityHashMap.get("why");

        System.out.println(why);
    }
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

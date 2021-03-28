package readandwrite.book.cyc2018.newCharacteristics.eeight.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CreateNewStreamWithMap {
}

class NamePhoneEmail {
    String name;
    String phonenum;
    String email;

    NamePhoneEmail(String n, String p, String e) {
        name = n;
        phonenum = p;
        email = e;
    }
}

class NamePhone {
    String name;
    String phonenum;

    NamePhone(String n, String p) {
        name = n;
        phonenum = p;
    }
}


/**
 * @Description
 * @CreateDate 18/09/18 9:37
 * @Author zohn
 * @Version 1.0
 */
class StreamDemo03 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));
        System.out.println("original values in myList: ");
        myList.forEach(a ->
                System.out.println("name: " + a.name + ", Phone: " + a.phonenum + ", Email:" + a.email)
        );

        // 对象.属性
        Stream<NamePhone> namePhoneStream = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
        System.out.println("List of Names and Phone Numbers:");
        namePhoneStream.forEach(a -> System.out.println("name: " + a.name + ", Phone: " + a.phonenum));

        Stream<NamePhone> namePhoneStream1 = myList.stream().filter((a) -> a.name.equals("James")).map((a) -> new NamePhone(a.name, a.phonenum));

        System.out.println("name是James的信息：");
        namePhoneStream1.forEach(a -> System.out.println("name: " + a.name + ", Phone:" + a.phonenum));
    }


}
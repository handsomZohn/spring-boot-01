package spring.whatisioc;

public class Client {
    public static void main(String[] args) {
        Fruit instance = Factory.getInstance("spring.whatisioc.Orange");
        if (instance != null) {
            instance.eat();
        }
    }
}

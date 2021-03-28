package readandwrite.javaHightRanking.pattern.factorypattern;

public class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Phone huaWei = factory.createPhone("HuaWei");
        Phone iphone = factory.createPhone("Iphone");

        System.out.println(huaWei.brand());
        System.out.println(iphone.brand());

    }
}

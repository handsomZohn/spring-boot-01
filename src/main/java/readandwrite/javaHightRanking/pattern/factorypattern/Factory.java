package readandwrite.javaHightRanking.pattern.factorypattern;

public class Factory {
    public Phone createPhone(String phoneName){
        if ("HuaWei".equals(phoneName)) {
            return new Huawei();
        } else if ("Iphone".equals(phoneName)) {
            return new Iphone();
        } else {
            return null;
        }
    }
}

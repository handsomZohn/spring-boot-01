package readandwrite.book.effectivejava.liebiaoyouxianyushuzu;

public class Demo01 {
    public static void main(String[] args) {
        // fail at runtime
        // Object[] objectArray = new Long[1];
        //objectArray[0] = "I Don't fit in!";
        // Won't compile
        // List<Object> objectList = new ArrayList<Long>();
        // objectList.add("I don't fit in!");

        User user = null;
        user = new User();
        user.setName("21");
        try{
            String name = user.getName();
            System.out.println(name);
        } catch (NullPointerException e) {
            //e.printStackTrace();
            System.out.println("其他错误信息");
        }

    }
}

class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package com.zohn.springboot01.workingfolder.nulluser;

public class User01 {
    private String name;

    public User01(String name){
        this.name = name;
    }


    public static void main(String[] args) {
        User01 user01 = new User01("zhangsan");
        user01 = null;

        boolean b = user01 == null || "zhangsan".equals(user01.name);
        System.out.println(b);

    }
}

package readandwrite.javase.list;

import java.util.ArrayList;
import java.util.List;

public class ListRemove {
    public static void main(String[] args) {
        //建立一个list集合，里面有5个元素含有“a”，3个不含有“a”
        List<String> list = new ArrayList<>();

        list.add("abc");
        list.add("anc");
        list.add("amg");
        list.add("agf");
        list.add("omg");
        list.add("aig");
        list.add("gme");
        list.add("wbe");

        //遍历集合，移除含有“a”的元素
        for(int i = 0; i < list.size();i++){
            String str = list.get(i);
            if(str.contains("a")){
                list.remove(i);
                i--;// 这一行 才能把所有包含a的都移除掉
            }
        }

        //打印，看结果
        for (Object st : list) {
            System.out.println(st+"   ");
        }
    }
}

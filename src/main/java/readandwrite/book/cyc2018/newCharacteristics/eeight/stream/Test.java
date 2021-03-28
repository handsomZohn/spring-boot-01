package readandwrite.book.cyc2018.newCharacteristics.eeight.stream;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @Description 数组元素包含相同属性时，去除元素，只留一个
 * @CreateDate 18/09/20 12:53
 * @Author zohn
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 原数组
        Ry[] rys = new Ry[3];
        Ry ry0 = new Ry();
        ry0.setSfzhm("411322199501302430");
        Ry ry1 = new Ry();
        ry1.setSfzhm("411322199501302432");
        Ry ry2 = new Ry();
        ry2.setSfzhm("411322199501302430");
        rys[0] = ry0;
        rys[1] = ry1;
        rys[2] = ry2;

        // 数组里面的元素属性重复，去掉属性重复的元素，只保留一个

        // 先把数组转为集合
        List<Ry> ries = Arrays.asList(rys);

        //for (Ry ry : ries ) {
            //System.out.println(ry.getSfzhm());
        //}

        List<String> collect = ries.stream().map(Ry::getSfzhm).distinct().collect(Collectors.toList());

        for (Ry ry : ries) {
            System.out.println(ry.getSfzhm());
        }



        // 数组放入map 数组元素的sfzhm属性做key 数组元素做value
        //Map haMap = new HashMap();
        //for (int i = 0; i < rys.length; i++) {
        //    haMap.put(rys[i].getSfzhm(), rys[i]);
        //}
////
////
        //Ry[] newRys = new Ry[haMap.size()];
////
        //Iterator iterator = haMap.entrySet().iterator();
        //int i = 0;
        //while (iterator.hasNext()) {
        //    Map.Entry next = (Entry) iterator.next();
        //    newRys[i] = (Ry) next.getValue();
        //    i++;
        //}
        //for (int j = 0; j < newRys.length; j++) {
        //    System.out.println(newRys[j].getSfzhm());
        //}
//
        // System.out.println(haMap);
    }

}

class Ry {

    private String sfzhm;

    public String getSfzhm() {
        return sfzhm;
    }

    public void setSfzhm(String sfzhm) {
        this.sfzhm = sfzhm;
    }

}
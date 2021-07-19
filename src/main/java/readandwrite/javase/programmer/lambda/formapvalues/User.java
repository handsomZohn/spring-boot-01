package readandwrite.javase.programmer.lambda.formapvalues;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class User {
    private Integer id;
    private String name;
    private String city;
    private Integer age;

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
                new User((int) (Math.random()*10),"小明","北京",18),
                new User((int) (Math.random()*10),"小红", "南京", 17),
                new User((int) (Math.random()*10),"小丫", "湖北", 14),
                new User((int) (Math.random()*10),"小黑", "深圳", 22),
                new User((int) (Math.random()*10),"小玉", "广州", 19),
                new User((int) (Math.random()*10),"小小", "江西", 21)
        );
        //已ID作为Key
        Map<Integer, List<User>> userMap = userList.stream().collect(Collectors.groupingBy(User::getId));
        // 分组后的userMap
        System.out.println(userMap);

        // 根据age从小到大
        Map<Integer, List<User>> map = userMap.entrySet().stream().sorted(Comparator.comparing(o -> o.getValue().get(0).getAge())).map(entry -> {
            Map<Integer, List<User>> result = new LinkedHashMap<>();
            result.put(entry.getKey(), entry.getValue());
            return result;
        }).reduce((map1, map2) -> {
            map2.forEach(map1::put);
            return map1;
        }).get();
        System.out.print(map);
    }



}

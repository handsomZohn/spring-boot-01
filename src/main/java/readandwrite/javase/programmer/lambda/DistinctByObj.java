package readandwrite.javase.programmer.lambda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对象去重
 * .stream().distinct().collect(Collectors.toList());
 * 用这种方法时，对象需要重写hashCode和equals方法
 */
public class DistinctByObj {
    public static void main(String[] args) throws JsonProcessingException {
        Student student1 = new Student();
        student1.setAge("18");
        student1.setGrade("二年级");
        student1.setId(1L);
        student1.setName("张三");
        Student student2 = new Student();
        student2.setAge("18");
        student2.setGrade("二年级");
        student2.setId(1L);
        student2.setName("张三");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);


        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("去重前：");
        System.out.println(objectMapper.writeValueAsString(studentList));

        studentList = studentList.stream().distinct().collect(Collectors.toList());

        System.out.println("去重后：");
        System.out.println(objectMapper.writeValueAsString(studentList));
    }

//    结果如下
//    去重前：
//            [{"name":"张三","age":"18","grade":"二年级","id":1},{"name":"张三","age":"18","grade":"二年级","id":1}]
//    去重后：
//            [{"name":"张三","age":"18","grade":"二年级","id":1}]

}

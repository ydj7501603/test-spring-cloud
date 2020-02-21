package com.yindejin.base;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: YDJ
 * @Date: 2020/2/18
 * @Description:
 */
public class TestStream {

    public static class Student{
        private int age;
        private String name;

        public Student(int age, String name){
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        List<String> list =
                Arrays.stream(arr).filter(e -> e>3).limit(2).peek(e -> System.out.println(e)).mapToObj(String::valueOf).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }


        //list
        Stream.of(new Student[]{new Student(1, "test"),
                new Student(2, "test2"),
                new Student(3, "test3"),
            }).peek( student -> {
                student.setAge(student.getAge() * 2);
        }).collect(Collectors.toMap(Student::getAge, Student::getName)).forEach( (i, s) -> System.out.println("age:" + i +",name=" + s));

        //计算
        int result = Stream.of(1,2,3,4,5,6).reduce((a,b) -> a+b).get();
        System.out.println(result);


        //排序
        Stream.of(12,2,5,4,123,34,7,11,5).sorted().peek(e -> System.out.println(e)).collect(Collectors.toList());

        Stream.of(new Student[]{new Student(23, "test"),
                new Student(12, "test2"),
                new Student(35, "test3"),
        }).sorted(Comparator.comparing(Student::getAge)).peek(e -> System.out.println(e.getAge())).count();

    }
}

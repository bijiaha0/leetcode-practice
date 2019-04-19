package tju.mldn.bijiaoqiDemo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:43
 * Email: clickgwas@gmail.com
 */
public class comparatorDemo {
    public static void main(String[] args) throws Exception {
        Person data [] = new Person [] {
                new Person("小强-A",80) ,
                new Person("小强-B",50) ,
                new Person("小强-C",100)} ;
        Arrays.sort(data,new PersonComparator());	 // 进行对象数组的排序
        System.out.println(Arrays.toString(data));
    }
}

class Person {
    private String name ;
    private int age ;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 无参构造、setter、getter略
    @Override
    public String toString() {
        return "【Person类对象】姓名：" + this.name + "、年龄：" + this.age + "\n" ;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge() ;
    }
}
package tju.mldn.colllectionDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:54
 * Email: clickgwas@gmail.com
 */
public class demo1 {
    public static void main(String[] args) throws Exception {
        List<Person> all = new ArrayList<Person>();
        all.add(new Person("张三",30)) ;
        all.add(new Person("李四",16)) ;
        all.add(new Person("小强",78)) ;
        System.out.println(all.contains(new Person("小强",78)));
        all.remove(new Person("小强",78)) ;
        all.forEach(System.out::println); 	// 方法引用代替了消费型的接口
    }

}
class Person {
    private String name ;
    private int age ;
    public Person(String name,int age) {
        this.name = name ;
        this.age = age ;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true ;
        }
        if (obj == null) {
            return false ;
        }
        if (!(obj instanceof Person)) {
            return false ;
        }
        Person per = (Person) obj ;
        return this.name.equals(per.name) && this.age == per.age ;
    }
    // setter、getter、构造略
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age ;
    }
}

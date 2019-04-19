package tju.mldn.colllectionDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午6:05
 * Email: clickgwas@gmail.com
 */
public class mapDemo3 {
    public static void main(String[] args) throws Exception {
        Map<Person3, String> map = new HashMap<Person3, String>();
        map.put(new Person3("小强", 78), "林弱"); // 使用自定义类作为Key
        System.out.println(map.get(new Person3("小强", 78))); // 通过key找到value
    }
}
class Person3{
    private String name;
    private int age;

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person3 other = (Person3) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
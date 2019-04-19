package tju.mldn.ObjectClass;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:25
 * Email: clickgwas@gmail.com
 */
public class equalsMethod {
    public static void main(String args[]) {
        Person perA = new Person("张三",20) ;
        Person perB = new Person("张三",30) ;
        System.out.println(perA.equals(perB)) ;
    }
}
class Person {
    private String name ;
    private int age ;
    public Person(String name,int age) {
        this.name = name ;
        this.age = age ;
    }
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age ;
    }
    // equals()方法这个时候会有两个对象：当前对象this、传入的Object
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false ;
        }
        if (obj == null) {	// 不关心null的比较
            return false ;
        }
        if (this == obj) {	// 同一个地址
            return true ;
        }
        Person per = (Person) obj ; // 目的是为了获取类中的属性
        return this.name.equals(per.name) &&  this.age == per.age ;
    }
}
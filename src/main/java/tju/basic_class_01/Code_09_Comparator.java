package tju.basic_class_01;
import java.util.Arrays;
import java.util.Comparator;
/*比较器的使用
* */
public class Code_09_Comparator {
		public static class Student {
		public String name;
		public int id;
		public int age;
		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}
	/*
	* 递增
	* */
	public static class IdAscendingComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			//return o1.id - o2.id; //等效为下面的代码。
			if(o1.id < o2.id){
				return -1;//返回负的时候，表示O1应该在排序中排在前面。
			}
			if(o1.id > o2.id){
				return 1;//返回正数的时候，表示O2应该在排序中排在前面。
			}
			return 0 ;//如果返回0，表示O1和O2相等，谁放在前，谁放在后，无所谓。
		}
	}
	/*
	* 递减
	* */
	public static class IdDescendingComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o2.id - o1.id;
		}
	}

	public static class AgeAscendingComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}
	}

	public static class AgeDescendingComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o2.age - o1.age;
		}
	}

	public static void printStudents(Student[] students) {
		for (Student student : students) {
			System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
		}
		System.out.println("===========================");
	}

	public static void main(String[] args) {
		Student student1 = new Student("A", 1, 23);
		Student student2 = new Student("B", 2, 21);
		Student student3 = new Student("C", 3, 22);

		Student[] students = new Student[] { student3, student2, student1 };
		printStudents(students);

		Arrays.sort(students, new IdAscendingComparator());
		printStudents(students);

		Arrays.sort(students, new IdDescendingComparator());
		printStudents(students);

		Arrays.sort(students, new AgeAscendingComparator());
		printStudents(students);

		Arrays.sort(students, new AgeDescendingComparator());
		printStudents(students);

	}

}

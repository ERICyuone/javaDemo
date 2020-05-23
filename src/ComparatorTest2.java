import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest2 {
    public static class Student {
        public int id;
        public String name;
        public int age;

        public Student(String name, int age, int id) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    //重写compare方法，实现按照年龄的升序排列
    public static class ageAscendingComparator implements Comparator<Student> {//Comparator 一个接口
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;

        }

        public static void printStudent(Student[] stu) {
            for (int i = 0; i < stu.length; i++) {
                System.out.print(stu[i].id);
                System.out.print("  ");
                System.out.print(stu[i].name);
                System.out.print("  ");
                System.out.println(stu[i].age);
            }
        }

        public static void main(String[] args) {
            Student s1 = new Student("A", 11, 1);
            Student s2 = new Student("B", 18, 2);
            Student s3 = new Student("C", 38, 3);
            Student s4 = new Student("D", 20, 4);
            Student s5 = new Student("E", 30, 5);
            Student s6 = new Student("F", 17, 6);
            Student[] arr_stu = new Student[]{s1, s2, s3, s4, s5, s6};
            System.out.println("未排序前的输出如下：");
            printStudent(arr_stu);
            System.out.println("按照年龄升序排列后输出如下：");
            Arrays.sort(arr_stu, new ageAscendingComparator());
            printStudent(arr_stu);
        }

    }
}

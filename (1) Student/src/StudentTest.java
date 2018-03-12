import java.util.*;

public class StudentTest
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生学号:");
        String stuNumber = sc.nextLine();
        System.out.print("请输入学生姓名:");
        String stuName = sc.nextLine();
        System.out.print("请输入学生三门课成绩(数学，英语，科学):");
        int math = sc.nextInt();
        int english = sc.nextInt();
        int science = sc.nextInt();
        Student stu = new Student(stuNumber,stuName);
        stu.enterMarks(math,english,science);

        System.out.println("学生信息如下:");
        System.out.print(stu.toString());
    }
}

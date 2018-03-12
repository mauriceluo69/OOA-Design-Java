import java.util.*;

public class StudentListTest
{
    public static void ShowMenu()
    {
        System.out.print("菜单如下,请输入1~8代表您要执行的操作:\n" +
                "1.增加1个学生\n2.根据学号删除学生\n3.根据位置删除学生\n" +
                "4.判断是否为空\n5.根据位置返回学生\n6.根据学号返回学生\n" +
                "7.输出全部学生信息\n8.退出程序\n" + "请输入您的操作:");
    }

    public static void main(String args[])
    {
        StudentList Stulist = new StudentList(0);
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while(choice != 8)
        {
            ShowMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
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
                    Stulist.add(stu);
                    break;

                case 2:
                    System.out.print("请输入要删除学生的学号:");
                    String toDeleteNumber = sc.nextLine();
                    System.out.print("学号:" + toDeleteNumber);
                    if(Stulist.remove(toDeleteNumber))
                        System.out.println("删除成功");
                    else
                        System.out.println("删除失败");
                    break;

                case 3:
                    System.out.print("请输入要删除第几个学生:");
                    int no = sc.nextInt();
                    if(Stulist.remove(no))
                        System.out.println("删除成功");
                    else
                        System.out.println("删除失败");
                    break;

                case 4:
                    if(Stulist.isEmpty())
                        System.out.println("学生信息为空");
                    else
                        System.out.println("学生信息不为空");
                    break;

                case 5:
                    System.out.print("请输入要显示第几个学生的信息:");
                    no = sc.nextInt();
                    System.out.println(Stulist.getItem(no).toString());
                    break;

                case 6:
                    System.out.print("请输入学生的学号:");
                    String toShowNumber = sc.nextLine();
                    System.out.println(Stulist.getItem(toShowNumber).toString());
                    break;

                case 7:
                    if (Stulist.getList().size() == 0)
                        System.out.println("暂无学生信息!");
                    else
                        Stulist.ShowAllStu();
                    break;
            }
        }
    }
}

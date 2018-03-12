package homework2;

import java.util.*;


public class StudentListTestPrime
{
    public static void ShowMenu()
    {
        System.out.print("菜单如下,请输入1~8代表您要执行的操作:\n" +
                "1.增加1个学生\n2.根据学号删除学生\n3.根据位置删除学生\n" +
                "4.判断是否为空\n5.根据位置返回学生\n6.根据学号返回学生\n" +
                "7.输出全部学生信息\n8.退出程序\n" + "请输入您的操作:");
    }

    public static boolean isValidScore(int a)
    {
        if(a >= 0 && a <= 100)
            return true;
        return false;
    }

    public static boolean isNumeric(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public static String validNumber() throws InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while(!valid)
        {
            try
            {
                String number = sc.nextLine();
                if (number.length() != 10 || number.charAt(0) != '2' || number.charAt(1) != '0' || !isNumeric(number))
                    throw new StudentNumberException();
                else
                    return number;
            }
            catch (StudentNumberException e)
            {
                e.showInfo();
                Thread.sleep(100);
                System.out.print("请输入学生学号:");
            }
        }
        return null;
    }

    public static int[] validScore() throws InterruptedException
    {
        int[] scores = new int[3];
        boolean valid = false;
        while(!valid)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                scores[0] = sc.nextInt();
                scores[1] = sc.nextInt();
                scores[2] = sc.nextInt();
                if (!(isValidScore(scores[0]) && isValidScore(scores[1]) && isValidScore(scores[2])))
                    throw new ScoreException();
                else
                    return scores;
            }
            catch (ScoreException e)
            {
                e.showInfo();
                Thread.sleep(100);
                System.out.print("请输入学生三门课成绩(数学，英语，科学):");
            }
        }
        return null;
    }

    public static void main(String args[]) throws InterruptedException
    {
        StudentList Stulist = new StudentList(0);
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while(choice != 8)
        {
            ShowMenu();
            boolean valid = false;
            while(!valid)
            {
                try
                {
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice <= 0 || choice > 8)
                        throw new MenuInputException();
                    else
                        valid = true;
                }
                catch (MenuInputException e)
                {
                    e.showInfo();
                }
            }

            switch(choice)
            {
                case 1:
                    System.out.print("请输入学生学号:");
                    String stuNumber = validNumber();
                    System.out.print("请输入学生姓名:");
                    String stuName = sc.nextLine();
                    System.out.print("请输入学生三门课成绩(数学，英语，科学):");
                    int[] scores = validScore();
                    int math = scores[0];
                    int english = scores[1];
                    int science = scores[2];
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

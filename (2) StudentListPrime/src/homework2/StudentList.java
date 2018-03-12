package homework2;

import java.util.*;

public class StudentList
{
    private ArrayList<Student> list; //list存储学生对象
    private int total = 0; //学生总人数

    StudentList()
    {
    }

    StudentList(int length)
    {
        list = new ArrayList<Student>();
        total = length;
    }

    public ArrayList<Student> getList()
    {
        return list;
    }

    public void setList(ArrayList<Student> li)
    {
        list = li;
    }

    public boolean add(Student stu)
    {//增加stu到数组中，成功，返回true，否则false
        try
        {
            list.add(stu);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean remove(int no)
    {//删除第no个数组元素，删除成功，返回true，否则false
        if (no<=0 || no>list.size())
            return false;
        try
        {
            list.remove(no-1);
            return true;
        }
        catch (Exception e)
        {
            System.err.println("error!");
            return false;
        }
    }

    public boolean remove(String number)
    {//删除学号为number的学生，删除成功，返回true，否则false
        int location = locateNumber(number);
        try
        {
            if(location != -1)
            {
                list.remove(location);
                return true;
            }
            else
                return false;
        }
        catch(Exception e)
        {
            System.err.println("error!");
            return false;
        }
    }

    public boolean isEmpty()
    {
        return list.size() == 0;
    }

    public Student getItem(int no)
    {//返回第no个学生
        return list.get(no-1);
    }

    public Student getItem(String number)
    {//返回学号为number的学生，若该生不存在，返回null
        int location = locateNumber(number);
        if (location != -1)
            return list.get(location);
        else
            return null;
    }

    int getTotal()
    {
        return list.size();
    }

    public void ShowAllStu()
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println("第" + Integer.valueOf(i+1) + "个学生:");
            System.out.println(list.get(i).toString());
        }
    }
    private int locateNumber(String a)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getNumber().equals(a))
            {
                return i;
            }
        }
        return -1;
    }
}

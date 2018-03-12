package homework2;

public class StudentNumberException extends Exception
{
    public StudentNumberException()
    {

    }
    public void showInfo()
    {
        System.err.println("学号格式不正确，请重新输入");
    }
}

package homework2;

public class MenuInputException extends Exception
{
    public MenuInputException()
    {
        super("输入错误，请重试(1-8):");
    }
    public void showInfo()
    {
        System.err.print("输入错误，请重试(1-8):");
    }
}

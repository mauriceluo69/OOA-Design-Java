package homework2;

public class ScoreException extends Exception
{
    public ScoreException()
    {

    }
    public void showInfo()
    {
        System.err.println("成绩数据有误，请重新输入");
    }
}

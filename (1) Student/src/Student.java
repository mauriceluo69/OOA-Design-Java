public class Student
{
    private String studentNumber;
    private String studentName;
    private int markForMath = -1;
    private int markForEnglish = -1;
    private int markForScience = -1;

    Student()
    {
    }

    Student(String number, String name)
    {
        this.studentNumber = number;
        this.studentName = name;
    }

    public String getNumber() {return studentNumber;}
    public String getName() {return studentName;}
    public int getMarkForMath() {return markForMath;}
    public int getMarkForEnglish() {return markForEnglish;}
    public int getMarkForScience() {return markForScience;}

    public void enterMarks(int markForMath,int markForEnglish,int markForScience)
    {
        this.markForMath = markForMath;
        this.markForEnglish = markForEnglish;
        this.markForScience = markForScience;
    }
    public double calculateAverage()
    {
        return (markForMath + markForScience + markForEnglish)/3.0;
    }
    public String toString()
    {
        return ("学号:" + studentNumber + "\n姓名:" + studentName + "\n数学成绩:" + markForMath +
                "\n英语成绩:" + markForEnglish + "\n科学成绩:" + markForScience + "\n平均成绩:" + calculateAverage());
    }
}

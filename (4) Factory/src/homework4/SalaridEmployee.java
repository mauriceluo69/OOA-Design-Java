package homework4;

public class SalaridEmployee extends Employee
{
    private double weeklySalary;

    public SalaridEmployee(String _first,String _last,String _social)
    {
        super(_first,_last,_social);
    }

    @Override
    public double earning()
    {
        return this.weeklySalary * 4;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public String toString()
    {
        return ("Firstname:" + this.getFirstName() + "\tLastname:" + this.getLastName() +
                "\tSocial Security Number:"+ this.getSocialSecurityNumber() +
                "\tWeekly Salary:" + this.weeklySalary + "\tMonthly Salary:" + this.earning());
    }
}

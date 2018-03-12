package homework3;

public class HourlyEmployee extends Employee
{
    private double wage;
    private int hours;

    public double getWage() {
        return wage;
    }

    public int getHours() {
        return hours;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    double earning()
    {
        return wage * hours;
    }

    public String toString()
    {
        return ("Firstname:" + this.getFirstName() + "\tLastname:" + this.getLastName() +
                "\tSocial Security Number:"+ this.getSocialSecurityNumber() +
                "\tWage:" + this.wage +  "\tWorking hours:" + this.hours +
                "\tMonthly Salary:" + this.earning());
    }

}

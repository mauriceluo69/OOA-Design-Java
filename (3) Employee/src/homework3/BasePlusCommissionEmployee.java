package homework3;

public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary;//月基本工资

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    double earning()
    {
        return this.baseSalary + this.getGrossSales() * this.getCommissionRate();
    }

    public String toString()
    {
        return ("Firstname:" + this.getFirstName() + "\tLastname:" + this.getLastName() +
                "\tSocial Security Number:"+ this.getSocialSecurityNumber() +
                "\tGross sales:" + this.getGrossSales() +  "\tCommission Rate:" + this.getCommissionRate() +
                "\tBase Salary:" + this.baseSalary + "\tMonthly Salary:" + this.earning());
    }

}

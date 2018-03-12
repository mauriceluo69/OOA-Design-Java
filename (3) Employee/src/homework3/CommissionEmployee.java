package homework3;

public class CommissionEmployee extends Employee
{
    private double grossSales;//销售额
    private double commissionRate;//提成比率

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String toString()
    {
        return ("Firstname:" + this.getFirstName() + "\tLastname:" + this.getLastName() +
                "\tSocial Security Number:"+ this.getSocialSecurityNumber() +
                "\tGross sales:" + this.grossSales +  "\tCommission Rate:" + this.commissionRate +
                "\tMonthly Salary:" + this.earning());
    }

    @Override
    double earning() {
        return grossSales * commissionRate;
    }

}

package homework7;

import java.util.ArrayList;

public class CompositeBestforCustomer extends CopositeStrategy implements IPricingStrategy
{
    public CompositeBestforCustomer(String _strategynumber, ArrayList a, String _name, int _type)
    {
        super(_strategynumber, a, _name, _type);
    }

    public int getStrategytype() {
        return 3;
    }

    public double getSubTotal(SaleLineItem a)
    {
        double temp, min = strategies.get(0).getSubTotal(a);
        for (IPricingStrategy value : strategies)
        {
            temp = value.getSubTotal(a);
            if (temp < min)
                return min = temp;
        }
        return min;
    }

    public double getnumber() {
        return 0;
    }

    public void update(double a, int b, String _name) {
        ;
    }
}

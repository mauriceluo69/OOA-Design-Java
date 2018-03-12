package homework6;

public class NoDiscountStrategy implements IPricingStrategy
{
    @Override
    public double getSubTotal(SaleLineItem a) {
        return a.getProdSpec().getPrice();
    }
}

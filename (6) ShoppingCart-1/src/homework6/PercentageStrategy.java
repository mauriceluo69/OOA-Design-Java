package homework6;

public class PercentageStrategy implements IPricingStrategy
{
    private int discountPercentage;

    public PercentageStrategy(int _discountPercentage)
    {
        discountPercentage = _discountPercentage;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getSubTotal(SaleLineItem a)
    {
        return (a.getProdSpec().getPrice() * (1-this.discountPercentage/100.0));
    }
}

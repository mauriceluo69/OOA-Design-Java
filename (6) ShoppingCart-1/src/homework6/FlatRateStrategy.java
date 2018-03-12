package homework6;

public class FlatRateStrategy implements IPricingStrategy
{
    private double discountPerBook;

    public FlatRateStrategy(double _discountPerBook)
    {
        discountPerBook = _discountPerBook;
    }

    public double getDiscountPerBook() {
        return discountPerBook;
    }

    public void setDiscountPerBook(double discountPerBook) {
        this.discountPerBook = discountPerBook;
    }

    @Override
    public double getSubTotal(SaleLineItem a)
    {
        return a.getProdSpec().getPrice() - this.discountPerBook;
    }
}

package homework6;


public class SaleLineItem
{
    private int copies;
    private ProductSpecification prodSpec;
    private IPricingStrategy strategy;

    public SaleLineItem(int _copies, ProductSpecification _prodSpec, IPricingStrategy _strategy)
    {
        copies = _copies;
        prodSpec = _prodSpec;
        strategy = _strategy;
    }

    public int getCopies() {
        return copies;
    }

    public ProductSpecification getProdSpec() {
        return prodSpec;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setProdSpec(ProductSpecification prodSpec) {
        this.prodSpec = prodSpec;
    }

    public IPricingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IPricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double getSubTotal()
    {
        return strategy.getSubTotal(this) * this.copies;
    }
}

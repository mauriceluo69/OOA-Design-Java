package homework7;

public class SaleLineItem {
	
	  private int copies;
	  private BookSpecification prodSpec;
	  private IPricingStrategy strategy;

	  public SaleLineItem(int _copies, BookSpecification _prodSpec, IPricingStrategy _strategy) 
	  {
	    copies = _copies;
	    prodSpec = _prodSpec;
	    strategy = _strategy;
	  }
	  
	  public double getoriginalcost() 
	  {
		  return prodSpec.getprice();
	  }
	  
	  public int getcopies()
	  {
		  return copies;
	  }
	  
	  public String gettitle()
	  {
		  return prodSpec.gettitle();
	  }
	  
	  public double getSubTotal() 
	  {
		  return strategy.getSubTotal(this) * copies;
	  }
	  
	  public String getisbn()
	  {
		  return prodSpec.getisbn();
	  } 
	  public void addcopies(int inccopies)
	  {
		  copies+=inccopies;
	  }
	}

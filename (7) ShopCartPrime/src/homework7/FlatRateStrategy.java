package homework7;

import java.util.ArrayList;

public class FlatRateStrategy  implements IPricingStrategy {
	
	private double discountPerbook;
	private int type;
	private String strategynumber;
	private String name;

	public FlatRateStrategy(String _strategynumber, double _discountPerbook, int _type, String _name) 
	{
		strategynumber = _strategynumber;
		discountPerbook = _discountPerbook;
		type = _type;
		name = _name;
	}
	
	public void update(double _discountPerbook, int _type, String _name) 
	{
		discountPerbook = _discountPerbook;
		type = _type;
		name = _name;
	}

	public int getStrategytype() 
	{
		return 2;
	}
	
	public int gettype() 
	{
		return type;
	}
	
	public String getname() 
	{
		return name;
	}
	
	public String getStrategynumber() 
	{
		return strategynumber;
	}
	
	public double getnumber() 
	{
		return discountPerbook;
	}
	
	public double getSubTotal(SaleLineItem a) 
	{
		return a.getoriginalcost() - discountPerbook;
	}

	public void update2(ArrayList _strategies, String _name, int _type) 
	{
		;
	}
	
	public boolean isin(IPricingStrategy a) 
	{
		return false;
	}
}

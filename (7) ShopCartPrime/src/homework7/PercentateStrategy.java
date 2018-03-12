package homework7;

import java.util.ArrayList;

public class PercentateStrategy  implements IPricingStrategy
{
	
	private double discountPercentage;
	private int type;
	private String strategynumber;
	private String name;
		
	public String getname()
	{
			return name;
	}
	
	public String getStrategynumber()
	{
		return strategynumber;
	}
	
	public double getSubTotal(SaleLineItem a) 
	{
		return a.getoriginalcost() * (1 - discountPercentage);
	}
	
	public PercentateStrategy(String _strategynumber,double _discountPercentage,int _type,String _name) 
	{
		strategynumber=_strategynumber;
		discountPercentage = _discountPercentage;
		type=_type;
		name=_name;
	}
	
	public void update(double _discountPercentage,int _type,String _name)
	{
		discountPercentage = _discountPercentage;
		type=_type;
		name=_name;
	}
	
	public double getnumber()
	{
		return discountPercentage;
	}
	
	public int getStrategytype()
	{
		return 1;
	}
	
	public int gettype()
	{
		return type;
	}
	
	public void update2(ArrayList _strategies,String _name,int _type)
	{
		;
	}
	
	public boolean isin(IPricingStrategy a)
	{
		return false;
	}
}

package homework7;

import java.util.ArrayList;

public class NoDiscountStrategy  implements IPricingStrategy {
	
	private String strategynumber;
	private String name="";
	
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
		return a.getoriginalcost();
	}
	
	public double getnumber()
	{
		return 0;
	}
	
	public int gettype()
	{
		return 5;
	}
	
	public void update(double a,int b,String _name)
	{
		;
	}
	
	public int getStrategytype()
	{
		return 4;
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


package homework7;

import java.util.ArrayList;

public abstract class CopositeStrategy
{
	
	protected ArrayList <IPricingStrategy> strategies;
	private String strategynumber;
	private int type;
	private String name;
	
	public String getname() 
	{
		return name;
	}
	
	public String getStrategynumber() 
	{
		return strategynumber;
	}
	
	public void add(IPricingStrategy a) 
	{
		strategies.add(a);
	}
	
	public abstract double getSubTotal(SaleLineItem a);
	
	public int gettype() 
	{
		return type;
	}
	
	public CopositeStrategy(String _strategynumber,ArrayList _strategies,String _name, int _type) 
	{
		strategynumber=_strategynumber;
		strategies=_strategies;
		type = _type;
		name = _name;
	}
	
	public ArrayList getstrategies() 
	{
		return strategies;
	}
	
	public abstract int getStrategytype();
	
	public void update2(ArrayList _strategies,String _name,int _type)
	{
		strategies=_strategies;
		type = _type;
		name = _name;
	}
	
	public boolean isin(IPricingStrategy obj)
	{
		if(strategies.indexOf(obj)==-1)
			return false;
		else
			return true;
	}
}
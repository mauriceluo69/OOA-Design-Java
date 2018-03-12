package homework7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class strategyCatalog
{
  
	private HashMap < String, IPricingStrategy > strategies = new HashMap < String, IPricingStrategy > ();

	public void AddStrategy(IPricingStrategy a) 
	{
		strategies.put(a.getStrategynumber(), a);
	}
	
	public void deleteStrategy(String a) 
	{
		strategies.remove(a);
	}
	
	public void updateStrategy(String a, double value, int kind, String name) 
	{
		IPricingStrategy b = strategies.get(a);
		b.update(value, kind, name);
		strategies.put(a, b);
	}
	
	public void updateCompositeStrategy(String a, ArrayList _strategies, String name, int _type) 
	{
		IPricingStrategy b = strategies.get(a);
		b.update2(_strategies, name, _type);
		strategies.put(a, b);
	}

	public IPricingStrategy getStrategy(String strategynumber) 
	{
		return strategies.get(strategynumber);
	}

	public IPricingStrategy getStrategybytype(int bookType) 
	{
		for ( Entry < String, IPricingStrategy > value : strategies.entrySet()) 
		{
			if (bookType == value.getValue().gettype())
				return value.getValue();
		}
		NoDiscountStrategy a = new NoDiscountStrategy();
		return (IPricingStrategy) a;
	}
	
	public HashMap getStrategies() 
	{
		return strategies;
	}
}

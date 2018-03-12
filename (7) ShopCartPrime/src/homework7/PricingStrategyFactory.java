package homework7;

import java.util.ArrayList;
import java.util.HashMap;

public class PricingStrategyFactory {

	private int i=1;
	private static PricingStrategyFactory instance;
	private strategyCatalog catalog=new strategyCatalog();
	private PricingStrategyFactory() {}
	
	public static PricingStrategyFactory getlnstance() 
	{
		if ( instance == null )
			instance = new PricingStrategyFactory();
		return instance;
	}
	
	public IPricingStrategy getPricingStrategy(int bookType) 
	{
		return catalog.getStrategybytype(bookType);
	}
	
	public void AddStrategy(IPricingStrategy a) 
	{
		catalog.AddStrategy(a);
	}
	
	public void updateStrategy(String a, double value, int kind,String name) 
	{
		catalog.updateStrategy(a, value, kind,name);
	}
	
	public IPricingStrategy getStrategy(String strategynumber) 
	{
		return catalog.getStrategy(strategynumber);
	}
	
	public HashMap getStrategies() 
	{
		return catalog.getStrategies();
	}
	
	public void deleteStrategy(String a) 
	{
		catalog.deleteStrategy(a);
	}
	
	public void updateCompositeStrategy(String a,ArrayList strategies,String name,int type) 
	{
		catalog.updateCompositeStrategy(a,strategies,name,type);
	}
	
	public String assignstrategynumber() 
	{
        String str="Discount"+String.format("%03d",i);
        i++;
        return str;
	}
}
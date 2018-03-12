package homework7;

import java.util.ArrayList;

public interface IPricingStrategy {
	
	public double getSubTotal(SaleLineItem a);
	
	public String getStrategynumber();
	
	public int gettype();
	
	public void update(double a,int b,String _name);
	
	public double getnumber();
	
	public String getname();
	
	public int getStrategytype();
	
	public void update2(ArrayList _strategies,String _name,int _type);
	
	public boolean isin(IPricingStrategy a);
}
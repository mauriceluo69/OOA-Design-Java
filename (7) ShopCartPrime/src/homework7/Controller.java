package homework7;

import java.util.ArrayList;

public class Controller
{

	private Sale sale = new Sale();

	public void Addbook(String _isbn, double _price, String _name, int _type)
	{
		BookSpecification a = new BookSpecification(_isbn, _price, _name, _type);
		BookCatalog.getlnstance().Addbook(a);
	}

	public void AddSimpleStrategy(int strategykind, double value, int kind, String name)
	{
		switch (strategykind)
		{
			case 1:
				PercentateStrategy a = new PercentateStrategy(PricingStrategyFactory.getlnstance().assignstrategynumber(),value, kind, name);
				PricingStrategyFactory.getlnstance().AddStrategy(a);
				break;

			case 2:
				FlatRateStrategy b = new FlatRateStrategy(PricingStrategyFactory.getlnstance().assignstrategynumber(),value, kind, name);
				PricingStrategyFactory.getlnstance().AddStrategy(b);
				break;

			default:
				break;
		}
	}

	public void AddCompositeStrategy(ArrayList _strategies,String _name,int _type)
	{
		CompositeBestforCustomer a = new CompositeBestforCustomer(PricingStrategyFactory.getlnstance().assignstrategynumber(),_strategies,_name,_type);
		PricingStrategyFactory.getlnstance().AddStrategy(a);
	}

	public void deleteStrategy(String a)
	{
		PricingStrategyFactory.getlnstance().deleteStrategy(a);
	}

	public void updateSimpleStrategy(String a, double value, int kind,String name)
	{
		PricingStrategyFactory.getlnstance().updateStrategy(a, value, kind,name);
	}

	public void updateCompositeStrategy(String a,ArrayList strategies,String name,int type)
	{
		PricingStrategyFactory.getlnstance().updateCompositeStrategy(a,strategies,name,type);
	}

	public void buyBook(String isbn, int copies)
	{
		BookSpecification a = BookCatalog.getlnstance().get(isbn);
		if(a!=null)
			sale.addBook(a, copies, PricingStrategyFactory.getlnstance().getPricingStrategy(a.gettype()));
		else
			javax.swing.JOptionPane.showMessageDialog(null, "不存在该ISBN对应的书。");
	}

	public Sale getSale()
	{
		return sale;
	}
}
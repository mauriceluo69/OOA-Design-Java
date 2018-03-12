package homework7;

import java.util.ArrayList;

public class SaleTest
{
	public static void main(String[] args)
	{

		MainUI mainui= new MainUI();

		BookSpecification book1 = new BookSpecification("978-7-302-2", 18, "UML与模式应用", 2);
		BookSpecification book2 = new BookSpecification("978-7-312-3", 34, "Java与模式", 1);
		BookSpecification book3 = new BookSpecification("968-6-302-1", 58, "HeadFirst设计模式", 1);
		BookSpecification book4 = new BookSpecification("958-1-302-2", 30, "爱丽丝历险记", 3);
		BookSpecification book5 = new BookSpecification("900-7-392-2", 20, "煲汤大全", 4);

		BookCatalog.getlnstance().Addbook(book1);
		BookCatalog.getlnstance().Addbook(book2);
		BookCatalog.getlnstance().Addbook(book3);
		BookCatalog.getlnstance().Addbook(book4);
		BookCatalog.getlnstance().Addbook(book5);

		FlatRateStrategy a = new FlatRateStrategy(PricingStrategyFactory.getlnstance().assignstrategynumber(), 1, 2, "绝对值优惠策略1");
		PricingStrategyFactory.getlnstance().AddStrategy(a);

		PercentateStrategy b = new PercentateStrategy(PricingStrategyFactory.getlnstance().assignstrategynumber(), 0.07, 3, "百分比折扣策略1");
		PricingStrategyFactory.getlnstance().AddStrategy(b);

		PercentateStrategy c = new PercentateStrategy(PricingStrategyFactory.getlnstance().assignstrategynumber(), 0.03, 1, "百分比折扣策略2");
		PricingStrategyFactory.getlnstance().AddStrategy(c);

		ArrayList < IPricingStrategy > strategies = new ArrayList < IPricingStrategy > ();
		strategies.add(a);
		strategies.add(c);

		CompositeBestforCustomer d = new CompositeBestforCustomer(PricingStrategyFactory.getlnstance().assignstrategynumber(), strategies, "顾客最优策略1", 4);
		PricingStrategyFactory.getlnstance().AddStrategy(d);

		mainui.testbuybook("978-7-302-2", 2);
		mainui.testbuybook("978-7-312-3", 2);
		mainui.testbuybook("968-6-302-1", 1);
		mainui.testbuybook("958-1-302-2", 3);
		mainui.testbuybook("900-7-392-2", 3);
	}
}

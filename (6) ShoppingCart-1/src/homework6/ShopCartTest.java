package homework6;

import java.text.DecimalFormat;
import java.util.Formatter;

public class ShopCartTest
{
    public static void main(String args[])
    {
        ProductSpecification book1 = new ProductSpecification("978-7-302-2", 18, "UML与模式应用",2);       //教材
        ProductSpecification book2 = new ProductSpecification("978-7-312-3", 34, "Java与模式", 1);        //非教材计算机
        ProductSpecification book3 = new ProductSpecification("968-6-302-1", 58, "HeadFirst设计模式", 1); //非教材计算机
        ProductSpecification book4 = new ProductSpecification("958-1-302-2", 30, "爱丽丝历险记", 3);      //连环画
        ProductSpecification book5 = new ProductSpecification("900-7-392-2", 20, "煲汤大全", 4);         //其他

        FlatRateStrategy strategy1 = new FlatRateStrategy(1);
        PercentageStrategy strategy2 = new PercentageStrategy(3);
        PercentageStrategy strategy3 = new PercentageStrategy(3);
        PercentageStrategy strategy4 = new PercentageStrategy(7);
        NoDiscountStrategy strategy5 = new NoDiscountStrategy();

        SaleLineItem sale1 = new SaleLineItem(2,book1,strategy1);
        SaleLineItem sale2 = new SaleLineItem(2,book2,strategy2);
        SaleLineItem sale3 = new SaleLineItem(1,book3,strategy3);
        SaleLineItem sale4 = new SaleLineItem(3,book4,strategy4);
        SaleLineItem sale5 = new SaleLineItem(1,book5,strategy5);

        Sale order = new Sale();
        order.getItems().add(sale1);
        order.getItems().add(sale2);
        order.getItems().add(sale3);
        order.getItems().add(sale4);
        order.getItems().add(sale5);

        DecimalFormat df = new DecimalFormat(".##");
        Formatter formatter = new Formatter(System.out);

        System.out.println("折扣后总价格为：" + df.format(order.getTotal()) + "元");
        System.out.println(order.getItems().size() + "个订单信息如下:");
        for(int i = 0; i < order.getItems().size() ; i++)
        {
            String str1 = ("书名:《" + order.getItems().get(i).getProdSpec().getTitle() + "》");
            String str2 = ("单价:" + df.format(order.getItems().get(i).getSubTotal()/order.getItems().get(i).getCopies()) + "元");
            String str3 = ("份数:" + order.getItems().get(i).getCopies());

            formatter.format("%-25s %-10s %-7s \n", str1,str2,str3);
        }

        formatter.close();
    }
}

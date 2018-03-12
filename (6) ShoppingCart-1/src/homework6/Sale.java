package homework6;

import java.util.*;
import java.text.*;

public class Sale
{
    private ArrayList<SaleLineItem> items = new ArrayList<>();

    public double getTotal()
    {
        double sum = 0;

        for (int i = 0; i<items.size(); i++)
            sum += items.get(i).getSubTotal();

        return sum;
    }

    public ArrayList<SaleLineItem> getItems() {
        return items;
    }
}

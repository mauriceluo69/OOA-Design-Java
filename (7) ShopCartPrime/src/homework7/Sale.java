package homework7;

import java.util.ArrayList;

public class Sale implements Subject {

    private ArrayList<SaleLineItem> items;
    private ArrayList<Observer> observers;

    public Sale() {
        items = new ArrayList<SaleLineItem>();
        observers = new ArrayList<Observer>();
    }

    public void addBook(BookSpecification abook, int copies, IPricingStrategy strategy) {
        if (observers.isEmpty()) {
            Shoppingcart shoppingcart = new Shoppingcart(this);
            registerObserver(shoppingcart);
        }

        boolean flag = true;

        for (SaleLineItem value : items) {
            if (value.getisbn() == abook.getisbn()) {
                value.addcopies(copies);
                flag = false;
                notifyObserver();
            }
        }

        if (flag == true) {
            SaleLineItem a = new SaleLineItem(copies, abook, strategy);
            items.add(a);
            notifyObserver();
        }
    }

    public double getTotal() {
        double sum = 0;
        for (SaleLineItem value : items) {
            sum += value.getSubTotal();
        }
        return sum;
    }

    public ArrayList getitems() {
        return items;
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
        observers.clear();
        System.out.println("您提前结束了输入。");
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

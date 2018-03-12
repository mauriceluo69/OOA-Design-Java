package homework6;

public class ProductSpecification
{
    public static final int computerBook = 1;
    public static final int textBook = 2;
    public static final int comic = 3;
    public static final int others = 4;

    private String isbn;
    private double price;
    private String title;
    private int type;

    public ProductSpecification(String _isbn, double _price, String _title, int _type)
    {
        this.isbn = _isbn;
        this.price = _price;
        this.title = _title;
        this.type = _type;
    }

    public double getPrice() {
        return price;
    }

//    public int getType() {
//        return type;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
    public String getTitle() {
        return title;
    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//    }

}

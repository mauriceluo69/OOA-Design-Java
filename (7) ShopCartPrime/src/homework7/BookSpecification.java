package homework7;

public class BookSpecification
{
	
	private String isbn;
	private double price;
	private String name;
	private int type;
	
	public BookSpecification(String _isbn, double _price, String _name, int _type) 
	{
		isbn = _isbn;
		price = _price;
		name = _name;
		type = _type;
	}
	
	public String getisbn() 
	{
		return isbn;
	}
	
	public String gettitle() 
	{
		return name;
	}
	
	public double getprice() 
	{
		return price;
	}
	
	public int gettype() 
	{
		return type;
	}
}

package homework7;

import java.util.ArrayList;

public class BookCatalog
{
	private static BookCatalog instance;
	private ArrayList <BookSpecification> books=new ArrayList < BookSpecification >();
	private BookCatalog() {}
	
	public static BookCatalog getlnstance() 
	{
		if ( instance == null )
			instance = new BookCatalog();
		return instance;
	}
	
	public void Addbook(BookSpecification a) 
	{
		books.add(a);
	}
	
	public BookSpecification get(String isbn) 
	{
		for (BookSpecification value : books)
			if (value.getisbn().equals(isbn))
				return value;
		return null;
	}
	
	public ArrayList getbooks()
	{
		return books;
	}
}
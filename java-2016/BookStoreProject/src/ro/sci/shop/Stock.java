package ro.sci.shop;

import java.util.ArrayList;
import java.util.List;

/*
 * The stock depends of isbn. That's how we find a book and modify quantity in stockList;
 */

public class Stock {

	// this does not quite belong here
	List<Stock> stockList = new ArrayList<Stock>();

	public int quantity;
	public long isbn;

	public Stock(int quantity, long isbn) {
		super();
		this.quantity = quantity;
		this.isbn = isbn;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public Stock() {
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	public void addStock(Stock s) {
		stockList.add(s);
	}

	public Stock getStockByIsbn(long isbn) {
		for (Stock stock : stockList) {
			if (stock.getIsbn() == isbn) {
				return stock;
			}
		}
		return new Stock();

	}

	public void updateStock(long isbn, int noOfBooks) {
		//what would you expect this to do ?
		getStockByIsbn(isbn);
		setQuantity(getQuantity() - noOfBooks);
	}

}

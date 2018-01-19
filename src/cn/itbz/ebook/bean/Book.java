package cn.itbz.ebook.bean;

public class Book {
	private Integer id;
	private String bookName;
	private Double price;
	private String images;
	private Integer stock;
	private Double discounting;
	private String bookTypeName;
	
	public Book() {
		
	}
	
	public Book(Integer id, String bookName, Double price, String images,
			Integer stock, Double discounting, String bookTypeName) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.images = images;
		this.stock = stock;
		this.discounting = discounting;
		this.bookTypeName = bookTypeName;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", price=" + price
				+ ", images=" + images + ", stock=" + stock
				+ ", discounting=" + discounting + ", bookTypeName="
				+ bookTypeName + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStockl(Integer stock) {
		this.stock = stock;
	}

	public Double getDiscounting() {
		return discounting;
	}

	public void setDiscounting(Double discounting) {
		this.discounting = discounting;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	
}

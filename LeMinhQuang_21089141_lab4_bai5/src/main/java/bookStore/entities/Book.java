package bookStore.entities;

import java.util.Objects;

public class Book {
	private Integer bookId;
	private String code;
	private String title;
	private Double price;
	private Integer quantity;
	private String author;
	private String description;
	private String imageUrl;
	public Book() {
	}

	public Book(Integer bookId, String code, String title, Double price, Integer quantity, String author,
			String description, String imageUrl) {
		this.bookId = bookId;
		this.code = code;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.author = author;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", code=" + code + ", title=" + title + ", price=" + price + ", quantity="
				+ quantity + ", author=" + author + ", description=" + description + ", imageUrl=" + imageUrl + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookId, other.bookId);
	}
	

}

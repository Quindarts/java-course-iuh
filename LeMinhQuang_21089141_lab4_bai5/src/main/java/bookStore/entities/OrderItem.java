package bookStore.entities;

public class OrderItem {
	private Integer orderItemId;
	private Order order;
	private Book book;
	private Integer quantity;

	// Constructors
	public OrderItem() {
	}

	
	public OrderItem(Book book, Integer quantity) {
		super();
		this.book = book;
		this.quantity = quantity;
	}


	public OrderItem(Integer orderItemId, Order order, Book book, Integer quantity) {
		this.orderItemId = orderItemId;
		this.order = order;
		this.book = book;
		this.quantity = quantity;
	}

	// Getters and Setters
	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double totalItem() {
		return (double) this.book.getPrice() * this.quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", order=" + order + ", book=" + book + ", quantity="
				+ quantity + "]";
	}
	
}

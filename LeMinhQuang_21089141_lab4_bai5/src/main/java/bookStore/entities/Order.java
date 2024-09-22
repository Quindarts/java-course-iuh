package bookStore.entities;

import java.util.List;

public class Order {
	private Integer orderId;
	private String fullname;
	private String shippingAddress;
	private List<OrderItem> items;
	private String paymentMethod;

	public Order() {
	}

	public Order(Integer orderId, String fullname, String shippingAddress, Double totalPrice, String paymentMethod) {
		this.orderId = orderId;
		this.fullname = fullname;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
	}

	public double totalOrder() {
		double total = 0;
		for (int i = 0; i < this.items.size(); i++) {
			total += items.get(i).totalItem();
		}
		return total;

	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	

}
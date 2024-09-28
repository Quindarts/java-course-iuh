package shopping.entities;

public class ItemCart {
	private Product product;
	private int quantity;

	public ItemCart() {
	}

	public ItemCart(Product product, int quantity) {
		this.setProduct(product);
		this.setQuantity(quantity);
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
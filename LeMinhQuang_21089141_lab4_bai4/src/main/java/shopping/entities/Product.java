package shopping.entities;

public class Product {
	private int id;
	private String name;
	private double price;
	private String image;

	public Product() {
	}

	public Product(String name, double price, String image) {
		this.setName(name);
		this.setPrice(price);
		this.setImage(image);
	}

	public Product(int id, String name, double price, String image) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setImage(image);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String toString() {
		return "Product [id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", image=" + this.image
				+ "]";
	}
}

package shopping.dao;

import java.util.List;

import javax.naming.NamingException;

import shopping.entities.Product;

public interface ProductDAO {
	
	List<Product> findAll() throws NamingException, Throwable;
	Product getById(int var1) throws Throwable;
	void addProduct(Product var1) throws Throwable;
}

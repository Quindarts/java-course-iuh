package bookStore.dao;

import javax.naming.NamingException;

import bookStore.entities.Order;

public interface OrderDAO {
	boolean createOrder(Order order) throws NamingException, Throwable;
}

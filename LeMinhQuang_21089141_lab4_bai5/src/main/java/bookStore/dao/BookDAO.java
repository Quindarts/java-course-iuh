package bookStore.dao;

import java.util.List;

import javax.naming.NamingException;

import bookStore.entities.Book;

public interface BookDAO {

	List<Book> findAll() throws NamingException, Throwable;

	Book getById(int var1) throws Throwable;

	void addProduct(Book var1) throws Throwable;
}

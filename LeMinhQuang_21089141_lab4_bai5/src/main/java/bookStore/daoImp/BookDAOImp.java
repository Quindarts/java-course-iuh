package bookStore.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import bookStore.dao.BookDAO;
import bookStore.entities.Book;
import jakarta.annotation.Resource;

public class BookDAOImp implements BookDAO {
	@Resource(lookup = "java:comp/env/jdbc/bookStore")
	protected DataSource ds;

	public List<Book> findAll() {
		String sql = "SELECT * FROM Books";
		ArrayList<Book> list = new ArrayList<Book>();

		InitialContext initCtx = null;
		try {
			initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/bookStore");
			Connection conn = ds.getConnection();
			System.out.println(conn);
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int bookId = rs.getInt("bookId");
				String code = rs.getString("code");
				Double price = Double.valueOf(rs.getFloat("price"));
				String imageUrl = rs.getString("imageUrl");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				list.add(new Book(bookId, code, title, price, quantity, author, description, imageUrl));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public Book getById(int id) {
		String sql = "SELECT * FROM Books WHERE bookId = ?";
		Book book = null;
		InitialContext initCtx = null;
		try {
			initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/bookStore");
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int bookId = rs.getInt("bookId");
				String code = rs.getString("code");
				Double price = Double.valueOf(rs.getFloat("price"));
				String imageUrl = rs.getString("imageUrl");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");

				book = new Book(bookId, code, title, price, quantity, author, description, imageUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void addProduct(Book book) throws Throwable {
		String sql = "INSERT INTO Books (code, title, price, quantity, author, description, imageUrl) VALUES (?, ?, ?, ?, ?, ?, ?)";
		InitialContext initCtx = null;
		try {
			initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/bookStore");
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, book.getCode());
			ps.setString(2, book.getTitle());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getQuantity());
			ps.setString(5, book.getAuthor());
			ps.setString(6, book.getDescription());
			ps.setString(7, book.getImageUrl());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

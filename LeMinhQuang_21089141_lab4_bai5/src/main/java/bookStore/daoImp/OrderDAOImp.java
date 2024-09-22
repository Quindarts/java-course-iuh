package bookStore.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bookStore.dao.OrderDAO;
import bookStore.entities.Order;
import bookStore.entities.OrderItem;
import jakarta.annotation.Resource;

public class OrderDAOImp implements OrderDAO {
	@Resource(lookup = "java:comp/env/jdbc/bookStore")
	protected DataSource ds;

	@Override
	public boolean createOrder(Order order) throws NamingException, Throwable, SQLException {
		InitialContext initCtx = null;
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement psOrderItem = null;

		try {
			if (order.getItems().size() == 0) {
				return false;
			}

			// Thiết lập kết nối
			initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/bookStore");
			conn = ds.getConnection();
			conn.setAutoCommit(false); // Bắt đầu transaction

			// Thêm đơn hàng
			String sql = "INSERT INTO Orders (fullname, shippingAddress, total_price, paymentMethod) VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, order.getFullname());
			ps.setString(2, order.getShippingAddress());
			ps.setDouble(3, order.totalOrder());
			ps.setString(4, order.getPaymentMethod());
			ps.executeUpdate();

			// Lấy orderId mới tạo
			ResultSet generatedKeys = ps.getGeneratedKeys();
			System.out.println(generatedKeys);
			if (generatedKeys.next()) {
				int orderId = generatedKeys.getInt(1); // orderId vừa tạo
				System.out.println(orderId);
				String sqlOrderItem = "INSERT INTO OrderItems (orderId, bookId, quantity) VALUES (?, ?, ?)";
				psOrderItem = conn.prepareStatement(sqlOrderItem);
				for (OrderItem item : order.getItems()) {
					psOrderItem.setInt(1, orderId);
					psOrderItem.setInt(2, item.getBook().getBookId());
					psOrderItem.setInt(3, item.getQuantity());
					psOrderItem.executeUpdate();
				}
			}

			// Cam kết transaction
			conn.commit();
			return true;

		} catch (Exception e) {
			if (conn != null) {
				conn.rollback(); // Rollback nếu có lỗi
			}
			e.printStackTrace();
		} finally {
			// Đóng các tài nguyên
			if (psOrderItem != null)
				psOrderItem.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}
		return false;
	}

}
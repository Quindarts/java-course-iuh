package bookStore.controllers;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;

import bookStore.dao.OrderDAO;
import bookStore.daoImp.OrderDAOImp;
import bookStore.entities.Order;
import bookStore.entities.OrderItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/payment")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO orderDAO = null;

	public OrderController() {
		super();
		orderDAO = new OrderDAOImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Order.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullname = request.getParameter("fullname");
		String shippingAddress = request.getParameter("address");
		String paymentMethod = request.getParameter("payment-method");
		System.out.println(fullname);
		double total = 0;
		List<OrderItem> cart = (List<OrderItem>) request.getSession().getAttribute("cart");
		if (cart != null) {
			for (OrderItem item : cart) {
				total += item.getBook().getPrice() * item.getQuantity();
			}
		}
		Order order = new Order();
		order.setFullname(fullname);
		order.setShippingAddress(shippingAddress);
		order.setItems(cart);
		order.setPaymentMethod(paymentMethod);
		try {
			if (orderDAO.createOrder(order)) {
				HttpSession session = request.getSession();
				request.setAttribute("fullname", order.getFullname());
				request.setAttribute("shippingAddress", order.getShippingAddress());
				request.setAttribute("totalPrice", order.totalOrder());
				request.setAttribute("paymentMethod", order.getPaymentMethod());
				request.getRequestDispatcher("success.jsp").forward(request, response);
				session.setAttribute("cart", null);
			}

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
}

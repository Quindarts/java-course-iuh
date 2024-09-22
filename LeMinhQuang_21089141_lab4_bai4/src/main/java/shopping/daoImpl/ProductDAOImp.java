package shopping.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.annotation.Resource;
import shopping.config.DBConnection;
import shopping.dao.ProductDAO;
import shopping.entities.Product;

public class ProductDAOImp implements ProductDAO {
	@Resource(lookup = "java:comp/env/jdbc/shopping")
	protected DataSource ds1;

	public List<Product> findAll() throws Throwable {
		System.out.println(this.ds1);
		InitialContext initCtx = null;
		try {
			initCtx = new InitialContext();
		} catch (NamingException var48) {
			var48.printStackTrace();
		}
		try {
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/shopping");
			try {
				Connection conn = ds.getConnection();
				System.out.println(conn);
			} catch (SQLException var46) {
				var46.printStackTrace();
			}
		} catch (NamingException var47) {
			var47.printStackTrace();
		}

		String sql = "SELECT * FROM product";
		ArrayList list = new ArrayList();

		try {
			Throwable var5 = null;
			Object var6 = null;

			try {
				Connection con = DBConnection.getConnection();

				try {
					PreparedStatement ps = con.prepareStatement(sql);

					try {
						ResultSet rs = ps.executeQuery();

						try {
							while (rs.next()) {
								int id = rs.getInt("id");
								String name = rs.getString("name");
								Double price = Double.valueOf(rs.getFloat("price"));
								String image = rs.getString("image");
								list.add(new Product(id, name, price, image));
							}
						} finally {
							if (rs != null) {
								rs.close();
							}

						}
					} catch (Throwable var50) {
						if (var5 == null) {
							var5 = var50;
						} else if (var5 != var50) {
							var5.addSuppressed(var50);
						}

						if (ps != null) {
							ps.close();
						}

						throw var5;
					}

					if (ps != null) {
						ps.close();
					}
				} catch (Throwable var51) {
					if (var5 == null) {
						var5 = var51;
					} else if (var5 != var51) {
						var5.addSuppressed(var51);
					}

					if (con != null) {
						con.close();
					}

					throw var5;
				}

				if (con != null) {
					con.close();
				}
			} catch (Throwable var52) {
				if (var5 == null) {
					var5 = var52;
				} else if (var5 != var52) {
					var5.addSuppressed(var52);
				}

				throw var5;
			}
		} catch (SQLException var53) {
			var53.printStackTrace();
		}
		return list;
	}

	public Product getById(int id) throws Throwable {
		String sql = "SELECT * FROM product WHERE id=?";
		Product p = null;

		try {
			Throwable var4 = null;
			Object var5 = null;

			try {
				Connection con = DBConnection.getConnection();

				try {
					PreparedStatement ps = con.prepareStatement(sql);

					try {
						ps.setInt(1, id);
						Throwable var8 = null;
						Object var9 = null;

						try {
							ResultSet rs = ps.executeQuery();

							try {
								while (rs.next()) {
									String name = rs.getString("name");
									Double price = rs.getDouble("price");
									String image = rs.getString("image");
									p = new Product(id, name, price, image);
								}
							} finally {
								if (rs != null) {
									rs.close();
								}

							}
						} catch (Throwable var45) {
							if (var8 == null) {
								var8 = var45;
							} else if (var8 != var45) {
								var8.addSuppressed(var45);
							}

							throw var8;
						}
					} finally {
						if (ps != null) {
							ps.close();
						}

					}
				} catch (Throwable var47) {
					if (var4 == null) {
						var4 = var47;
					} else if (var4 != var47) {
						var4.addSuppressed(var47);
					}

					if (con != null) {
						con.close();
					}

					throw var4;
				}

				if (con != null) {
					con.close();
				}
			} catch (Throwable var48) {
				if (var4 == null) {
					var4 = var48;
				} else if (var4 != var48) {
					var4.addSuppressed(var48);
				}

				throw var4;
			}
		} catch (SQLException var49) {
			var49.printStackTrace();
		}

		return p;
	}

	public void addProduct(Product p) throws Throwable {
		String sql = "INSERT INTO product (name, price, image) VALUES (?,?,?)";

		try {
			Throwable var3 = null;
			Object var4 = null;

			try {
				Connection con = DBConnection.getConnection();

				try {
					PreparedStatement ps = con.prepareStatement(sql);

					try {
						ps.setString(1, p.getName());
						ps.setDouble(2, p.getPrice());
						ps.setString(3, p.getImage());
						ps.executeUpdate();
					} finally {
						if (ps != null) {
							ps.close();
						}

					}
				} catch (Throwable var20) {
					if (var3 == null) {
						var3 = var20;
					} else if (var3 != var20) {
						var3.addSuppressed(var20);
					}

					if (con != null) {
						con.close();
					}

					throw var3;
				}

				if (con != null) {
					con.close();
				}
			} catch (Throwable var21) {
				if (var3 == null) {
					var3 = var21;
				} else if (var3 != var21) {
					var3.addSuppressed(var21);
				}

				throw var3;
			}
		} catch (SQLException var22) {
			var22.printStackTrace();
		}

	}
}
package entity;



import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;
//	private String maKhachHang;
//	private String hoTen;
//	private boolean gioiTinh;
//	private Date ngaySinh;
//	private String diaChi;
//	private String soDienThoai;
//	private int diemThuong;
//	private String ghiChu;
		@Id
		@Column(name = "maKhachHang", length = 16, nullable = false)
		private String maKhachHang;
	
		@Column(name = "hoTen", columnDefinition = "nvarchar(40)", nullable = true)
		private String hoTen;
	
		@Column(name = "gioiTinh", nullable = true)
		private boolean gioiTinh;
		
		
	//	@Temporal(TemporalType.DATE)
		@Column(name = "ngaySinh", nullable = true)
		private Date ngaySinh;
	
		@Column(name = "diaChi", columnDefinition = "nvarchar(100)", nullable = true)
		private String diaChi;
	
		@Column(name = "soDienThoai", length = 10, nullable = true)
		private String soDienThoai;
	
		@Column(name = "diemThuong", nullable = true)
		private int diemThuong;
	
		@Column(name = "ghiChu", columnDefinition = "nvarchar(100)", nullable = true)
		private String ghiChu;

	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}
}
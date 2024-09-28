package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

@Table(name = "ChiTietDichVu")
public class ChiTietDichVu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDon", referencedColumnName = "maHoaDon", nullable = true)
	private HoaDon hoaDon;

	@Id
	@ManyToOne
	@JoinColumn(name = "maDichVu", referencedColumnName = "maDichVu", nullable = true)
	private DichVu dichVu;
	
	@Id
	@Column(name = "soLuong", nullable = false)
	private int soLuong;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maPhong", referencedColumnName = "maPhong", nullable = true)
	
	
	private Phong phong;

	public ChiTietDichVu(HoaDon hoaDon, DichVu dichVu, int soLuong) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
	}

	public ChiTietDichVu(HoaDon hoaDon, DichVu dichVu) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
	}
	public double thanhTien() {
		return  getSoLuong() * getDichVu().getDonGia();

	}

}

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
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable {
	private static final long serialVersionUID = 1L;
//	private String maKhuyenMai;
//	private String tenKhuyenMai;
//	private String maGiamGia;
//	private Date ngayBatDau;
//	private Date ngayKetThuc;
//	private int tongSoLuong;
//	private float chietKhau;
//	private String moTa;
	@Id
	@Column(name = "maKhuyenMai", nullable = false)
	private String maKhuyenMai;

	@Column(name = "tenKhuyenMai", columnDefinition = "nvarchar(40)", nullable = true)
	private String tenKhuyenMai;

	@Column(name = "maGiamGia", nullable = true)
	private String maGiamGia;

	@Column(name = "ngayBatDau", nullable = true)
	private Date ngayBatDau;

    
	@Column(name = "ngayKetThuc", nullable = true)
	private Date ngayKetThuc;

	@Column(name = "tongSoLuong", nullable = true)
	private int tongSoLuong;

	@Column(name = "chietKhau", nullable = true)
	private double chietKhau;

	@Column(name = "moTa", columnDefinition = "nvarchar(100)", nullable = true)
	private String moTa;

	public KhuyenMai(String maKhuyenMai) {
		super();
		this.maKhuyenMai = maKhuyenMai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhuyenMai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		return Objects.equals(maKhuyenMai, other.maKhuyenMai);
	}
}
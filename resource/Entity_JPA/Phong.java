package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Phong")
public class Phong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maPhong", length = 16, nullable = false)
	private String maPhong;

	@Column(name = "tenPhong", columnDefinition = "nvarchar(40)", nullable = true)
	private String tenPhong;

	@ManyToOne
	@JoinColumn(name = "maLoaiPhong", referencedColumnName = "maLoaiPhong", nullable = true)
	private LoaiPhong loaiPhong;

	@ManyToOne
	@JoinColumn(name = "maTrangThai", referencedColumnName = "maTrangThai", nullable = true)
	private TrangThaiPhong trangThaiPhong;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngayTaoPhong", nullable = false)
	private Date ngayTaoPhong;

	@Column(name = "viTriPhong", columnDefinition = "nvarchar(8)", nullable = true)
	private String viTriPhong;

	@Column(name = "ghiChu", columnDefinition = "nvarchar(100)", nullable = true)
	private String ghiChu;

	@Column(name = "tinhTrangPhong", columnDefinition = "nvarchar(100)", nullable = true)
	private String tinhTrangPhong;

	public Phong(String maPhong, String tenPhong, TrangThaiPhong trangThaiPhong, String viTriPhong, String ghiChu,
			String tinhTrangPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.trangThaiPhong = trangThaiPhong;
		this.viTriPhong = viTriPhong;
		this.ghiChu = ghiChu;
		this.tinhTrangPhong = tinhTrangPhong;

	}

	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}

}

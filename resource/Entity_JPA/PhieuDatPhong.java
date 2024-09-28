package entity;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
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
@Table(name = "PhieuDatPhong")
public class PhieuDatPhong implements Serializable {
	private static final long serialVersionUID = 1L;
//	private String maPhieuDat;
//	private Phong phong;
//	private NhanVien nhanVien;
//	private KhachHang khachHang;
//	private Timestamp thoiGianDatPhong;
//	private Timestamp thoiGianNhanPhong;
//	private float tienCoc;
//	private String trangThai;
//	private String moTa;

	@Id
	@Column(name = "maPhieuDat", nullable = false)
	private String maPhieuDat;

	@ManyToOne
	@JoinColumn(name = "maPhong", referencedColumnName = "maPhong", nullable = false)
	private Phong phong;

	@ManyToOne
	@JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien", nullable = false)
	private NhanVien nhanVien;

	@ManyToOne
	@JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang", nullable = false)
	private KhachHang khachHang;

	@Column(name = "thoiGianDatPhong", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp thoiGianDatPhong;
	

	@Column(name = "thoiGianNhanPhong", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp thoiGianNhanPhong;

	@Column(name = "tienCoc", nullable = true)
	private double tienCoc;

	@Column(name = "trangThai", columnDefinition = "nvarchar(20)", nullable = true)
	private String trangThai;

	@Column(name = "moTa", columnDefinition = "nvarchar(100)", nullable = true)
	private String moTa;

	/**
	 * @param maPhieuDat
	 * @param phong
	 * @param nhanVien
	 * @param khachHang
	 * @param tgDatPhong
	 * @param tgNhanPhong
	 * @param tienCoc
	 * @param trangThai
	 * @param moTa
	 */
	public PhieuDatPhong(String maPhieuDat, Phong phong, NhanVien nhanVien, KhachHang khachHang,
			java.util.Date tgDatPhong, java.sql.Timestamp tgNhanPhong, float tienCoc, String trangThai, String moTa) {
		super();
		this.maPhieuDat = maPhieuDat;
		this.phong = phong;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.thoiGianDatPhong = (java.sql.Timestamp) tgDatPhong;
		this.thoiGianNhanPhong = (java.sql.Timestamp) tgNhanPhong;
		this.tienCoc = tienCoc;
		this.trangThai = trangThai;
		this.moTa = moTa;
	}

	public PhieuDatPhong(String maPhieuDat) {
		super();
		this.maPhieuDat = maPhieuDat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatPhong other = (PhieuDatPhong) obj;
		return Objects.equals(maPhieuDat, other.maPhieuDat);
	}
}

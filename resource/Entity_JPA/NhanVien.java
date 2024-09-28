package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maNhanVien", length = 16, nullable = false)
	private String maNhanVien;

	@ManyToOne
	@JoinColumn(name = "maLoaiNhanVien", referencedColumnName = "maLoaiNhanVien", nullable = false)
	private LoaiNhanVien loaiNhanVien;

	@Column(name = "hoTen", columnDefinition = "nvarchar(40)", nullable = true)
	private String hoTen;

	@Column(name = "gioiTinh", nullable = true)
	private boolean gioiTinh;

	@Column(name = "ngaySinh", nullable = true)
	private Date ngaySinh;

	@Column(name = "soDienThoai", length = 10, nullable = true)
	private String soDienThoai;

	@Column(name = "CCCD", length = 12, nullable = true)
	private String CCCD;

	@Column(name = "diaChi",  columnDefinition = "nvarchar(40)",length = 40, nullable = true)
	private String diaChi;

	@Enumerated(EnumType.STRING)
	private TrangThaiNhanVien trangThai;

	@Column(name = "anhThe", length = 100, nullable = true)
	private String anhThe;

	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public LoaiNhanVien getLoaiNhanVien() {
		return loaiNhanVien;
	}

	public void setLoaiNhanVien(LoaiNhanVien loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public TrangThaiNhanVien getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiNhanVien trangThai) {
		this.trangThai = trangThai;
	}

	public String getAnhThe() {
		return anhThe;
	}

	public void setAnhThe(String anhThe) {
		this.anhThe = anhThe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

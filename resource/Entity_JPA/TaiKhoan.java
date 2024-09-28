package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @OneToOne
	@JoinColumn(name="maNhanVien")
	private NhanVien nhanVien;

	@Column(name = "tenDangNhap", length = 16, nullable = false)
	private String tenDangNhap;

	@Column(name = "matKhau", length = 40, nullable = false)
	private String matKhau;

	@Column(name = "trangThai", nullable = false)
	private boolean trangThai;

	@Column(name = "email", length = 255, nullable = false)
	private String email;

	/**
	 * @param maNhanVien
	 * @param tenDangNhap
	 * @param matKhau
	 * @param trangThai
	 */

	/**
	 * @param maNhanVien
	 */
	public TaiKhoan(NhanVien nhanVien) {
		super();
		this.nhanVien = nhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(nhanVien, other.nhanVien);
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

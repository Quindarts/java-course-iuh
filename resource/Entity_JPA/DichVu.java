package entity;



import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
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

/**
 * DichVu trangThai: conHang, hetHang
 * 
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "DichVu")
public class DichVu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maDichVu", length = 15, nullable = false)
	private String maDichVu;

	@Column(name = "tenDichVu", length = 40, columnDefinition = "nvarchar(40)", nullable = false)
	private String tenDichVu;

	@Column(name = "donViTinh", length = 12, nullable = false)
	private String donViTinh;

	@Column(name = "donGia", nullable = false)
	private double donGia;

	@Column(name = "trangThai", nullable = false)
	private boolean trangThai;
	
	@OneToOne
    @JoinColumn(name = "maThongTinDichVu", referencedColumnName = "maThongTinDichVu", nullable = false)
	private ThongTinDichVu thongTinDichVu;

	
	public DichVu(String maDichVu, String tenDichVu, float donGia) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;

		this.donGia = donGia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}

	public DichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
}
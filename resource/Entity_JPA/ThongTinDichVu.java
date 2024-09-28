package entity;



import java.io.Serializable;
import java.sql.Date;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "ThongTinDichVu")
public class ThongTinDichVu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "maThongTinDichVu", nullable = false)
	private String maThongTinDichVu;

	@Column(name = "soLuong", nullable = false)
	private int soLuong;

	@Column(name = "soLuongDaSuDung", nullable = false)
	private int soLuongDaSuDung;
//
//    @Temporal(TemporalType.DATE)
	@Column(name = "ngayNhap", nullable = false)
	private Date ngayNhap;

//    @Temporal(TemporalType.DATE)
	@Column(name = "ngayHetHan", nullable = false)
	private Date ngayHetHan;

	@Column(name = "moTa", columnDefinition = "nvarchar(40)",nullable = true)
	private String moTa;

	@Column(name = "hinhAnh", nullable = true)
	private String hinhAnh;

	public ThongTinDichVu(String maThongTinDichVu) {
		super();
		this.maThongTinDichVu = maThongTinDichVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maThongTinDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThongTinDichVu other = (ThongTinDichVu) obj;
		return Objects.equals(maThongTinDichVu, other.maThongTinDichVu);
	}

	public int tinhSoLuongConLai() {
		if (getSoLuong() - getSoLuongDaSuDung() > 0)
			return getSoLuong() - getSoLuongDaSuDung();
		else {
			return 0;
		}
	}
}

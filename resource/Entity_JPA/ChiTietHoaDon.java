package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ChiTietHoaDon")

public class ChiTietHoaDon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDon", referencedColumnName = "maHoaDon", nullable = false)
	private HoaDon hoaDon;

	@Id
	@ManyToOne
	@JoinColumn(name = "maPhong", referencedColumnName = "maPhong", nullable = false)
	private Phong phong;

	@Override
	public int hashCode() {
		return Objects.hash(hoaDon, phong);
	}

	public double thanhTien(float soGioHat) {

		return (float) getPhong().getLoaiPhong().getGiaTien() * soGioHat;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(hoaDon, other.hoaDon) && Objects.equals(phong, other.phong);
	}

}

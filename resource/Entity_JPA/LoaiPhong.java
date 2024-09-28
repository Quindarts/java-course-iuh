package entity;



import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "LoaiPhong")
public class LoaiPhong implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private static final long serialVersionUID = 1L;
//	private String maLoaiPhong;
//	private String tenLoaiPhong;
//	private int soLuongToiDa;
//	private float giaTien;
//	private String hinhAnh;
//	private String moTa;
//	

	/**
	 * 
	 */

	@Id
	@Column(name = "maLoaiPhong", nullable = false)
	private String maLoaiPhong;

	@Column(name = "tenLoaiPhong", columnDefinition = "nvarchar(40)", nullable = true)
	private String tenLoaiPhong;

	@Column(name = "soLuongKhachToiDa", nullable = true)
	private int soLuongKhachToiDa;

	@Column(name = "giaTien", nullable = true)
	private float giaTien;

	@Column(name = "hinhAnh", nullable = true)
	private String hinhAnh;

	@Column(name = "moTa", columnDefinition = "nvarchar(40)", nullable = true)
	private String moTa;

	public LoaiPhong(String maLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maLoaiPhong, other.maLoaiPhong);
	}

}

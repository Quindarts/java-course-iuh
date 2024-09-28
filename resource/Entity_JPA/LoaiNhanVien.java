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
@Table(name = "LoaiNhanVien")
public class LoaiNhanVien implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "maLoaiNhanVien", nullable = false)
	private String maLoaiNhanVien;

	@Column(name = "tenLoaiNhanVien", columnDefinition = "nvarchar(40)", length = 40, nullable = false)
	private String tenLoaiNhanVien;

	public LoaiNhanVien(String maLoaiNhanVien) {
		super();
		this.maLoaiNhanVien = maLoaiNhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiNhanVien other = (LoaiNhanVien) obj;
		return Objects.equals(maLoaiNhanVien, other.maLoaiNhanVien);
	}
}

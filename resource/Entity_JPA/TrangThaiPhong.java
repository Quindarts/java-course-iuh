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
@Table(name = "TrangThaiPhong")
public class TrangThaiPhong implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "maTrangThai", length = 16)
	private String maTrangThai;

	@Column(name = "tenTrangThai", columnDefinition = "nvarchar(40)")
	private String tenTrangThai;

	public TrangThaiPhong(String maTrangThai) {
		super();
		this.maTrangThai = maTrangThai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTrangThai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrangThaiPhong other = (TrangThaiPhong) obj;
		return Objects.equals(maTrangThai, other.maTrangThai);
	}

}

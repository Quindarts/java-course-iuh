package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
//import java.time.Duration;
import java.util.ArrayList;
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
@Setter
@Getter
@ToString
@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "maHoaDon", length = 15, nullable = false)
	private String maHoaDon;

	@ManyToOne
	@JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang", nullable = true)
	private KhachHang khachHang;

	@ManyToOne
	@JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien", nullable = true)
	private NhanVien nhanVien;

	@ManyToOne
	@JoinColumn(name = "maPhieuDat", referencedColumnName = "maPhieuDat", nullable = true)
	private PhieuDatPhong phieuDatPhong;

	@ManyToOne
	@JoinColumn(name = "maKhuyenMai", referencedColumnName = "maKhuyenMai", nullable = true)
	private KhuyenMai khuyenMai;

	@Column(name = "ngayLap", nullable = false)
	private Timestamp ngayLap;

	@Enumerated(EnumType.STRING)
	private TrangThaiHoaDon trangThai;
//
	@Column(name = "thoiGianKetThuc", nullable = true)
	private Timestamp thoiGianKetThuc;

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public float tinhGioHat() {
		// Lấy Timestamp kết thúc từ đối tượng HoaDon
		long gioHat = 0;
		float result;
		if (getThoiGianKetThuc() != null) {
			Timestamp thoiGianKetThuc = getThoiGianKetThuc();
			Timestamp thoiGianNhanPhong = getNgayLap();
			System.out.println(getNgayLap());
			// Chuyển Timestamp thành LocalDateTime

			LocalDateTime ketThuc = thoiGianKetThuc.toLocalDateTime();
			LocalDateTime batDau = getNgayLap().toLocalDateTime();

			// Tính khoảng thời gian (duration) giữa hai thời điểm
			Duration duration = Duration.between(batDau, ketThuc);

			// Chuyển khoảng thời gian thành số giờ
			gioHat = duration.toMinutes();
			result = (float) gioHat / 60;
		} else {
			// Lấy thời gian hiện tại
			long currentTimeMillis = System.currentTimeMillis();

			// Tạo đối tượng Timestamp từ thời gian hiện tại
			Timestamp currentTimestamp = new Timestamp(currentTimeMillis);

			Duration duration = Duration.between(getNgayLap().toLocalDateTime(),
					((Timestamp) currentTimestamp).toLocalDateTime());
			gioHat = duration.toMinutes();

			// In ra timestamp

			result = (float) gioHat / 60;
		}
		return result;// Trả về giờ hát dưới dạng số nguyên

	}

	public long tinhTienPhong(ArrayList<ChiTietHoaDon> dsCTHD) {
		long sum = 0;
		for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
			sum += chiTietHoaDon.thanhTien(tinhGioHat());
		}
		return sum;
	}

	public double tinhTienDichVu(ArrayList<ChiTietDichVu> dsCTDV) {
		double sum = 0;
		if (dsCTDV == null)
			return 0;
		for (ChiTietDichVu chiTietDichVu : dsCTDV) {
			sum += chiTietDichVu.thanhTien();
		}
		return sum;
	}

	public double tinhTongTien(ArrayList<ChiTietHoaDon> dsCTHD, ArrayList<ChiTietDichVu> dsCTDV) {
		if (dsCTDV == null)
			return 0;
		int thoiGian = 0;
		double sum = tinhTienDichVu(dsCTDV) + tinhTienPhong(dsCTHD);
		if (getPhieuDatPhong() != null) {
			sum = sum - getPhieuDatPhong().getTienCoc();
		}

		return sum * 1.05;
	}
}
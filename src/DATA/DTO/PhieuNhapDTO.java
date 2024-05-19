package DATA.DTO;

import java.sql.Date;

public class PhieuNhapDTO {
    private String maPN;
    private Date ngayNhap;
    private String maNN;
    private String maNCC;
    private long tongTien;
    
    
	public PhieuNhapDTO() {
	}
	public PhieuNhapDTO(String maPN, Date ngayNhap, String maNN, String maNCC, long tongTien) {
		this.maPN = maPN;
		this.ngayNhap = ngayNhap;
		this.maNN = maNN;
		this.maNCC = maNCC;
		this.tongTien = tongTien;
	}
	public String getMaPN() {
		return maPN;
	}
	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public String getMaNN() {
		return maNN;
	}
	public void setMaNN(String maNN) {
		this.maNN = maNN;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public long getTongTien() {
		return tongTien;
	}
	public void setTongTien(long tongTien) {
		this.tongTien = tongTien;
	}
}

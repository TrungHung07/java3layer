package DATA.DTO;

public class ChiTietPhieuNhapDTO {
	private String maPN;
	private String maSP;
    private int soLuong;
    private long donGia;
    private long thanhTien = donGia * soLuong;

	public ChiTietPhieuNhapDTO(){}
	public ChiTietPhieuNhapDTO(String maPN, String maSP, int soLuong, long donGia,long thanhTien){
		this.maPN = maPN;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}
	public String getMaPN() {
		return maPN;
	}
	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public long getDonGia() {
		return donGia;
	}
	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}
	public long getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}
}

package DATA.DTO;

public class ChiTietHoaDonDTO {
    private String maCTHD;
    private String maKH;
    private String maNGK;
    private int soluong;
    private long thanhtien;
    private String soHD;

    public ChiTietHoaDonDTO() {
    }

    public ChiTietHoaDonDTO(String maCTHD, String maKH, String maNGK, int soluong, long thanhtien, String soHD) {
        this.maCTHD = maCTHD;
        this.maKH = maKH;
        this.maNGK = maNGK;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
        this.soHD = soHD;
    }

    public String getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(String maCTHD) {
        this.maCTHD = maCTHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNGK() {
        return maNGK;
    }

    public void setMaNGK(String maNGK) {
        this.maNGK = maNGK;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public long getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(long thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getSoHD() {
        return soHD;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }
}

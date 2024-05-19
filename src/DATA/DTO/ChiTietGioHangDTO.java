package DATA.DTO;

public class ChiTietGioHangDTO {
    private String maCTGH;
    private String maNGK;
    private int soluong;
    private long thanhtien;
    private String maGH;
    private String tinhTrang;

    public ChiTietGioHangDTO() {
    }

    public ChiTietGioHangDTO(String maCTGH, String maNGK, int soluong, long thanhtien, String maGH, String tinhTrang) {
        this.maCTGH = maCTGH;
        this.maNGK = maNGK;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
        this.maGH = maGH;
        this.tinhTrang = tinhTrang;
    }

    public String getMaCTGH() {
        return maCTGH;
    }

    public void setMaCTGH(String maCTGH) {
        this.maCTGH = maCTGH;
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

    public String getMaGH() {
        return maGH;
    }

    public void setMaGH(String maGH) {
        this.maGH = maGH;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}

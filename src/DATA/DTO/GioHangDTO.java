package DATA.DTO;

public class GioHangDTO {
    private String maGH;
    private String maKH;
    private int soluonghang;
    private long tongtien;

    public GioHangDTO() {
    }

    public GioHangDTO(String maGH, String maKH, int soluonghang, long tongtien) {
        this.maGH = maGH;
        this.maKH = maKH;
        this.soluonghang = soluonghang;
        this.tongtien = tongtien;
    }

    public String getMaGH() {
        return maGH;
    }

    public void setMaGH(String maGH) {
        this.maGH = maGH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getSoluonghang() {
        return soluonghang;
    }

    public void setSoluonghang(int soluonghang) {
        this.soluonghang = soluonghang;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }
}

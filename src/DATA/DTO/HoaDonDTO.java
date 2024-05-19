package DATA.DTO;

import java.sql.Date;

public class HoaDonDTO {
    private String soHD;
    private Date ngaylap;
    private long tongtien;
    private String maKH;
    private String trangThai;
    private String moTa;

    public HoaDonDTO() {
    }

    public HoaDonDTO(String soHD, Date ngaylap, long tongtien, String maKH, String trangThai, String moTa) {
        this.soHD = soHD;
        this.ngaylap = ngaylap;
        this.tongtien = tongtien;
        this.maKH = maKH;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public String getSoHD() {
        return soHD;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}

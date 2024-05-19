package DATA.DTO;

public class ChucNangDTO {
    private String ma;
    private String chucVu_ma;
    private String tenChucNang;
    private String trangThai;
    public ChucNangDTO() {
    }
    public ChucNangDTO(String ma, String chucVu_ma, String tenChucNang, String trangThai) {
        this.ma = ma;
        this.chucVu_ma = chucVu_ma;
        this.tenChucNang = tenChucNang;
        this.trangThai = trangThai;
    }
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getChucVu_ma() {
        return chucVu_ma;
    }
    public void setChucVu_ma(String chucVu_ma) {
        this.chucVu_ma = chucVu_ma;
    }
    public String getTenChucNang() {
        return tenChucNang;
    }
    public void setTenChucNang(String tenChucNang) {
        this.tenChucNang = tenChucNang;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

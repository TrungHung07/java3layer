package DATA.DTO;

public class TaiKhoanDTO {
    private String ma;
    private String tenTK;
    private String diachi;
    private String sdt;
    private String matkhau;
    private boolean trangThai;
    private String role;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String ma, String tenTK, String diachi, String sdt, String matkhau, boolean trangThai,
            String role) {
        this.ma = ma;
        this.tenTK = tenTK;
        this.diachi = diachi;
        this.sdt = sdt;
        this.matkhau = matkhau;
        this.trangThai = trangThai;
        this.role = role;
    }

    public TaiKhoanDTO(TaiKhoanDTO kh) {
        this.ma = kh.ma;
        this.tenTK = kh.tenTK;
        this.diachi = kh.diachi;
        this.sdt = kh.sdt;
        this.matkhau = kh.matkhau;
        this.trangThai = kh.trangThai;
        this.role = kh.role;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

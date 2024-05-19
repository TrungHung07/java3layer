package DATA.DTO;

public class NuocGiaiKhatDTO {
    private String maNGK;
    private String tenNGK;
    private String donvitinh;
    private int slcon;
    private long giaban;
    private String tenloai;
    private String maNB;
    private String maHSX;
    private String maQL;
    private String img;
    private boolean trangThai;
    public String getMaNGK() {
        return maNGK;
    }
    public void setMaNGK(String maNGK) {
        this.maNGK = maNGK;
    }
    public String getTenNGK() {
        return tenNGK;
    }
    public void setTenNGK(String tenNGK) {
        this.tenNGK = tenNGK;
    }
    public String getDonvitinh() {
        return donvitinh;
    }
    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }
    public int getSlcon() {
        return slcon;
    }
    public void setSlcon(int slcon) {
        this.slcon = slcon;
    }
    public long getGiaban() {
        return giaban;
    }
    public void setGiaban(long giaban) {
        this.giaban = giaban;
    }
    public String getTenloai() {
        return tenloai;
    }
    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }
    public String getMaNB() {
        return maNB;
    }
    public void setMaNB(String maNB) {
        this.maNB = maNB;
    }
    public String getMaHSX() {
        return maHSX;
    }
    public void setMaHSX(String maHSX) {
        this.maHSX = maHSX;
    }
    public String getMaQL() {
        return maQL;
    }
    public void setMaQL(String maQL) {
        this.maQL = maQL;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public boolean isTrangThai() {
        return trangThai;
    }
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    public NuocGiaiKhatDTO() {
    }

    public NuocGiaiKhatDTO(String maNGK, String tenNGK, String donvitinh, int slcon, long giaban, String tenloai,
            String maNB, String maHSX, String maQL, String img, boolean trangThai) {
        this.maNGK = maNGK;
        this.tenNGK = tenNGK;
        this.donvitinh = donvitinh;
        this.slcon = slcon;
        this.giaban = giaban;
        this.tenloai = tenloai;
        this.maNB = maNB;
        this.maHSX = maHSX;
        this.maQL = maQL;
        this.img = img;
        this.trangThai = trangThai;
    }
}

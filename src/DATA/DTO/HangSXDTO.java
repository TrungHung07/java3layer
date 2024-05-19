package DATA.DTO;

public class HangSXDTO {
    private String maHSX;
    private String tenHSX;

    public HangSXDTO() {
    }

    public HangSXDTO(String maHSX, String tenHSX) {
        this.maHSX = maHSX;
        this.tenHSX = tenHSX;
    }

    public String getMaHSX() {
        return maHSX;
    }

    public void setMaHSX(String maHSX) {
        this.maHSX = maHSX;
    }

    public String getTenHSX() {
        return tenHSX;
    }

    public void setTenHSX(String tenHSX) {
        this.tenHSX = tenHSX;
    }
}

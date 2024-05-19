package DATA.DTO;

public class ChucVuDTO {
    private String maChucVu;
    private String tenChucVu;
    private String moTa;

    public ChucVuDTO() {
    }
    
    public ChucVuDTO(String maChucVu, String tenChucVu, String moTa) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
        this.moTa = moTa;
    }

    public String getMaChucVu() {
        return maChucVu;
    }
    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }
    public String getTenChucVu() {
        return tenChucVu;
    }
    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}

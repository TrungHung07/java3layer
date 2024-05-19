package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.ChucVuDTO;
import DATA.database.*;

public class ChucVuDAO {
    private connect database = new connect();
    private List<ChucVuDTO> dsChucVu = new ArrayList<>();
    public ChucVuDAO() {
    }
    public ChucVuDAO(List<ChucVuDTO> dsChucVu) {
        this.dsChucVu = dsChucVu;
    }
    public List<ChucVuDTO> getData() {
        try {
            Connection c = database.getConnection();
            String sql = "SELECT * FROM chucVu";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String ma = rs.getString("ma");
                        String ten = rs.getString("ten");
                        String moTa = rs.getString("moTa");
                        ChucVuDTO chucVu = new ChucVuDTO(ma, ten, moTa);
                        dsChucVu.add(chucVu);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsChucVu;
    }
}

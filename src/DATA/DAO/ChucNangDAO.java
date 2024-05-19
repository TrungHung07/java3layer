package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.ChucNangDTO;
import DATA.database.*;

public class ChucNangDAO {
    private connect database = new connect();
    private List<ChucNangDTO> dscn = new ArrayList<>();

    public ChucNangDAO() {
    }

    public ChucNangDAO(List<ChucNangDTO> dscn) {
        this.dscn = dscn;
    }

    public List<ChucNangDTO> getData() {
        try (Connection connection = database.getConnection()) {
            String sql = "SELECT * FROM phanquyen";
            try (PreparedStatement pst = connection.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        ChucNangDTO chucNang = new ChucNangDTO();
                        chucNang.setMa(rs.getString("ma"));
                        chucNang.setChucVu_ma(rs.getString("chucVu_ma"));
                        chucNang.setTenChucNang(rs.getString("tenChucNang"));
                        chucNang.setTrangThai(rs.getString("trangThai"));
                        dscn.add(chucNang);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dscn;
    }
}

package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import DATA.DTO.HangSXDTO;
import DATA.database.*;

public class HangSanXuatDAO {
    private connect database;
    private List<HangSXDTO> dsHangSX;

    public HangSanXuatDAO() {
    }

    public HangSanXuatDAO(List<HangSXDTO> dsHangSX) {
        this.dsHangSX = dsHangSX;
    }

    public List<HangSXDTO> getData() {
        try {
            Connection c = database.getConnection();
            String sql = "SELECT * FROM hangsx";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String ma = rs.getString("maHSX");
                        String ten = rs.getString("tenHSX");
                        HangSXDTO hsx = new HangSXDTO(ma, ten);
                        dsHangSX.add(hsx);
                    }
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (pst != null)
                        pst.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (c != null)
                    c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsHangSX;
    }
}

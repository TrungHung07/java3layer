package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.ChiTietHoaDonDTO;
import DATA.database.*;

public class ChiTietHoaDonDAO {
    private connect database = new connect();
    private List<ChiTietHoaDonDTO> dsCTHD = new ArrayList<>();

    public ChiTietHoaDonDAO() {
    }

    public ChiTietHoaDonDAO(List<ChiTietHoaDonDTO> dsCTHD) {
        this.dsCTHD = dsCTHD;
    }

    public List<ChiTietHoaDonDTO> getData() {
        try {
            Connection c = database.getConnection();
            String sql = "SELECT * FROM cthoadon";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String ma = rs.getString("maCTHD");
                        String maKH = rs.getString("maKH");
                        String maNGK = rs.getString("maNGK");
                        int sk = rs.getInt("soluong");
                        long thanhTien = rs.getLong("thanhtien");
                        String soHD = rs.getString("soHD");
                        ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO(ma, maKH, maNGK, sk, thanhTien, soHD);
                        dsCTHD.add(ct);
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
        return dsCTHD;
    }

    public void insertChiTietHoaDon(ChiTietHoaDonDTO cthd) {
        try {
            Connection conn = database.getConnection();
            String sql = "INSERT INTO cthoadon (maCTHD, maKH, maNGK, soluong, thanhtien, soHD) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cthd.getMaCTHD());
            pst.setString(2, cthd.getMaKH());
            pst.setString(3, cthd.getMaNGK());
            pst.setInt(4, cthd.getSoluong());
            pst.setLong(5, cthd.getThanhtien());
            pst.setString(6, cthd.getSoHD());

            pst.executeUpdate();
            
            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int deleteData(String maCTHD) {
        try {
            Connection c = database.getConnection();
            String sql = "DELETE FROM cthoadon WHERE soHD=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, maCTHD);
            int success= pst.executeUpdate();
            if(success>0){
                if (pst!= null)
                    pst.close();
                if (c!= null)
                    c.close();
                    return success;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

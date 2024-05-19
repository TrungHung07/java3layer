package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.ChiTietGioHangDTO;
import DATA.database.*;

public class ChiTietGioHangDAO {
    private connect database = new connect();
    private List<ChiTietGioHangDTO> dsCTGH = new ArrayList<>();

    public ChiTietGioHangDAO() {
    }

    public ChiTietGioHangDAO(List<ChiTietGioHangDTO> dsCTGH) {
        this.dsCTGH = dsCTGH;
    }

    public List<ChiTietGioHangDTO> getData() {
        try {
            Connection c = database.getConnection();
            String sql = "SELECT * FROM ctgiohang";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String ma = rs.getString("maCTGH");
                        String maNGK = rs.getString("maNGK");
                        int sl = rs.getInt("soluong");
                        long tongTien = rs.getLong("thanhtien");
                        String maGH = rs.getString("maGH");
                        String tinhTrang = rs.getString("tinhTrang");
                        ChiTietGioHangDTO ctgh = new ChiTietGioHangDTO(ma, maNGK, sl, tongTien, maGH, tinhTrang);
                        dsCTGH.add(ctgh);
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
        return dsCTGH;
    }

    public void insertData(ChiTietGioHangDTO ctgh) {
        try {
            Connection c = database.getConnection();
            String sql = "INSERT INTO ctgiohang(maCTGH, maNGK, soluong, thanhtien, maGH, tinhTrang) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, ctgh.getMaCTGH());
            pst.setString(2, ctgh.getMaNGK());
            pst.setInt(3, ctgh.getSoluong());
            pst.setLong(4, ctgh.getThanhtien());
            pst.setString(5, ctgh.getMaGH());
            pst.setString(6, ctgh.getTinhTrang());
            pst.executeUpdate();
            if (pst != null)
                pst.close();
            if (c != null)
                c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTinhTrangToChoDuyet(String maCTGH, String tinhTrang) {
        try {
            Connection c = database.getConnection();
            String sql = "UPDATE ctgiohang SET tinhTrang = ? WHERE maCTGH = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, tinhTrang);
            pst.setString(2, maCTGH);
            pst.executeUpdate();
            if (pst != null)
                pst.close();
            if (c != null)
                c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCart(String maCTGH) {
        try {
            Connection c = database.getConnection();
            String sql = "DELETE FROM ctgiohang WHERE maCTGH=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, maCTGH);
            pst.executeUpdate();
            if (pst != null)
                pst.close();
            if (c != null)
                c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

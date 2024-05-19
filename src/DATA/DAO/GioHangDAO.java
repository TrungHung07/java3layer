package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.GioHangDTO;
import DATA.database.*;

public class GioHangDAO {
    private connect database = new connect();
    private List<GioHangDTO> dsGH = new ArrayList<>();

    public GioHangDAO() {
    }

    public GioHangDAO(List<GioHangDTO> dsGH) {
        this.dsGH = dsGH;
    }

    public List<GioHangDTO> getData() {
        try {
            Connection c = database.getConnection();
            String sql = "SELECT * FROM giohang";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String ma = rs.getString("maGH");
                        String maKH = rs.getString("maKH");
                        int sl = rs.getInt("soluonghang");
                        long tongTien = rs.getLong("tongtien");
                        GioHangDTO gh = new GioHangDTO(ma, maKH, sl, tongTien);
                        dsGH.add(gh);
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
        return dsGH;
    }

    public void insertData(GioHangDTO gioHang) {
        try {
            Connection c = database.getConnection();
            String sql = "INSERT INTO giohang (maGH, maKH, soluonghang, tongtien) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                pst.setString(1, gioHang.getMaGH());
                pst.setString(2, gioHang.getMaKH());
                pst.setInt(3, gioHang.getSoluonghang());
                pst.setLong(4, gioHang.getTongtien());
                pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (c != null)
                    c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void updateCartData(String maGH) {
        try {
            Connection conn = database.getConnection();
            String sqlCount = "SELECT COUNT(*) AS soluong, SUM(thanhtien) AS tongtien FROM ctgiohang WHERE maGH=?";
            PreparedStatement pstCount = conn.prepareStatement(sqlCount);
            pstCount.setString(1, maGH);
            ResultSet rs = pstCount.executeQuery();
            
            int soluonghang = 0;
            long tongtien = 0;
            
            if (rs.next()) {
                soluonghang = rs.getInt("soluong");
                tongtien = rs.getLong("tongtien");
            }
            
            String sqlUpdate = "UPDATE giohang SET soluonghang=?, tongtien=? WHERE maGH=?";
            PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdate);
            pstUpdate.setInt(1, soluonghang);
            pstUpdate.setLong(2, tongtien);
            pstUpdate.setString(3, maGH);
            
            pstUpdate.executeUpdate();
            
            if (pstCount != null) {
                pstCount.close();
            }
            if (pstUpdate != null) {
                pstUpdate.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(GioHangDTO gioHang) {
        try {
            Connection c = database.getConnection();
            String sql = "DELETE FROM giohang WHERE maGH = ?";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                pst.setString(1, gioHang.getMaGH());
                pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (c != null)
                    c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}

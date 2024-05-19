package DATA.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.HoaDonDTO;
import DATA.database.*;

public class HoaDonDAO {
    private connect database = new connect();
    private List<HoaDonDTO> dsHD = new ArrayList<>();

    public HoaDonDAO() {
    }

    public HoaDonDAO(List<HoaDonDTO> dsHD) {
        this.dsHD = dsHD;
    }

    public List<HoaDonDTO> getData() {
        try {
            Connection c = database.getConnection();
            String sql = "SELECT * FROM hoadon";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String soHD = rs.getString("soHD");
                        Date ngayLap = rs.getDate("ngaylap");
                        long tongTien = rs.getLong("tongtien");
                        String maKH = rs.getString("maKH");
                        String trangThai = rs.getString("trangThai");
                        String moTa = rs.getString("moTa");
                        HoaDonDTO hd = new HoaDonDTO(soHD, ngayLap, tongTien, maKH, trangThai, moTa);
                        dsHD.add(hd);
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
        return dsHD;
    }

    public void insertHoaDon(HoaDonDTO hd) {
        try {
            Connection conn = database.getConnection();
            String sqlInsert = "INSERT INTO hoadon (soHD, ngaylap, tongtien, maKH, trangThai, moTa) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstInsert = conn.prepareStatement(sqlInsert);
            pstInsert.setString(1, hd.getSoHD());
            pstInsert.setDate(2, hd.getNgaylap());
            pstInsert.setLong(3, hd.getTongtien());
            pstInsert.setString(4, hd.getMaKH());
            pstInsert.setString(5, hd.getTrangThai());
            pstInsert.setString(6, hd.getMoTa());
            pstInsert.executeUpdate();
            if (pstInsert != null) {
                pstInsert.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateTinhTrangToChoDuyet(String maHD, String tinhTrang) {
        try {
            Connection c = database.getConnection();
            String sql = "UPDATE hoadon SET trangThai = ? WHERE soHD = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, tinhTrang);
            pst.setString(2, maHD);
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

    public int deleteData(String soHD) {
        try {
            Connection c = database.getConnection();
            String sql = "DELETE FROM hoadon WHERE soHD=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, soHD);
            int success = pst.executeUpdate();
            if (success > 0) {
                if (pst != null)
                    pst.close();
                if (c != null)
                    c.close();
                return success;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<HoaDonDTO> searchHoaDon(String maKH, String startDate, String endDate, Long fromPrice, Long toPrice) {
        List<HoaDonDTO> list = new ArrayList<>();
        try {
            Connection conn = database.getConnection();
            String searchDate = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date defaultStartDate = null;
            Date defaultEndDate = null;
            if (!startDate.equals("") && !endDate.equals("")) {
                try {
                    defaultStartDate = new Date(sdf.parse(startDate).getTime());
                    defaultEndDate = new Date(sdf.parse(endDate).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                searchDate = "AND ngaylap BETWEEN ? AND ?";
            }
            String sql = "SELECT * FROM hoadon WHERE maKH LIKE ? AND tongtien >= ? AND tongtien <= ? "+searchDate;
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, "%"+maKH+"%");
                pst.setLong(2, fromPrice);
                pst.setLong(3, toPrice);
                if (!startDate.equals("") &&!endDate.equals("")) {
                    pst.setDate(4, defaultStartDate);
                    pst.setDate(5, defaultEndDate);
                }
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String soHD = rs.getString("soHD");
                        Date ngayLap = rs.getDate("ngaylap");
                        long tongTien = rs.getLong("tongtien");
                        String maKH1 = rs.getString("maKH");
                        String trangThai = rs.getString("trangThai");
                        String moTa = rs.getString("moTa");
                        HoaDonDTO hd = new HoaDonDTO(soHD, ngayLap, tongTien, maKH1, trangThai, moTa);
                        list.add(hd);
                    }
                    if(rs!=null) rs.close();
                    if(pst!=null) pst.close();
                    if(conn!=null) conn.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateQuantity(String soHD) {
    Connection conn = null;
    PreparedStatement pstCheck = null;
    PreparedStatement pstUpdate = null;
    ResultSet rs = null;
    boolean success = true;

    try {
        conn = database.getConnection();
        conn.setAutoCommit(false); // Bắt đầu giao dịch

        // Truy vấn kiểm tra số lượng tồn kho
        String sqlCheck = "SELECT cthd.maNGK, cthd.soluong, ngk.slcon " +
                          "FROM cthoadon cthd " +
                          "INNER JOIN ngk ON cthd.maNGK = ngk.maNGK " +
                          "WHERE cthd.soHD = ?";
        pstCheck = conn.prepareStatement(sqlCheck, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstCheck.setString(1, soHD);
        rs = pstCheck.executeQuery();

        // Kiểm tra nếu tất cả sản phẩm đều có đủ số lượng tồn kho
        while (rs.next()) {
            int soLuongDat = rs.getInt("soluong");
            int soLuongCon = rs.getInt("slcon");
            if (soLuongDat > soLuongCon) {
                success = false;
                break;
            }
        }

        if (success) {
            // Nếu tất cả sản phẩm đều có đủ số lượng tồn kho, cập nhật số lượng tồn kho
            rs.beforeFirst(); // Reset lại con trỏ ResultSet
            String sqlUpdate = "UPDATE ngk SET slcon = slcon - ? WHERE maNGK = ?";
            pstUpdate = conn.prepareStatement(sqlUpdate);

            while (rs.next()) {
                int soLuongDat = rs.getInt("soluong");
                String maNGK = rs.getString("maNGK");
                pstUpdate.setInt(1, soLuongDat);
                pstUpdate.setString(2, maNGK);
                pstUpdate.addBatch();
            }
            pstUpdate.executeBatch();
        }

        if (success) {
            conn.commit(); // Commit nếu thành công
        } else {
            conn.rollback(); // Rollback nếu thất bại
        }

    } catch (SQLException e) {
        success = false;
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        e.printStackTrace();
    } finally {
        // Đóng các tài nguyên
        try {
            if (rs != null) rs.close();
            if (pstCheck != null) pstCheck.close();
            if (pstUpdate != null) pstUpdate.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return success;
}

}

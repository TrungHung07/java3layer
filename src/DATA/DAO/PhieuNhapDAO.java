package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import DATA.DTO.PhieuNhapDTO;
import DATA.DTO.ThongKePhieuNhapDTO;
import DATA.database.*;

public class PhieuNhapDAO {
    private connect database = new connect();
    public List<PhieuNhapDTO> dspn = new ArrayList<>();

    public PhieuNhapDAO() {
    }

    public PhieuNhapDAO(List<PhieuNhapDTO> dspn) {
        this.dspn = dspn;
    }

    public List<PhieuNhapDTO> getData() {
        Connection c = null;
        try {
            c = database.getConnection();
            String sql = "SELECT * FROM phieunhap";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String maPN = rs.getString("maPN");
                        Date ngayNhap = rs.getDate("ngayNhap");
                        String maNN = rs.getString("maNN");
                        String maNCC = rs.getString("maNCC");
                        long tongTien = rs.getLong("tongTien");
                        PhieuNhapDTO pn = new PhieuNhapDTO(maPN, ngayNhap, maNN, maNCC, tongTien);
                        dspn.add(pn);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    if (pst != null) {
                        pst.close();
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally {
                if (c != null) {
                    c.close();
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dspn;
    }

    public int insertData(PhieuNhapDTO pn) {
        try {
            Connection c = database.getConnection();
            String sql = "INSERT INTO phieunhap (maPN, ngaynhap, maNN, maNCC, tongTien) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, pn.getMaPN());
            pst.setDate(2, pn.getNgayNhap());
            pst.setString(3, pn.getMaNN());
            pst.setString(4, pn.getMaNCC());
            pst.setLong(5, pn.getTongTien());
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                if (pst != null)
                    pst.close();
                if (c != null)
                    c.close();
                return affectedRows;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteData(String maPN) {
        Connection connection = null;
        PreparedStatement pstPhieuNhap = null;
        PreparedStatement pstChiTiet = null;
        int affected=0;
        try {
            connection = database.getConnection();
            connection.setAutoCommit(false); // Bắt đầu transaction

            // Kiểm tra xem phiếu nhập tồn tại trước khi xóa
            String checkExistenceQuery = "SELECT COUNT(*) AS count FROM phieunhap WHERE maPN = ?";
            PreparedStatement checkExistenceStmt = connection.prepareStatement(checkExistenceQuery);
            checkExistenceStmt.setString(1, maPN);
            ResultSet existenceResult = checkExistenceStmt.executeQuery();
            existenceResult.next();
            int count = existenceResult.getInt("count");
            if (count == 0) {
                System.out.println("Phiếu nhập không tồn tại.");
                return 0; // Thoát nếu phiếu nhập không tồn tại
            }

            // Xóa chi tiết phiếu nhập
            String sqlChiTiet = "DELETE FROM chitietphieunhap WHERE maPN = ?";
            pstChiTiet = connection.prepareStatement(sqlChiTiet);
            pstChiTiet.setString(1, maPN);
            pstChiTiet.executeUpdate();
            pstChiTiet.close();

            // Xóa phiếu nhập
            String sqlPhieuNhap = "DELETE FROM phieunhap WHERE maPN = ?";
            pstPhieuNhap = connection.prepareStatement(sqlPhieuNhap);
            pstPhieuNhap.setString(1, maPN);
            affected = pstPhieuNhap.executeUpdate();
            pstPhieuNhap.close();

            connection.commit(); // Hoàn thành transaction
        } catch (Exception e) {
            // Rollback transaction nếu có lỗi
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Đóng tất cả tài nguyên
            try {
                if (pstChiTiet != null) {
                    pstChiTiet.close();
                }
                if (pstPhieuNhap != null) {
                    pstPhieuNhap.close();
                }
                if (connection != null) {
                    connection.setAutoCommit(true); // Đặt lại auto-commit thành true
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return affected;
    }

    public int updatePrice(String maPN) {
        try {
            Connection c = database.getConnection();
            String query = "SELECT SUM(thanhTien) AS tongTien FROM chitietphieunhap WHERE maPN = ?";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setString(1, maPN);
            ResultSet rs = pst.executeQuery();

            long tongTien = 0;
            if (rs.next()) {
                tongTien = rs.getLong("tongTien");
            }

            String updateQuery = "UPDATE phieunhap SET tongTien = ? WHERE maPN = ?";
            PreparedStatement uppst = c.prepareStatement(updateQuery);
            uppst.setLong(1, tongTien);
            uppst.setString(2, maPN);
            int success = uppst.executeUpdate();
            if (success > 0) {
                uppst.close();
                rs.close();
                pst.close();
                c.close();
                return success;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return 0;
    }

    public int checkId(String id) {
        try {
            Connection conn = database.getConnection();
            String sql = "SELECT COUNT(*) AS count FROM phieunhap WHERE maPN = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("count");
                return count;
            }
            if (count > 0) {
                if (pst != null)
                    pst.close();
                if (conn != null)
                    conn.close();
                return count;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<ThongKePhieuNhapDTO> getProductStatistics(int quarter, int year, Date startDate, Date endDate) {
        List<ThongKePhieuNhapDTO> list = new ArrayList<>();
        try {
            String sql = "";
            Connection conn = database.getConnection();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date defaultStartDate = null;
            Date defaultEndDate = null;
            try {
                defaultStartDate = new Date(sdf.parse("1975-01-01").getTime());
                defaultEndDate = new Date(sdf.parse("2035-01-01").getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (quarter == 0 && year == 0 && startDate.compareTo(defaultStartDate) == 0
                    && endDate.compareTo(defaultEndDate) == 0) {
                sql = "SELECT ngk.`maNGK`, ngk.`tenNGK`, SUM(chitietphieunhap.`soLuong`) as totalQuantity, SUM(phieunhap.`tongTien`) as totalPrice, SUM(chitietphieunhap.`soLuong`)/SUM(phieunhap.`tongTien`) as price \r\n"
                        + //
                        "FROM phieunhap INNER JOIN chitietphieunhap ON phieunhap.`maPN` = chitietphieunhap.`maPN` INNER JOIN ngk ON ngk.`maNGK` = chitietphieunhap.`maSP`\r\n"
                        + //
                        "GROUP BY ngk.`maNGK`, ngk.`tenNGK`";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                int i = 1;
                while (rs.next()) {
                    ThongKePhieuNhapDTO dto = new ThongKePhieuNhapDTO();
                    dto.setStt(i++);
                    dto.setMaSP(rs.getString("maNGK"));
                    dto.setTenSP(rs.getString("tenNGK"));
                    dto.setSoLuong(rs.getInt("totalQuantity"));
                    dto.setThanhTien(rs.getLong("totalPrice"));
                    dto.setDonGia((float) rs.getLong("totalPrice") / rs.getInt("totalQuantity"));
                    list.add(dto);
                }
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
                if (conn != null)
                    conn.close();
                return list;
            } else {
                String dateCondition = "";
                if (quarter > 0 && quarter <= 4) {
                    switch (quarter) {
                        case 1:
                            dateCondition = "AND MONTH(phieunhap.`ngayNhap`) IN (1, 2, 3) AND";
                            break;
                        case 2:
                            dateCondition = "AND MONTH(phieunhap.`ngayNhap`) IN (4, 5, 6) AND";
                            break;
                        case 3:
                            dateCondition = "AND MONTH(phieunhap.`ngayNhap`) IN (7, 8, 9) AND";
                            break;
                        case 4:
                            dateCondition = "AND MONTH(phieunhap.`ngayNhap`) IN (10, 11, 12) AND";
                            break;
                    }
                }
                String yearCondition = "";
                if (year > 0) {
                    yearCondition = "YEAR(phieunhap.`ngayNhap`) =?";
                }
                sql = "SELECT ngk.`maNGK`, ngk.`tenNGK`, " +
                        "SUM(chitietphieunhap.`soLuong`) as totalQuantity, " +
                        "SUM(phieunhap.`tongTien`) as totalPrice, " +
                        "SUM(chitietphieunhap.`soLuong`)/SUM(phieunhap.`tongTien`) as price " +
                        "FROM phieunhap " +
                        "INNER JOIN chitietphieunhap ON phieunhap.`maPN` = chitietphieunhap.`maPN` " +
                        "INNER JOIN ngk ON ngk.`maNGK` = chitietphieunhap.`maSP` " +
                        "WHERE " + yearCondition + " " +
                        dateCondition + " " +
                        "phieunhap.`ngayNhap` BETWEEN ? AND ? " +
                        "GROUP BY ngk.`maNGK`, ngk.`tenNGK`";
                PreparedStatement pst = conn.prepareStatement(sql);
                if (year > 0) {
                    pst.setInt(1, year);
                    pst.setDate(2, startDate);
                    pst.setDate(3, endDate);
                } else {
                    pst.setDate(1, startDate);
                    pst.setDate(2, endDate);
                }

                ResultSet rs = pst.executeQuery();
                int i = 1;
                while (rs.next()) {
                    ThongKePhieuNhapDTO dto = new ThongKePhieuNhapDTO();
                    dto.setStt(i++);
                    dto.setMaSP(rs.getString("maNGK"));
                    dto.setTenSP(rs.getString("tenNGK"));
                    dto.setSoLuong(rs.getInt("totalQuantity"));
                    dto.setThanhTien(rs.getLong("totalPrice"));
                    dto.setDonGia((float) rs.getLong("totalPrice") / rs.getInt("totalQuantity"));
                    list.add(dto);
                }
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
                if (conn != null)
                    conn.close();
                return list;
            }

        } catch (Exception e) {
            e.printStackTrace(); // ignore
            return null;
        }
    }

        public List<PhieuNhapDTO> searchList(String maPN, String maNV, String maNCC, Date startDate, Date endDate){
            List<PhieuNhapDTO> listDateSearch = new ArrayList<>();
            Connection c = null;
        try {
            c = database.getConnection();
            String searchDate="";
            if(startDate == null || endDate == null){
                searchDate="";
            }else{
                searchDate="AND phieunhap.`ngayNhap` BETWEEN ? AND ? ";
            }
            String sql = "SELECT * FROM phieunhap WHERE maPN LIKE ? AND maNN LIKE ? AND maNCC LIKE ? "+searchDate;
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                pst.setString(1,"%"+ maPN+"%");
                pst.setString(2, "%"+maNV+"%");
                pst.setString(3, "%"+maNCC+"%");
                if(!searchDate.equals("")){
                    pst.setDate(4, startDate);
                    pst.setDate(5, endDate);
                }
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String maPN1 = rs.getString("maPN");
                        Date ngayNhap = rs.getDate("ngayNhap");
                        String maNN = rs.getString("maNN");
                        String maNCC1 = rs.getString("maNCC");
                        long tongTien = rs.getLong("tongTien");
                        PhieuNhapDTO pn = new PhieuNhapDTO(maPN1, ngayNhap, maNN, maNCC1, tongTien);
                        listDateSearch.add(pn);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    if (pst != null) {
                        pst.close();
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally {
                if (c != null) {
                    c.close();
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listDateSearch;
        }

}

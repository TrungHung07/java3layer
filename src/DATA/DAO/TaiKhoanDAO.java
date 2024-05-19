package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.TaiKhoanDTO;
import DATA.database.*;

public class TaiKhoanDAO {
    private connect database = new connect();
    private List<TaiKhoanDTO> dsKH = new ArrayList<>();

    public TaiKhoanDAO() {
    }

    public TaiKhoanDAO(List<TaiKhoanDTO> dsKH) {
        this.dsKH = dsKH;
    }
    

    public List<TaiKhoanDTO> getData() {
        try {
            Connection c = database.getConnection();
            String sql = "SELECT * FROM taikhoan";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String ma = rs.getString("ma");
                        String ten = rs.getString("tenTK");
                        String diaChi = rs.getString("diachi");
                        String sdt = rs.getString("sdt");
                        String matkhau = rs.getString("matkhau");
                        boolean trangThai = rs.getBoolean("trangThai");
                        String role = rs.getString("role");
                        TaiKhoanDTO kh = new TaiKhoanDTO(ma, ten, diaChi, sdt, matkhau, trangThai, role);
                        dsKH.add(kh);
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
        return dsKH;
    }

    public List<TaiKhoanDTO> searchByName(String keyword) {
        List<TaiKhoanDTO> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Chuẩn bị câu lệnh truy vấn
            String sql = "SELECT * FROM taikhoan WHERE tenTK LIKE ?";
            connection = database.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // Thiết lập tham số cho câu lệnh truy vấn
            preparedStatement.setString(1, "%" + keyword + "%");
            // Thực thi truy vấn
            resultSet = preparedStatement.executeQuery();
            // Duyệt qua kết quả trả về
            while (resultSet.next()) {
                String ma = resultSet.getString("ma");
                String ten = resultSet.getString("tenTK");
                String diaChi = resultSet.getString("diachi");
                String sdt = resultSet.getString("sdt");
                String matkhau = resultSet.getString("matkhau");
                boolean trangThai = resultSet.getBoolean("trangThai");
                String role = resultSet.getString("role");
                // Tạo đối tượng TaiKhoan và thêm vào danh sách kết quả
                TaiKhoanDTO kh = new TaiKhoanDTO(ma, ten, diaChi, sdt, matkhau, trangThai, role);
                result.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các kết nối và tài nguyên
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Trả về danh sách kết quả
        return result;
    }

    public int insertData(TaiKhoanDTO khachHang) {
        try {
            Connection c = database.getConnection();
            String sql = "INSERT INTO taikhoan (ma, tenTK, diachi, sdt, matkhau, trangThai, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                pst.setString(1, khachHang.getMa());
                pst.setString(2, khachHang.getTenTK());
                pst.setString(3, khachHang.getDiachi());
                pst.setString(4, khachHang.getSdt());
                pst.setString(5, khachHang.getMatkhau());
                pst.setBoolean(6, khachHang.isTrangThai());
                pst.setString(7, khachHang.getRole());
                int affected =pst.executeUpdate();
                if(affected>0){
                    if(pst!=null) pst.close();
                    if(c!=null) c.close();
                    return affected;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int editData(TaiKhoanDTO kh) {
        try {
            Connection c = database.getConnection();
            String sql = "UPDATE taikhoan SET tenTK=?, diachi=?, sdt=?, matkhau=?, trangThai=?, role=? WHERE ma=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, kh.getTenTK());
            pst.setString(2, kh.getDiachi());
            pst.setString(3, kh.getSdt());
            pst.setString(4, kh.getMatkhau());
            pst.setBoolean(5, kh.isTrangThai());
            pst.setString(6, kh.getRole());
            pst.setString(7, kh.getMa());
            int affected=pst.executeUpdate();
            if(affected>0){
                if (pst != null)
                pst.close();
            if (c != null)
                c.close();
                return affected;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteData(String ma) {
        try {
            Connection c = database.getConnection();
            String sql = "DELETE FROM taikhoan WHERE ma=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, ma);
            int affected =pst.executeUpdate();
            if(affected>0){
                if (pst != null)
                pst.close();
            if (c != null)
                c.close();
                return affected;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void updateRole(String maTK, String role) {
        // Chuỗi SQL UPDATE
        String sql = "UPDATE taikhoan SET role = ? WHERE ma = ?";
        try (
                // Mở kết nối đến cơ sở dữ liệu
                Connection connection = database.getConnection();
                // Tạo câu lệnh PreparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            // Thiết lập tham số cho câu lệnh SQL
            preparedStatement.setString(1, role);
            preparedStatement.setString(2, maTK);

            // Thực thi câu lệnh SQL UPDATE
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int checkIdCustomer(String idCustomer) {
        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            c = database.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE ma=?";
            pst = c.prepareStatement(sql);
            pst.setString(1, idCustomer);
            rs = pst.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo rằng các tài nguyên được đóng trong khối finally
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (c != null) c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    
    public List<TaiKhoanDTO> searchCustomer(String idCustomer, String nameCustomer, String activity) {
        List<TaiKhoanDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    
        try {
            conn = database.getConnection();
            String activitySearch = "";
    
            if (activity.equals("hd")) {
                activitySearch = " AND trangThai=1";
            } else if (activity.equals("tn")) {
                activitySearch = " AND trangThai=0";
            }
    
            String sql = "SELECT * FROM taikhoan WHERE ma LIKE ? AND tenTK LIKE ? " + activitySearch + " AND role='khachhang'";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + idCustomer + "%");
            pst.setString(2, "%" + nameCustomer + "%");
    
            rs = pst.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("tenTK");
                String diaChi = rs.getString("diachi");
                String sdt = rs.getString("sdt");
                String matkhau = rs.getString("matkhau");
                boolean trangThai = rs.getBoolean("trangThai");
                String role = rs.getString("role");
    
                // Tạo đối tượng TaiKhoan và thêm vào danh sách kết quả
                TaiKhoanDTO kh = new TaiKhoanDTO(ma, ten, diaChi, sdt, matkhau, trangThai, role);
                result.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    

}

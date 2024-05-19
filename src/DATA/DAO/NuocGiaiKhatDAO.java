package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.NuocGiaiKhatDTO;
import DATA.database.*;

public class NuocGiaiKhatDAO {
    private connect database = new connect();
    private List<NuocGiaiKhatDTO> dsngk = new ArrayList<>();

    public NuocGiaiKhatDAO() {
    }

    public NuocGiaiKhatDAO(List<NuocGiaiKhatDTO> dsngk) {
        this.dsngk = dsngk;
    }

    public List<NuocGiaiKhatDTO> getData() {
        try {
            String sql = "SELECT * FROM ngk";
            Connection c = database.getConnection();
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String maNGK = rs.getString("maNGK");
                        String tenNGK = rs.getString("tenNGK");
                        String donvitinh = rs.getString("donvitinh");
                        int slcon = rs.getInt("slcon");
                        long giaban = rs.getLong("giabanle");
                        String tenloai = rs.getString("tenloai");
                        String maNB = rs.getString("maNB");
                        String maHSX = rs.getString("maHSX");
                        String maQL = rs.getString("maQL");
                        String img = rs.getString("img");
                        boolean trangThai = rs.getBoolean("trangThai");
                        NuocGiaiKhatDTO ngk = new NuocGiaiKhatDTO(maNGK, tenNGK, donvitinh, slcon, giaban, tenloai,
                                maNB,
                                maHSX, maQL, img, trangThai);
                        dsngk.add(ngk);
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
        return dsngk;
    }

    public List<NuocGiaiKhatDTO> searchByName(String keyword) {
        List<NuocGiaiKhatDTO> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Chuẩn bị câu lệnh truy vấn
            String sql = "SELECT * FROM ngk WHERE tenNGK LIKE ?";
            connection = database.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // Thiết lập tham số cho câu lệnh truy vấn
            preparedStatement.setString(1, "%" + keyword + "%");
            // Thực thi truy vấn
            resultSet = preparedStatement.executeQuery();
            // Duyệt qua kết quả trả về
            while (resultSet.next()) {
                String maNGK = resultSet.getString("maNGK");
                String tenNGK = resultSet.getString("tenNGK");
                String donvitinh = resultSet.getString("donvitinh");
                int slcon = resultSet.getInt("slcon");
                long giaban = resultSet.getLong("giabanle");
                String tenloai = resultSet.getString("tenloai");
                String maNB = resultSet.getString("maNB");
                String maHSX = resultSet.getString("maHSX");
                String maQL = resultSet.getString("maQL");
                String img = resultSet.getString("img");
                boolean trangThai = resultSet.getBoolean("trangThai");
                // Tạo đối tượng NuocGiaiKhat và thêm vào danh sách kết quả
                NuocGiaiKhatDTO ngk = new NuocGiaiKhatDTO(maNGK, tenNGK, donvitinh, slcon, giaban, tenloai, maNB,
                        maHSX, maQL, img, trangThai);
                result.add(ngk);
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

    public int insertData(NuocGiaiKhatDTO nuocGiaiKhat) {
        try {
            Connection c = database.getConnection();
            String sql = "INSERT INTO ngk (maNGK, tenNGK, donvitinh, slcon, giabanle, tenloai, maNB, maHSX, maQL, img, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, nuocGiaiKhat.getMaNGK());
            pst.setString(2, nuocGiaiKhat.getTenNGK());
            pst.setString(3, nuocGiaiKhat.getDonvitinh());
            pst.setInt(4, nuocGiaiKhat.getSlcon());
            pst.setLong(5, nuocGiaiKhat.getGiaban());
            pst.setString(6, nuocGiaiKhat.getTenloai());
            pst.setString(7, nuocGiaiKhat.getMaNB());
            pst.setString(8, nuocGiaiKhat.getMaHSX());
            pst.setString(9, nuocGiaiKhat.getMaQL());
            pst.setString(10, nuocGiaiKhat.getImg());
            pst.setBoolean(11, nuocGiaiKhat.isTrangThai());
            // Thực thi câu lệnh SQL
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
            return 0;
        }
        return 0;
    }

    public int updateData(NuocGiaiKhatDTO nuocGiaiKhat) {
        try {
            Connection c = database.getConnection();
            String sql = "UPDATE ngk SET tenNGK=?, donvitinh=?, slcon=?, giabanle=?, tenloai=?, maNB=?, maHSX=?, maQL=?, trangThai=? WHERE maNGK=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, nuocGiaiKhat.getTenNGK());
            pst.setString(2, nuocGiaiKhat.getDonvitinh());
            pst.setInt(3, nuocGiaiKhat.getSlcon());
            pst.setLong(4, nuocGiaiKhat.getGiaban());
            pst.setString(5, nuocGiaiKhat.getTenloai());
            pst.setString(6, nuocGiaiKhat.getMaNB());
            pst.setString(7, nuocGiaiKhat.getMaHSX());
            pst.setString(8, nuocGiaiKhat.getMaQL());
            pst.setBoolean(9, nuocGiaiKhat.isTrangThai());
            pst.setString(10, nuocGiaiKhat.getMaNGK());
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

    public int deleteData(String idProduct) {
        try {
            Connection c = database.getConnection();
            String sql = "DELETE FROM ngk WHERE maNGK =?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, idProduct);
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

    public List<NuocGiaiKhatDTO> searchProduct(String id, String idSaler, long fromPrice, long toPrice) {
        List<NuocGiaiKhatDTO> result = new ArrayList<>();
        try {
            Connection c = database.getConnection();
            String sql = "SELECT * FROM ngk WHERE `maNGK` LIKE ? AND `maNB` LIKE ? AND giabanle BETWEEN ? AND ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, "%"+id+"%");
            pst.setString(2, "%"+idSaler+"%");
            pst.setLong(3, fromPrice);
            pst.setLong(4, toPrice);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                String maNGK = resultSet.getString("maNGK");
                String tenNGK = resultSet.getString("tenNGK");
                String donvitinh = resultSet.getString("donvitinh");
                int slcon = resultSet.getInt("slcon");
                long giaban = resultSet.getLong("giabanle");
                String tenloai = resultSet.getString("tenloai");
                String maNB = resultSet.getString("maNB");
                String maHSX = resultSet.getString("maHSX");
                String maQL = resultSet.getString("maQL");
                String img = resultSet.getString("img");
                boolean trangThai = resultSet.getBoolean("trangThai");
                // Tạo đối tượng NuocGiaiKhat và thêm vào danh sách kết quả
                NuocGiaiKhatDTO ngk = new NuocGiaiKhatDTO(maNGK, tenNGK, donvitinh, slcon, giaban, tenloai, maNB,
                        maHSX, maQL, img, trangThai);
                result.add(ngk);
            }
            if (pst != null) pst.close();
            if (c != null) c.close();
            if(resultSet != null) resultSet.close();
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long getPriceProduct(String maSP) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        long donGia = 0;
        try {
            // Kết nối đến cơ sở dữ liệu
            connection = database.getConnection();

            // Truy vấn SQL để lấy đơn giá từ bảng sanpham dựa trên mã sản phẩm
            String sql = "SELECT giabanle FROM ngk WHERE maNGK = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maSP);

            // Thực thi truy vấn
            resultSet = statement.executeQuery();

            // Nếu có kết quả, lấy đơn giá từ ResultSet
            if (resultSet.next()) {
                donGia = resultSet.getLong("giabanle");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return donGia;
    }

    // Phương thức cập nhật số lượng tồn của nước giải khát
    public void updateSoLuongTon(String maNGK, int soLuongBan) {
        // Kết nối đến cơ sở dữ liệu
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = database.getConnection();

            // Truy vấn để lấy thông tin số lượng tồn hiện tại
            String sqlSelect = "SELECT slcon FROM ngk WHERE maNGK=?";
            pst = conn.prepareStatement(sqlSelect);
            pst.setString(1, maNGK);
            rs = pst.executeQuery();

            if (rs.next()) {
                int soLuongTonHienTai = rs.getInt("slcon");

                // Tính toán số lượng tồn mới
                int soLuongTonMoi = soLuongTonHienTai - soLuongBan;

                // Cập nhật số lượng tồn mới vào cơ sở dữ liệu
                String sqlUpdate = "UPDATE ngk SET slcon=? WHERE maNGK=?";
                pst = conn.prepareStatement(sqlUpdate);
                pst.setInt(1, soLuongTonMoi);
                pst.setString(2, maNGK);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateSoLuongTontoPhieuNhap(String maNGK, int soLuongBan) {
        // Kết nối đến cơ sở dữ liệu
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = database.getConnection();

            // Truy vấn để lấy thông tin số lượng tồn hiện tại
            String sqlSelect = "SELECT slcon FROM ngk WHERE maNGK=?";
            pst = conn.prepareStatement(sqlSelect);
            pst.setString(1, maNGK);
            rs = pst.executeQuery();

            if (rs.next()) {
                int soLuongTonHienTai = rs.getInt("slcon");

                // Tính toán số lượng tồn mới
                int soLuongTonMoi = soLuongTonHienTai + soLuongBan;

                // Cập nhật số lượng tồn mới vào cơ sở dữ liệu
                String sqlUpdate = "UPDATE ngk SET slcon=? WHERE maNGK=?";
                pst = conn.prepareStatement(sqlUpdate);
                pst.setInt(1, soLuongTonMoi);
                pst.setString(2, maNGK);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.ChiTietPhieuNhapDTO;
import DATA.database.*;

public class ChiTietPhieuNhapDAO {
    private connect database = new connect();
    public List<ChiTietPhieuNhapDTO> dsctpn = new ArrayList<>();
    
    public ChiTietPhieuNhapDAO(){

    }
    public ChiTietPhieuNhapDAO(List<ChiTietPhieuNhapDTO> dsctpn){
        this.dsctpn = dsctpn;
    }

    public List<ChiTietPhieuNhapDTO> getData(){
        Connection c = null;
        try  {
            c = database.getConnection();
            String sql = "SELECT * FROM chitietphieunhap";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while(rs.next()){
                        String maPN = rs.getString("maPN");
                        String maSP = rs.getString("maSP");
                        int soLuong = rs.getInt("soLuong");
                        long donGia = rs.getLong("donGia");
                        long thanhTien = rs.getLong("thanhTien");
                        ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(maPN, maSP, soLuong, donGia, thanhTien);
                        dsctpn.add(ctpn);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally{
                    if(pst != null){
                        pst.close();
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally{
                if(c != null){
                    c.close();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsctpn;
    }

    public int insertData(ChiTietPhieuNhapDTO ctpn){
        try {
            Connection c = database.getConnection();
            String sql = "INSERT INTO chitietphieunhap (maPN, maSP, soLuong, donGia, thanhTien) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, ctpn.getMaPN());
            pst.setString(2, ctpn.getMaSP());
            pst.setInt(3, ctpn.getSoLuong());
            pst.setLong(4, ctpn.getDonGia());
            pst.setLong(5, ctpn.getThanhTien());
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                if (pst != null)
                    pst.close();
                if (c != null)
                    c.close();
                return affectedRows;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return 0;
    }

    public int updateChiTietPhieuNhap(ChiTietPhieuNhapDTO chiTietPhieuNhap){
        try {
            Connection c = database.getConnection();
            String sql = "UPDATE chitietphieunhap SET soLuong=?, donGia=?, thanhTien=? WHERE mapn=? AND maSP=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, chiTietPhieuNhap.getSoLuong());
            pst.setLong(2, chiTietPhieuNhap.getDonGia());
            pst.setLong(3, chiTietPhieuNhap.getThanhTien());
            pst.setString(4, chiTietPhieuNhap.getMaPN());
            pst.setString(5, chiTietPhieuNhap.getMaSP());

            int affect = pst.executeUpdate();
            if(affect>0){
                pst.close();
            c.close();
            return affect;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void deleteChiTietPhieuNhap(String maPN, String maSP) {
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            connection = database.getConnection();
            String sql = "DELETE FROM chitietphieunhap WHERE maPN = ? AND maSP = ?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, maPN);
            pst.setString(2, maSP);

            pst.executeUpdate();
        } catch (Exception e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // Xử lý ngoại lệ
                e.printStackTrace();
            }
        }
    }

    public void updateInventoryQuantity(ChiTietPhieuNhapDTO ctpn) {
        try {
            Connection c = database.getConnection();
            String query = "SELECT slcon FROM ngk WHERE maNGK = ?";
            PreparedStatement pstSelect = c.prepareStatement(query);
            pstSelect.setString(1, ctpn.getMaSP());
            ResultSet rs = pstSelect.executeQuery();
    
            int soLuongHienTai = 0;
            if (rs.next()) {
                soLuongHienTai = rs.getInt("slcon");
            }
    
            int soLuongMoi = soLuongHienTai + ctpn.getSoLuong();
            
            String updateQuery = "UPDATE ngk SET slcon = ? WHERE maNGK = ?";
            PreparedStatement pstUpdate = c.prepareStatement(updateQuery);
            pstUpdate.setInt(1, soLuongMoi);
            pstUpdate.setString(2, ctpn.getMaSP());
            pstUpdate.executeUpdate();
    
            pstSelect.close();
            rs.close();
            pstUpdate.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}

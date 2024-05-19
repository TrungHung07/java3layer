package DATA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATA.DTO.NhaCungCapDTO;
import DATA.database.*;

public class NhaCungCapDAO {
    private connect database = new connect();
    public List<NhaCungCapDTO> dsncc = new ArrayList<>();

    
    public NhaCungCapDAO() {
    }
    public NhaCungCapDAO(List<NhaCungCapDTO> dsncc) {
        this.dsncc = dsncc;
    }

    public List<NhaCungCapDTO> getData(){
        Connection c= null;
        try {
            c = database.getConnection();
            String sql = "SELECT * FROM nhacungcap";
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String maNCC = rs.getString("maNCC");
                        String tenNCC = rs.getString("tenNCC");
                        String diaChi = rs.getString("diaChi");
                        String sdt = rs.getString("sdt");
                        boolean trangThai = rs.getBoolean("trangThai");
                        NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, diaChi, sdt, trangThai);
                        dsncc.add(ncc);
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
            }finally{
                if(c!= null){
                    c.close();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsncc;
    }

    public void insertData(NhaCungCapDTO ncc){
        try {
            Connection c = database.getConnection();
            String sql = "INSERT INTO nhacungcap (maNCC, tenNCC, diaChi, sdt, trangThai) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, ncc.getMaNCC());
            pst.setString(2, ncc.getTenNCC());
            pst.setString(3, ncc.getDiaChi());
            pst.setString(4, ncc.getSdt());
            pst.setBoolean(5, ncc.isTrangThai());
            pst.executeUpdate();
            if(pst != null){
                pst.close();
            }
            if(c != null){
                c.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void updateState(NhaCungCapDTO ncc){
        try {
            Connection c= database.getConnection();
            String sql = "UPDATE nhacungcap SET tenNCC=?, diaChi=?, sdt=?, trangThai = ? WHERE maNCC = ?";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, ncc.getTenNCC());
            pst.setString(2, ncc.getDiaChi());
            pst.setString(3, ncc.getSdt());
            pst.setBoolean(4, ncc.isTrangThai());
            pst.setString(5, ncc.getMaNCC());
            pst.executeUpdate();

            pst.close();
            c.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

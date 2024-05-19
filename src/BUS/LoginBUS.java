package BUS;

import java.util.ArrayList;
import java.util.List;

import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.TaiKhoanDTO;

//import com.google.gson.Gson;

public class LoginBUS {
    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    private List<TaiKhoanDTO> dsTaiKhoan = new ArrayList<>(taiKhoanDAO.getData());

    public TaiKhoanDTO checkAccount(TaiKhoanDTO account) {
        for (TaiKhoanDTO taiKhoanDTO : dsTaiKhoan) {
            if(taiKhoanDTO.getMa().equals(account.getMa()) && taiKhoanDTO.getMatkhau().equals(account.getMatkhau())){
                return taiKhoanDTO;
            }
        }
        return null;
    }
}

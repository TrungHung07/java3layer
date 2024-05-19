package BUS;

import java.util.List;

import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.TaiKhoanDTO;

public class KhachHangBUS {
    private TaiKhoanDAO tkDAO = new TaiKhoanDAO();

    public List<TaiKhoanDTO> getData(){
        return tkDAO.getData();
    }

    public boolean checkIdCustomer(String idCustomer){
        if(tkDAO.checkIdCustomer(idCustomer)==0){
            return true;
        }
        return false;
    }

    public boolean insertCustomer(TaiKhoanDTO tkDTO){
        if(tkDAO.insertData(tkDTO)>0){
            return true;
        }
        return false;
    }

    public boolean updateCustomer(TaiKhoanDTO tkDTO){
        if(tkDAO.editData(tkDTO)>0){
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(String idCustomer){
        if(tkDAO.deleteData(idCustomer)>0){
            return true;
        }
        return false;
    }

    public List<TaiKhoanDTO> searchCustomer(String idCustomer, String nameCustomer, String activity){
        return tkDAO.searchCustomer(idCustomer, nameCustomer, activity);
    }
}

package BUS;

import java.util.List;

import DATA.DAO.NuocGiaiKhatDAO;
import DATA.DTO.NuocGiaiKhatDTO;

public class SanPhamBUS {
    private NuocGiaiKhatDAO ngkDAO = new NuocGiaiKhatDAO();

    public List<NuocGiaiKhatDTO> getData(){
        return ngkDAO.getData();
    }

    public boolean insertProduct(NuocGiaiKhatDTO product){
        int result =ngkDAO.insertData(product);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean updateProduct(NuocGiaiKhatDTO product){
        int result =ngkDAO.updateData(product);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteProduct(String idProduct){
        int result =ngkDAO.deleteData(idProduct);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    public List<NuocGiaiKhatDTO> searchProduct(String id, String idSaler, long fromPrice, long toPrice){
        return ngkDAO.searchProduct(id, idSaler, fromPrice, toPrice);
    }
}

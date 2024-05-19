package BUS;

import java.util.List;

import DATA.DAO.ChiTietHoaDonDAO;
import DATA.DAO.HoaDonDAO;
import DATA.DTO.ChiTietHoaDonDTO;
import DATA.DTO.HoaDonDTO;

public class HoaDonBUS {
    private HoaDonDAO hdDAO = new HoaDonDAO();
    private ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();

    public List<HoaDonDTO> getDataHdDAO() {
        return hdDAO.getData();
    }

    public List<ChiTietHoaDonDTO> getDataCTHDDAO() {
        return cthdDAO.getData();
    }

    public boolean deleteHoaDon(String soHD) {
        if (cthdDAO.deleteData(soHD) > 0 && hdDAO.deleteData(soHD) > 0) {
            return true;
        }
        return false;
    }

    public List<HoaDonDTO> searchHoaDon(String maKH, String startDate, String endDate, Long fromPrice, Long toPrice) {
        return hdDAO.searchHoaDon(maKH, startDate, endDate, fromPrice, toPrice);
    }

    public boolean updateStoryInvoice(String soHD, String story) {
        if (hdDAO.updateTinhTrangToChoDuyet(soHD, story) > 0) {
            return true;
        }
        return false;
    }

    public boolean updateQuantity(String soHD) {
        if(hdDAO.updateQuantity(soHD)){
            return true;
        }
        return false;
    }

}

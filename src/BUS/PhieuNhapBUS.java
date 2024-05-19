package BUS;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import DATA.DAO.ChiTietPhieuNhapDAO;
import DATA.DAO.PhieuNhapDAO;
import DATA.DTO.ChiTietPhieuNhapDTO;
import DATA.DTO.PhieuNhapDTO;

public class PhieuNhapBUS {
    private PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    private ChiTietPhieuNhapDAO ctpnDAO = new ChiTietPhieuNhapDAO();

    public List<PhieuNhapDTO> getDataPnDAO() {
        return pnDAO.getData();
    }

    public List<ChiTietPhieuNhapDTO> getDataCtpnDAO() {
        return ctpnDAO.getData();
    }

    public boolean checkInfo(String id) {
        if (pnDAO.checkId(id) > 0) {
            return true;
        }
        return false;
    }

    public boolean insertDataPnDAO(PhieuNhapDTO pnDTO) {
        if (pnDAO.insertData(pnDTO) > 0) {
            return true;
        }
        return false;
    }

    public boolean insertDataCtpnDAO(ChiTietPhieuNhapDTO ptDTO) {
        if (ctpnDAO.insertData(ptDTO) > 0) {
            ctpnDAO.updateInventoryQuantity(ptDTO);
            return true;
        }
        return false;
    }

    public boolean updatePrice(String maPN) {
        if (pnDAO.updatePrice(maPN) > 0) {
            return true;
        }
        return false;
    }

    public boolean updateChiTiet(ChiTietPhieuNhapDTO ctDTO) {
        if (ctpnDAO.updateChiTietPhieuNhap(ctDTO) > 0) {
            pnDAO.updatePrice(ctDTO.getMaPN());
            return true;
        }
        return false;
    }

    public boolean deleteData(String maPN) {
        if (pnDAO.deleteData(maPN) > 0) {
            return true;
        }
        return false;
    }

    public List<PhieuNhapDTO> searchData(String maPN, String maNV, String maNCC, String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date defaultStartDate = null;
        Date defaultEndDate = null;
        try {
            if (!startDate.equals("") && !endDate.equals("")) {
                defaultStartDate = new Date(sdf.parse(startDate).getTime());
                defaultEndDate = new Date(sdf.parse(endDate).getTime());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pnDAO.searchList(maPN, maNV, maNCC, defaultStartDate, defaultEndDate);
    }

}

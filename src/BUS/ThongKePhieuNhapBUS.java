package BUS;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import DATA.DAO.PhieuNhapDAO;
import DATA.DTO.PhieuNhapDTO;
import DATA.DTO.ThongKePhieuNhapDTO;

public class ThongKePhieuNhapBUS {
    private PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    
    public List<ThongKePhieuNhapDTO> getData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date defaultStartDate = null;
        Date defaultEndDate = null;
        try {
            defaultStartDate = new Date(sdf.parse("1975-01-01").getTime());
            defaultEndDate = new Date(sdf.parse("2035-01-01").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pnDAO.getProductStatistics(0, 0, defaultStartDate, defaultEndDate);
    }

    //Thắc mắc cách gọi
    public List<ThongKePhieuNhapDTO> getData(int quarter, int year, String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date defaultStartDate = null;
        Date defaultEndDate = null;
        try {
            defaultStartDate = new Date(sdf.parse(startDate).getTime());
            defaultEndDate = new Date(sdf.parse(endDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pnDAO.getProductStatistics(quarter, year, defaultStartDate, defaultEndDate);
    }

    public List<PhieuNhapDTO> getPhieuNhap(){
        return pnDAO.getData();
    }

    
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import BUS.ThongKePhieuNhapBUS;
import GUI.QuanLyKhoHang.ThongKePhieuNhapGUI;

public class ThongKePhieuNhapControler implements ActionListener {
    private ThongKePhieuNhapGUI tk;
    private ThongKePhieuNhapBUS tkBUS = new ThongKePhieuNhapBUS();
    

    public ThongKePhieuNhapControler(ThongKePhieuNhapGUI tk) {
        this.tk = tk;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.tk.btnLoc) {
            String startDate = this.tk.getValues()[0];
            String endDate = this.tk.getValues()[1];
            String year = this.tk.getValues()[2];
            String quarter = this.tk.getValues()[3];

            if (startDate.equals("") && endDate.equals("") && year.equals("") && quarter.equals("Chọn")) {
                this.tk.errorMessage("Vui lòng nhập thông tin tìm kiếm");
                return;
            }

            if ((!year.equals("") && quarter.equals("Chọn")) || (year.equals("") && !quarter.equals("Chọn"))) {
                this.tk.errorMessage("Vui lòng nhập đầy đủ Quý và Năm");
                return;
            }

            if ((!startDate.equals("") && endDate.equals("")) || (startDate.equals("") && !endDate.equals(""))) {
                this.tk.errorMessage("Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc");
                return;
            }

            if (!startDate.equals("") && !quarter.equals("Chọn")) {
                if (!this.isValidDateFormat(startDate) || !this.isValidDateFormat(endDate)
                        || !Pattern.matches("\\d+", year) || !Pattern.matches("\\d+", year)) {
                    this.tk.errorMessage("Dữ liệu không hợp lệ");
                    return;
                }
            } else if (!startDate.equals("")) {
                if (this.isValidDateFormat(startDate) && this.isValidDateFormat(endDate)) {
                    this.tkBUS.getData(-1, -1, startDate, endDate);
                } else {
                    this.tk.errorMessage("Ngày không hợp lệ");
                }
            } else if (!quarter.equals("Chọn")) {
                if (!Pattern.matches("\\d+", year) && !Pattern.matches("\\d+", year)) {
                    this.tk.errorMessage("Năm không hợp lệ");
                    return;
                } else {
                    this.tkBUS.getData(Integer.parseInt(quarter), Integer.parseInt(year), "1975-01-01",
                            "2035-01-01");
                }
            }
        }
    }

    // Exceptions
    public boolean isValidDateFormat(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

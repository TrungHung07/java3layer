package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import BUS.HoaDonBUS;
import DATA.DTO.ChiTietHoaDonDTO;
import GUI.Admin.HoaDonGUI;

public class HoaDonController implements ActionListener, MouseListener {
    private HoaDonGUI vhd;
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private List<ChiTietHoaDonDTO> dsCthd = new ArrayList<>();

    public HoaDonController(HoaDonGUI vhd) {
        this.vhd = vhd;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vhd.table_hoadon) {
            if (!dsCthd.isEmpty()) {
                dsCthd.clear();
            }
            dsCthd = hdBUS.getDataCTHDDAO();
            this.vhd.getDataSelectRowTable(dsCthd);
        }
        if (e.getSource() == this.vhd.table_cthd) {
            this.vhd.getTxtFromTable();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vhd.btnDatLai) {
            this.vhd.resetTxt();
        }
        if (e.getSource() == this.vhd.btnXoa) {
            String maHD = this.vhd.getFieldValue("txtSoHoaDon");
            if (this.vhd.confirmMessage("Xác nhận xóa hóa đơn") == JOptionPane.YES_OPTION) {
                if (hdBUS.deleteHoaDon(maHD)) {
                    this.vhd.successMessage("Xóa thành công");
                    this.vhd.resetTxt();
                    this.vhd.getData(hdBUS.getDataHdDAO());
                } else {
                    this.vhd.errorMessage("Xóa thất bại. Vui lòng thử lại");
                    return;
                }
            }
        }
        if (e.getSource() == this.vhd.btnDong) {
            this.vhd.closeView();
        }
        if (e.getSource() == this.vhd.btnXemHoaDon) {
            this.vhd.checkHoaDon();
        }
        if (e.getSource() == this.vhd.btnTimKiem) {
            String maKH = this.vhd.getFieldValue("txtTKMaKhachHang");
            String startDate = this.vhd.getFieldValue("txtTKNgayBatDau");
            String endDate = this.vhd.getFieldValue("txtTKNgayKetThuc");
            String fromPrice_txt = this.vhd.getFieldValue("txtTongTienTu");
            String toPrice_txt = this.vhd.getFieldValue("txtTongTienDen");

            long fromPrice = 0;
            long toPrice = 999999999;

            // Kiểm tra nếu tất cả các trường đều trống
            if (maKH.equals("") && startDate.equals("") && endDate.equals("") && fromPrice_txt.equals("")
                    && toPrice_txt.equals("")) {
                this.vhd.errorMessage("Vui lòng điền ít nhất một thông tin");
                return;
            }

            // Kiểm tra định dạng số cho từ giá và đến giá
            if ((!fromPrice_txt.equals("") && !toPrice_txt.equals(""))
                    && (!Pattern.matches("\\d+", fromPrice_txt) || !Pattern.matches("\\d+", toPrice_txt))) {
                this.vhd.errorMessage("Số tiền sai định dạng. Vui lòng thử lại");
                return;
            } else {
                if (!fromPrice_txt.equals("")) {
                    fromPrice = Long.parseLong(fromPrice_txt);
                }
                if (!toPrice_txt.equals("")) {
                    toPrice = Long.parseLong(toPrice_txt);
                }
            }

            // Kiểm tra ngày bắt đầu và ngày kết thúc
            if ((!startDate.equals("") && endDate.equals("")) || (startDate.equals("") && !endDate.equals(""))) {
                this.vhd.errorMessage("Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc");
                return;
            } else if (!startDate.equals("") && !endDate.equals("")
                    && (!this.vhd.isValidDateFormat(startDate) || !this.vhd.isValidDateFormat(endDate))) {
                this.vhd.errorMessage("Ngày sai định dạng. Vui lòng thử lại");
                return;
            }

            // Gọi phương thức tìm kiếm với các giá trị đã kiểm tra
            this.vhd.getData(this.hdBUS.searchHoaDon(maKH, startDate, endDate, fromPrice, toPrice));
        }
        if (e.getSource() == this.vhd.btnHuyTimKiem) {
            this.vhd.getData(this.hdBUS.getDataHdDAO());
        }
        if (e.getSource() == this.vhd.btnQuayLai) {
            this.vhd.closeFrame();
        }
    }

}

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
import GUI.Admin.GioHangGUI;

public class ControllerViewGioHang implements ActionListener, MouseListener {
    private GioHangGUI vgh;
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private List<ChiTietHoaDonDTO> dsCthd = new ArrayList<>();

    public ControllerViewGioHang(GioHangGUI vgh) {
        this.vgh = vgh;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vgh.tableDonHang) {
            if (!dsCthd.isEmpty()) {
                dsCthd.clear();
            }
            dsCthd = hdBUS.getDataCTHDDAO();
            this.vgh.displayDataOnTable(dsCthd);
        }
        if (e.getSource() == this.vgh.tableChiTietDonHang) {
            this.vgh.setTxtFormTable();
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
        if (e.getSource() == this.vgh.btnDuyetDon) {
            String soHD = this.vgh.getFieldValue("txtMaGioHang");
            String story = "Đã duyệt";
            if (this.vgh.confirmMessage("Xác nhận duyệt đơn hàng") == JOptionPane.YES_OPTION) {
                if (this.hdBUS.updateStoryInvoice(soHD, story)) {
                    this.vgh.successMessage("Duyệt đơn hàng thành công");
                    this.vgh.getData(hdBUS.getDataHdDAO());
                } else {
                    this.vgh.errorMessage("Duyệt đơn hàng thất bại. Vui lòng thử lại");
                    return;
                }
            }
        }
        if (e.getSource() == this.vgh.btnTuChoi) {
            String soHD = this.vgh.getFieldValue("txtMaGioHang");
            String story = "Từ chối";
            if (this.vgh.confirmMessage("Xác nhận Từ chối đơn hàng") == JOptionPane.YES_OPTION) {
                if (this.hdBUS.updateStoryInvoice(soHD, story)) {
                    this.vgh.successMessage("Đơn hàng đã từ chối");
                    this.vgh.getData(hdBUS.getDataHdDAO());
                } else {
                    this.vgh.errorMessage("Lỗi");
                    return;
                }
            }
        }
        if (e.getSource() == this.vgh.btnGiaoHang) {
            String soHD = this.vgh.getFieldValue("txtMaGioHang");
            String story = "Đang giao";
            if (this.vgh.confirmMessage("Đơn hàng đang được giao") == JOptionPane.YES_OPTION) {
                if (this.hdBUS.updateQuantity(soHD)) {
                    if (this.hdBUS.updateStoryInvoice(soHD, story)) {
                        this.vgh.successMessage("Đơn hàng đang giao");
                        this.vgh.getData(hdBUS.getDataHdDAO());
                    } else {
                        this.vgh.errorMessage("Lỗi");
                        return;
                    }
                } else {
                    this.vgh.errorMessage("Số lượng tồn kho không thỏa. VUi lòng nhập thêm sản phẩm");
                    return;
                }
            }
        }
        if (e.getSource() == this.vgh.btnTimKiem) {
            String maKH = this.vgh.getFieldValue("txtTKMaKhachHang");
            String giaTu = this.vgh.getFieldValue("txtTongTienTu");
            String giaDen = this.vgh.getFieldValue("txtTongTienDen");
            long fromPrice =0;
            long toPrice =999999999;
            if (giaTu.equals("") && giaDen.equals("") && maKH.equals("")) {
                this.vgh.warningMessage("Vui lòng điền ít nhất 1 thông tin cần tìm");
                return;
            }
            if(!giaTu.equals("") && !giaDen.equals("")){
                if((!Pattern.matches("\\d+", giaTu) || !Pattern.matches("\\d+", giaDen))){
                    this.vgh.warningMessage("Vui lòng nhập đúng định dạng số");
                return;
                }else{
                    fromPrice = Long.parseLong(giaTu);
                    toPrice = Long.parseLong(giaDen);
                }
                
            }else{
            }
           this.vgh.getData( this.hdBUS.searchHoaDon(maKH, "", "", fromPrice, toPrice));
        }
        if (e.getSource() == this.vgh.btnHuyTimKiem) {
            this.vgh.getData(this.hdBUS.getDataHdDAO());
        }
        if (e.getSource() == this.vgh.btnQuayLai) {
            this.vgh.comeback();
        }
        if (e.getSource() == this.vgh.btnInHoaDon) {
            this.vgh.printTheInvoice();
        }
    }

}

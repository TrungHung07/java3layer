package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import BUS.KhachHangBUS;
import DATA.DTO.TaiKhoanDTO;
import GUI.Admin.KhachHangGUI;

public class KhachHangController implements ActionListener, MouseListener {
    private KhachHangGUI vkh;
    private KhachHangBUS khBUS = new KhachHangBUS();

    public KhachHangController(KhachHangGUI vkh) {
        this.vkh = vkh;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vkh.table) {
            this.vkh.setTextData(khBUS.getData());
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
        if (e.getSource() == this.vkh.btnThem) {
            String maKH = this.vkh.getField("txtMaKhachHang");
            String tenKH = this.vkh.getField("txtTenKhachHang");
            String sdt = this.vkh.getField("txtSdt");
            String diaChi = this.vkh.getField("txtDiaChi");
            String matKhau = this.vkh.getField("txtMatKhau");
            if (maKH.equals("") || tenKH.equals("") || sdt.equals("") || sdt.equals("") || diaChi.equals("")
                    || matKhau.equals("")) {
                this.vkh.warningMessage("Vui lòng nhập đầy đủ thông tin");
                return;
            }
            int choice = JOptionPane.showConfirmDialog(null, "Xác nhận thêm khách hàng", "Thông báo",
                    JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (!khBUS.checkIdCustomer(maKH)) {
                    this.vkh.warningMessage("Mã khách hàng đã tồn tại");
                    return;
                } else {
                    TaiKhoanDTO taiKhoan = new TaiKhoanDTO(maKH, tenKH, diaChi, sdt, matKhau, true, "khachhang");
                    if (khBUS.insertCustomer(taiKhoan)) {
                        this.vkh.infoMessage("Đã thêm mới");
                        this.vkh.getData(khBUS.getData());
                    } else {
                        this.vkh.warningMessage("Thêm mới thất bại");
                    }
                }
            }
        }
        if (e.getSource() == this.vkh.btnSua) {
            String maKH = this.vkh.getField("txtMaKhachHang");
            String tenKH = this.vkh.getField("txtTenKhachHang");
            String sdt = this.vkh.getField("txtSdt");
            String diaChi = this.vkh.getField("txtDiaChi");
            String matKhau = this.vkh.getField("txtMatKhau");
            boolean trangthai = true;
            if(this.vkh.getField("HoatDong").equals("Hoạt động")){
                trangthai = true;
            }else{
                trangthai = false;
            }
            if (maKH.equals("") || tenKH.equals("") || sdt.equals("") || sdt.equals("") || diaChi.equals("")
                    || matKhau.equals("")) {
                this.vkh.warningMessage("Vui lòng nhập đầy đủ thông tin");
                return;
            }
            int choice = JOptionPane.showConfirmDialog(null, "Xác nhận sửa khách hàng", "Thông báo",
                    JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION){
                        if (khBUS.checkIdCustomer(maKH)){
                            this.vkh.warningMessage("Mã khách hàng không tồn tại");
                            return;
                        }else{
                            TaiKhoanDTO taiKhoan = new TaiKhoanDTO(maKH, tenKH, diaChi, sdt, matKhau, trangthai, "khachhang");
                            if (khBUS.updateCustomer(taiKhoan)) {
                                this.vkh.infoMessage("Đã sửa");
                                this.vkh.getData(khBUS.getData());
                            } else {
                                this.vkh.warningMessage("Sửa thất bại");
                            }
                        }
                    }
        }
        if (e.getSource() == this.vkh.btnXoa) {
            String maKH = this.vkh.getField("txtMaKhachHang");
            if(maKH.equals("")){
                this.vkh.warningMessage("Vui lòng chọn khách hàng cần xóa");
                return;
            }
            if(khBUS.checkIdCustomer(maKH)){
                this.vkh.warningMessage("Mã khách hàng không tồn tại");
                return;
            }
            int choice = JOptionPane.showConfirmDialog(null, "Xác nhận xóa khách hàng", "Thông báo",
                    JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION){
                        if (khBUS.deleteCustomer(maKH)) {
                            this.vkh.infoMessage("Đã xóa");
                            this.vkh.getData(khBUS.getData());
                        } else {
                            this.vkh.warningMessage("Xóa thất bại");
                        }
                    }
        }
        if (e.getSource() == this.vkh.btnHuyBo) {
            this.vkh.clearTxt();
        }
        if (e.getSource() == this.vkh.btnTroLai) {
            this.vkh.closeView();
        }
        if (e.getSource() == this.vkh.btnTimKiemKhachHang) {
            String tenKhachHang = this.vkh.getField("txtTimKiemTenKhachHang");
		    String maTimKiem = this.vkh.getField("txtTimKiemMaKhachHang");
            String trangthai = "";
            if(this.vkh.getField("TrangThai").equals("Trạng thái")){
                trangthai = "";
            }else if (this.vkh.getField("TrangThai").equals("Hoạt động")){
                trangthai="hd";
            }else if (this.vkh.getField("TrangThai").equals("Tạm ngưng")){
                trangthai="tn";
            }
            System.out.println(trangthai);
            this.vkh.getData(khBUS.searchCustomer(tenKhachHang, maTimKiem, trangthai));
        }
        if (e.getSource() == this.vkh.btnHuyTimKiemKhachHang) {
            this.vkh.getData(khBUS.getData());
        }
    }

}

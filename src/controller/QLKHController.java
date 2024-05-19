package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.QuanLyKhoHang.QLKHGUI;

public class QLKHController implements ActionListener {
    private QLKHGUI qlkh;

    public QLKHController(QLKHGUI qlkh) {
        this.qlkh = qlkh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == this.qlkh.btnSanPham){
                this.qlkh.openViewSanPham();
            }
            if(e.getSource() == this.qlkh.btnNhaCungCap){
                this.qlkh.openNhaCungCap();
            }
            if(e.getSource() == this.qlkh.btnPhieuNhap){
                this.qlkh.openViewPhieuNhap();
            }
            if(e.getSource() == this.qlkh.btnThongKe){
                this.qlkh.openViewThongKeKhoHang();
            }
            if (e.getSource() == this.qlkh.btn_dangxuat) {
                this.qlkh.logout();
            }
            if (e.getSource() == this.qlkh.btn_dong) {
                this.qlkh.closeView();
            }
    }

}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.Admin.QLCHGUI;

public class QLCHController implements ActionListener {
    private QLCHGUI qlch;

    public QLCHController(QLCHGUI viewQLCH) {
        this.qlch = viewQLCH;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == this.qlch.btnKhachHang){
                this.qlch.openViewKhachHang();
            }
            if(e.getSource() == this.qlch.btnGioHang){
                this.qlch.openViewGioHang();
            }
            if(e.getSource() == this.qlch.btnHoaDon){
                this.qlch.openViewHoaDon();
            }
            if(e.getSource() == this.qlch.ddbtnThongKe){
                this.qlch.openViewThongKe();
            }
            if (e.getSource() == this.qlch.btn_dangxuat) {
                this.qlch.logout();
            }
            if (e.getSource() == this.qlch.btn_dong) {
                this.qlch.closeView();
            }
    }
}

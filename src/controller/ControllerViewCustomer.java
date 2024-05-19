package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.Customer.CustomerGUI;

public class ControllerViewCustomer implements ActionListener, MouseListener {
	private CustomerGUI vcs;

	public ControllerViewCustomer(CustomerGUI vcs) {
		this.vcs = vcs;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.vcs.panel_home || e.getSource() == this.vcs.lbl_home
				|| e.getSource() == this.vcs.lbl_img_trangchu) {
			this.vcs.panelHome.setVisible(true);
			this.vcs.panelCart.setVisible(false);
			this.vcs.panelHistory.setVisible(false);
			this.vcs.panelProFile.setVisible(false);

			this.vcs.panel_home.setBackground(new Color(214, 36, 31));
			this.vcs.panel_cart.setBackground(new Color(255, 128, 40));
			this.vcs.panel_history.setBackground(new Color(255, 128, 40));
			this.vcs.panel_profile.setBackground(new Color(255, 128, 40));
		}
		if (e.getSource() == this.vcs.panel_cart || e.getSource() == this.vcs.lbl_cart
				|| e.getSource() == this.vcs.lbl_img_gioHang) {
			this.vcs.panelHome.setVisible(false);
			this.vcs.panelCart.setVisible(true);
			this.vcs.panelHistory.setVisible(false);
			this.vcs.panelProFile.setVisible(false);

			this.vcs.panel_home.setBackground(new Color(255, 128, 40));
			this.vcs.panel_cart.setBackground(new Color(214, 36, 31));
			this.vcs.panel_history.setBackground(new Color(255, 128, 40));
			this.vcs.panel_profile.setBackground(new Color(255, 128, 40));
		}
		if (e.getSource() == this.vcs.panel_history || e.getSource() == this.vcs.lbl_history
				|| e.getSource() == this.vcs.lbl_img_lichSu) {
			this.vcs.panelHome.setVisible(false);
			this.vcs.panelCart.setVisible(false);
			this.vcs.panelHistory.setVisible(true);
			this.vcs.panelProFile.setVisible(false);

			this.vcs.panel_home.setBackground(new Color(255, 128, 40));
			this.vcs.panel_cart.setBackground(new Color(255, 128, 40));
			this.vcs.panel_history.setBackground(new Color(214, 36, 31));
			this.vcs.panel_profile.setBackground(new Color(255, 128, 40));
		}
		if (e.getSource() == this.vcs.panel_profile || e.getSource() == this.vcs.lbl_profile
				|| e.getSource() == this.vcs.lbl_img_ttCaNhan) {
			this.vcs.panelHome.setVisible(false);
			this.vcs.panelCart.setVisible(false);
			this.vcs.panelHistory.setVisible(false);
			this.vcs.panelProFile.setVisible(true);

			this.vcs.panel_home.setBackground(new Color(255, 128, 40));
			this.vcs.panel_cart.setBackground(new Color(255, 128, 40));
			this.vcs.panel_history.setBackground(new Color(255, 128, 40));
			this.vcs.panel_profile.setBackground(new Color(214, 36, 31));
		}
		if (e.getSource() == this.vcs.tableHomeProduct) {
			this.vcs.getDataOnTable();
		}
		if(e.getSource() == this.vcs.tableCartChiTietGioHang){
			this.vcs.setTxtFormTable();
		}
		if(e.getSource() == this.vcs.tableLichSuHoaDon){
			this.vcs.setTableHistory();
		}
		if(e.getSource() == this.vcs.tableLichSuChiTietHoaDon){
			this.vcs.setTxtHistory();
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
		if (e.getSource() == this.vcs.btnClose) {
			this.vcs.closeView();
		}

		if (e.getSource() == this.vcs.btnLogout || e.getSource() == this.vcs.btnDangXuatProfile) {
			this.vcs.logOut();
		}
		//profile
		if (e.getSource() == this.vcs.btnSuaProfile) {
			this.vcs.editProfile();
		}
		if (e.getSource() == this.vcs.btnHuyBoProfile) {
			this.vcs.setProfile();
		}
		if (e.getSource() == this.vcs.btnLuuProfile) {
			this.vcs.saveProfile();
		}
		//Cart
		if (e.getSource() == this.vcs.btnDatHang) {
			this.vcs.checkOut();
		}
		if (e.getSource() == this.vcs.btnXoaGioHang) {
			this.vcs.deleteCart();
		}
		if(e.getSource() == this.vcs.btnHuyDon){
			this.vcs.cancelOrder();
		}
		if(e.getSource() == this.vcs.btnDaNhan){
			this.vcs.receivedOrder();
		}
		if(e.getSource() == this.vcs.btnThanhToan){
			this.vcs.paymentForOrder();
		}
		if(e.getSource() == this.vcs.btnXemHoaDon){
			this.vcs.checkHoaDon();
		}
		//home
		if(e.getSource() == this.vcs.btnThemGioHang){
			this.vcs.addToCart();
		}
		if(e.getSource() == this.vcs.btnMuaNgay){
			this.vcs.buyNow();
		}
		if(e.getSource() == this.vcs.btn_TimKiem){
			this.vcs.searchProduct();
		}
		if(e.getSource() == this.vcs.btnHy){
			this.vcs.cancelSearch();
		}
	}

}

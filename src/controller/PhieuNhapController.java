package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import BUS.PhieuNhapBUS;
import DATA.DTO.ChiTietPhieuNhapDTO;
import DATA.DTO.PhieuNhapDTO;
import GUI.QuanLyKhoHang.PhieuNhapGUI;

public class PhieuNhapController implements ActionListener, MouseListener {
	private PhieuNhapGUI vpn;
	private PhieuNhapBUS pnBUS = new PhieuNhapBUS();
	private List<ChiTietPhieuNhapDTO> list = new ArrayList<>();

	public PhieuNhapController(PhieuNhapGUI vpn) {
		this.vpn = vpn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.vpn.btn_TroVe) {
			this.vpn.comeBack();
		}
		if (e.getSource() == this.vpn.btn_Them) {
			String maPN = this.vpn.getFieldValue("txt_TTCT_MaPhieu");
			String maNV = this.vpn.getFieldValue("txt_TTCT_MaNV");
			String maNCC = this.vpn.getFieldValue("txt_TTCT_MaNCC");
			String ngayLap = this.vpn.getFieldValue("txt_TTCT_NgayLap");
			String maSP = this.vpn.getFieldValue("txt_TTCT_MaSP");
			String soLuong = this.vpn.getFieldValue("txt_TTCT_SoLuong");
			String dongia = this.vpn.getFieldValue("txt_TTCT_DonGia");
			if (maPN.equals("") || maNV.equals("") || maNCC.equals("") || maSP.equals("")
					|| soLuong.equals("")) {
				this.vpn.errorMessage("Vui lòng nhập đầy đủ thông tin");
				return;
			}
			if (!(Pattern.matches("\\d+", soLuong)) || !Pattern.matches("\\d+", dongia)) {
				this.vpn.errorMessage("Số lượng hoặc đơn giá sai định dạng. Vui lòng thử lại");
				return;
			}
			if (!this.vpn.checkAccount()) {
				this.vpn.errorMessage("Mật khẩu sai");
				return;
			}
			Date newDate;
			if (ngayLap.equals("")) {
				LocalDate currDate = LocalDate.now();
				newDate = Date.valueOf(currDate);
			} else {
				newDate = Date.valueOf(ngayLap);
			}
			if (!this.vpn.checkPosition(maNV) && !this.vpn.checkPosition(maNCC)) {
				this.vpn.errorMessage("Nhân viên hoặc nhà cung cấp không tồn tại");
				return;
			}
			int quantity = Integer.valueOf(soLuong);
			long donGia = Long.valueOf(dongia);
			long thanhTien = quantity * donGia;
			if (!pnBUS.checkInfo(maPN)) {
				if (this.vpn.confirmMessage(
						"Mã phiếu nhập cần cập nhật không tồn tại. Xác nhận thêm mới") == JOptionPane.YES_OPTION) {
					PhieuNhapDTO pn = new PhieuNhapDTO(maPN, newDate, maNV, maNCC, thanhTien);
					ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(maPN, maSP, quantity, donGia, thanhTien);
					if (pnBUS.insertDataPnDAO(pn)) {
						if (pnBUS.insertDataCtpnDAO(ctpn)) {
							this.vpn.successMessage("Thêm thành công");
							this.vpn.clearTxt();
							this.vpn.getData(pnBUS.getDataPnDAO());
						} else {
							this.vpn.errorMessage("Thêm chi tiết phiếu nhập thất bại. Vui lòng thử lại");
							return;
						}
					} else {
						this.vpn.errorMessage("Thêm phiếu nhập thất bại. Vui lòng thử lại");
						return;
					}
				}
			} else {
				if (this.vpn.confirmMessage("Mã đã tồn tại. Xác nhận thêm chi tiết") == JOptionPane.YES_OPTION) {
					ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(maPN, maSP, quantity, donGia, thanhTien);
					if (this.pnBUS.insertDataCtpnDAO(ctpn) && this.pnBUS.updatePrice(maPN)) {
						this.vpn.successMessage("Thêm thành công");
						this.vpn.clearTxt();
					} else {
						this.vpn.errorMessage("Thêm chi tiết phiếu nhập thất bại. Vui lòng thử lại");
						return;
					}

				}
			}
		}
		if (e.getSource() == this.vpn.btn_Huy_TK) {
			this.vpn.getData(pnBUS.getDataPnDAO());
		}
		if (e.getSource() == this.vpn.btn_Sua) {
			String maPN = this.vpn.getFieldValue("txt_TTCT_MaPhieu");
			String maNV = this.vpn.getFieldValue("txt_TTCT_MaNV");
			String maNCC = this.vpn.getFieldValue("txt_TTCT_MaNCC");
			String maSP = this.vpn.getFieldValue("txt_TTCT_MaSP");
			String soLuong = this.vpn.getFieldValue("txt_TTCT_SoLuong");
			String dongia = this.vpn.getFieldValue("txt_TTCT_DonGia");
			if (maPN.equals("") || maNV.equals("") || maNCC.equals("") || maSP.equals("")
					|| soLuong.equals("")) {
				this.vpn.errorMessage("Vui lòng nhập đầy đủ thông tin");
				return;
			}
			if (!(Pattern.matches("\\d+", soLuong)) || !Pattern.matches("\\d+", dongia)) {
				this.vpn.errorMessage("Số lượng hoặc đơn giá sai định dạng. Vui lòng thử lại");
				return;
			}
			if (!this.vpn.checkAccount()) {
				this.vpn.errorMessage("Mật khẩu sai");
				return;
			}
			int quantity = Integer.valueOf(soLuong);
			long donGia = Long.valueOf(dongia);
			long thanhTien = quantity * donGia;
			if (!pnBUS.checkInfo(maPN)) {
				this.vpn.errorMessage("Mã phiếu nhập cần cập nhật không tồn tại");
				return;
			}
			if (this.vpn.confirmMessage("Xác nhận chỉnh sửa.") == JOptionPane.YES_OPTION) {
				ChiTietPhieuNhapDTO ct = new ChiTietPhieuNhapDTO(maPN, maSP, quantity, donGia, thanhTien);
				if (pnBUS.updateChiTiet(ct)) {
					this.vpn.successMessage("Sửa thành công");
					this.vpn.clearTxt();
					this.vpn.getData(pnBUS.getDataPnDAO());
				} else {
					this.vpn.errorMessage("Chỉnh sửa chi tiết phiếu nhập thất bại. Vui lòng thử lại");
					return;
				}

			}
		}
		if (e.getSource() == this.vpn.btn_Xoa) {
			String maPN = this.vpn.getFieldValue("txt_TTCT_MaPhieu");
			if (maPN.equals("")) {
				this.vpn.errorMessage("Vui lòng chọn phiếu nhập cần xóa");
				return;
			}
			if (this.vpn.confirmMessage("Xác nhận xóa.") == JOptionPane.YES_OPTION) {
				if (pnBUS.deleteData(maPN)) {
					this.vpn.successMessage("Xóa thành công");
					this.vpn.clearTxt();
					this.vpn.getData(pnBUS.getDataPnDAO());
				} else {
					this.vpn.errorMessage("Xóa phiếu nhập thất bại. Vui lòng thử lại");
					return;
				}
			}
		}
		if (e.getSource() == this.vpn.btn_TimKiem) {
			String maPhieu = this.vpn.getFieldValue("txt_TK_MaPhieu");
			String ngayBatDauString = this.vpn.getFieldValue("txt_TK_NgayBD");
			String ngayKetThucString = this.vpn.getFieldValue("txt_TK_NgayKT");
			String maNCC = this.vpn.getFieldValue("txt_TK_MaNCC");
			String maNV = this.vpn.getFieldValue("txt_TK_MaNV");
			if (maPhieu.equals("") && ngayBatDauString.equals("")
					&& ngayKetThucString.equals("") && maNCC.equals("") && maNV.equals("")) {
				this.vpn.errorMessage("Vui lòng nhập ít nhất một thông tin");
				return;
			}
			if ((!ngayBatDauString.equals("") && ngayKetThucString.equals(""))
					|| (ngayBatDauString.equals("") && !ngayKetThucString.equals(""))) {
				this.vpn.errorMessage("Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc");
				return;
			} else if ((!this.vpn.isValidDateFormat(ngayBatDauString)
					|| !this.vpn.isValidDateFormat(ngayKetThucString)) && (!ngayBatDauString.equals("") &&!ngayKetThucString.equals(""))) {
				this.vpn.errorMessage("Ngày sai định dạng. Vui lòng thử lại (yyyy-MM-dd)");
				return;
			}

			this.vpn.getData(pnBUS.searchData(maPhieu, maNV, maNCC, ngayBatDauString, ngayKetThucString));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.vpn.table_DanhSach) {
			if (!list.isEmpty()) {
				list.removeAll(list);
			}
			list = pnBUS.getDataCtpnDAO();
			this.vpn.getDataSelectRowTable(list);
		}
		if (e.getSource() == this.vpn.table_ChiTiet) {
			this.vpn.setTxtFormTable();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

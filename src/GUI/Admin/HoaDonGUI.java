//Tim kiem trong khoang ngay
package GUI.Admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import BUS.HoaDonBUS;
import DATA.DAO.NuocGiaiKhatDAO;
import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.ChiTietHoaDonDTO;
import DATA.DTO.HoaDonDTO;
import DATA.DTO.TaiKhoanDTO;
import GUI.Login;
import controller.HoaDonController;

import javax.swing.JTextField;

public class HoaDonGUI extends JFrame {
	private List<HoaDonDTO> hd = new ArrayList<>();
	private List<ChiTietHoaDonDTO> cthd = new ArrayList<>();
	private NuocGiaiKhatDAO dssp = new NuocGiaiKhatDAO();
	private TaiKhoanDAO khDAO = new TaiKhoanDAO();
	private List<TaiKhoanDTO> kh = new ArrayList<>(khDAO.getData());
	private FormHoaDon fhd;
	private HoaDonBUS hdBUS = new HoaDonBUS();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSoHoaDon;
	private JTextField txtNgayLap;
	private JTextField txtMaKhachHang;
	private JTextField txtTongTien;
	private JTextField txtMaSP;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtThanhTien;
	private JTextField txtTKNgayBatDau;
	private JTextField txtTKNgayKetThuc;
	private JTextField txtTongTienTu;
	private JTextField txtTongTienDen;
	private JTextField txtTKMaKhachHang;
	public JTable table_hoadon;
	public JTable table_cthd;

	public JButton btnDong;
	public JButton btnTimKiem;
	public JButton btnHuyTimKiem;
	public JButton btnXoa;
	public JButton btnDatLai;
	public JButton btnQuayLai;
	public JButton btnXemHoaDon;

	/**
	 * Create the frame.
	 */
	public HoaDonGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		setTitle("Quản lý hóa đơn");
		ImageIcon imgIcon = new ImageIcon("./src/img/icon_HoaDon.png");
		setIconImage(imgIcon.getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(164, 195, 178));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel xuLy = new JPanel();
		xuLy.setBounds(530, 0, 456, 763);
		contentPane.add(xuLy);
		xuLy.setLayout(null);

		JLabel lbl_qlhd_1 = new JLabel("Thông tin chi tiết");
		lbl_qlhd_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbl_qlhd_1.setBounds(4, 228, 196, 61);
		xuLy.add(lbl_qlhd_1);

		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDong.setBounds(325, 613, 107, 33);
		xuLy.add(btnDong);

		JLabel lbl_sohoadon = new JLabel("Số hóa đơn:");
		lbl_sohoadon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_sohoadon.setBounds(4, 299, 85, 28);
		xuLy.add(lbl_sohoadon);

		txtSoHoaDon = new JTextField();
		txtSoHoaDon.setBounds(99, 299, 111, 26);
		xuLy.add(txtSoHoaDon);
		txtSoHoaDon.setColumns(10);

		JLabel lbl_ngaylap = new JLabel("Ngày Lập:");
		lbl_ngaylap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ngaylap.setBounds(4, 356, 85, 28);
		xuLy.add(lbl_ngaylap);

		txtNgayLap = new JTextField();
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(99, 356, 151, 26);
		xuLy.add(txtNgayLap);

		JLabel lblMKhchHng = new JLabel("Mã Khách hàng:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKhchHng.setBounds(226, 299, 115, 28);
		xuLy.add(lblMKhchHng);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(351, 299, 85, 26);
		xuLy.add(txtMaKhachHang);

		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngTin.setBounds(229, 413, 85, 28);
		xuLy.add(lblTngTin);

		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(329, 413, 111, 26);
		xuLy.add(txtTongTien);

		JLabel lblMSnPhm = new JLabel("Mã sản phẩm:");
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSnPhm.setBounds(0, 413, 115, 28);
		xuLy.add(lblMSnPhm);

		txtMaSP = new JTextField();
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(125, 413, 85, 26);
		xuLy.add(txtMaSP);

		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(0, 474, 70, 28);
		xuLy.add(lblSLng);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(99, 474, 111, 26);
		xuLy.add(txtSoLuong);

		JLabel lblnGi = new JLabel("Đơn giá:");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnGi.setBounds(226, 474, 89, 28);
		xuLy.add(lblnGi);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(325, 474, 111, 26);
		xuLy.add(txtDonGia);

		JLabel lblThnhTin = new JLabel("Thành tiền:");
		lblThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThnhTin.setBounds(0, 526, 89, 28);
		xuLy.add(lblThnhTin);

		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(99, 526, 111, 26);
		xuLy.add(txtThanhTien);

		JLabel lblNewLabel = new JLabel("Tìm kiếm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(0, 79, 63, 34);
		xuLy.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Ngày bắt đầu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(4, 123, 85, 34);
		xuLy.add(lblNewLabel_1_1);

		txtTKNgayBatDau = new JTextField();
		txtTKNgayBatDau.setColumns(10);
		txtTKNgayBatDau.setBounds(99, 129, 111, 26);
		xuLy.add(txtTKNgayBatDau);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày kết thúc:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(239, 123, 85, 34);
		xuLy.add(lblNewLabel_1_1_1);

		txtTKNgayKetThuc = new JTextField();
		txtTKNgayKetThuc.setColumns(10);
		txtTKNgayKetThuc.setBounds(334, 129, 111, 26);
		xuLy.add(txtTKNgayKetThuc);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTimKiem.setBounds(206, 29, 94, 28);
		xuLy.add(btnTimKiem);

		btnHuyTimKiem = new JButton("Hủy");
		btnHuyTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHuyTimKiem.setBounds(315, 29, 99, 28);
		xuLy.add(btnHuyTimKiem);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(59, 612, 111, 34);
		xuLy.add(btnXoa);

		btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatLai.setBounds(189, 612, 111, 34);
		xuLy.add(btnDatLai);

		JLabel lbl_qlhd_1_1 = new JLabel("Tìm kiếm sản phẩm");
		lbl_qlhd_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_qlhd_1_1.setBounds(0, 10, 182, 61);
		xuLy.add(lbl_qlhd_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tổng tiền. Từ:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(4, 177, 95, 34);
		xuLy.add(lblNewLabel_1_2);

		txtTongTienTu = new JTextField();
		txtTongTienTu.setColumns(10);
		txtTongTienTu.setBounds(99, 183, 95, 26);
		xuLy.add(txtTongTienTu);

		JLabel lblNewLabel_1_3 = new JLabel("Đến:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(206, 179, 41, 34);
		xuLy.add(lblNewLabel_1_3);

		txtTongTienDen = new JTextField();
		txtTongTienDen.setColumns(10);
		txtTongTienDen.setBounds(246, 183, 95, 26);
		xuLy.add(txtTongTienDen);

		JLabel lblNewLabel_1_4 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(73, 79, 97, 34);
		xuLy.add(lblNewLabel_1_4);

		txtTKMaKhachHang = new JTextField();
		txtTKMaKhachHang.setColumns(10);
		txtTKMaKhachHang.setBounds(180, 85, 85, 26);
		xuLy.add(txtTKMaKhachHang);

		JPanel danhSach = new JPanel();
		danhSach.setBounds(0, 0, 522, 763);
		contentPane.add(danhSach);
		danhSach.setLayout(null);

		JLabel lbl_qlhd = new JLabel("Quản lý Hóa Đơn");
		lbl_qlhd.setBounds(10, 10, 187, 61);
		danhSach.add(lbl_qlhd);
		lbl_qlhd.setFont(new Font("Tahoma", Font.BOLD, 21));

		table_hoadon = new JTable();
		table_hoadon.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Số hóa đơn", "Ngày lập", "Tổng tiền", "Mã Khách hàng","Trạng thái"
				}));

		JScrollPane scroolPane_hoadon = new JScrollPane(table_hoadon);
		scroolPane_hoadon.setBounds(10, 81, 512, 253);
		danhSach.add(scroolPane_hoadon);

		table_cthd = new JTable();
		table_cthd.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã Chi Tiết", "Mã Khách Hàng", "Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
				}));
		JScrollPane scroolPane_ctHoaDon = new JScrollPane(table_cthd);
		scroolPane_ctHoaDon.setBounds(10, 434, 512, 319);
		danhSach.add(scroolPane_ctHoaDon);

		JLabel lbl_cthd = new JLabel("Chi tiết Hóa Đơn");
		lbl_cthd.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbl_cthd.setBounds(10, 344, 181, 80);
		danhSach.add(lbl_cthd);

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBounds(401, 26, 111, 33);
		danhSach.add(btnQuayLai);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 15));

		btnXemHoaDon = new JButton("Xem hóa đơn");
		btnXemHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXemHoaDon.setBounds(327, 366, 138, 34);
		danhSach.add(btnXemHoaDon);

		xuLy.setOpaque(true);
		xuLy.setBackground(new Color(107, 144, 128));
		danhSach.setOpaque(true);
		danhSach.setBackground(new Color(255, 255, 255, 0));

		txtSoHoaDon.setEditable(false);
		txtNgayLap.setEditable(false);
		txtTongTien.setEditable(false);
		txtDonGia.setEditable(false);
		txtMaKhachHang.setEditable(false);
		txtMaSP.setEditable(false);
		txtSoLuong.setEditable(false);
		txtThanhTien.setEditable(false);

		ActionListener atl = new HoaDonController(this);
		btnDatLai.addActionListener(atl);
		btnDong.addActionListener(atl);
		btnHuyTimKiem.addActionListener(atl);
		btnQuayLai.addActionListener(atl);
		btnTimKiem.addActionListener(atl);
		btnXoa.addActionListener(atl);
		btnXemHoaDon.addActionListener(atl);

		MouseListener mol = new HoaDonController(this);
		table_hoadon.addMouseListener(mol);
		table_cthd.addMouseListener(mol);

		getData(hdBUS.getDataHdDAO());

		setVisible(true);
	}

	// Lay du lieu hoa don
	public void getData(List<HoaDonDTO> data) {
		DefaultTableModel model = (DefaultTableModel) table_hoadon.getModel();
		model.setRowCount(0);
		for (HoaDonDTO hoaDon : data) {
			if (hoaDon.getTrangThai().equals("Hoàn thành") || hoaDon.getTrangThai().equals("Từ chối")
					|| hoaDon.getTrangThai().equals("Đã hủy")) {
				model.addRow(new Object[] {
						hoaDon.getSoHD(),
						hoaDon.getNgaylap(),
						hoaDon.getTongtien(),
						hoaDon.getMaKH(),
						hoaDon.getTrangThai()
				});
			}

		}
	}

	// Xoa toan bo txt
	public void resetTxt() {
		txtSoHoaDon.setText("");
		txtNgayLap.setText("");
		txtTongTien.setText("");
		txtDonGia.setText("");
		txtMaKhachHang.setText("");
		txtMaSP.setText("");
		txtSoLuong.setText("");
		txtThanhTien.setText("");
	}

	// Lay du kieu chi tiet hoa don
	public void getDataSelectRowTable(List<ChiTietHoaDonDTO> data) {
		DefaultTableModel model = (DefaultTableModel) table_hoadon.getModel();
		DefaultTableModel model_chiTietHoaDon = (DefaultTableModel) table_cthd.getModel();
		model_chiTietHoaDon.setRowCount(0); // Xóa tất cả các dòng trong bảng chi tiết hóa đơn
		int i_row = table_hoadon.getSelectedRow();
		if (i_row != -1) {
			String soHD = table_hoadon.getValueAt(i_row, 0).toString();
			txtSoHoaDon.setText(soHD);
			for (ChiTietHoaDonDTO chiTietHoaDon : data) {
				if (chiTietHoaDon.getSoHD().equals(soHD)) {
					int soLuong = Integer.parseInt(chiTietHoaDon.getSoluong() + "");
					long donGia = dssp.getPriceProduct(chiTietHoaDon.getMaNGK());
					long thanhTien = soLuong * donGia;
					model_chiTietHoaDon.addRow(new Object[] {
							chiTietHoaDon.getMaCTHD(),
							chiTietHoaDon.getMaKH(),
							chiTietHoaDon.getMaNGK(),
							soLuong + "",
							donGia + "",
							thanhTien
					});
				}
			}
			String trangThai = model.getValueAt(i_row, 3) + "";
			btnXemHoaDon.setEnabled(false);
			if (trangThai.equals("Hoàn thành")) {
				btnXemHoaDon.setEnabled(true);
			}
		}
	}

	// gan du lieu tu bang vao txt
	public void getTxtFromTable() {
		DefaultTableModel model_hoadon = (DefaultTableModel) table_hoadon.getModel();
		DefaultTableModel model_chiTietHoaDon = (DefaultTableModel) table_cthd.getModel();
		int iRowHD = table_hoadon.getSelectedRow();
		int iRowCTHD = table_cthd.getSelectedRow();
		if (iRowHD < 0) {
			return;
		}
		txtSoHoaDon.setText(model_hoadon.getValueAt(iRowHD, 0) + "");
		txtNgayLap.setText(model_hoadon.getValueAt(iRowHD, 1) + "");
		txtTongTien.setText(model_hoadon.getValueAt(iRowHD, 2) + "");
		if (iRowCTHD < 0) {
			return;
		}
		txtDonGia.setText(model_chiTietHoaDon.getValueAt(iRowCTHD, 4) + "");
		txtMaKhachHang.setText(model_chiTietHoaDon.getValueAt(iRowCTHD, 1) + "");
		txtMaSP.setText(model_chiTietHoaDon.getValueAt(iRowCTHD, 2) + "");
		txtSoLuong.setText(model_chiTietHoaDon.getValueAt(iRowCTHD, 3) + "");
		txtThanhTien.setText(model_chiTietHoaDon.getValueAt(iRowCTHD, 5) + "");
	}

	// Xem hoa don
	public void checkHoaDon() {
		DefaultTableModel model_hoadon = (DefaultTableModel) table_hoadon.getModel();
		int iRowHD = table_hoadon.getSelectedRow();
		String soHD = model_hoadon.getValueAt(iRowHD, 0) + "";
		for (HoaDonDTO hoaDon : hd) {
			if (hoaDon.getSoHD().equals(soHD)) {
				for (ChiTietHoaDonDTO chiTietHoaDon : cthd) {
					if (chiTietHoaDon.getSoHD().equals(hoaDon.getSoHD())) {
						for (TaiKhoanDTO khachHang : kh) {
							if (chiTietHoaDon.getMaKH().equals(khachHang.getMa())) {
								fhd = new FormHoaDon();
								TaiKhoanDTO nb1 = new TaiKhoanDTO();
								nb1 = (TaiKhoanDTO) Login.getObject();
								fhd.printTheInvoice(hoaDon, khachHang, nb1);
								return;
							}
						}
					}
				}
			}
		}
	}

	//GET SET
	public String getFieldValue(String fieldName) {
		switch (fieldName) {
			case "txtSoHoaDon":
				return txtSoHoaDon.getText();
			case "txtTKNgayBatDau":
				return txtTKNgayBatDau.getText();
			case "txtTKNgayKetThuc":
				return txtTKNgayKetThuc.getText();
			case "txtTongTienTu":
				return txtTongTienTu.getText();
			case "txtTongTienDen":
				return txtTongTienDen.getText();
			case "txtTKMaKhachHang":
				return txtTKMaKhachHang.getText();
			default:
				return "";
		}
	}
	public void setFieldValue(String fieldName, String value) {
		switch (fieldName) {
			case "txtSoHoaDon":
				txtSoHoaDon.setText(value);
				break;
			case "txtTKNgayBatDau":
				txtTKNgayBatDau.setText(value);
				break;
			case "txtTKNgayKetThuc":
				txtTKNgayKetThuc.setText(value);
				break;
			case "txtTongTienTu":
				txtTongTienTu.setText(value);
				break;
			case "txtTongTienDen":
				txtTongTienDen.setText(value);
				break;
		}
	}
	//<-- END GET SET -->

	//<-- Message -->
	public void successMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}
	public void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.ERROR_MESSAGE);
    }
	public void warningMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
	public int confirmMessage(String message){
		return JOptionPane.showConfirmDialog(null, message, "Thông báo", JOptionPane.YES_NO_OPTION);
	}
	//<-- END MESSAGE -->

	// kiem trad dinh dang ngay
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

	// Quay lai
	public void closeFrame() {
		this.dispose();
		new QLCHGUI();
	}

	// Dong
	public void closeView() {
		System.exit(0);
	}

	
}

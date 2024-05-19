package GUI.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.HoaDonBUS;
import DATA.DAO.NuocGiaiKhatDAO;
import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.ChiTietHoaDonDTO;
import DATA.DTO.HoaDonDTO;
import DATA.DTO.NuocGiaiKhatDTO;
import DATA.DTO.TaiKhoanDTO;
import GUI.Login;
import controller.ControllerViewGioHang;

public class GioHangGUI extends JFrame {
	private TaiKhoanDAO khDAO = new TaiKhoanDAO();
	private List<TaiKhoanDTO> kh = new ArrayList<>(khDAO.getData());
	private NuocGiaiKhatDAO spDAO = new NuocGiaiKhatDAO();
	private List<NuocGiaiKhatDTO> sp = new ArrayList<>(spDAO.getData());
	private List<HoaDonDTO> hd = new ArrayList<>();
	private FormHoaDon fhd;
	private HoaDonBUS hdBUS = new HoaDonBUS();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtMaGioHang;
	private JTextField txtMaKhachHang;
	private JTextField txtTongTien;
	private JTextField txtMaSP;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtThanhTien;
	private JTextField txtTongTienTu;
	private JTextField txtTongTienDen;
	private JTextField txtTKMaKhachHang;
	private JTextField txtTenSanPham;
	private JTextField txtTenKhachHang;
	private JTextField txtSdt;
	private JTextField txtDiaChi;
	private JTextField txtTinhTrang;

	public JTable tableDonHang;
	public JTable tableChiTietDonHang;

	public JButton btnGiaoHang;
	public JButton btnTimKiem;
	public JButton btnHuyTimKiem;
	public JButton btnDuyetDon;
	public JButton btnTuChoi;
	public JButton btnQuayLai;
	public JButton btnInHoaDon;

	/**
	 * Create the frame.
	 */
	public GioHangGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 1000, 800);
		setTitle("Quan Lý đơn hàng");
		ImageIcon imgIcon = new ImageIcon("./src/img/Cart-Icon.png");
		setIconImage(imgIcon.getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(164, 195, 178));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel xuLy = new JPanel();
		xuLy.setBounds(532, 0, 456, 763);
		contentPane.add(xuLy);
		xuLy.setLayout(null);

		JLabel lbl_qlhd_1 = new JLabel("Thông tin chi tiết");
		lbl_qlhd_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbl_qlhd_1.setBounds(4, 169, 196, 61);
		xuLy.add(lbl_qlhd_1);

		btnGiaoHang = new JButton("Giao hàng");
		btnGiaoHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGiaoHang.setBounds(99, 700, 111, 33);
		xuLy.add(btnGiaoHang);

		JLabel lbl_sohoadon = new JLabel("Mã đơn hàng:");
		lbl_sohoadon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_sohoadon.setBounds(4, 239, 85, 28);
		xuLy.add(lbl_sohoadon);

		txtMaGioHang = new JTextField();
		txtMaGioHang.setBounds(99, 239, 111, 26);
		xuLy.add(txtMaGioHang);
		txtMaGioHang.setColumns(10);

		JLabel lblMKhchHng = new JLabel("Mã Khách hàng:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKhchHng.setBounds(226, 239, 115, 28);
		xuLy.add(lblMKhchHng);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(351, 239, 85, 26);
		xuLy.add(txtMaKhachHang);

		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngTin.setBounds(229, 578, 85, 28);
		xuLy.add(lblTngTin);

		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(329, 578, 111, 26);
		xuLy.add(txtTongTien);

		JLabel lblMSnPhm = new JLabel("Mã sản phẩm:");
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSnPhm.setBounds(4, 480, 99, 28);
		xuLy.add(lblMSnPhm);

		txtMaSP = new JTextField();
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(112, 480, 85, 26);
		xuLy.add(txtMaSP);

		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(4, 527, 70, 28);
		xuLy.add(lblSLng);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(103, 527, 111, 26);
		xuLy.add(txtSoLuong);

		JLabel lblnGi = new JLabel("Đơn giá:");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnGi.setBounds(230, 527, 89, 28);
		xuLy.add(lblnGi);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(329, 527, 111, 26);
		xuLy.add(txtDonGia);

		JLabel lblThnhTin = new JLabel("Thành tiền:");
		lblThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThnhTin.setBounds(3, 578, 89, 28);
		xuLy.add(lblThnhTin);

		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(102, 578, 111, 26);
		xuLy.add(txtThanhTien);

		JLabel lblNewLabel = new JLabel("Tìm kiếm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(0, 79, 63, 34);
		xuLy.add(lblNewLabel);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTimKiem.setBounds(206, 29, 94, 28);
		xuLy.add(btnTimKiem);

		btnHuyTimKiem = new JButton("Hủy");
		btnHuyTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHuyTimKiem.setBounds(315, 29, 99, 28);
		xuLy.add(btnHuyTimKiem);

		btnDuyetDon = new JButton("Duyệt");
		btnDuyetDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDuyetDon.setBounds(99, 648, 111, 34);
		xuLy.add(btnDuyetDon);

		btnTuChoi = new JButton("Từ chối");
		btnTuChoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTuChoi.setBounds(247, 648, 115, 34);
		xuLy.add(btnTuChoi);

		JLabel lbl_qlhd_1_1 = new JLabel("Tìm kiếm Đơn hàng");
		lbl_qlhd_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_qlhd_1_1.setBounds(0, 10, 182, 61);
		xuLy.add(lbl_qlhd_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tổng tiền. Từ:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(4, 123, 95, 34);
		xuLy.add(lblNewLabel_1_2);

		txtTongTienTu = new JTextField();
		txtTongTienTu.setColumns(10);
		txtTongTienTu.setBounds(105, 129, 95, 26);
		xuLy.add(txtTongTienTu);

		JLabel lblNewLabel_1_3 = new JLabel("Đến:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(234, 123, 41, 34);
		xuLy.add(lblNewLabel_1_3);

		txtTongTienDen = new JTextField();
		txtTongTienDen.setColumns(10);
		txtTongTienDen.setBounds(285, 129, 95, 26);
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

		JLabel lbl_qlhd = new JLabel("Đơn hàng");
		lbl_qlhd.setBounds(10, 10, 187, 61);
		danhSach.add(lbl_qlhd);
		lbl_qlhd.setFont(new Font("Tahoma", Font.BOLD, 21));

		tableDonHang = new JTable();
		tableDonHang.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã đơn hàng", "Ngày lập", "Mã Khách hàng", "Tổng tiền", "Trạng thái"
				}));

		JScrollPane scroolPane_hoadon = new JScrollPane(tableDonHang);
		scroolPane_hoadon.setBounds(10, 81, 512, 253);
		danhSach.add(scroolPane_hoadon);

		tableChiTietDonHang = new JTable();
		tableChiTietDonHang.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã đơn hàng", "Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
				}));
		JScrollPane scroolPane_ctHoaDon = new JScrollPane(tableChiTietDonHang);
		scroolPane_ctHoaDon.setBounds(10, 434, 512, 319);
		danhSach.add(scroolPane_ctHoaDon);

		JLabel lbl_cthd = new JLabel("Chi tiết đơn hàng");
		lbl_cthd.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbl_cthd.setBounds(10, 344, 181, 80);
		danhSach.add(lbl_cthd);

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBounds(401, 26, 111, 33);
		danhSach.add(btnQuayLai);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtMaGioHang.setEditable(false);
		txtTongTien.setEditable(false);
		txtDonGia.setEditable(false);
		txtMaKhachHang.setEditable(false);
		txtMaSP.setEditable(false);
		txtSoLuong.setEditable(false);
		txtThanhTien.setEditable(false);

		JLabel lblTn = new JLabel("Tên:");
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTn.setBounds(230, 480, 35, 28);
		xuLy.add(lblTn);

		txtTenSanPham = new JTextField();
		txtTenSanPham.setEditable(false);
		txtTenSanPham.setColumns(10);
		txtTenSanPham.setBounds(275, 480, 165, 26);
		xuLy.add(txtTenSanPham);

		btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInHoaDon.setBounds(247, 700, 115, 33);
		xuLy.add(btnInHoaDon);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(4, 286, 106, 28);
		xuLy.add(lblTnKhchHng);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(117, 290, 165, 26);
		xuLy.add(txtTenKhachHang);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(4, 334, 94, 28);
		xuLy.add(lblSinThoi);

		txtSdt = new JTextField();
		txtSdt.setEditable(false);
		txtSdt.setColumns(10);
		txtSdt.setBounds(99, 338, 111, 26);
		xuLy.add(txtSdt);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(4, 381, 48, 28);
		xuLy.add(lblaCh);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(62, 383, 253, 26);
		xuLy.add(txtDiaChi);

		JLabel lbl_qlhd_1_2 = new JLabel("Sản phẩm");
		lbl_qlhd_1_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbl_qlhd_1_2.setBounds(4, 419, 111, 51);
		xuLy.add(lbl_qlhd_1_2);

		JLabel lblTnhTrngn = new JLabel("Tình trạng đơn hàng:");
		lblTnhTrngn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnhTrngn.setBounds(144, 430, 135, 28);
		xuLy.add(lblTnhTrngn);

		txtTinhTrang = new JTextField();
		txtTinhTrang.setEditable(false);
		txtTinhTrang.setColumns(10);
		txtTinhTrang.setBounds(285, 430, 129, 28);
		xuLy.add(txtTinhTrang);

		scroolPane_hoadon.setOpaque(true);
		scroolPane_hoadon.setBackground(new Color(255, 255, 255, 0));
		scroolPane_ctHoaDon.setOpaque(true);
		scroolPane_ctHoaDon.setBackground(new Color(255, 255, 255, 0));
		danhSach.setOpaque(true);
		danhSach.setBackground(new Color(255, 255, 255, 0));
		xuLy.setOpaque(true);
		xuLy.setBackground(new Color(107, 144, 128));

		btnTuChoi.setOpaque(true);
		btnTuChoi.setBackground(new Color(255, 255, 255, 0));
		btnGiaoHang.setOpaque(true);
		btnGiaoHang.setBackground(new Color(255, 255, 255, 0));
		btnHuyTimKiem.setOpaque(true);
		btnHuyTimKiem.setBackground(new Color(255, 255, 255, 0));
		btnQuayLai.setOpaque(true);
		btnQuayLai.setBackground(new Color(255, 255, 255, 0));
		btnTimKiem.setOpaque(true);
		btnTimKiem.setBackground(new Color(255, 255, 255, 0));
		btnDuyetDon.setOpaque(true);
		btnDuyetDon.setBackground(new Color(255, 255, 255, 0));
		btnInHoaDon.setOpaque(true);
		btnInHoaDon.setBackground(new Color(255, 255, 255, 0));

		btnTuChoi.setEnabled(false);
		btnGiaoHang.setEnabled(false);
		btnDuyetDon.setEnabled(false);
		btnInHoaDon.setEnabled(false);

		ActionListener atl = new ControllerViewGioHang(this);
		btnTuChoi.addActionListener(atl);
		btnGiaoHang.addActionListener(atl);
		btnHuyTimKiem.addActionListener(atl);
		btnQuayLai.addActionListener(atl);
		btnTimKiem.addActionListener(atl);
		btnDuyetDon.addActionListener(atl);
		btnInHoaDon.addActionListener(atl);

		MouseListener mol = new ControllerViewGioHang(this);
		tableDonHang.addMouseListener(mol);
		tableChiTietDonHang.addMouseListener(mol);

		getData(hdBUS.getDataHdDAO());

		setVisible(true);
	}

	// Lay du lieu tu bang
	public void getData(List<HoaDonDTO> data) {
		DefaultTableModel modelDonHang = (DefaultTableModel) tableDonHang.getModel();
		DefaultTableModel modelChiTietDonHang = (DefaultTableModel) tableChiTietDonHang.getModel();
		modelChiTietDonHang.setRowCount(0);
		modelDonHang.setRowCount(0);
		for (HoaDonDTO hoaDon : data) {
			if (!(hoaDon.getTrangThai().equals("Hoàn thành")) && !(hoaDon.getTrangThai().equals("Từ chối"))) {
				modelDonHang.addRow(new Object[] {
						hoaDon.getSoHD(),
						hoaDon.getNgaylap(),
						hoaDon.getMaKH(),
						hoaDon.getTongtien() + "",
						hoaDon.getTrangThai()
				});
			}

		}
	}

	// Hien thi len bang chi tiet
	public void displayDataOnTable(List<ChiTietHoaDonDTO> data) {
		DefaultTableModel modelDonHang = (DefaultTableModel) tableDonHang.getModel();
		DefaultTableModel modelChiTietDonHang = (DefaultTableModel) tableChiTietDonHang.getModel();
		modelChiTietDonHang.setRowCount(0);
		int iRow = tableDonHang.getSelectedRow();
		if (iRow != -1) {
			String soHD = modelDonHang.getValueAt(iRow, 0) + "";
			String tinhTrang = modelDonHang.getValueAt(iRow, 4) + "";
			txtTinhTrang.setText(tinhTrang);
			String maKH = modelDonHang.getValueAt(iRow, 2) + "";
			txtMaGioHang.setText(modelDonHang.getValueAt(iRow, 0) + "");
			txtMaKhachHang.setText(maKH);
			txtTongTien.setText(modelDonHang.getValueAt(iRow, 3) + "");
			for (TaiKhoanDTO khachHang : kh) {
				if (khachHang.getMa().equals(maKH)) {
					txtTenKhachHang.setText(khachHang.getTenTK());
					txtSdt.setText(khachHang.getSdt());
					txtDiaChi.setText(khachHang.getDiachi());
					break;
				}
			}
			for (ChiTietHoaDonDTO chiTietHoaDon : data) {
				if (chiTietHoaDon.getSoHD().equals(soHD)) {
					int soLuong = chiTietHoaDon.getSoluong();
					long donGia = spDAO.getPriceProduct(chiTietHoaDon.getMaNGK());
					long thanhTien = soLuong * donGia;
					modelChiTietDonHang.addRow(new Object[] {
							chiTietHoaDon.getMaCTHD(),
							chiTietHoaDon.getMaNGK(),
							soLuong,
							donGia,
							thanhTien
					});
				}
			}
			btnTuChoi.setEnabled(false);
			btnGiaoHang.setEnabled(false);
			btnDuyetDon.setEnabled(false);
			btnInHoaDon.setEnabled(false);
			// Kiem tra tuy tinh huong
			if (tinhTrang.equals("Chờ duyệt")) {
				btnTuChoi.setEnabled(true);
				btnGiaoHang.setEnabled(false);
				btnDuyetDon.setEnabled(true);
				btnInHoaDon.setEnabled(false);
			}
			if (tinhTrang.equals("Đã duyệt")) {
				btnTuChoi.setEnabled(false);
				btnGiaoHang.setEnabled(true);
				btnDuyetDon.setEnabled(false);
				btnInHoaDon.setEnabled(false);
			}
			if (tinhTrang.equals("Đang giao")) {
				btnTuChoi.setEnabled(false);
				btnGiaoHang.setEnabled(false);
				btnDuyetDon.setEnabled(false);
				btnInHoaDon.setEnabled(true);
			}
			if (tinhTrang.equals("Đã thanh toán")) {
				btnTuChoi.setEnabled(false);
				btnGiaoHang.setEnabled(true);
				btnDuyetDon.setEnabled(false);
				btnInHoaDon.setEnabled(true);
			}
		}
	}

	// Dat trang thai click chuot cho bang
	public void setTxtFormTable() {
		DefaultTableModel modelChiTietDonHang = (DefaultTableModel) tableChiTietDonHang.getModel();
		int iRowDonHang = tableDonHang.getSelectedRow();
		int iRowChiTiet = tableChiTietDonHang.getSelectedRow();
		if (iRowDonHang != -1) {
			if (iRowChiTiet != -1) {
				String maSP = modelChiTietDonHang.getValueAt(iRowChiTiet, 1) + "";
				txtMaSP.setText(maSP);
				for (NuocGiaiKhatDTO nuocGiaiKhat : sp) {
					if (nuocGiaiKhat.getMaNGK().equals(maSP)) {
						txtTenSanPham.setText(nuocGiaiKhat.getTenNGK());
						break;
					}
				}
				txtSoLuong.setText(modelChiTietDonHang.getValueAt(iRowChiTiet, 2) + "");
				txtDonGia.setText(modelChiTietDonHang.getValueAt(iRowChiTiet, 3) + "");
				txtThanhTien.setText(modelChiTietDonHang.getValueAt(iRowChiTiet, 4) + "");
			}
		}
	}

	//GET SET 
	public String getFieldValue(String fieldName) {
        switch (fieldName) {
            case "txtMaGioHang":
                return txtMaGioHang.getText();
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
            case "txtMaGioHang":
                txtMaGioHang.setText(value);
                break;
            case "txtTongTienTu":
                txtTongTienTu.setText(value);
                break;
            case "txtTongTienDen":
                txtTongTienDen.setText(value);
                break;
            case "txtTKMaKhachHang":
                txtTKMaKhachHang.setText(value);
                break;
            default:
                break;
        }
    }
	//END GET SET

	//MESSAGE
	public void successMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
	}
	public void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Thông báo",
                JOptionPane.ERROR_MESSAGE);
    }
	public void warningMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Thông báo",
                JOptionPane.WARNING_MESSAGE);
    }
	public int confirmMessage(String message){
		return JOptionPane.showConfirmDialog(null, message, "Thông báo",
                JOptionPane.YES_NO_OPTION);
	}
	//END MESSAGE

	// In hoa don
	public void printTheInvoice() {
		DefaultTableModel modelGioHang = (DefaultTableModel) tableDonHang.getModel();
		int iRowGH = tableDonHang.getSelectedRow();
		HoaDonDTO hd1 = new HoaDonDTO();
		TaiKhoanDTO kh1 = new TaiKhoanDTO();
		if (iRowGH != -1) {
			String maHD = modelGioHang.getValueAt(iRowGH, 0) + "";
			String maKH = modelGioHang.getValueAt(iRowGH, 2) + "";
			for (HoaDonDTO hoaDon : hd) {
				if (hoaDon.getSoHD().equals(maHD)) {
					hd1 = hoaDon;
					break;
				}
			}
			for (TaiKhoanDTO khachHang : kh) {
				if (khachHang.getMa().equals(maKH)) {
					kh1 = khachHang;
				}
			}
			TaiKhoanDTO nb1 = new TaiKhoanDTO();
			nb1 = (TaiKhoanDTO) Login.getObject();
			fhd = new FormHoaDon();
			fhd.printTheInvoice(hd1, kh1, nb1);
		}
	}

	public void comeback() {
		this.dispose();
		new QLCHGUI();
	}

}

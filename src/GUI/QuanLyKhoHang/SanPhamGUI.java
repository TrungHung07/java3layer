//Hoan thanh
package GUI.QuanLyKhoHang;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.SanPhamBUS;
import DATA.DAO.NuocGiaiKhatDAO;
import DATA.DTO.NuocGiaiKhatDTO;
import controller.SanPhamController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class SanPhamGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtSLTon;
	private JTextField txtDonVi;
	private JTextField txtDonGia;
	private JTextField txtLoai;
	private JTextField txtHang;

	private JTextField txtTKMaSP;
	private JTextField txtTKMaNB;
	private JTextField txtTKGiaTu;
	private JTextField txtTKGiaDen;

	public JTable table;
	public JButton btnXoa;
	public JButton btnLuu;
	public JButton btnHuyBo;
	public JButton btnTroLai;
	public JButton btnSua;
	public JButton btnThem;
	public JButton btnTimKiem;
	public JButton btnHuyTimKiem;

	private NuocGiaiKhatDAO dssp = new NuocGiaiKhatDAO();
	private List<NuocGiaiKhatDTO> NGK = new ArrayList<>();
	private SanPhamBUS spBUS = new SanPhamBUS();

	private JTextField txtNguoiBan;
	private JTextField txtQuanLy;
	private JRadioButton rdbHoatDong;
	private JRadioButton rdbTamNgung;
	private ButtonGroup btnGroup;

	/**
	 * Create the frame.
	 */

	public SanPhamGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý sản phẩm");
		ImageIcon i_img = new ImageIcon("./src/img/icon_SanPham.png");
		setIconImage(i_img.getImage());
		setBounds(20, 20, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 204, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 966, 84);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Sản Phẩm Cửa Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 10, 245, 64);
		panel.add(lblNewLabel);

		JLabel lbl_tk_masp = new JLabel("Mã sản phẩm:");
		lbl_tk_masp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tk_masp.setBounds(265, 10, 102, 25);
		panel.add(lbl_tk_masp);

		JLabel lbl_tk_kichco = new JLabel("Mã Người bán:");
		lbl_tk_kichco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tk_kichco.setBounds(265, 49, 102, 25);
		panel.add(lbl_tk_kichco);

		panel.setOpaque(true);
		panel.setBackground(new Color(171, 196, 255));

		txtTKMaSP = new JTextField();
		txtTKMaSP.setBounds(377, 10, 102, 23);
		panel.add(txtTKMaSP);
		txtTKMaSP.setColumns(10);

		txtTKMaNB = new JTextField();
		txtTKMaNB.setColumns(10);
		txtTKMaNB.setBounds(377, 51, 102, 23);
		panel.add(txtTKMaNB);

		JLabel lblNewLabel_1_2 = new JLabel("Giá sản phẩm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(489, 10, 102, 25);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Từ:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(587, 10, 32, 25);
		panel.add(lblNewLabel_1_2_1);

		txtTKGiaTu = new JTextField();
		txtTKGiaTu.setColumns(10);
		txtTKGiaTu.setBounds(629, 12, 102, 23);
		panel.add(txtTKGiaTu);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Đến:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_1.setBounds(587, 49, 32, 25);
		panel.add(lblNewLabel_1_2_1_1);

		txtTKGiaDen = new JTextField();
		txtTKGiaDen.setColumns(10);
		txtTKGiaDen.setBounds(629, 51, 102, 23);
		panel.add(txtTKGiaDen);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimKiem.setBounds(741, 29, 102, 31);
		panel.add(btnTimKiem);

		btnHuyTimKiem = new JButton("Hủy");
		btnHuyTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHuyTimKiem.setBounds(854, 29, 102, 31);
		panel.add(btnHuyTimKiem);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã", "Tên", "Đơn vị", "Số lượng còn", "Giá bán", "Tên loại", "Người bán", "Hãng", "Quản lý"
				}));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setPreferredWidth(15);
		table.getColumnModel().getColumn(6).setPreferredWidth(30);
		table.getColumnModel().getColumn(7).setPreferredWidth(30);
		JScrollPane scroolScrollPane = new JScrollPane(table);
		scroolScrollPane.setBounds(10, 104, 966, 283);
		getContentPane().add(scroolScrollPane);

		JLabel lbl_masp = new JLabel("Mã sản phẩm:");
		lbl_masp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_masp.setBounds(10, 451, 126, 38);
		contentPane.add(lbl_masp);

		JLabel lbl_thongtinsp = new JLabel("Thông tin sản phẩm");
		lbl_thongtinsp.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_thongtinsp.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbl_thongtinsp.setBounds(72, 396, 389, 45);
		contentPane.add(lbl_thongtinsp);

		JLabel lbl_tensp = new JLabel("Tên sản phẩm:");
		lbl_tensp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_tensp.setBounds(10, 518, 126, 38);
		contentPane.add(lbl_tensp);

		JLabel lbl_dongia = new JLabel("Đơn giá:");
		lbl_dongia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_dongia.setBounds(328, 451, 79, 38);
		contentPane.add(lbl_dongia);

		JLabel lbl_kichco = new JLabel("Loại: ");
		lbl_kichco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_kichco.setBounds(328, 518, 79, 38);
		contentPane.add(lbl_kichco);

		JLabel lbl_slton = new JLabel("Số lượng tồn:");
		lbl_slton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_slton.setBounds(10, 588, 126, 38);
		contentPane.add(lbl_slton);

		JLabel lbl_kieudang = new JLabel("Đơn vị:");
		lbl_kieudang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_kieudang.setBounds(10, 666, 112, 27);
		contentPane.add(lbl_kieudang);

		JLabel lbl_loai = new JLabel("Hãng:");
		lbl_loai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_loai.setBounds(328, 594, 79, 27);
		contentPane.add(lbl_loai);

		txtMaSP = new JTextField();
		txtMaSP.setBounds(146, 458, 172, 30);
		contentPane.add(txtMaSP);
		txtMaSP.setColumns(10);

		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(146, 525, 172, 30);
		contentPane.add(txtTenSP);

		txtSLTon = new JTextField();
		txtSLTon.setColumns(10);
		txtSLTon.setBounds(146, 595, 172, 30);
		contentPane.add(txtSLTon);

		txtDonVi = new JTextField();
		txtDonVi.setColumns(10);
		txtDonVi.setBounds(146, 667, 172, 30);
		contentPane.add(txtDonVi);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(417, 458, 104, 30);
		contentPane.add(txtDonGia);

		txtLoai = new JTextField();
		txtLoai.setColumns(10);
		txtLoai.setBounds(417, 525, 104, 30);
		contentPane.add(txtLoai);

		txtHang = new JTextField();
		txtHang.setColumns(10);
		txtHang.setBounds(417, 595, 104, 30);
		contentPane.add(txtHang);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoa.setBounds(344, 715, 126, 38);
		contentPane.add(btnXoa);
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLuu.setBounds(523, 715, 126, 38);
		// contentPane.add(btnLuu);

		btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHuyBo.setBounds(689, 715, 126, 38);
		contentPane.add(btnHuyBo);

		btnTroLai = new JButton("Trở lại");
		btnTroLai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTroLai.setBounds(850, 715, 126, 38);
		contentPane.add(btnTroLai);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.setBounds(177, 715, 126, 38);
		contentPane.add(btnSua);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThem.setBounds(10, 715, 126, 38);
		contentPane.add(btnThem);

		JLabel lbl_masp_1 = new JLabel("Người bán:");
		lbl_masp_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_masp_1.setBounds(531, 451, 79, 38);
		contentPane.add(lbl_masp_1);

		txtNguoiBan = new JTextField();
		txtNguoiBan.setColumns(10);
		txtNguoiBan.setBounds(620, 458, 150, 30);
		contentPane.add(txtNguoiBan);

		JLabel lbl_masp_2 = new JLabel("Quản lý:");
		lbl_masp_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_masp_2.setBounds(531, 518, 62, 38);
		contentPane.add(lbl_masp_2);

		txtQuanLy = new JTextField();
		txtQuanLy.setColumns(10);
		txtQuanLy.setBounds(620, 525, 150, 30);
		contentPane.add(txtQuanLy);

		JLabel lbl_masp_1_1 = new JLabel("Trạng thái:");
		lbl_masp_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_masp_1_1.setBounds(531, 588, 79, 38);
		contentPane.add(lbl_masp_1_1);

		rdbHoatDong = new JRadioButton("Hoạt động");
		rdbHoatDong.setHorizontalAlignment(SwingConstants.CENTER);
		rdbHoatDong.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbHoatDong.setBounds(620, 588, 102, 32);
		contentPane.add(rdbHoatDong);

		rdbTamNgung = new JRadioButton("Tạm ngưng");
		rdbTamNgung.setHorizontalAlignment(SwingConstants.CENTER);
		rdbTamNgung.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbTamNgung.setBounds(724, 588, 113, 32);
		contentPane.add(rdbTamNgung);

		btnGroup = new ButtonGroup();
		btnGroup.add(rdbHoatDong);
		btnGroup.add(rdbTamNgung);

		ActionListener atc = new SanPhamController(this);
		btnTroLai.addActionListener(atc);
		btnThem.addActionListener(atc);
		btnLuu.addActionListener(atc);
		btnSua.addActionListener(atc);
		btnHuyBo.addActionListener(atc);
		btnHuyTimKiem.addActionListener(atc);
		btnTimKiem.addActionListener(atc);
		btnXoa.addActionListener(atc);

		MouseListener mls = new SanPhamController(this);
		table.addMouseListener(mls);

		this.getData(spBUS.getData());

		setVisible(true);
	}

	// Event Comebakc
	public void troLai() {
		this.dispose();
		new QLKHGUI().openMenu();
	}

	// Event Error Messages
	public void errorMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Thông báo", JOptionPane.ERROR_MESSAGE);
	}

	public void successMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}

	public int confirmMessage(String msg) {
		return JOptionPane.showConfirmDialog(null, msg, "Thông báo", JOptionPane.YES_NO_OPTION);
	}

	// GETTER & SETTER
	public void getData(List<NuocGiaiKhatDTO> data) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (NuocGiaiKhatDTO nuocGiaiKhat : data) {
			model.addRow(new Object[] {
					nuocGiaiKhat.getMaNGK(),
					nuocGiaiKhat.getTenNGK(),
					nuocGiaiKhat.getDonvitinh(),
					nuocGiaiKhat.getSlcon() + "",
					nuocGiaiKhat.getGiaban() + "",
					nuocGiaiKhat.getTenloai(),
					nuocGiaiKhat.getMaNB(),
					nuocGiaiKhat.getMaHSX(),
					nuocGiaiKhat.getMaQL()
			});
		}
	}

	public void setField(String fieldName, String value) {
		switch (fieldName) {
			case "txtMaSP":
				txtMaSP.setText(value);
				break;
			case "txtTenSP":
				txtTenSP.setText(value);
				break;
			case "txtSLTon":
				txtSLTon.setText(value);
				break;
			case "txtDonVi":
				txtDonVi.setText(value);
				break;
			case "txtDonGia":
				txtDonGia.setText(value);
				break;
			case "txtHang":
				txtHang.setText(value);
				break;
			case "txtLoai":
				txtLoai.setText(value);
				break;
			case "txtNguoiBan":
				txtNguoiBan.setText(value);
				break;
			case "txtQuanLy":
				txtQuanLy.setText(value);
				break;
			default:
				break;
		}
	}

	public String getField(String fieldName) {
		switch (fieldName) {
			case "txtMaSP":
				return txtMaSP.getText();
			case "txtTenSP":
				return txtTenSP.getText();
			case "txtSLTon":
				return txtSLTon.getText();
			case "txtDonVi":
				return txtDonVi.getText();
			case "txtDonGia":
				return txtDonGia.getText();
			case "txtHang":
				return txtHang.getText();
			case "txtLoai":
				return txtLoai.getText();
			case "txtNguoiBan":
				return txtNguoiBan.getText();
			case "txtQuanLy":
				return txtQuanLy.getText();
			case "txtTKMaSP":
				return txtTKMaSP.getText();
			case "txtTKMaNB":
				return txtTKMaNB.getText();
			case "txtTKGiaTu":
				return txtTKGiaTu.getText();
			case "txtTKGiaDen":
				return txtTKGiaDen.getText();
			default:
				return null;
		}
	}

	// Tạo các phương thức getter và setter cho RadioButton
	public void setRadioButton(String radioButtonName, boolean selected) {
		if (radioButtonName.equals("rdbHoatDong")) {
			rdbHoatDong.setSelected(selected);
		} else if (radioButtonName.equals("rdbTamNgung")) {
			rdbTamNgung.setSelected(selected);
		}
	}

	public boolean isRadioButtonSelected(String radioButtonName) {
		if (radioButtonName.equals("rdbHoatDong")) {
			return rdbHoatDong.isSelected();
		} else if (radioButtonName.equals("rdbTamNgung")) {
			return rdbTamNgung.isSelected();
		}
		return false;
	}
	// END GETTER & SETTER

	public void clearTxt() {
		txtMaSP.setText("");
		txtTenSP.setText("");
		txtDonGia.setText("");
		txtDonVi.setText("");
		txtHang.setText("");
		txtLoai.setText("");
		txtNguoiBan.setText("");
		txtQuanLy.setText("");
		txtSLTon.setText("");
		getData(spBUS.getData());
	}

	public void getTxtFormTable(List<NuocGiaiKhatDTO> list) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int iRow = table.getSelectedRow();
		if (iRow < 0) {
			return;
		} else {
			txtMaSP.setText(model.getValueAt(iRow, 0) + "");
			txtTenSP.setText(model.getValueAt(iRow, 1) + "");
			txtDonVi.setText(model.getValueAt(iRow, 2) + "");
			txtSLTon.setText(model.getValueAt(iRow, 3) + "");
			txtDonGia.setText(model.getValueAt(iRow, 4) + "");
			txtLoai.setText(model.getValueAt(iRow, 5) + "");
			txtNguoiBan.setText(model.getValueAt(iRow, 6) + "");
			txtHang.setText(model.getValueAt(iRow, 7) + "");
			txtQuanLy.setText(model.getValueAt(iRow, 8) + "");
			for (NuocGiaiKhatDTO nuocGiaiKhat : list) {
				if (nuocGiaiKhat.getMaNGK().equals((model.getValueAt(iRow, 0) + ""))) {
					if (nuocGiaiKhat.isTrangThai()) {
						rdbHoatDong.setSelected(true);
					} else {
						rdbTamNgung.setSelected(true);
					}
				}

			}
		}
	}

	public void insertAndSave() {
		String maSP = txtMaSP.getText();
		String tenSP = txtTenSP.getText();
		String donVi = txtDonVi.getText();
		String slTon = txtSLTon.getText();
		String donGia = txtDonGia.getText();
		String loai = txtLoai.getText();
		String nguoiBan = txtNguoiBan.getText();
		String hang = txtHang.getText();
		String quanLy = txtQuanLy.getText();
		boolean trangThai = true;
		if (rdbHoatDong.isSelected()) {
			trangThai = true;
		} else if (rdbTamNgung.isSelected()) {
			trangThai = false;
		}
		if (maSP.equals("") || tenSP.equals("") || donVi.equals("") || slTon.equals("") || donGia.equals("")
				|| loai.equals("") || nguoiBan.equals("") || hang.equals("") || quanLy.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (!Pattern.matches("\\d+", slTon) || !Pattern.matches("\\d+", donGia)) {
			JOptionPane.showMessageDialog(null, "Số lượng, đơn giá sai định dạng. Vui lòng thử lại");
			return;
		}
		boolean check = false;
		for (NuocGiaiKhatDTO nuocGiaiKhat : NGK) {
			if (nuocGiaiKhat.getMaNGK().equals(maSP)) {
				check = true;
				int choose = JOptionPane.showConfirmDialog(null,
						"Mã sản phẩm đã tồn tại. Bạn có muốn cập nhật sản phẩm này?", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (choose == JOptionPane.YES_OPTION) {
					int soLuong = Integer.valueOf(slTon);
					long donGiaBan = Long.valueOf(donGia);
					NuocGiaiKhatDTO ngk = new NuocGiaiKhatDTO(maSP, tenSP, donVi, soLuong, donGiaBan, loai, nguoiBan,
							hang,
							quanLy, null, trangThai);
					dssp.updateData(ngk);
					// getData();
				} else {
					return;
				}
			}
		}
		if (!check) {
			int choose = JOptionPane.showConfirmDialog(null,
					"Mã sản phẩm hiện chưa có trong danh sách. Bạn có muốn thêm mới", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				int soLuong = Integer.valueOf(slTon);
				long donGiaBan = Long.valueOf(donGia);
				NuocGiaiKhatDTO nuocGiaiKhat = new NuocGiaiKhatDTO(maSP, tenSP, donVi, soLuong, donGiaBan, loai,
						nguoiBan,
						hang, quanLy, null, trangThai);
				dssp.insertData(nuocGiaiKhat);
			}
		}
	}
}

package GUI.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.KhachHangBUS;
import DATA.DAO.ChiTietGioHangDAO;
import DATA.DAO.GioHangDAO;
import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.ChiTietGioHangDTO;
import DATA.DTO.GioHangDTO;
import DATA.DTO.TaiKhoanDTO;
import controller.KhachHangController;

import javax.swing.JRadioButton;

public class KhachHangGUI extends JFrame {
	private TaiKhoanDAO tkDAO = new TaiKhoanDAO();
	private List<TaiKhoanDTO> tk = new ArrayList<>();
	private GioHangDAO ghDAO = new GioHangDAO();
	private List<GioHangDTO> dsgh = new ArrayList<>();
	private ChiTietGioHangDAO ctghDAO = new ChiTietGioHangDAO();
	private List<ChiTietGioHangDTO> ctgh = new ArrayList<>();
	private KhachHangBUS khBUS = new KhachHangBUS();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSdt;
	private JTextField txtDiaChi;
	private JTextField txtMatKhau;
	private JTextField txtTimKiemMaKhachHang;
	private JRadioButton rdbHoatDong;
	private JRadioButton rdbTamNgung;
	private ButtonGroup btnGroup;
	private JComboBox<String> listTrangThai;

	public JTable table;
	public JButton btnXoa;
	public JButton btnHuyBo;
	public JButton btnTroLai;
	public JButton btnSua;
	public JButton btnThem;
	public JButton btnTimKiemKhachHang;
	public JButton btnHuyTimKiemKhachHang;
	private JLabel lbl_tk_masp_1;
	private JLabel lbl_tk_masp_2;
	private JTextField txtTimKiemTenKhachHang;

	/**
	 * Create the frame.
	 */
	public KhachHangGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý khách hàng");
		ImageIcon i_img = new ImageIcon("./src/img/Custom-Icon.png");
		setIconImage(i_img.getImage());
		setBounds(20, 20, 855, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(164, 195, 178));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 824, 84);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 245, 64);
		panel.add(lblNewLabel);

		panel.setOpaque(true);
		panel.setBackground(new Color(107, 144, 128));

		JLabel lbl_tk_masp = new JLabel("Mã khách hàng:");
		lbl_tk_masp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tk_masp.setBounds(265, 10, 102, 25);
		panel.add(lbl_tk_masp);

		txtTimKiemMaKhachHang = new JTextField();
		txtTimKiemMaKhachHang.setBounds(377, 10, 102, 23);
		panel.add(txtTimKiemMaKhachHang);
		txtTimKiemMaKhachHang.setColumns(10);

		btnTimKiemKhachHang = new JButton("Tìm kiếm");
		btnTimKiemKhachHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimKiemKhachHang.setBounds(550, 43, 102, 31);
		panel.add(btnTimKiemKhachHang);

		btnHuyTimKiemKhachHang = new JButton("Hủy");
		btnHuyTimKiemKhachHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHuyTimKiemKhachHang.setBounds(681, 43, 102, 31);
		panel.add(btnHuyTimKiemKhachHang);

		lbl_tk_masp_1 = new JLabel("Lọc trạng thái:");
		lbl_tk_masp_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tk_masp_1.setBounds(265, 49, 102, 25);
		panel.add(lbl_tk_masp_1);

		listTrangThai = new JComboBox<>();
		listTrangThai.setBounds(377, 51, 102, 23);
		panel.add(listTrangThai);

		lbl_tk_masp_2 = new JLabel("Tên khách hàng:");
		lbl_tk_masp_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_tk_masp_2.setBounds(489, 10, 117, 25);
		panel.add(lbl_tk_masp_2);

		txtTimKiemTenKhachHang = new JTextField();
		txtTimKiemTenKhachHang.setColumns(10);
		txtTimKiemTenKhachHang.setBounds(616, 10, 180, 23);
		panel.add(txtTimKiemTenKhachHang);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã khách hàng", "Tên", "Số điện thoại", "Mật khẩu", "Trạng thái"
				}));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		JScrollPane scroolScrollPane = new JScrollPane(table);
		scroolScrollPane.setBounds(10, 104, 824, 283);
		getContentPane().add(scroolScrollPane);

		JLabel lbl_masp = new JLabel("Mã khách hàng:");
		lbl_masp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_masp.setBounds(10, 451, 126, 38);
		contentPane.add(lbl_masp);

		JLabel lbl_thongtinsp = new JLabel("Thông tin Khách hàng");
		lbl_thongtinsp.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_thongtinsp.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbl_thongtinsp.setBounds(20, 396, 336, 45);
		contentPane.add(lbl_thongtinsp);

		JLabel lbl_tensp = new JLabel("Tên khách hàng:");
		lbl_tensp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_tensp.setBounds(10, 518, 126, 38);
		contentPane.add(lbl_tensp);

		JLabel lbl_dongia = new JLabel("Mật khẩu:");
		lbl_dongia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_dongia.setBounds(378, 451, 79, 38);
		contentPane.add(lbl_dongia);

		JLabel lbl_slton = new JLabel("Liên hệ:");
		lbl_slton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_slton.setBounds(10, 576, 62, 38);
		contentPane.add(lbl_slton);

		JLabel lbl_kieudang = new JLabel("Địa chỉ:");
		lbl_kieudang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_kieudang.setBounds(10, 643, 62, 27);
		contentPane.add(lbl_kieudang);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBounds(146, 458, 210, 30);
		contentPane.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(146, 525, 210, 30);
		contentPane.add(txtTenKhachHang);

		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(146, 583, 210, 30);
		contentPane.add(txtSdt);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(146, 644, 375, 30);
		contentPane.add(txtDiaChi);

		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(467, 458, 141, 30);
		contentPane.add(txtMatKhau);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoa.setBounds(344, 715, 126, 38);
		contentPane.add(btnXoa);

		btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHuyBo.setBounds(514, 715, 126, 38);
		contentPane.add(btnHuyBo);

		btnTroLai = new JButton("Trở lại");
		btnTroLai.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTroLai.setBounds(676, 715, 126, 38);
		contentPane.add(btnTroLai);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBounds(177, 715, 126, 38);
		contentPane.add(btnSua);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThem.setBounds(10, 715, 126, 38);
		contentPane.add(btnThem);

		JLabel lbl_masp_1 = new JLabel("Trạng thái:");
		lbl_masp_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_masp_1.setBounds(378, 518, 79, 38);
		contentPane.add(lbl_masp_1);

		rdbHoatDong = new JRadioButton("Hoạt động");
		rdbHoatDong.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbHoatDong.setHorizontalAlignment(SwingConstants.CENTER);
		rdbHoatDong.setBounds(467, 518, 102, 32);
		contentPane.add(rdbHoatDong);

		rdbTamNgung = new JRadioButton("Tạm ngưng");
		rdbTamNgung.setHorizontalAlignment(SwingConstants.CENTER);
		rdbTamNgung.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbTamNgung.setBounds(571, 518, 113, 32);
		contentPane.add(rdbTamNgung);

		btnGroup = new ButtonGroup();
		btnGroup.add(rdbHoatDong);
		btnGroup.add(rdbTamNgung);

		listTrangThai.addItem("Trạng thái");
		listTrangThai.addItem("Hoạt động");
		listTrangThai.addItem("Tạm ngưng");

		ActionListener atc = new KhachHangController(this);
		btnTroLai.addActionListener(atc);
		btnThem.addActionListener(atc);
		btnSua.addActionListener(atc);
		btnHuyBo.addActionListener(atc);
		btnHuyTimKiemKhachHang.addActionListener(atc);
		btnTimKiemKhachHang.addActionListener(atc);
		btnXoa.addActionListener(atc);

		MouseListener mls = new KhachHangController(this);
		table.addMouseListener(mls);

		getData(khBUS.getData());

		setVisible(true);
	}

	// Lay du lieu
	private void getData() {
		if (!tk.isEmpty()) {
			tk.removeAll(tk);
		}
		tk = tkDAO.getData();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (TaiKhoanDTO taiKhoan : tk) {
			if (taiKhoan.getRole().equals("khachhang")) {
				String trangThai = "";
				if (taiKhoan.isTrangThai()) {
					trangThai = "Hoạt động";
				} else {
					trangThai = "Tạm ngưng";
				}
				model.addRow(new Object[] {
						taiKhoan.getMa(),
						taiKhoan.getTenTK(),
						taiKhoan.getSdt(),
						taiKhoan.getMatkhau(),
						trangThai
				});
			}
		}
	}

	//GET DATA
	public void getData(List<TaiKhoanDTO> tkDTO) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (TaiKhoanDTO taiKhoan : tkDTO) {
			if (taiKhoan.getRole().equals("khachhang")) {
				String trangThai = "";
				if (taiKhoan.isTrangThai()) {
					trangThai = "Hoạt động";
				} else {
					trangThai = "Tạm ngưng";
				}
				model.addRow(new Object[] {
						taiKhoan.getMa(),
						taiKhoan.getTenTK(),
						taiKhoan.getSdt(),
						taiKhoan.getMatkhau(),
						trangThai
				});
			}
		}
	}
	//GET SET 
	public String getField(String fieldName) {
        switch (fieldName) {
            case "txtMaKhachHang":
                return txtMaKhachHang.getText();
            case "txtTenKhachHang":
                return txtTenKhachHang.getText();
            case "txtSdt":
                return txtSdt.getText();
            case "txtDiaChi":
                return txtDiaChi.getText();
            case "txtMatKhau":
                return txtMatKhau.getText();
            case "txtTimKiemMaKhachHang":
                return txtTimKiemMaKhachHang.getText();
            case "txtTimKiemTenKhachHang":
                return txtTimKiemTenKhachHang.getText();
            case "TrangThai":
                return (String) listTrangThai.getSelectedItem();
            case "HoatDong":
                return rdbHoatDong.isSelected() ? "Hoạt động" : "Không hoạt động";
            case "TamNgung":
                return rdbTamNgung.isSelected() ? "Tạm ngưng" : "Không tạm ngưng";
            default:
                return "";
        }
    }
	//MESSAGE
	public void errorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Thông báo", JOptionPane.ERROR_MESSAGE);
	}
	public void infoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
	public void warningMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
	public int confirmMessage(String message){
		return JOptionPane.showConfirmDialog(this, message, "Thông báo", JOptionPane.YES_NO_OPTION);
	}




	// Su kien bảng
	public void setTextData(List<TaiKhoanDTO> data) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int iRow = table.getSelectedRow();
		if (iRow != -1) {
			txtMaKhachHang.setText(model.getValueAt(iRow, 0) + "");
			txtTenKhachHang.setText(model.getValueAt(iRow, 1) + "");
			txtSdt.setText(model.getValueAt(iRow, 2) + "");
			txtMatKhau.setText(model.getValueAt(iRow, 3) + "");
			for (TaiKhoanDTO taiKhoan : data) {
				if (taiKhoan.getMa().equals((model.getValueAt(iRow, 0) + ""))) {
					txtDiaChi.setText(taiKhoan.getDiachi());
					if (taiKhoan.isTrangThai()) {
						rdbHoatDong.setSelected(true);
					} else {
						rdbTamNgung.setSelected(true);
					}
					break;
				}
			}

		}
	}

	/* // tạo mã gio hang mới
	private String generateNewMaHD(List<GioHangDTO> gh) {
		// Lấy mã chi tiết giỏ hàng cuối cùng
		String maCT = gh.get(gh.size() - 1).getMaGH();

		// Tách phần số từ mã chi tiết giỏ hàng cuối cùng bằng biểu thức chính quy
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(maCT);
		matcher.find();
		String so = matcher.group();

		// Tăng giá trị số lên 1
		int soMoi = Integer.parseInt(so) + 1;

		// Tạo mã mới bằng cách kết hợp phần cố định và phần số đã tăng
		String maCTGHMoi = "gh" + String.format("%03d", soMoi); // Đảm bảo mã mới luôn có 4 chữ số
		return maCTGHMoi;
	} */

	// huy text
	public void clearTxt() {
		txtMaKhachHang.setText("");
		;
		txtTenKhachHang.setText("");
		;
		txtSdt.setText("");
		;
		txtDiaChi.setText("");
		;
		txtMatKhau.setText("");
		;
	}

	// Dong frame
	public void closeView() {
		new QLCHGUI();
		this.dispose();
	}

}

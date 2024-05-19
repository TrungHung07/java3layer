package GUI.QuanLyKhoHang;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DATA.DAO.ChiTietPhieuNhapDAO;
import DATA.DAO.NhaCungCapDAO;
import DATA.DAO.NuocGiaiKhatDAO;
import DATA.DAO.PhieuNhapDAO;
import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.ChiTietPhieuNhapDTO;
import DATA.DTO.NhaCungCapDTO;
import DATA.DTO.NuocGiaiKhatDTO;
import DATA.DTO.PhieuNhapDTO;
import DATA.DTO.TaiKhoanDTO;
import controller.ControllerViewNhaCungCap;

import java.awt.event.MouseListener;
import java.awt.event.ActionListener;

public class NhaCungCapGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table_DanhSach;
	public JTable table_ChiTiet;
	private JTextField txt_TT_Ma;

	public JButton btn_TimKiem = new JButton("Tìm kiếm");
	public JButton btn_Huy_TK = new JButton("Hủy tim kiếm");
	public JButton btn_Them = new JButton("THÊM");
	public JButton btn_Luu = new JButton("LƯU");
	public JButton btn_TroVe = new JButton("Trở Về");
	private JTextField txt_TK_MaNCC;
	private JTextField txt_TK_Ten;
	private JTextField txt_TK_SDT;
	private JTextField txt_TT_Ten;
	private JTextField txt_TT_DiaChi;
	private JTextField txt_TT_SDT;
	private JComboBox<String> cbb_TK_TrangThai = new JComboBox<>();
	private JComboBox<String> cbb_TT_TrangThai = new JComboBox<>();

	private NhaCungCapDAO dsncc = new NhaCungCapDAO();
	private List<NhaCungCapDTO> ncc = new ArrayList<>();
	private PhieuNhapDAO dspn = new PhieuNhapDAO();
	private List<PhieuNhapDTO> pn = new ArrayList<>();
	private ChiTietPhieuNhapDAO dsctpn = new ChiTietPhieuNhapDAO();
	private List<ChiTietPhieuNhapDTO> ctpn = new ArrayList<>();
	private NuocGiaiKhatDAO dsngk = new NuocGiaiKhatDAO();
	private List<NuocGiaiKhatDTO> ngk = new ArrayList<>();
	private TaiKhoanDAO tkDAO = new TaiKhoanDAO();
	private List<TaiKhoanDTO> tk = new ArrayList<>(tkDAO.getData());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhaCungCapGUI frame = new NhaCungCapGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhaCungCapGUI() {
		setTitle("Nhà cung cấp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(182, 204, 254));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 24);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lb_DSPN = new JLabel("Danh sách nhà cung cấp");
		lb_DSPN.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_DSPN.setBounds(10, 0, 226, 20);
		panel.add(lb_DSPN);
		panel.setBackground(new Color(171, 196, 255));

		table_DanhSach = new JTable();
		table_DanhSach.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã NCC", "Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại", "Trạng Thái"
				}));
		table_DanhSach.getColumnModel().getColumn(0).setPreferredWidth(5);
		table_DanhSach.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_DanhSach.getColumnModel().getColumn(2).setPreferredWidth(70);
		table_DanhSach.getColumnModel().getColumn(3).setPreferredWidth(25);
		table_DanhSach.getColumnModel().getColumn(4).setPreferredWidth(10);

		JScrollPane scrollPane = new JScrollPane(table_DanhSach);
		scrollPane.setBounds(0, 25, 546, 235);
		contentPane.add(scrollPane);

		table_ChiTiet = new JTable();
		table_ChiTiet.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã NCC", "Mã NGK", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá"
				}));
		table_ChiTiet.getColumnModel().getColumn(0).setPreferredWidth(10);
		table_ChiTiet.getColumnModel().getColumn(1).setPreferredWidth(10);
		table_ChiTiet.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_ChiTiet.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_ChiTiet.getColumnModel().getColumn(4).setPreferredWidth(30);
		JScrollPane scrollPane_1 = new JScrollPane(table_ChiTiet);
		scrollPane_1.setBounds(0, 300, 546, 219);
		contentPane.add(scrollPane_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(556, 0, 318, 40);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(171, 196, 255));

		JLabel lb_TimKiem = new JLabel("Tìm Kiếm:");
		lb_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_TimKiem.setBounds(0, 0, 89, 32);
		panel_3.add(lb_TimKiem);

		btn_TimKiem.setBounds(81, 7, 100, 23);
		panel_3.add(btn_TimKiem);

		btn_Huy_TK.setBounds(191, 7, 100, 23);
		panel_3.add(btn_Huy_TK);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(556, 62, 318, 198);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã NCC:");
		lblNewLabel.setBounds(10, 11, 49, 22);
		panel_5.add(lblNewLabel);
		panel_5.setBackground(new Color(171, 196, 255));

		txt_TK_MaNCC = new JTextField();
		txt_TK_MaNCC.setBounds(69, 12, 170, 20);
		panel_5.add(txt_TK_MaNCC);
		txt_TK_MaNCC.setColumns(10);

		JLabel lblTn = new JLabel("Tên:");
		lblTn.setBounds(10, 44, 49, 22);
		panel_5.add(lblTn);

		txt_TK_Ten = new JTextField();
		txt_TK_Ten.setColumns(10);
		txt_TK_Ten.setBounds(69, 43, 170, 20);
		panel_5.add(txt_TK_Ten);

		JLabel lblSdt = new JLabel("SDT:");
		lblSdt.setBounds(10, 79, 49, 22);
		panel_5.add(lblSdt);

		JLabel lblTrngThi = new JLabel("Trạng thái:");
		lblTrngThi.setBounds(10, 107, 62, 22);
		panel_5.add(lblTrngThi);

		txt_TK_SDT = new JTextField();
		txt_TK_SDT.setColumns(10);
		txt_TK_SDT.setBounds(69, 76, 170, 20);
		panel_5.add(txt_TK_SDT);

		String[] options = { "", "Đang hợp tác", "Ngừng hợp tác" };
		cbb_TK_TrangThai = new JComboBox<>(options);
		cbb_TK_TrangThai.setBounds(69, 107, 115, 22);
		panel_5.add(cbb_TK_TrangThai);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBounds(556, 304, 318, 164);
		contentPane.add(panel_6_1);
		panel_6_1.setLayout(null);

		JLabel lb_TTCT_MaPhieu = new JLabel("Mã Nhà Cung Cấp:");
		lb_TTCT_MaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_MaPhieu.setBounds(0, 0, 113, 26);
		panel_6_1.add(lb_TTCT_MaPhieu);
		panel_6_1.setBackground(new Color(171, 196, 255));

		txt_TT_Ma = new JTextField();
		txt_TT_Ma.setBounds(123, 4, 170, 20);
		panel_6_1.add(txt_TT_Ma);
		txt_TT_Ma.setColumns(10);

		JLabel lb_TTCT_MaPhieu_1 = new JLabel("Tên Nhà Cung Cấp:");
		lb_TTCT_MaPhieu_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_MaPhieu_1.setBounds(0, 32, 113, 26);
		panel_6_1.add(lb_TTCT_MaPhieu_1);

		JLabel lb_TTCT_MaPhieu_2 = new JLabel("Địa Chỉ");
		lb_TTCT_MaPhieu_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_MaPhieu_2.setBounds(0, 65, 113, 26);
		panel_6_1.add(lb_TTCT_MaPhieu_2);

		JLabel lb_TTCT_MaPhieu_3 = new JLabel("SDT:");
		lb_TTCT_MaPhieu_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_MaPhieu_3.setBounds(0, 102, 113, 26);
		panel_6_1.add(lb_TTCT_MaPhieu_3);

		txt_TT_Ten = new JTextField();
		txt_TT_Ten.setColumns(10);
		txt_TT_Ten.setBounds(123, 35, 170, 20);
		panel_6_1.add(txt_TT_Ten);

		txt_TT_DiaChi = new JTextField();
		txt_TT_DiaChi.setColumns(10);
		txt_TT_DiaChi.setBounds(123, 69, 170, 20);
		panel_6_1.add(txt_TT_DiaChi);

		txt_TT_SDT = new JTextField();
		txt_TT_SDT.setColumns(10);
		txt_TT_SDT.setBounds(123, 106, 170, 20);
		panel_6_1.add(txt_TT_SDT);

		JLabel lb_TTCT_MaPhieu_3_1 = new JLabel("Trạng Thái:");
		lb_TTCT_MaPhieu_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_MaPhieu_3_1.setBounds(0, 139, 113, 26);
		panel_6_1.add(lb_TTCT_MaPhieu_3_1);

		cbb_TT_TrangThai = new JComboBox<>(options);
		cbb_TT_TrangThai.setBounds(123, 137, 113, 22);
		panel_6_1.add(cbb_TT_TrangThai);

		btn_TroVe.setBounds(0, 518, 84, 32);
		contentPane.add(btn_TroVe);
		btn_TroVe.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lb_TTTK = new JLabel("Thông tin tìm kiếm:");
		lb_TTTK.setBounds(566, 38, 143, 21);
		contentPane.add(lb_TTTK);
		lb_TTTK.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lb_CTPN = new JLabel("Danh sách mặt hàng cung cấp");
		lb_CTPN.setBounds(10, 271, 236, 19);
		contentPane.add(lb_CTPN);
		lb_CTPN.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lb_TTCT = new JLabel("Thông tin");
		lb_TTCT.setBounds(566, 268, 228, 25);
		contentPane.add(lb_TTCT);
		lb_TTCT.setFont(new Font("Tahoma", Font.BOLD, 15));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(556, 479, 318, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btn_Them.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_Them.setBounds(10, 0, 137, 37);
		panel_1.add(btn_Them);
		panel_1.setBackground(new Color(171, 196, 255));

		btn_Luu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_Luu.setBounds(170, 0, 138, 37);
		panel_1.add(btn_Luu);

		ActionListener act = new ControllerViewNhaCungCap(this);
		btn_Huy_TK.addActionListener(act);
		btn_Luu.addActionListener(act);
		btn_Them.addActionListener(act);
		btn_TimKiem.addActionListener(act);
		btn_TroVe.addActionListener(act);

		MouseListener mol = new ControllerViewNhaCungCap(this);
		table_DanhSach.addMouseListener(mol);
		table_ChiTiet.addMouseListener(mol);

		//getData();
		setVisible(true);
	}

	public void comeBack() {
		this.setVisible(false);
		new QLKHGUI().openMenu();
	}

	public String getField(String fieldName) {
        switch (fieldName) {
            case "TT_Ma":
                return txt_TT_Ma.getText();
            case "TK_MaNCC":
                return txt_TK_MaNCC.getText();
            case "TK_Ten":
                return txt_TK_Ten.getText();
            case "TK_SDT":
                return txt_TK_SDT.getText();
            case "TT_Ten":
                return txt_TT_Ten.getText();
            case "TT_DiaChi":
                return txt_TT_DiaChi.getText();
            case "TT_SDT":
                return txt_TT_SDT.getText();
            case "TK_TrangThai":
                return (String) cbb_TK_TrangThai.getSelectedItem();
            case "TT_TrangThai":
                return (String) cbb_TT_TrangThai.getSelectedItem();
            default:
                return "";
        }
    }

	public void getData(List<NhaCungCapDTO> nccDTO) {
		DefaultTableModel model_NhaCungCap = (DefaultTableModel) table_DanhSach.getModel();
		DefaultTableModel model_ChiTiet = (DefaultTableModel) table_ChiTiet.getModel();
		model_NhaCungCap.setRowCount(0);
		model_ChiTiet.setRowCount(0);

		for (NhaCungCapDTO nhaCungCap : nccDTO) {
			String trangThai;
			if (nhaCungCap.isTrangThai()) {
				trangThai = "Đang hợp tác";
			} else {
				trangThai = "Ngừng hợp tác";
			}
			model_NhaCungCap.addRow(new Object[] {
					nhaCungCap.getMaNCC() + "",
					nhaCungCap.getTenNCC() + "",
					nhaCungCap.getDiaChi() + "",
					nhaCungCap.getSdt() + "",
					trangThai
			});
		}

	}

	public void getDataSelectRowTable() {
		txt_TT_Ma.setText("");
		txt_TT_Ten.setText("");
		txt_TT_DiaChi.setText("");
		txt_TT_SDT.setText("");
		cbb_TT_TrangThai.setSelectedItem("");
		DefaultTableModel model_NhaCungCap = (DefaultTableModel) table_DanhSach.getModel();
		DefaultTableModel model_ChiTiet = (DefaultTableModel) table_ChiTiet.getModel();
		model_ChiTiet.setRowCount(0);
		int i_row = table_DanhSach.getSelectedRow();
		String maNCC = model_NhaCungCap.getValueAt(i_row, 0) + "";
		boolean check_PN_ExistNCC = false;
		for (PhieuNhapDTO phieuNhap : pn) {
			if (phieuNhap.getMaNCC().equals(maNCC)) {
				check_PN_ExistNCC = true;
				break;
			}
		}
		if (check_PN_ExistNCC) {
			for (NuocGiaiKhatDTO ngk : ngk) {
				int sumSoLuong = 0;
				long tempDonGia = 0;
				String tempMaNCC = "";
				for (PhieuNhapDTO phieuNhap : pn) {
					// HashSet<ChiTietPhieuNhap> ctpn_Checked = new HashSet<>();
					if (phieuNhap.getMaNCC().equals(maNCC)) {
						tempMaNCC = phieuNhap.getMaNCC();
						// Di chuyển dòng này ra khỏi vòng lặp chi tiết phiếu nhập
						for (ChiTietPhieuNhapDTO chiTietPhieuNhap : ctpn) {
							if (chiTietPhieuNhap.getMaPN().equals(phieuNhap.getMaPN())) {
								if (ngk.getMaNGK().equals(chiTietPhieuNhap.getMaSP())) {
									sumSoLuong += chiTietPhieuNhap.getSoLuong();
									tempDonGia = chiTietPhieuNhap.getDonGia();
								}
							}
						}
					}

				}
				model_ChiTiet.addRow(new Object[] {
						tempMaNCC,
						ngk.getMaNGK() + "",
						ngk.getTenNGK() + "",
						sumSoLuong,
						tempDonGia
				});
			}
		} else {
			model_ChiTiet.setRowCount(0);
		}
	}

	public void setTxtFormTable() {
		DefaultTableModel modelDanhSach = (DefaultTableModel) table_DanhSach.getModel();
		int i_row = table_DanhSach.getSelectedRow();
		String maNCC = modelDanhSach.getValueAt(i_row, 0) + "";
		if (i_row != -1) {
			txt_TT_Ma.setText(modelDanhSach.getValueAt(i_row, 0) + "");
			txt_TT_Ten.setText(modelDanhSach.getValueAt(i_row, 1) + "");
			txt_TT_DiaChi.setText(modelDanhSach.getValueAt(i_row, 2) + "");
			txt_TT_SDT.setText(modelDanhSach.getValueAt(i_row, 3) + "");
			for (NhaCungCapDTO nCungCap : ncc) {
				if (nCungCap.getMaNCC().equals(maNCC)) {
					if (nCungCap.isTrangThai()) {
						cbb_TT_TrangThai.setSelectedItem("Đang hợp tác");
						break;
					} else {
						cbb_TT_TrangThai.setSelectedItem("Ngừng hợp tác");
						break;
					}
				}
			}
		}
	}




	public boolean checkAccount() {
		String passwordInput = JOptionPane.showInputDialog(null, "Nhập mật khẩu của quản lý kho:", "Xác thực tài khoản",
				JOptionPane.PLAIN_MESSAGE);
		if (passwordInput.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu để tiếp tục!!!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		for (TaiKhoanDTO tk : tk) {
			if (passwordInput.equals(tk.getMatkhau())) {
				if (tk.getRole().equals("quanlykho")) {
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "Mật khẩu sai cho quản lý kho", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Mật khẩu sai cho quản lý kho", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
		return false;
	}

	

	public void clearTxt() {
		txt_TT_Ma.setText("");
		txt_TT_Ten.setText("");
		txt_TT_DiaChi.setText("");
		txt_TT_SDT.setText("");
		cbb_TT_TrangThai.setSelectedItem("");
		txt_TK_MaNCC.setText("");
		txt_TK_Ten.setText("");
		txt_TK_SDT.setText("");
		cbb_TK_TrangThai.setSelectedItem("");
	}
}

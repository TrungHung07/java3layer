//Gio hang, lich su mua hang
package GUI.Customer;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DATA.DAO.ChiTietGioHangDAO;
import DATA.DAO.ChiTietHoaDonDAO;
import DATA.DAO.GioHangDAO;
import DATA.DAO.HoaDonDAO;
import DATA.DAO.NuocGiaiKhatDAO;
import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.ChiTietGioHangDTO;
import DATA.DTO.ChiTietHoaDonDTO;
import DATA.DTO.GioHangDTO;
import DATA.DTO.HoaDonDTO;
import DATA.DTO.NuocGiaiKhatDTO;
import DATA.DTO.TaiKhoanDTO;
import GUI.Login;
import GUI.Admin.FormHoaDon;
// import GUI.NguoiDieuHanh.NguoiDieuHanhGUI;
import controller.ControllerViewCustomer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;

public class CustomerGUI extends JFrame {
	private NuocGiaiKhatDAO ngkDAO = new NuocGiaiKhatDAO();
	private List<NuocGiaiKhatDTO> listNGK = new ArrayList<>(ngkDAO.getData());
	private TaiKhoanDAO dskh = new TaiKhoanDAO();
	private TaiKhoanDTO kh = new TaiKhoanDTO();
	private GioHangDAO ghDAO = new GioHangDAO();
	private List<GioHangDTO> gh = new ArrayList<>();
	private ChiTietGioHangDAO ctghDAO = new ChiTietGioHangDAO();
	private List<ChiTietGioHangDTO> ctgh = new ArrayList<>();
	private HoaDonDAO hdDAO = new HoaDonDAO();
	private List<HoaDonDTO> hd = new ArrayList<>();
	private ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
	private List<ChiTietHoaDonDTO> cthd = new ArrayList<>();
	private Set<String> loaiNuocGiaiKhat = new HashSet<>();
	private FormHoaDon fhd;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_GiaTu;
	private JTextField txt_GiaDen;
	private JLabel lblTenSanPham;
	private JLabel lblHang;
	private JLabel lblDonGia;
	private JLabel lblSoLuong;
	private JLabel lblLoai;
	private JLabel lbl_user;
	private JComboBox<String> comboBox;

	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtSdt;
	private JTextField txtMatKhau;
	private JLabel txtTinhTrang;

	public JPanel panelHome;
	public JPanel panelCart;
	public JPanel panelHistory;
	public JPanel panelProFile;

	public JPanel panel_home;
	public JPanel panel_cart;
	public JPanel panel_history;
	public JPanel panel_profile;

	public JTable tableHomeProduct;
	public JTable tableCartChiTietGioHang;
	public JTable tableLichSuHoaDon;

	public JLabel lbl_img_trangchu;
	public JLabel lbl_home;
	public JLabel lbl_img_gioHang;
	public JLabel lbl_cart;
	public JLabel lbl_img_lichSu;
	public JLabel lbl_history;
	public JLabel lbl_img_ttCaNhan;
	public JLabel lbl_profile;
	public JButton btnThemGioHang;
	public JButton btnMuaNgay;
	public JButton btnLogout;
	public JButton btnClose;
	public JButton btnSuaProfile;
	public JButton btnLuuProfile;
	public JButton btnHuyBoProfile;
	public JButton btnDangXuatProfile;
	public JButton btnXoaGioHang;
	public JButton btnDatHang;
	public JButton btn_TimKiem;
	public JButton btnHy;
	public JButton btnDaNhan;
	public JButton btnHuyDon;
	public JButton btnThanhToan;

	private JTextField txt_tenSP;
	private JTextField txt_soLuong;
	private JTextField txt_donGia;
	private JTextField txt_hang;
	private JTextField txt_loai;

	ActionListener atl = new ControllerViewCustomer(this);
	MouseListener mns = new ControllerViewCustomer(this);

	private JTextField txtTenSP;
	private JTextField txtHang;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtLoai;
	private JTextField txtTongTien;
	private JTextField txtThanhTien;
	private JTextField txtLichSuTongTien;
	private JLabel lblNewLabel_2;
	private JTextField txtLichSuTenSanPham;
	private JLabel lblNewLabel_10;
	private JTextField txtLichSuNgayDat;
	private JLabel lblNewLabel_11;
	private JTextField txtLichSuDonGia;
	private JLabel lblNewLabel_12;
	private JTextField txtLichSuSoLuong;
	private JLabel lblNewLabel_13;
	private JTextField txtLichSuThanhTien;
	public JTable tableLichSuChiTietHoaDon;
	private JTextField txtLichSuTrangThai;
	public JButton btnXemHoaDon;
	private JTextField txtTimKiemTenSanPham;

	/**
	 * Create the frame.
	 */
	public CustomerGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1100, 700);
		setTitle("Cửa hàng nước giải khát");
		ImageIcon i_img = new ImageIcon("./src/img/Twitter.png");
		setIconImage(i_img.getImage());

		contentPane = new JPanel(null) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon imgIcon = new ImageIcon("./src/img/background.gif");
				Image image = imgIcon.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		// contentPane.setBackground(new Color(23, 191, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_menu = new JPanel();
		panel_menu.setBounds(0, 0, 284, 663);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 284, 87);
		panel_menu.add(panel);
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setBackground(new Color(255, 255, 255, 0));

		JLabel lblNewLabel = new JLabel("Nước Giải Khát");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 264, 67);
		panel.add(lblNewLabel);

		panel_home = new JPanel();
		panel_home.setBounds(49, 113, 225, 68);
		panel_menu.add(panel_home);
		panel_home.setLayout(null);

		int newWidth = 50, newHeight = 50;
		ImageIcon imgIconHome = new ImageIcon("./src/img/ViewUser/home-icon.png");
		Image getImgHome = imgIconHome.getImage();
		Image reSizeHome = getImgHome.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon imgHome = new ImageIcon(reSizeHome);
		lbl_img_trangchu = new JLabel();
		lbl_img_trangchu.setIcon(imgHome);
		lbl_img_trangchu.setBounds(10, 10, 50, 50);
		panel_home.add(lbl_img_trangchu);

		lbl_home = new JLabel("Trang Chủ");
		lbl_home.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_home.setBounds(61, 10, 154, 50);
		panel_home.add(lbl_home);

		panel_cart = new JPanel();
		panel_cart.setLayout(null);
		panel_cart.setBounds(49, 221, 225, 68);
		panel_menu.add(panel_cart);

		ImageIcon imgIconCart = new ImageIcon("./src/img/ViewUser/cart-icon.png");
		Image getImgCart = imgIconCart.getImage();
		Image reSizeCart = getImgCart.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon imgCart = new ImageIcon(reSizeCart);
		lbl_img_gioHang = new JLabel();
		lbl_img_gioHang.setIcon(imgCart);
		lbl_img_gioHang.setBounds(10, 10, 50, 50);
		panel_cart.add(lbl_img_gioHang);

		lbl_cart = new JLabel("G iỏ hàng");
		lbl_cart.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_cart.setBounds(61, 10, 154, 50);
		panel_cart.add(lbl_cart);

		panel_history = new JPanel();
		panel_history.setLayout(null);
		panel_history.setBounds(49, 323, 225, 68);
		panel_menu.add(panel_history);

		ImageIcon imgIconHistory = new ImageIcon("./src/img/ViewUser/history-icon.png");
		Image getImgHistory = imgIconHistory.getImage();
		Image reSizeHistory = getImgHistory.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon imgHistory = new ImageIcon(reSizeHistory);
		lbl_img_lichSu = new JLabel();
		lbl_img_lichSu.setIcon(imgHistory);
		lbl_img_lichSu.setBounds(10, 10, 50, 50);
		panel_history.add(lbl_img_lichSu);

		lbl_history = new JLabel("Lịch sử");
		lbl_history.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_history.setBounds(61, 10, 154, 50);
		panel_history.add(lbl_history);

		panel_profile = new JPanel();
		panel_profile.setLayout(null);
		panel_profile.setBounds(49, 431, 225, 68);
		panel_menu.add(panel_profile);

		ImageIcon imgIconInfo = new ImageIcon("./src/img/ViewUser/person-icon.png");
		Image getImgInfo = imgIconInfo.getImage();
		Image reSizeInfo = getImgInfo.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon imgInfo = new ImageIcon(reSizeInfo);
		lbl_img_ttCaNhan = new JLabel();
		lbl_img_ttCaNhan.setIcon(imgInfo);
		lbl_img_ttCaNhan.setBounds(10, 10, 50, 50);
		panel_profile.add(lbl_img_ttCaNhan);

		lbl_profile = new JLabel("Thông tin cá nhân");
		lbl_profile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_profile.setBounds(61, 10, 154, 50);
		panel_profile.add(lbl_profile);

		JLabel lblNewLabel_3 = new JLabel("nhom5@sgu.edu.vn");
		lblNewLabel_3.setBounds(10, 627, 274, 26);
		panel_menu.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(283, 0, 803, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lbl_user = new JLabel("Tên người dùng:");
		lbl_user.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_user.setBounds(555, 10, 174, 21);
		panel_1.add(lbl_user);

		panel_menu.setOpaque(true);
		panel_menu.setBackground(new Color(255, 255, 255, 0));
		panel_1.setOpaque(true);
		panel_1.setBackground(new Color(255, 255, 255, 0));

		btnClose = new JButton("Đóng");
		btnClose.setBounds(644, 39, 85, 21);
		panel_1.add(btnClose);

		btnLogout = new JButton("Đăng xuất");
		btnLogout.setBounds(555, 39, 85, 21);
		panel_1.add(btnLogout);

		panel_home.setOpaque(true);
		panel_home.setBackground(new Color(214, 36, 31));
		panel_cart.setOpaque(true);
		panel_cart.setBackground(new Color(255, 128, 40));
		panel_history.setOpaque(true);
		panel_history.setBackground(new Color(255, 128, 40));
		panel_profile.setOpaque(true);
		panel_profile.setBackground(new Color(255, 128, 40));

		panelHome = slideHome();
		panelCart = slideCart();
		panelHistory = slideHistory();
		panelProFile = slideProfile();
		panelHome.setVisible(true);
		panelCart.setVisible(false);
		panelHistory.setVisible(false);
		panelProFile.setVisible(false);
		contentPane.add(panelHome);
		contentPane.add(panelCart);
		contentPane.add(panelHistory);
		contentPane.add(panelProFile);

		btnLogout.setOpaque(true);
		btnLogout.setBackground(new Color(255, 255, 255, 0));
		btnClose.setOpaque(true);
		btnClose.setBackground(new Color(255, 255, 255, 0));

		btnLogout.addActionListener(atl);
		btnClose.addActionListener(atl);

		panelHome.addMouseListener(mns);
		panelCart.addMouseListener(mns);
		panelHistory.addMouseListener(mns);
		panelCart.addMouseListener(mns);

		lbl_home.addMouseListener(mns);
		lbl_cart.addMouseListener(mns);
		lbl_history.addMouseListener(mns);
		lbl_profile.addMouseListener(mns);

		lbl_img_trangchu.addMouseListener(mns);
		lbl_img_gioHang.addMouseListener(mns);
		lbl_img_lichSu.addMouseListener(mns);
		lbl_img_ttCaNhan.addMouseListener(mns);
		setVisible(true);
	}

	// Panel trang chu
	public JPanel slideHome() {
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(294, 82, 792, 581);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 441, 581);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 10, 76, 32);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Giá từ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 52, 46, 32);
		panel_4.add(lblNewLabel_4);

		txt_GiaTu = new JTextField();
		txt_GiaTu.setColumns(10);
		txt_GiaTu.setBounds(66, 52, 103, 28);
		panel_4.add(txt_GiaTu);

		JLabel lblNewLabel_4_1 = new JLabel("Đến:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(179, 52, 33, 32);
		panel_4.add(lblNewLabel_4_1);

		txt_GiaDen = new JTextField();
		txt_GiaDen.setColumns(10);
		txt_GiaDen.setBounds(222, 52, 103, 28);
		panel_4.add(txt_GiaDen);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 152, 441, 419);
		panel_4.add(scrollPane);

		tableHomeProduct = new JTable();
		tableHomeProduct.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã sản phẩm", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng",
						"\u0110\u01A1n gi\u00E1", "Lo\u1EA1i", "H\u00E3ng s\u1EA3n xu\u1EA5t"
				}));
		scrollPane.setViewportView(tableHomeProduct);

		JLabel lblNewLabel_4_2 = new JLabel("Loại:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(10, 94, 46, 32);
		panel_4.add(lblNewLabel_4_2);

		btn_TimKiem = new JButton("Tìm kiếm");
		btn_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_TimKiem.setBounds(335, 52, 96, 28);
		panel_4.add(btn_TimKiem);

		btnHy = new JButton("Hủy");
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHy.setBounds(335, 98, 96, 28);
		panel_4.add(btnHy);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(440, 0, 352, 581);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Thông tin sản phẩm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 5, 332, 48);
		panel_5.add(lblNewLabel_5);

		lblTenSanPham = new JLabel("Tên sản phẩm:");
		lblTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenSanPham.setBounds(10, 74, 95, 35);
		panel_5.add(lblTenSanPham);

		lblHang = new JLabel("Hãng:");
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHang.setBounds(10, 137, 95, 35);
		panel_5.add(lblHang);

		lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia.setBounds(10, 262, 95, 39);
		panel_5.add(lblDonGia);

		lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoLuong.setBounds(10, 198, 95, 39);
		panel_5.add(lblSoLuong);

		lblLoai = new JLabel("Loại:");
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoai.setBounds(10, 329, 95, 39);
		panel_5.add(lblLoai);

		btnThemGioHang = new JButton("Thêm vào giỏ");
		btnThemGioHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemGioHang.setBounds(48, 506, 106, 39);
		panel_5.add(btnThemGioHang);

		btnMuaNgay = new JButton("Mua ngay");
		btnMuaNgay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMuaNgay.setBounds(215, 506, 106, 39);
		panel_5.add(btnMuaNgay);

		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(255, 255, 255, 0));
		panel_4.setOpaque(true);
		panel_4.setBackground(new Color(255, 255, 255, 0));
		panel_5.setOpaque(true);
		panel_5.setBackground(new Color(255, 255, 255, 0));

		txt_tenSP = new JTextField();
		txt_tenSP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txt_tenSP.setBounds(115, 74, 156, 29);
		panel_5.add(txt_tenSP);
		txt_tenSP.setColumns(10);
		txt_tenSP.setEditable(false);

		txt_soLuong = new JTextField();
		txt_soLuong.setColumns(10);
		txt_soLuong.setBounds(115, 198, 156, 30);
		panel_5.add(txt_soLuong);
		txt_soLuong.setEditable(false);

		txt_donGia = new JTextField();
		txt_donGia.setColumns(10);
		txt_donGia.setBounds(115, 262, 156, 30);
		panel_5.add(txt_donGia);
		txt_donGia.setEditable(false);

		txt_hang = new JTextField();
		txt_hang.setColumns(10);
		txt_hang.setBounds(115, 139, 156, 29);
		panel_5.add(txt_hang);
		txt_hang.setEditable(false);

		txt_loai = new JTextField();
		txt_loai.setColumns(10);
		txt_loai.setBounds(115, 335, 156, 29);
		panel_5.add(txt_loai);
		txt_loai.setEditable(false);

		tableHomeProduct.addMouseListener(mns);

		btnThemGioHang.setOpaque(true);
		btnThemGioHang.setBackground(new Color(255, 255, 255, 0));
		btnMuaNgay.setOpaque(true);
		btnMuaNgay.setBackground(new Color(255, 255, 255, 0));
		btn_TimKiem.setOpaque(true);
		btn_TimKiem.setBackground(new Color(255, 255, 255, 0));
		btnHy.setOpaque(true);
		btnHy.setBackground(new Color(255, 255, 255, 0));

		comboBox = new JComboBox<>();
		comboBox.setBounds(66, 94, 158, 29);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.addItem("Chọn loại nước");
		for (NuocGiaiKhatDTO nuocGiaiKhat : listNGK) {
			loaiNuocGiaiKhat.add(nuocGiaiKhat.getTenloai());
		}
		for (String loai : loaiNuocGiaiKhat) {
			comboBox.addItem(loai);
		}
		panel_4.add(comboBox);

		JLabel lblNewLabel_4_1_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(96, 10, 116, 32);
		panel_4.add(lblNewLabel_4_1_1);

		txtTimKiemTenSanPham = new JTextField();
		txtTimKiemTenSanPham.setColumns(10);
		txtTimKiemTenSanPham.setBounds(222, 10, 158, 28);
		panel_4.add(txtTimKiemTenSanPham);

		btnThemGioHang.addActionListener(atl);
		btnMuaNgay.addActionListener(atl);
		btn_TimKiem.addActionListener(atl);
		btnHy.addActionListener(atl);

		getDataSetHome();

		return panel_2;
	}

	// Panel gio hang
	public JPanel slideCart() {
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(294, 82, 782, 571);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 394, 571);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Giỏ hàng của bạn");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(10, 5, 151, 50);
		panel_4.add(lblNewLabel_7);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 65, 374, 496);
		panel_4.add(scrollPane_1);

		tableCartChiTietGioHang = new JTable();
		tableCartChiTietGioHang.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã giỏ hàng", "Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
				}));
		scrollPane_1.setViewportView(tableCartChiTietGioHang);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(393, 0, 389, 571);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Thông tin sản phẩm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 5, 332, 48);
		panel_5.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Tên sản phẩm:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(24, 88, 98, 39);
		panel_5.add(lblNewLabel_6);

		JLabel txtTrangThai = new JLabel("Trạng thái");
		txtTrangThai.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTrangThai.setBounds(10, 393, 98, 39);
		panel_5.add(txtTrangThai);

		JLabel lblNewLabel_6_1_1 = new JLabel("Đơn giá:");
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1_1.setBounds(190, 175, 64, 39);
		panel_5.add(lblNewLabel_6_1_1);

		JLabel lblNewLabel_6_2 = new JLabel("Số lượng:");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_2.setBounds(10, 175, 64, 39);
		panel_5.add(lblNewLabel_6_2);

		JLabel lblNewLabel_6_3 = new JLabel("Loại:");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_3.setBounds(221, 253, 39, 39);
		panel_5.add(lblNewLabel_6_3);

		btnXoaGioHang = new JButton("Xóa");
		btnXoaGioHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaGioHang.setBounds(221, 477, 95, 33);
		panel_5.add(btnXoaGioHang);

		btnDatHang = new JButton("Đặt hàng");
		btnDatHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDatHang.setBounds(84, 477, 95, 33);
		panel_5.add(btnDatHang);

		JLabel lblNewLabel_6_1_1_1 = new JLabel("Tổng tiền:");
		lblNewLabel_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1_1_1.setBounds(10, 327, 77, 39);
		panel_5.add(lblNewLabel_6_1_1_1);

		txtTenSP = new JTextField();
		txtTenSP.setBounds(132, 94, 122, 30);
		panel_5.add(txtTenSP);
		txtTenSP.setColumns(10);

		txtHang = new JTextField();
		txtHang.setColumns(10);
		txtHang.setBounds(140, 393, 114, 30);
		panel_5.add(txtHang);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(84, 175, 90, 30);
		panel_5.add(txtSoLuong);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(264, 175, 100, 30);
		panel_5.add(txtDonGia);

		txtLoai = new JTextField();
		txtLoai.setColumns(10);
		txtLoai.setBounds(270, 253, 112, 30);
		panel_5.add(txtLoai);

		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(97, 327, 98, 30);
		panel_5.add(txtTongTien);

		JLabel lblNewLabel_6_1_1_1_1 = new JLabel("Thành tiền:");
		lblNewLabel_6_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1_1_1_1.setBounds(10, 253, 77, 39);
		panel_5.add(lblNewLabel_6_1_1_1_1);

		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(97, 253, 114, 30);
		panel_5.add(txtThanhTien);

		btnDatHang.addActionListener(atl);
		btnXoaGioHang.addActionListener(atl);
		tableCartChiTietGioHang.addMouseListener(mns);

		txtTenSP.setEditable(false);
		txtDonGia.setEditable(false);
		txtThanhTien.setEditable(false);
		txtTongTien.setEditable(false);
		txtLoai.setEditable(false);
		txtHang.setEditable(false);

		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(255, 255, 255, 0));
		panel_4.setOpaque(true);
		panel_4.setBackground(new Color(255, 255, 255, 0));
		panel_5.setOpaque(true);
		panel_5.setBackground(new Color(255, 255, 255, 0));

		btnXoaGioHang.setOpaque(true);
		btnXoaGioHang.setBackground(new Color(255, 255, 255, 0));
		btnDatHang.setOpaque(true);
		btnDatHang.setBackground(new Color(255, 255, 255, 0));

		btnXoaGioHang.setEnabled(false);
		btnDatHang.setEnabled(false);

		btnXoaGioHang.addActionListener(atl);
		btnDatHang.addActionListener(atl);

		getDataSetCartTable();

		return panel_2;
	}

	// Panel lich su
	public JPanel slideHistory() {
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(294, 82, 782, 571);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 394, 271);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Lịch sử mua hàng");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(10, 5, 151, 50);
		panel_4.add(lblNewLabel_7);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 374, 195);
		panel_4.add(scrollPane);

		tableLichSuHoaDon = new JTable();
		tableLichSuHoaDon.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"S\u1ED1 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "T\u1ED5ng ti\u1EC1n", "Trạng thái"
				}));
		scrollPane.setViewportView(tableLichSuHoaDon);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(393, 0, 389, 571);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		JLabel lblNewLabel_5 = new JLabel("Thông tin hóa đơn");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 74, 332, 48);
		panel_5.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Tổng tiền:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 132, 80, 39);
		panel_5.add(lblNewLabel_6);

		txtLichSuTongTien = new JTextField();
		txtLichSuTongTien.setBounds(100, 132, 96, 31);
		panel_5.add(txtLichSuTongTien);
		txtLichSuTongTien.setColumns(10);

		lblNewLabel_2 = new JLabel("Tên sản phẩm:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 198, 107, 39);
		panel_5.add(lblNewLabel_2);

		txtLichSuTenSanPham = new JTextField();
		txtLichSuTenSanPham.setColumns(10);
		txtLichSuTenSanPham.setBounds(127, 198, 107, 31);
		panel_5.add(txtLichSuTenSanPham);

		lblNewLabel_10 = new JLabel("Ngày đặt:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(206, 124, 70, 39);
		panel_5.add(lblNewLabel_10);

		txtLichSuNgayDat = new JTextField();
		txtLichSuNgayDat.setColumns(10);
		txtLichSuNgayDat.setBounds(286, 124, 106, 31);
		panel_5.add(txtLichSuNgayDat);

		lblNewLabel_11 = new JLabel("Đơn giá:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(10, 270, 70, 39);
		panel_5.add(lblNewLabel_11);

		txtLichSuDonGia = new JTextField();
		txtLichSuDonGia.setColumns(10);
		txtLichSuDonGia.setBounds(89, 276, 107, 31);
		panel_5.add(txtLichSuDonGia);

		lblNewLabel_12 = new JLabel("Số lượng:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(206, 270, 70, 39);
		panel_5.add(lblNewLabel_12);

		txtLichSuSoLuong = new JTextField();
		txtLichSuSoLuong.setColumns(10);
		txtLichSuSoLuong.setBounds(272, 276, 107, 31);
		panel_5.add(txtLichSuSoLuong);

		lblNewLabel_13 = new JLabel("Thành tiền:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(10, 347, 107, 39);
		panel_5.add(lblNewLabel_13);

		txtLichSuThanhTien = new JTextField();
		txtLichSuThanhTien.setColumns(10);
		txtLichSuThanhTien.setBounds(127, 353, 126, 31);
		panel_5.add(txtLichSuThanhTien);

		JPanel panel = new JPanel();
		panel.setBounds(0, 272, 394, 299);
		panel_2.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_7_1 = new JLabel("Chi tiết đơn hàng");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7_1.setBounds(10, 0, 151, 50);
		panel.add(lblNewLabel_7_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 61, 374, 217);
		panel.add(scrollPane_1);

		tableLichSuChiTietHoaDon = new JTable();
		tableLichSuChiTietHoaDon.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã chi tiết", "Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
				}));
		scrollPane_1.setViewportView(tableLichSuChiTietHoaDon);

		panel.setOpaque(true);
		panel.setBackground(new Color(255, 255, 255, 0));

		btnXemHoaDon = new JButton("Xem hóa đơn");
		btnXemHoaDon.setOpaque(true);
		btnXemHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXemHoaDon.setEnabled(false);
		btnXemHoaDon.setBackground(new Color(255, 255, 255, 0));
		btnXemHoaDon.setBounds(245, 12, 117, 30);
		panel.add(btnXemHoaDon);
		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(255, 255, 255, 0));
		panel_4.setOpaque(true);
		panel_4.setBackground(new Color(255, 255, 255, 0));
		panel_5.setOpaque(true);
		panel_5.setBackground(new Color(255, 255, 255, 0));

		txtLichSuTongTien.setEditable(false);
		txtLichSuTenSanPham.setEditable(false);
		txtLichSuNgayDat.setEditable(false);
		txtLichSuDonGia.setEditable(false);
		txtLichSuSoLuong.setEditable(false);
		txtLichSuThanhTien.setEditable(false);

		btnDaNhan = new JButton("Đã nhận");
		btnDaNhan.setOpaque(true);
		btnDaNhan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDaNhan.setEnabled(false);
		btnDaNhan.setBackground(new Color(255, 255, 255, 0));
		btnDaNhan.setBounds(33, 479, 95, 33);
		panel_5.add(btnDaNhan);

		btnHuyDon = new JButton("Hủy đơn");
		btnHuyDon.setOpaque(true);
		btnHuyDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHuyDon.setEnabled(false);
		btnHuyDon.setBackground(new Color(255, 255, 255, 0));
		btnHuyDon.setBounds(273, 479, 95, 33);
		panel_5.add(btnHuyDon);

		JLabel lblNewLabel_13_1 = new JLabel("Trạng thái:");
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_1.setBounds(10, 408, 107, 39);
		panel_5.add(lblNewLabel_13_1);

		txtLichSuTrangThai = new JTextField();
		txtLichSuTrangThai.setEditable(false);
		txtLichSuTrangThai.setColumns(10);
		txtLichSuTrangThai.setBounds(127, 414, 126, 31);
		panel_5.add(txtLichSuTrangThai);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setOpaque(true);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThanhToan.setEnabled(false);
		btnThanhToan.setBackground(new Color(255, 255, 255, 0));
		btnThanhToan.setBounds(147, 480, 106, 33);
		panel_5.add(btnThanhToan);

		btnHuyDon.addActionListener(atl);
		btnDaNhan.addActionListener(atl);
		btnThanhToan.addActionListener(atl);
		btnXemHoaDon.addActionListener(atl);

		tableLichSuHoaDon.addMouseListener(mns);
		tableLichSuChiTietHoaDon.addMouseListener(mns);

		getDataInvoice();

		return panel_2;
	}

	// Panel thong tin ca nhan
	public JPanel slideProfile() {
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(294, 82, 783, 571);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Thông tin khách hàng");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_8.setBounds(33, 26, 294, 66);
		panel_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Mã khách hàng:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_9.setBounds(33, 102, 141, 51);
		panel_2.add(lblNewLabel_9);

		JLabel lblNewLabel_9_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_9_1.setBounds(33, 163, 141, 52);
		panel_2.add(lblNewLabel_9_1);

		JLabel lblNewLabel_9_2 = new JLabel("Địa chỉ:");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_9_2.setBounds(33, 225, 141, 54);
		panel_2.add(lblNewLabel_9_2);

		JLabel lblNewLabel_9_3 = new JLabel("Số điện thoại:");
		lblNewLabel_9_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_9_3.setBounds(33, 301, 141, 44);
		panel_2.add(lblNewLabel_9_3);

		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMa.setBounds(220, 102, 228, 38);
		panel_2.add(txtMa);
		txtMa.setColumns(10);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTen.setColumns(10);
		txtTen.setBounds(220, 163, 228, 38);
		panel_2.add(txtTen);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setColumns(20);
		txtDiaChi.setBounds(220, 225, 346, 38);
		panel_2.add(txtDiaChi);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSdt.setColumns(10);
		txtSdt.setBounds(220, 301, 228, 38);
		panel_2.add(txtSdt);

		JLabel lblNewLabel_9_3_1 = new JLabel("Tình trạng:");
		lblNewLabel_9_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_9_3_1.setBounds(33, 427, 98, 44);
		panel_2.add(lblNewLabel_9_3_1);

		txtTinhTrang = new JLabel("");
		txtTinhTrang.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTinhTrang.setBounds(141, 427, 141, 44);
		panel_2.add(txtTinhTrang);

		JLabel lblNewLabel_9_4 = new JLabel("Mật khẩu:");
		lblNewLabel_9_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_9_4.setBounds(33, 366, 141, 51);
		panel_2.add(lblNewLabel_9_4);

		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(220, 366, 228, 38);
		panel_2.add(txtMatKhau);

		btnSuaProfile = new JButton("Sửa");
		btnSuaProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSuaProfile.setBounds(141, 493, 125, 38);
		panel_2.add(btnSuaProfile);

		btnLuuProfile = new JButton("Lưu");
		btnLuuProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLuuProfile.setBounds(291, 493, 125, 38);
		panel_2.add(btnLuuProfile);

		btnHuyBoProfile = new JButton("Hủy bỏ");
		btnHuyBoProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuyBoProfile.setBounds(441, 493, 125, 38);
		panel_2.add(btnHuyBoProfile);

		btnDangXuatProfile = new JButton("Đăng xuất");
		btnDangXuatProfile
				.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangXuatProfile
				.setBounds(603, 493, 125, 38);
		panel_2.add(btnDangXuatProfile);

		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(255, 255, 255, 0));

		btnDangXuatProfile.setOpaque(true);
		btnDangXuatProfile.setBackground(new Color(255, 255, 255, 0));
		btnSuaProfile.setOpaque(true);
		btnSuaProfile.setBackground(new Color(255, 255, 255, 0));
		btnLuuProfile.setOpaque(true);
		btnLuuProfile.setBackground(new Color(255, 255, 255, 0));
		btnHuyBoProfile.setOpaque(true);
		btnHuyBoProfile.setBackground(new Color(255, 255, 255, 0));

		btnDangXuatProfile.addActionListener(atl);
		btnSuaProfile.addActionListener(atl);
		btnLuuProfile.addActionListener(atl);
		btnHuyBoProfile.addActionListener(atl);

		setProfile();

		return panel_2;
	}

	// Trang chủ
	// lay du lieu gan vao bang san pham
	public void getDataSetHome() {
		if (Login.getObject() instanceof TaiKhoanDTO) {
			kh = (TaiKhoanDTO) Login.getObject();
		}
		lbl_user.setText("Người dùng: " + kh.getTenTK());
		DefaultTableModel model = (DefaultTableModel) tableHomeProduct.getModel();
		for (NuocGiaiKhatDTO nuocGiaiKhat : listNGK) {
			loaiNuocGiaiKhat.add(nuocGiaiKhat.getTenloai());
			if (nuocGiaiKhat.getSlcon() > 0 && nuocGiaiKhat.isTrangThai()) {
				model.addRow(new Object[] {
						nuocGiaiKhat.getMaNGK(),
						nuocGiaiKhat.getTenNGK(),
						nuocGiaiKhat.getSlcon() + "",
						nuocGiaiKhat.getGiaban() + "",
						nuocGiaiKhat.getTenloai(),
						nuocGiaiKhat.getMaHSX()
				});
			}
		}
	}

	// su kien table - xuat hien text khi nhan
	public void getDataOnTable() {
		DefaultTableModel model = (DefaultTableModel) tableHomeProduct.getModel();
		int iRow = tableHomeProduct.getSelectedRow();
		if (iRow < 0) {
			lblTenSanPham.setText("Tên sản phẩm:");
			lblHang.setText("Hãng:");
			lblDonGia.setText("Đơn giá:");
			lblSoLuong.setText("Số lượng:");
			lblLoai.setText("Loại");
			return;
		} else {
			String maSP = model.getValueAt(iRow, 0) + "";
			String tenSP = model.getValueAt(iRow, 1) + "";
			String soLuong = model.getValueAt(iRow, 2) + "";
			String donGia = model.getValueAt(iRow, 3) + "";
			String loai = model.getValueAt(iRow, 4) + "";
			String hangSX = model.getValueAt(iRow, 5) + "";
			String image = "";
			for (NuocGiaiKhatDTO nuocGiaiKhat : listNGK) {
				if (nuocGiaiKhat.getMaNGK().equals(maSP)) {
					image = nuocGiaiKhat.getImg();
					break;
				}
			}
			txt_tenSP.setText(tenSP);
			txt_hang.setText(hangSX);
			txt_donGia.setText(donGia);
			txt_soLuong.setText(soLuong);
			txt_loai.setText(loai);
		}
	}

	public void refreshData() {
		if (!gh.isEmpty()) {
			gh.removeAll(gh);
		}
		gh = ghDAO.getData();
		if (!ctgh.isEmpty()) {
			ctgh.removeAll(ctgh);
		}
		ctgh = ctghDAO.getData();
		if (!hd.isEmpty()) {
			hd.removeAll(hd);
		}
		hd = hdDAO.getData();
		if (!cthd.isEmpty()) {
			cthd.removeAll(cthd);
		}
		cthd = cthdDAO.getData();
	}

	// them gio hang - Button
	public void addToCart() {
		DefaultTableModel model = (DefaultTableModel) tableHomeProduct.getModel();
		int iRow = tableHomeProduct.getSelectedRow();
		if (iRow < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm thêm vào giỏ hàng!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String input = JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm!");
		int soLuong = 0;
		if (input != null && !input.isEmpty()) {
			if (!Pattern.matches("\\d+", input)) {
				JOptionPane.showMessageDialog(null, "Số lượng phải là số", "Thông báo", JOptionPane.WARNING_MESSAGE);
				return;
			} else {
				soLuong = Integer.parseInt(input);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập lại số lượng", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int checkSoLuong = Integer.valueOf(model.getValueAt(iRow, 2) + "");
		if (soLuong > checkSoLuong) {
			JOptionPane.showMessageDialog(null, "Số lượng muốn thêm vượt quá số lượng tồn kho. Vui lòng nhập lại",
					"Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String maSP = model.getValueAt(iRow, 0) + "";
		long donGia = ngkDAO.getPriceProduct(maSP);
		long thanhTien = donGia * soLuong;
		String maCTGHMoi = "";
		if (ctgh.isEmpty()) {
			maCTGHMoi = "g0001";
		} else {
			String maCT = ctgh.get(ctgh.size() - 1).getMaCTGH();
			// Tách phần số từ mã chi tiết giỏ hàng cuối cùng bằng biểu thức chính quy
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(maCT);
			matcher.find();
			String so = matcher.group();

			// Tăng giá trị số lên 1
			int soMoi = Integer.parseInt(so) + 1;

			// Tạo mã mới bằng cách kết hợp phần cố định và phần số đã tăng
			maCTGHMoi = "g" + String.format("%04d", soMoi); // Đảm bảo mã mới luôn có 4 chữ số
		}

		String maGH = null;
		for (GioHangDTO gioHang : gh) {
			if (gioHang.getMaKH().equals(kh.getMa())) {
				maGH = gioHang.getMaGH();
				break;
			}
		}
		ChiTietGioHangDTO newCtgh = new ChiTietGioHangDTO(maCTGHMoi, maSP, soLuong, thanhTien, maGH, "Xem");
		ctghDAO.insertData(newCtgh);
		ghDAO.updateCartData(maGH);
		getDataSetCartTable();
		JOptionPane.showMessageDialog(null, "Đã thêm thành công. Vui lòng kiểm tra trong giỏ hàng", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
		getDataSetCartTable();

	}

	// Mua ngay - Btn
	public void buyNow() {
		DefaultTableModel model = (DefaultTableModel) tableHomeProduct.getModel();
		int iRow = tableHomeProduct.getSelectedRow();
		if (iRow < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần mua!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String input = JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm!");
		int soLuong = 0;
		if (input != null && !input.isEmpty()) {
			if (!Pattern.matches("\\d+", input)) {
				JOptionPane.showMessageDialog(null, "Số lượng phải là số", "Thông báo", JOptionPane.WARNING_MESSAGE);
				return;
			} else {
				soLuong = Integer.parseInt(input);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập lại số lượng", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int checkSoLuong = Integer.valueOf(model.getValueAt(iRow, 2) + "");
		if (soLuong > checkSoLuong) {
			JOptionPane.showMessageDialog(null, "Số lượng muốn thêm vượt quá số lượng tồn kho. Vui lòng nhập lại",
					"Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		LocalDate nowDate = LocalDate.now();
		Date date = Date.valueOf(nowDate);
		String maSP = model.getValueAt(iRow, 0) + "";
		long donGia = ngkDAO.getPriceProduct(maSP);
		long thanhTien = donGia * soLuong;

		// Hoa don
		String maHD = hd.get(hd.size() - 1).getSoHD();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(maHD);
		matcher.find();
		String so = matcher.group();

		// Tăng giá trị số lên 1
		int soMoi = Integer.parseInt(so) + 1;

		// Tạo mã mới bằng cách kết hợp phần cố định và phần số đã tăng
		String maHDMoi = "hd" + String.format("%03d", soMoi);

		HoaDonDTO hoaDon1 = new HoaDonDTO(maHDMoi, date, thanhTien, kh.getMa(), "Chờ duyệt", null);
		hdDAO.insertHoaDon(hoaDon1);

		// chi tiet hoa don
		String maCTHD = cthd.get(cthd.size() - 1).getMaCTHD();
		pattern = Pattern.compile("\\d+");
		matcher = pattern.matcher(maCTHD);
		matcher.find();
		String soCTHD = matcher.group();

		// Tăng giá trị số lên 1
		int soMoiCTHD = Integer.parseInt(soCTHD) + 1;

		// Tạo mã mới bằng cách kết hợp phần cố định và phần số đã tăng
		String maCTHDMoi = "c" + String.format("%04d", soMoiCTHD);
		ChiTietHoaDonDTO chiTietHoaDon1 = new ChiTietHoaDonDTO(maCTHDMoi, kh.getMa(), maSP, soLuong, thanhTien, maHDMoi);
		cthdDAO.insertChiTietHoaDon(chiTietHoaDon1);
		getDataSetCartTable();
		JOptionPane.showMessageDialog(null, "Đã đặt mua. Vui lòng kiểm tra trạng thái trong giỏ hàng", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
		refreshData();
		getDataInvoice();
	}

	// Tim kiem san pham
	public void searchProduct() {
		cancelSearch();
		boolean isTableEmpty = false;
		String giaTu = txt_GiaTu.getText() + "";
		String tenSanPham = txtTimKiemTenSanPham.getText() + "";
		String giaDen = txt_GiaDen.getText() + "";
		String selectedType = (String) comboBox.getSelectedItem();
		if (tenSanPham.equals("") && giaTu.equals("") && giaDen.equals("") && selectedType.equals("Chọn loại nước")) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền ít nhất 1 thông tin cần tìm", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (!giaTu.equals("")) {
			if (!(Pattern.matches("\\d+", txt_GiaTu.getText()))) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập lại giá khởi điểm. Không phải ký tự", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
				txt_GiaTu.requestFocus();
				return;
			}
		}
		if (!giaDen.equals("")) {
			if (!(Pattern.matches("\\d+", txt_GiaDen.getText()))) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập lại giá kết thúc. Không phải ký tự", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
				txt_GiaDen.requestFocus();
				return;
			}
		}
		DefaultTableModel model = (DefaultTableModel) tableHomeProduct.getModel();
		int countRow = tableHomeProduct.getRowCount();
		Set<String> idDelete = new TreeSet<String>();

		if (!tenSanPham.equals("")) {
			for (int i = 0; i < countRow; i++) {
				String idProduct = model.getValueAt(i, 0) + "";
				String tenSP = model.getValueAt(i, 1) + "";
				if (!tenSP.toLowerCase().contains(tenSanPham.toLowerCase())) {
					idDelete.add(idProduct);
				}
			}
		}
		if (giaTu.length() > 0) {
			long startPrice = Long.valueOf(giaTu + "");
			if (giaDen.equals("")) {
				for (int i = 0; i < countRow; i++) {
					long priceOnTable = Long.valueOf(model.getValueAt(i, 3) + "");
					String idProduct = model.getValueAt(i, 0) + "";
					if (priceOnTable < startPrice) {
						idDelete.add(idProduct);
					}
				}
			} else {
				long endPrice = Long.valueOf(giaDen + "");
				for (int i = 0; i < countRow; i++) {
					long priceOnTable = Long.valueOf(model.getValueAt(i, 3) + "");
					String idProduct = model.getValueAt(i, 0) + "";
					if (startPrice > priceOnTable || endPrice < priceOnTable) {
						idDelete.add(idProduct);
					}
				}

			}
		}
		if (giaDen.length() > 0) {
			long endPrice = Long.valueOf(giaDen + "");
			if (giaTu.equals("")) {
				for (int i = 0; i < countRow; i++) {
					long priceOnTable = Long.valueOf(model.getValueAt(i, 3) + "");
					String idProduct = model.getValueAt(i, 0) + "";
					if (priceOnTable > endPrice) {
						idDelete.add(idProduct);
					}
				}
			} else {
				long startPrice = Long.valueOf(giaTu + "");
				for (int i = 0; i < countRow; i++) {
					long priceOnTable = Long.valueOf(model.getValueAt(i, 3) + "");
					String idProduct = model.getValueAt(i, 0) + "";
					if (startPrice > priceOnTable || endPrice < priceOnTable) {
						idDelete.add(idProduct);
					}
				}

			}
		}
		if (!(selectedType.equals("Chọn loại nước"))) {
			for (int i = 0; i < countRow; i++) {
				String loai = model.getValueAt(i, 4) + "";
				String idProduct = model.getValueAt(i, 0) + "";
				if (!loai.equals(selectedType)) {
					idDelete.add(idProduct);
				}
			}
		}
		for (String string : idDelete) {
			countRow = tableHomeProduct.getRowCount();
			for (int i = 0; i < countRow; i++) {
				String idProduct = model.getValueAt(i, 0) + "";
				if (string.equals(idProduct)) {
					try {
						model.removeRow(i);
						if (model.getRowCount() == 0) {
							isTableEmpty = true;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		if (isTableEmpty) {
			getDataSetHome();
			JOptionPane.showMessageDialog(null,
					"Sản phẩm mà bạn cần tìm hiện không có. Vui lòng thử lại với thông tin khác", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	// Huy tim kiem
	public void cancelSearch() {
		while (true) {
			DefaultTableModel model = (DefaultTableModel) tableHomeProduct.getModel();
			int countRow = model.getRowCount();
			if (countRow == 0)
				break;
			else {
				try {
					model.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		getDataSetHome();
	}
	// kết thúc trang chủ

	// GIO HANG
	// lay du lieu gan vao bang gio hang
	public void getDataSetCartTable() {
		if (!gh.isEmpty()) {
			gh.removeAll(gh);
		}
		if (!ctgh.isEmpty()) {
			ctgh.removeAll(ctgh);
		}
		gh = ghDAO.getData();
		ctgh = ctghDAO.getData();

		DefaultTableModel model = (DefaultTableModel) tableCartChiTietGioHang.getModel();
		model.setRowCount(0);
		for (GioHangDTO gioHang : gh) {
			if (gioHang.getMaKH() != null && gioHang.getMaKH().equals(kh.getMa())) {
				if (!ctgh.isEmpty()) {
					for (ChiTietGioHangDTO chiTietGioHang : ctgh) {
						if (chiTietGioHang.getMaGH() != null && chiTietGioHang.getMaGH().equals(gioHang.getMaGH())) {
							int soLuong = chiTietGioHang.getSoluong();
							long donGia = ngkDAO.getPriceProduct(chiTietGioHang.getMaNGK());
							long thanhTien = soLuong * donGia;
							model.addRow(new Object[] {
									chiTietGioHang.getMaCTGH(),
									chiTietGioHang.getMaNGK(),
									soLuong,
									donGia,
									thanhTien
							});
						}
					}
				}
				break;
			}
		}

		txtTenSP.setText("");
		txtHang.setText("");
		txtSoLuong.setText("");
		txtDonGia.setText("");
		txtLoai.setText("");
		txtTongTien.setText("");
		txtThanhTien.setText("");
	}

	// gan du lieu tu bang vao txt - Table
	public void setTxtFormTable() {
		DefaultTableModel modelCartChiTietGIoHang = (DefaultTableModel) tableCartChiTietGioHang.getModel();
		int iRowChiTiet = tableCartChiTietGioHang.getSelectedRow();
		if (iRowChiTiet >= 0) {
			String maSP = modelCartChiTietGIoHang.getValueAt(iRowChiTiet, 1) + "";
			int soLuong = Integer.valueOf(modelCartChiTietGIoHang.getValueAt(iRowChiTiet, 2) + "");
			long donGia = Long.valueOf(modelCartChiTietGIoHang.getValueAt(iRowChiTiet, 3) + "");
			long thanhTien = soLuong * donGia;
			long tongTien = 0;
			String trangThai = "";
			for (ChiTietGioHangDTO chiTietGioHang : ctgh) {
				tongTien += chiTietGioHang.getThanhtien();
				if (chiTietGioHang.getMaCTGH().equals(modelCartChiTietGIoHang.getValueAt(iRowChiTiet, 0))) {
					trangThai = chiTietGioHang.getTinhTrang();
				}
			}
			for (NuocGiaiKhatDTO nuocGiaiKhat : listNGK) {
				if (nuocGiaiKhat.getMaNGK().equals(maSP)) {
					txtTenSP.setText(nuocGiaiKhat.getTenNGK());
					txtLoai.setText(nuocGiaiKhat.getTenloai());
					txtHang.setText(trangThai);
					break;
				}
			}
			txtSoLuong.setText(soLuong + "");
			txtDonGia.setText(donGia + "");
			txtThanhTien.setText(thanhTien + "");
			txtTongTien.setText(tongTien + "");
			if (trangThai.equals("Xem")) {
				btnDatHang.setEnabled(true);
				btnHuyDon.setEnabled(false);
				btnDaNhan.setEnabled(false);
				btnXoaGioHang.setEnabled(true);
			}
			if (trangThai.equals("Chờ duyệt") || trangThai.equals("Đã duyệt")) {
				btnDatHang.setEnabled(false);
				btnHuyDon.setEnabled(true);
				btnDaNhan.setEnabled(false);
				btnXoaGioHang.setEnabled(false);
			}
			if (trangThai.equals("Đang giao")) {
				btnDatHang.setEnabled(false);
				btnHuyDon.setEnabled(false);
				btnDaNhan.setEnabled(true);
				btnXoaGioHang.setEnabled(false);
			}
		}
	}

	// tạo mã chi tiết hóa đơn mới
	private String generateNewMaCTHD(List<ChiTietHoaDonDTO> cthd) {
		if (!cthd.isEmpty()) {
			cthd.removeAll(cthd);
		}
		cthd = cthdDAO.getData();
		// Lấy mã chi tiết giỏ hàng cuối cùng
		String maCT = cthd.get(cthd.size() - 1).getMaCTHD();

		// Tách phần số từ mã chi tiết giỏ hàng cuối cùng bằng biểu thức chính quy
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(maCT);
		matcher.find();
		String so = matcher.group();

		// Tăng giá trị số lên 1
		int soMoi = Integer.parseInt(so) + 1;

		// Tạo mã mới bằng cách kết hợp phần cố định và phần số đã tăng
		String maCTGHMoi = "c" + String.format("%04d", soMoi); // Đảm bảo mã mới luôn có 4 chữ số
		return maCTGHMoi;
	}

	// tạo mã hóa đơn mới
	private String generateNewMaHD(List<HoaDonDTO> gh) {
		// Lấy mã chi tiết giỏ hàng cuối cùng
		String maCT = gh.get(gh.size() - 1).getSoHD();

		// Tách phần số từ mã chi tiết giỏ hàng cuối cùng bằng biểu thức chính quy
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(maCT);
		matcher.find();
		String so = matcher.group();

		// Tăng giá trị số lên 1
		int soMoi = Integer.parseInt(so) + 1;

		// Tạo mã mới bằng cách kết hợp phần cố định và phần số đã tăng
		String maCTGHMoi = "hd" + String.format("%03d", soMoi); // Đảm bảo mã mới luôn có 4 chữ số
		return maCTGHMoi;
	}

	// su kien Dat hang - Btn
	public void checkOut() {
		DefaultTableModel model = (DefaultTableModel) tableCartChiTietGioHang.getModel();
		int iRow = tableCartChiTietGioHang.getSelectedRow();
		int choice = JOptionPane.showConfirmDialog(null, "Xác nhận đặt hàng", "Thông báo", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			LocalDate currentDate = LocalDate.now();
			// ngay lap
			Date newDate = Date.valueOf(currentDate);
			long tongTien = 0;
			String trangThai = "Chờ duyệt";
			for (GioHangDTO gioHang : gh) {
				if (gioHang.getMaKH().equals(kh.getMa())) {
					// tong tien
					tongTien = gioHang.getTongtien();
					break;
				}
			}
			String maHD = generateNewMaHD(hd);
			HoaDonDTO hoaDon = new HoaDonDTO(maHD, newDate, tongTien, kh.getMa(), trangThai, null);
			hdDAO.insertHoaDon(hoaDon);
			// chi tiet hoa don
			String maKH = kh.getMa();
			int soluong = 0;
			long thanhTien = 0;
			String soHD = maHD;
			for (GioHangDTO gioHang : gh) {
				if (gioHang.getMaKH().equals(maKH)) {
					for (ChiTietGioHangDTO chiTietGioHang : ctgh) {
						soluong = chiTietGioHang.getSoluong();
						thanhTien = chiTietGioHang.getThanhtien();
						String maSP = chiTietGioHang.getMaNGK();
						String maCTHD = generateNewMaCTHD(cthd);
						ChiTietHoaDonDTO newCTHD = new ChiTietHoaDonDTO(maCTHD, maKH, maSP, soluong, thanhTien, soHD);
						cthdDAO.insertChiTietHoaDon(newCTHD);
						ctghDAO.deleteCart(chiTietGioHang.getMaCTGH());
						ghDAO.updateCartData(gioHang.getMaGH());
					}
					JOptionPane.showMessageDialog(null, "Đã đặt và đang chờ duyệt. Vui lòng kiểm tra lịch sử",
							"Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					getDataSetCartTable();
					getDataInvoice();
					return;
				}
			}

		}
	}

	// Su kien xoa gio hang - Btn
	public void deleteCart() {
		DefaultTableModel model = (DefaultTableModel) tableCartChiTietGioHang.getModel();
		int iRow = tableCartChiTietGioHang.getSelectedRow();
		if (iRow != -1) {
			int choose = JOptionPane.showConfirmDialog(null,
					"Xác nhận xóa giỏ hàng",
					"Thông báo", JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				String maCTGH = model.getValueAt(iRow, 0) + "";
				ctghDAO.deleteCart(maCTGH);
				for (ChiTietGioHangDTO chiTietGioHang : ctgh) {
					if (chiTietGioHang.getMaCTGH().equals(maCTGH)) {
						ghDAO.updateCartData(chiTietGioHang.getMaGH());
						break;
					}
				}
				JOptionPane.showMessageDialog(null, "Đơn hàng đã xóa", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
				getDataSetCartTable();
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một mặc hàng để xóa", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	// KET THUC GIO HANG

	// LICH SU
	// Gan hoa don vao lich su mua hang
	public void getDataInvoice() {
		if (!hd.isEmpty()) {
			hd.removeAll(hd);
		}
		if (!cthd.isEmpty()) {
			cthd.removeAll(cthd);
		}
		hd = hdDAO.getData();
		cthd = cthdDAO.getData();
		DefaultTableModel modelLichSuHoaDon = (DefaultTableModel) tableLichSuHoaDon.getModel();
		DefaultTableModel modelLichSuChiTietHoaDon = (DefaultTableModel) tableLichSuChiTietHoaDon.getModel();
		modelLichSuChiTietHoaDon.setRowCount(0);
		modelLichSuHoaDon.setRowCount(0);
		for (HoaDonDTO hoaDon : hd) {
			if (hoaDon.getMaKH().equals(kh.getMa())) {
				modelLichSuHoaDon.addRow(new Object[] {
						hoaDon.getSoHD(),
						hoaDon.getNgaylap(),
						hoaDon.getTongtien(),
						hoaDon.getTrangThai()
				});
			}
		}
	}

	// Gan chi tiet hoa don vao chi tiet
	public void setTableHistory() {
		DefaultTableModel modelLichSuHoaDon = (DefaultTableModel) tableLichSuHoaDon.getModel();
		DefaultTableModel modelLichSuChiTietHoaDon = (DefaultTableModel) tableLichSuChiTietHoaDon.getModel();
		modelLichSuChiTietHoaDon.setRowCount(0);
		int iRowLichSuHoaDon = tableLichSuHoaDon.getSelectedRow();
		if (iRowLichSuHoaDon >= 0) {
			String soHD = modelLichSuHoaDon.getValueAt(iRowLichSuHoaDon, 0) + "";
			for (ChiTietHoaDonDTO chiTietHoaDon : cthd) {
				if (chiTietHoaDon.getSoHD().equals(soHD)) {
					int soLuong = chiTietHoaDon.getSoluong();
					long donGia = ngkDAO.getPriceProduct(chiTietHoaDon.getMaNGK());
					long thanhTien = soLuong * donGia;
					modelLichSuChiTietHoaDon.addRow(new Object[] {
							chiTietHoaDon.getMaCTHD(),
							chiTietHoaDon.getMaNGK(),
							soLuong,
							donGia,
							thanhTien
					});
				}
			}
			String trangThai = modelLichSuHoaDon.getValueAt(iRowLichSuHoaDon, 3) + "";
			txtLichSuTongTien.setText(modelLichSuHoaDon.getValueAt(iRowLichSuHoaDon, 2) + "");
			txtLichSuNgayDat.setText(modelLichSuHoaDon.getValueAt(iRowLichSuHoaDon, 1) + "");
			txtLichSuTrangThai.setText(trangThai);
			btnDaNhan.setEnabled(false);
			btnHuyDon.setEnabled(false);
			btnThanhToan.setEnabled(false);
			btnXemHoaDon.setEnabled(false);
			if (trangThai.equals("Đang giao")) {
				btnDaNhan.setEnabled(true);
				btnThanhToan.setEnabled(false);
				btnHuyDon.setEnabled(false);
				btnXemHoaDon.setEnabled(true);
			}
			if (trangThai.equals("Chờ duyệt") || trangThai.equals("Đã duyệt")) {
				btnDaNhan.setEnabled(false);
				btnThanhToan.setEnabled(true);
				btnHuyDon.setEnabled(true);
				btnXemHoaDon.setEnabled(false);
			}
			if (trangThai.equals("Hoàn thành")) {
				btnDaNhan.setEnabled(true);
				btnThanhToan.setEnabled(false);
				btnHuyDon.setEnabled(false);
				btnXemHoaDon.setEnabled(true);
			}
		}
	}

	// Xem hoa don
	public void checkHoaDon() {
		DefaultTableModel modelLichSuHoaDon = (DefaultTableModel) tableLichSuHoaDon.getModel();
		int iRowLichSuHoaDon = tableLichSuHoaDon.getSelectedRow();
		if (iRowLichSuHoaDon != -1) {
			String soHD = modelLichSuHoaDon.getValueAt(iRowLichSuHoaDon, 0) + "";
			HoaDonDTO hd1 = new HoaDonDTO();
			for (HoaDonDTO hoaDon : hd) {
				if (hoaDon.getSoHD().equals(soHD)) {
					hd1 = hoaDon;
					break;
				}
			}
			fhd = new FormHoaDon();
			for (TaiKhoanDTO taiKhoan : dskh.getData()) {
				if (taiKhoan.getRole().equals("nguoiban")) {
					fhd.printTheInvoice(hd1, kh, taiKhoan);
					break;
				}
			}

		}
	}

	// Su kien gan du lieu tu bang vao txt - Table
	public void setTxtHistory() {
		DefaultTableModel modelLichSuChiTietHoaDon = (DefaultTableModel) tableLichSuChiTietHoaDon.getModel();
		int iRowChiTietHoaDon = tableLichSuChiTietHoaDon.getSelectedRow();
		String maSP = modelLichSuChiTietHoaDon.getValueAt(iRowChiTietHoaDon, 1) + "";
		for (NuocGiaiKhatDTO nuocGiaiKhat : listNGK) {
			if (nuocGiaiKhat.getMaNGK().equals(maSP)) {
				txtLichSuTenSanPham.setText(nuocGiaiKhat.getTenNGK());
				break;
			}
		}
		txtLichSuDonGia.setText(modelLichSuChiTietHoaDon.getValueAt(iRowChiTietHoaDon, 3) + "");
		txtLichSuSoLuong.setText(modelLichSuChiTietHoaDon.getValueAt(iRowChiTietHoaDon, 2) + "");
		txtLichSuThanhTien.setText(modelLichSuChiTietHoaDon.getValueAt(iRowChiTietHoaDon, 4) + "");
	}

	// Su kien huy don hang - Btn
	public void cancelOrder() {
		DefaultTableModel model = (DefaultTableModel) tableLichSuHoaDon.getModel();
		int iRow = tableLichSuHoaDon.getSelectedRow();
		if (iRow != -1) { // Kiểm tra xem có hàng nào được chọn không
			int choose = JOptionPane.showConfirmDialog(null,
					"Xác nhận hủy đơn hàng",
					"Thông báo", JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				String trangThai = "Đã hủy";
				String maHD = model.getValueAt(iRow, 0) + "";
				hdDAO.updateTinhTrangToChoDuyet(maHD, trangThai);
				JOptionPane.showMessageDialog(null, "Đơn hàng đã hủy", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
				getDataInvoice();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để hủy đơn", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	// Su kien thanh toan don hang
	public void paymentForOrder() {
		DefaultTableModel model = (DefaultTableModel) tableLichSuHoaDon.getModel();
		int iRow = tableLichSuHoaDon.getSelectedRow();
		if (iRow != -1) { // Kiểm tra xem có hàng nào được chọn không
			int choose = JOptionPane.showConfirmDialog(null,
					"Xác nhận thanh toán",
					"Thông báo", JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				String trangThaiKiemDuyet = model.getValueAt(iRow, 3) + "";
				if (trangThaiKiemDuyet.equals("Chờ duyệt")) {
					JOptionPane.showMessageDialog(null, "Để đảm bảo, bạn nên thanh toán khi đã duyệt!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				} else if (trangThaiKiemDuyet.equals("Đã duyệt")) {
					String trangThai = "Đã thanh toán";
					String maHD = model.getValueAt(iRow, 0) + "";
					hdDAO.updateTinhTrangToChoDuyet(maHD, trangThai);
					JOptionPane.showMessageDialog(null, "Đã thanh toán đơn hàng. Đang chuẩn bị cho bộ phận vận chuyển",
							"Thông báo",
							JOptionPane.WARNING_MESSAGE);
					getDataInvoice();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để hủy đơn", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	// Su kien da nhan duoc hang - Btn
	public void receivedOrder() {
		DefaultTableModel model = (DefaultTableModel) tableLichSuHoaDon.getModel();
		int iRow = tableLichSuHoaDon.getSelectedRow();
		if (iRow != -1) { // Kiểm tra xem có hàng nào được chọn không
			int choose = JOptionPane.showConfirmDialog(null,
					"Xác nhận đơn hàng",
					"Thông báo", JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				String trangThai = "Hoàn thành";
				String maHD = model.getValueAt(iRow, 0) + "";
				hdDAO.updateTinhTrangToChoDuyet(maHD, trangThai);
				JOptionPane.showMessageDialog(null, "Xác nhận thành công", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
				getDataInvoice();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 đơn hàng", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
	}
	// KET THUC LICH SU

	// thong tin ca nhan - loi diachi va sdt
	public void setProfile() {
		txtMa.setText(kh.getMa());
		txtTen.setText(kh.getTenTK());
		txtDiaChi.setText(kh.getDiachi());
		txtSdt.setText(kh.getSdt());
		txtMatKhau.setText("");
		if (kh.isTrangThai()) {
			txtTinhTrang.setText("Hoạt động");
		}
		txtMa.setEditable(false);
		txtTen.setEditable(false);
		txtDiaChi.setEditable(false);
		txtSdt.setEditable(false);
		txtMatKhau.setEditable(false);
	}

	// Sua tt ca nhan
	public void editProfile() {
		txtTen.setEditable(true);
		txtTen.requestFocus();
		txtSdt.setEditable(true);
		txtDiaChi.setEditable(true);
		txtMatKhau.setEditable(true);
		txtMatKhau.setText(kh.getMatkhau());
	}

	// Luu cai dat
	public void saveProfile() {
		String maKH = txtMa.getText();
		String tenKH = txtTen.getText();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSdt.getText();
		if (txtMatKhau.getText().equals("")) {
			return;
		} else {
			String matKhau = txtMatKhau.getText();
			int choose = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thay đổi", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				kh = new TaiKhoanDTO(maKH, tenKH, diaChi, sdt, matKhau, true, "khachhang");
				dskh.editData(kh);
				setProfile();
				JOptionPane.showMessageDialog(null, "Thay đổi của bạn đã được lưu");
			}
		}
	}

	// ket thuc thong tin ca nhan
	// Dang xuat
	public void logOut() {
		// if (kh.getRole().equals("giamdoc")) {
		// 	this.dispose();
		// 	new NguoiDieuHanhGUI();
		// } else {
			this.dispose();
			new Login();
		
	}

	// Dong Frame
	public void closeView() {
		System.exit(0);
	}
}
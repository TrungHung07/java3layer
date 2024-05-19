//Hoan thanh
package GUI.QuanLyKhoHang;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATA.DTO.TaiKhoanDTO;
import GUI.Login;
// import GUI.NguoiDieuHanh.NguoiDieuHanhGUI;
import controller.QLKHController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class QLKHGUI extends JFrame {
	private TaiKhoanDTO qlkh = new TaiKhoanDTO();

	private static final long serialVersionUID = 1L;
	private JPanel header;
	public JButton btnSanPham;
	public JButton btnNhaCungCap;
	public JButton btnPhieuNhap;
	public JButton btnThongKe;
	public JButton btn_dong;
	public JButton btn_dangxuat;

	/**
	 * Create the frame.
	 */
	public QLKHGUI() {
		ImageIcon i_img = new ImageIcon("./src/img/LogoLogin.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 554);
		setTitle("Quản lý cửa hàng");
		setIconImage(i_img.getImage());

		header = new JPanel(null) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon imgIcon = new ImageIcon("./src/img/background_summer.png");
				Image image = imgIcon.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		header.setBackground(Color.PINK);
		header.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(header);
		header.setLayout(null);

		JPanel button = new JPanel();
		button.setBounds(10, 448, 771, 59);
		button.setOpaque(true);
		button.setBackground(new Color(255, 255, 255, 0));
		header.add(button);
		button.setLayout(null);

		JPanel menu = new JPanel();
		menu.setBounds(10, 166, 771, 272);
		menu.setOpaque(true);
		menu.setBackground(new Color(255, 255, 255, 0));
		header.add(menu);
		menu.setLayout(null);

		ImageIcon iconsp = new ImageIcon("./src/img/icon_SanPham.png");
		Image imgsp = iconsp.getImage();
		int newWidth = 110;
		int newHeight = 110;
		Image reSizeSp = imgsp.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon icon_sp = new ImageIcon(reSizeSp);
		JLabel lbl_sanpham = new JLabel("");
		lbl_sanpham.setBounds(79, 47, 110, 110);
		lbl_sanpham.setIcon(icon_sp);
		menu.add(lbl_sanpham);

		ActionListener asc = new QLKHController(this);

		btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setForeground(new Color(255, 0, 128));
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSanPham.setBounds(84, 167, 100, 33);
		btnSanPham.setOpaque(true);
		btnSanPham.setBackground(new Color(255, 255, 255, 0));
		btnSanPham.addActionListener(asc);
		menu.add(btnSanPham);

		ImageIcon iconhd = new ImageIcon("./src/img/NhaCungCap-Icon.png");
		Image imghd = iconhd.getImage();
		Image reSizeHd = imghd.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon icon_hd = new ImageIcon(reSizeHd);
		JLabel lbl_hoadon = new JLabel("");
		lbl_hoadon.setBounds(242, 47, 110, 110);
		lbl_hoadon.setIcon(icon_hd);
		menu.add(lbl_hoadon);

		btnNhaCungCap = new JButton("Nhà Cung Cấp");
		btnNhaCungCap.setForeground(new Color(255, 0, 128));
		btnNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNhaCungCap.setBounds(247, 167, 100, 33);
		btnNhaCungCap.setOpaque(true);
		btnNhaCungCap.setBackground(new Color(255, 255, 255, 0));
		btnNhaCungCap.addActionListener(asc);
		menu.add(btnNhaCungCap);

		ImageIcon iconpn = new ImageIcon("./src/img/PhieuNhap-Icon.png");
		Image imgpn = iconpn.getImage();
		Image reSizepn = imgpn.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon icon_pn = new ImageIcon(reSizepn);
		JLabel lbl_phieunhap = new JLabel("");
		lbl_phieunhap.setBounds(410, 47, 110, 110);
		lbl_phieunhap.setIcon(icon_pn);
		menu.add(lbl_phieunhap);

		btnPhieuNhap = new JButton("Phiếu Nhập");
		btnPhieuNhap.setForeground(new Color(255, 0, 128));
		btnPhieuNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPhieuNhap.setBounds(415, 167, 100, 33);
		btnPhieuNhap.setOpaque(true);
		btnPhieuNhap.setBackground(new Color(255, 255, 255, 0));
		btnPhieuNhap.addActionListener(asc);
		menu.add(btnPhieuNhap);

		ImageIcon iconkh = new ImageIcon("./src/img/icon_ThongKe.png");
		Image imgkh = iconkh.getImage();
		Image reSizekh = imgkh.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon icon_kh = new ImageIcon(reSizekh);
		JLabel lbl_khachhang = new JLabel("");
		lbl_khachhang.setBounds(568, 47, 110, 110);
		lbl_khachhang.setIcon(icon_kh);
		menu.add(lbl_khachhang);

		btnThongKe = new JButton("Thống kê");
		btnThongKe.setForeground(new Color(255, 0, 128));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThongKe.setBounds(573, 167, 100, 33);
		btnThongKe.setOpaque(true);
		btnThongKe.setBackground(new Color(255, 255, 255, 0));
		btnThongKe.addActionListener(asc);
		menu.add(btnThongKe);

		JPanel banner = new JPanel();
		banner.setLayout(null);
		banner.setBounds(10, 10, 771, 146);
		banner.setOpaque(true);
		banner.setBackground(new Color(0, 0, 0, 0));
		header.add(banner);

		JLabel lblNewLabel = new JLabel("Hệ Thống Quản Lý Cửa Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 393, 82);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 255, 0));
		banner.add(lblNewLabel);

		JLabel lbl_avt = new JLabel("");
		lbl_avt.setBounds(681, 10, 80, 80);
		banner.add(lbl_avt);

		btn_dong = new JButton("Đóng");
		btn_dong.setBounds(668, 115, 93, 21);
		btn_dong.addActionListener(asc);
		banner.add(btn_dong);

		btn_dangxuat = new JButton("Đăng xuất");
		btn_dangxuat.setBounds(565, 115, 93, 21);
		btn_dangxuat.addActionListener(asc);
		banner.add(btn_dangxuat);

		JLabel lbl_nguoidung = new JLabel("Người dùng:");
		lbl_nguoidung.setBounds(516, 10, 155, 21);
		banner.add(lbl_nguoidung);

		JLabel lbl_chucvu = new JLabel("Chức vụ:");
		lbl_chucvu.setBounds(516, 41, 155, 21);
		banner.add(lbl_chucvu);

		JLabel lbl_ten = new JLabel("Tên:");
		lbl_ten.setBounds(516, 72, 155, 21);
		banner.add(lbl_ten);

		if (Login.getObject() != null) {
			qlkh = (TaiKhoanDTO) Login.getObject();
			lbl_nguoidung.setText("Người dùng: Nhân viên");
			lbl_chucvu.setText("Chức vụ: Quản lý kho hàng");
			lbl_ten.setText("Tên: " + qlkh.getTenTK());
		}
		setVisible(true);
	}

	public void openViewSanPham() {
		new SanPhamGUI();
		this.dispose();
	}

	public void openNhaCungCap() {
		new NhaCungCapGUI();
		this.dispose();
	}

	public void openViewThongKeKhoHang() {
		new ThongKePhieuNhapGUI();
		this.dispose();
	}

	public void openViewPhieuNhap() {
		new PhieuNhapGUI();
		this.dispose();
	}

	public void logout() {
		// if (qlkh.getRole().equals("giamdoc")) {
		// 	this.dispose();
		// 	new NguoiDieuHanhGUI();
		// } else {
			new Login().openFrame();
			this.dispose();
		
	}

	public void closeView() {
		System.exit(0);
	}

	public void openMenu() {
		this.setVisible(true);
	}

}

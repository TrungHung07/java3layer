package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATA.DAO.GioHangDAO;
import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.GioHangDTO;
import DATA.DTO.TaiKhoanDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Register extends JFrame {
	private TaiKhoanDAO tkDAO = new TaiKhoanDAO();
	private List<TaiKhoanDTO> dstk = new ArrayList<>(tkDAO.getData());
	private GioHangDAO ghDAO = new GioHangDAO();
	private List<GioHangDTO> dsgh = new ArrayList<>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JTextField txtMatKhau;
	private JTextField txtNhapLaiMatKhau;
	private JTextField txtSdt;
	private JTextField txtDiaChi;
	private JComboBox<String> comboBox;
	private JTextField txtHo;
	private JTextField txtTen;
	private JLabel lblThongBaoNhapTenDangNhap;
	private JLabel lblThongBaoTen;
	private JLabel lblThongBaoHo;
	private JLabel lblThongBaoMAtKhau;
	private JLabel lblThongBaoNhapLai;
	private JLabel lblThongBaoSdt;
	private JLabel lblThongBaoChonLoaiTK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 656);
		setTitle("Tạo tài khoản");
		ImageIcon img = new ImageIcon("./src/img/Facebook-Messenger.png");
		setIconImage(img.getImage());
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				// Tạo màu gradient từ đỏ đến xanh dương
				GradientPaint gradient = new GradientPaint(0, 0, new Color(234, 255, 28), getWidth(), getHeight(),
						new Color(119, 177, 255));
				// Sử dụng màu gradient để vẽ nền của JPanel
				g2d.setPaint(gradient);
				g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Đăng ký tài khoản");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		lblNewLabel.setBounds(78, 10, 333, 56);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Bạn là:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(98, 110, 61, 27);
		contentPane.add(lblNewLabel_1);

		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Chọn loại tài khoản", "Khách hàng", "Người bán hàng", "Quản lý kho" }));
		comboBox.setBounds(189, 111, 138, 26);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(58, 172, 101, 27);
		contentPane.add(lblNewLabel_1_1);

		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setBounds(189, 172, 178, 27);
		contentPane.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(69, 291, 101, 27);
		contentPane.add(lblNewLabel_1_1_1);

		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(200, 293, 178, 27);
		contentPane.add(txtMatKhau);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nhập lại mật khẩu:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(69, 360, 121, 27);
		contentPane.add(lblNewLabel_1_1_1_1);

		txtNhapLaiMatKhau = new JTextField();
		txtNhapLaiMatKhau.setColumns(10);
		txtNhapLaiMatKhau.setBounds(200, 361, 178, 27);
		contentPane.add(txtNhapLaiMatKhau);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Số điện thoại liên hệ:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2.setBounds(69, 428, 121, 27);
		contentPane.add(lblNewLabel_1_1_1_2);

		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(200, 429, 178, 27);
		contentPane.add(txtSdt);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_3.setBounds(34, 491, 48, 27);
		contentPane.add(lblNewLabel_1_1_1_3);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(89, 493, 382, 27);
		contentPane.add(txtDiaChi);

		JButton btnTaoTaiKhoan = new JButton("Tạo tài khoản");
		btnTaoTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTaoTaiKhoan.setBounds(101, 560, 121, 35);
		contentPane.add(btnTaoTaiKhoan);

		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuayLai.setBounds(266, 560, 121, 35);
		contentPane.add(btnQuayLai);

		lblThongBaoNhapTenDangNhap = new JLabel("");
		lblThongBaoNhapTenDangNhap.setBounds(190, 159, 281, 13);
		contentPane.add(lblThongBaoNhapTenDangNhap);

		lblThongBaoTen = new JLabel("");
		lblThongBaoTen.setBounds(294, 222, 138, 13);
		contentPane.add(lblThongBaoTen);

		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setBounds(189, 291, 177, 13);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setBounds(189, 360, 177, 13);
		contentPane.add(lblNewLabel_2_3);

		lblThongBaoChonLoaiTK = new JLabel("");
		lblThongBaoChonLoaiTK.setBounds(190, 99, 177, 13);
		contentPane.add(lblThongBaoChonLoaiTK);

		JLabel lblNewLabel_1_1_1_4 = new JLabel("Họ:");
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_4.setBounds(46, 232, 28, 27);
		contentPane.add(lblNewLabel_1_1_1_4);

		txtHo = new JTextField();
		txtHo.setColumns(10);
		txtHo.setBounds(84, 234, 138, 27);
		contentPane.add(txtHo);

		JLabel lblNewLabel_1_1_1_4_1 = new JLabel("Tên:");
		lblNewLabel_1_1_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_4_1.setBounds(249, 232, 37, 27);
		contentPane.add(lblNewLabel_1_1_1_4_1);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(296, 234, 138, 27);
		contentPane.add(txtTen);

		lblThongBaoHo = new JLabel("");
		lblThongBaoHo.setBounds(89, 222, 133, 13);
		contentPane.add(lblThongBaoHo);

		lblThongBaoMAtKhau = new JLabel("");
		lblThongBaoMAtKhau.setBounds(200, 280, 271, 13);
		contentPane.add(lblThongBaoMAtKhau);

		lblThongBaoNhapLai = new JLabel("");
		lblThongBaoNhapLai.setBounds(200, 347, 271, 13);
		contentPane.add(lblThongBaoNhapLai);

		lblThongBaoSdt = new JLabel("");
		lblThongBaoSdt.setBounds(200, 417, 271, 13);
		contentPane.add(lblThongBaoSdt);

		btnTaoTaiKhoan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUp();
			}

		});
		btnQuayLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}

		});

		setVisible(true);
	}

	private void signUp() {
		String tenTK = txtTenDangNhap.getText();
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		String matKhau = txtMatKhau.getText();
		String nhapLai = txtNhapLaiMatKhau.getText();
		String sdt = txtSdt.getText();
		String diaChi = txtDiaChi.getText();
		String selectType = (String) comboBox.getSelectedItem();
		boolean check = true;

		// Kiểm tra xem tên tài khoản có đúng định dạng không
		if (tenTK.equals("")) {
			lblThongBaoNhapTenDangNhap.setText("Trường bắt buộc. VUi lòng nhập thông tin");
			lblThongBaoNhapTenDangNhap.setForeground(Color.RED);
			check = false;
		} else {
			if (!tenTK.matches("[a-zA-Z0-9_]{1,20}")) {
				lblThongBaoNhapTenDangNhap.setText("Vui lòng nhập lại. Không chấp nhận ký tự đặt biệt");
				lblThongBaoNhapTenDangNhap.setForeground(Color.RED);
				txtTenDangNhap.requestFocus();
				check = false;
			} else {
				lblThongBaoNhapTenDangNhap.setText("");
			}
			boolean flag = true;
			for (TaiKhoanDTO taiKhoan : dstk) {
				if (taiKhoan.getMa().equals(tenTK)) {
					lblThongBaoNhapTenDangNhap.setText("Tên tài khoản đã tồn tại");
					lblThongBaoNhapTenDangNhap.setForeground(Color.RED);
					txtTenDangNhap.requestFocus();
					flag = false;
					check = false;
				}
			}
			if (flag) {
				lblThongBaoNhapTenDangNhap.setText("");
			}
		}
		if (ho.equals("")) {
			lblThongBaoHo.setText("Không được bỏ trống");
			lblThongBaoHo.setForeground(Color.RED);
			check = false;
		} else {
			lblThongBaoHo.setText("");
		}
		if (ten.equals("")) {
			lblThongBaoTen.setText("Không được bỏ trống");
			lblThongBaoTen.setForeground(Color.RED);
			check = false;
		} else {
			lblThongBaoTen.setText("");
		}

		if (matKhau.equals("")) {
			lblThongBaoMAtKhau.setText("Không được bỏ trống");
			lblThongBaoMAtKhau.setForeground(Color.RED);
			check = false;
		} else {
			lblThongBaoMAtKhau.setText("");
		}
		if (nhapLai.equals("")) {
			lblThongBaoNhapLai.setText("Không được bỏ trống");
			lblThongBaoNhapLai.setForeground(Color.RED);
			check = false;
		} else {
			lblThongBaoNhapLai.setText("");
		}

		if (!matKhau.equals(nhapLai)) {
			lblThongBaoNhapLai.setText("Mật khẩu và xác nhận không khớp.");
			lblThongBaoNhapLai.setForeground(Color.RED);
			txtNhapLaiMatKhau.requestFocus();
			check = false;
		} else {
			lblThongBaoNhapLai.setText("");
		}

		if (sdt.equals("")) {
			lblThongBaoSdt.setText("Không được bỏ trống");
			lblThongBaoSdt.setForeground(Color.RED);
			check = false;
		} else {
			// Kiểm tra xem số điện thoại có đúng định dạng không
			if (!sdt.matches("0[0-9]{9}")) {
				lblThongBaoSdt.setText("Số điện thoại không hợp lệ. Gồm 10 số và bắt đầu bằng 0");
				lblThongBaoSdt.setForeground(Color.RED);
				txtSdt.requestFocus();
				check = false;
			} else {
				lblThongBaoSdt.setText("");
			}
		}
		// Kiểm tra xem đã chọn loại tài khoản hay chưa
		if (selectType.equals("Chọn loại tài khoản")) {
			lblThongBaoChonLoaiTK.setText("Vui lòng chọn loại tài khoản");
			lblThongBaoChonLoaiTK.setForeground(Color.RED);
			check = false;
		} else {
			lblThongBaoChonLoaiTK.setText("");
		}

		if (!check) {
			JOptionPane.showMessageDialog(null, "Có Thông tin không hợp lệ");
		} else {
			String role = "";
			if (selectType.equals("Khách hàng")) {
				role = "khachhang";
			}
			if (selectType.equals("Người bán hàng")) {
				role = "nguoiban";
			}
			if (selectType.equals("Quản lý kho")) {
				role = "qunalykho";
			}
			if (role.equals("khachhang")) {
				TaiKhoanDTO taiKhoan = new TaiKhoanDTO(tenTK, ho + " " + ten, diaChi, sdt, matKhau, true, role);
				tkDAO.insertData(taiKhoan);
				JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công. Giờ đây bạn có thể đăng nhập");
				dsgh = ghDAO.getData();
				String maGH = generateNewMaHD(dsgh);
				GioHangDTO gioHang = new GioHangDTO(maGH, tenTK, 0, 0);
				ghDAO.insertData(gioHang);
				new Login();
				dispose();
			} else {
				TaiKhoanDTO taiKhoan = new TaiKhoanDTO(tenTK, ho + " " + ten, diaChi, sdt, matKhau, false, role);
				tkDAO.insertData(taiKhoan);
				JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công. Và đang chờ cấp hoạt động");
				new Login();
				dispose();
			}

		}
	}

	// tạo mã gio hang mới
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
	}
}

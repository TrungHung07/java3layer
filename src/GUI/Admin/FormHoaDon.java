package GUI.Admin;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DATA.DAO.ChiTietHoaDonDAO;
import DATA.DAO.NuocGiaiKhatDAO;
import DATA.DTO.ChiTietHoaDonDTO;
import DATA.DTO.HoaDonDTO;
import DATA.DTO.NuocGiaiKhatDTO;
import DATA.DTO.TaiKhoanDTO;

import java.awt.Color;
import javax.swing.JButton;

public class FormHoaDon extends JFrame {
	private ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
	private List<ChiTietHoaDonDTO> cthd = new ArrayList<>(cthdDAO.getData());
	private NuocGiaiKhatDAO ngkDAO = new NuocGiaiKhatDAO();
	private List<NuocGiaiKhatDTO> ngk = new ArrayList<>(ngkDAO.getData());

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel txtSoHoaDon;
	private JLabel txtKyHieu;
	private JLabel txtNgayLap;
	private JLabel txtKhachHang;
	private JLabel txtSdt;
	private JLabel txtDiaChi;
	private JLabel txtTongGiaTri;
	private JLabel txtHoTenKhachHang;
	private JLabel txtHoTenNguoiBan;

	/**
	 * Create the frame.
	 */
	public FormHoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 761, 793);
		setTitle("Phiếu Hóa đơn");
		ImageIcon img = new ImageIcon("./src/img/12.png");
		setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(31, 0, 706, 87);
		panel.setOpaque(true);
		panel.setBackground(new Color(255, 255, 255, 0));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hóa đơn bán hàng");
		lblNewLabel.setBounds(178, 10, 371, 38);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		txtSoHoaDon = new JLabel("Số hóa đơn:");
		txtSoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSoHoaDon.setBounds(559, 10, 137, 26);
		panel.add(txtSoHoaDon);

		txtKyHieu = new JLabel("Ký hiệu:");
		txtKyHieu.setBounds(559, 46, 137, 26);
		panel.add(txtKyHieu);

		txtNgayLap = new JLabel("Ngày ..........Tháng ..........Năm  20..........");
		txtNgayLap.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNgayLap.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayLap.setBounds(178, 58, 377, 25);
		panel.add(txtNgayLap);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(0, 0, 0));
		panel_3_1.setBounds(0, 0, 727, 4);
		panel.add(panel_3_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 89, 695, 161);
		panel_1.setOpaque(true);
		panel_1.setBackground(new Color(255, 255, 255, 0));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(37, 10, 177, 35);
		panel_1.add(lblNewLabel_1);

		txtKhachHang = new JLabel("Tên khách hàng:");
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtKhachHang.setBounds(37, 48, 282, 29);
		panel_1.add(txtKhachHang);

		txtSdt = new JLabel("Số điện thoại:");
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSdt.setBounds(37, 87, 282, 29);
		panel_1.add(txtSdt);

		txtDiaChi = new JLabel("Địa chỉ:");
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDiaChi.setBounds(37, 126, 282, 25);
		panel_1.add(txtDiaChi);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(Color.BLACK);
		panel_3_1_1.setBounds(181, 0, 365, 1);
		panel_1.add(panel_3_1_1);

		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setBounds(181, 154, 365, 1);
		panel_1.add(panel_3_1_1_1);
		panel_3_1_1_1.setBackground(Color.BLACK);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(31, 253, 695, 235);
		panel_1_1.setOpaque(true);
		panel_1_1.setBackground(new Color(255, 255, 255, 0));
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 675, 231);
		panel_1_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"STT", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thanh tiền"
				}));
		scrollPane.setViewportView(table);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(41, 489, 685, 257);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);

		txtTongGiaTri = new JLabel("Tổng giá trị:");
		txtTongGiaTri.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTongGiaTri.setBounds(10, 0, 632, 29);
		panel_1_2.add(txtTongGiaTri);

		JLabel lblNewLabel_3 = new JLabel("Người mua");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(458, 67, 145, 26);
		panel_1_2.add(lblNewLabel_3);

		JLabel lblkNghiR = new JLabel("(Ký, nghi rõ họ tên)");
		lblkNghiR.setHorizontalAlignment(SwingConstants.CENTER);
		lblkNghiR.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblkNghiR.setBounds(478, 94, 108, 26);
		panel_1_2.add(lblkNghiR);

		JLabel lblkngDu = new JLabel("(Ký, đóng dấu, nghi rõ họ tên)");
		lblkngDu.setHorizontalAlignment(SwingConstants.CENTER);
		lblkngDu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblkngDu.setBounds(75, 95, 156, 26);
		panel_1_2.add(lblkngDu);

		JLabel lblNewLabel_3_1 = new JLabel("Người bán");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(75, 67, 145, 26);
		panel_1_2.add(lblNewLabel_3_1);

		txtHoTenKhachHang = new JLabel("Bên A");
		txtHoTenKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtHoTenKhachHang.setBounds(432, 195, 230, 29);
		panel_1_2.add(txtHoTenKhachHang);

		txtHoTenNguoiBan = new JLabel("Bên B");
		txtHoTenNguoiBan.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoTenNguoiBan.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtHoTenNguoiBan.setBounds(37, 195, 238, 29);
		panel_1_2.add(txtHoTenNguoiBan);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(31, 751, 706, 2);
		contentPane.add(panel_3);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(733, 0, 4, 753);
		contentPane.add(panel_2_1);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(Color.BLACK);
		panel_2_1_1.setBounds(31, 0, 4, 753);
		contentPane.add(panel_2_1_1);

		JButton btnNewButton = new JButton("X");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnNewButton.setBounds(0, 0, 27, 21);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton){
					dispose();
				}
			}
		});
		contentPane.add(btnNewButton);

		setResizable(false);
		setVisible(true);
	}

	public void printTheInvoice(HoaDonDTO hd1, TaiKhoanDTO kh1, TaiKhoanDTO nb1) {
		HoaDonDTO hd = new HoaDonDTO();
		TaiKhoanDTO kh = new TaiKhoanDTO();
		hd = hd1;
		kh = kh1;
		txtSoHoaDon.setText("Số hóa đơn: " + hd.getSoHD());
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 5;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		txtKyHieu.setText("Ký hiệu: " + randomString);
		// Tạo một đối tượng java.sql.Date
		Date sqlDate = hd1.getNgaylap();

		// Chuyển đổi nó thành java.time.LocalDate
		LocalDate localDate = sqlDate.toLocalDate();

		// Lấy ngày, tháng, và năm
		int day = localDate.getDayOfMonth();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();

		txtNgayLap.setText("Ngày ..." + day + "...Tháng ..." + month + "...Năm  " + year + ".......");
		txtKhachHang.setText("Tên khách hàng: " + kh.getTenTK());
		txtSdt.setText("Số điện thoại: " + kh.getSdt());
		txtDiaChi.setText("Địa chỉ: " + kh.getDiachi());

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int i = 1;
		for (ChiTietHoaDonDTO chiTietHoaDon : cthd) {
			if (chiTietHoaDon.getSoHD().equals(hd.getSoHD())) {
				for (NuocGiaiKhatDTO nuocGiaiKhat : ngk) {
					if (chiTietHoaDon.getMaNGK().equals(nuocGiaiKhat.getMaNGK())) {
						model.addRow(new Object[] {
								i + "",
								nuocGiaiKhat.getTenNGK(),
								chiTietHoaDon.getSoluong() + "",
								nuocGiaiKhat.getGiaban() + "",
								chiTietHoaDon.getThanhtien() + ""
						});
						break;
					}
				}
				i++;
			}
		}
		txtTongGiaTri.setText("	TỔNG GIÁ TRỊ: " + hd.getTongtien());
		txtHoTenKhachHang.setText(kh.getTenTK());
		txtHoTenNguoiBan.setText(nb1.getTenTK());
	}
	
}

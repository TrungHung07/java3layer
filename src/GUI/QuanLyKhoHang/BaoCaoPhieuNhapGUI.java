package GUI.QuanLyKhoHang;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DATA.DTO.TaiKhoanDTO;

public class BaoCaoPhieuNhapGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel txtSoHoaDon;
	private JLabel txtNgayLap;
	private JLabel txtTenQLK;
	private JLabel txtSdtQLK;
	private JLabel txtChucVuQLK;
	private JLabel txtTongSP;
	private JLabel lblTenQLK;
	private JLabel lblTenNCC;
	private JLabel lblThoiGianThongKe;
	private JLabel txtTenNCC;
	private JLabel txtSdtNCC;
	private JLabel txtDiaChiNCC;
	private JLabel txtTongTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoPhieuNhapGUI frame = new BaoCaoPhieuNhapGUI();
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
	public BaoCaoPhieuNhapGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 761, 901);
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

		JLabel lblNewLabel = new JLabel("Báo cáo Nhập Kho");
		lblNewLabel.setBounds(178, 10, 371, 38);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		txtSoHoaDon = new JLabel("Mã số:");
		txtSoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSoHoaDon.setBounds(559, 10, 137, 26);
		panel.add(txtSoHoaDon);

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
		panel_1.setBounds(31, 166, 695, 161);
		panel_1.setOpaque(true);
		panel_1.setBackground(new Color(255, 255, 255, 0));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Đại diện Doanh Nghiệp");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(37, 10, 177, 35);
		panel_1.add(lblNewLabel_1);

		txtTenQLK = new JLabel("Tên Đại diện:");
		txtTenQLK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTenQLK.setBounds(37, 48, 267, 29);
		panel_1.add(txtTenQLK);

		txtSdtQLK = new JLabel("Số điện thoại:");
		txtSdtQLK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSdtQLK.setBounds(37, 87, 267, 29);
		panel_1.add(txtSdtQLK);

		txtChucVuQLK = new JLabel("Chức vụ:");
		txtChucVuQLK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtChucVuQLK.setBounds(37, 126, 267, 25);
		panel_1.add(txtChucVuQLK);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(Color.BLACK);
		panel_3_1_1.setBounds(181, 0, 365, 1);
		panel_1.add(panel_3_1_1);

		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setBounds(181, 154, 365, 1);
		panel_1.add(panel_3_1_1_1);
		panel_3_1_1_1.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đại diện bên Cung Cấp");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(398, 10, 177, 35);
		panel_1.add(lblNewLabel_1_1);
		
		txtTenNCC = new JLabel("Tên Đại diện:");
		txtTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTenNCC.setBounds(398, 48, 267, 29);
		panel_1.add(txtTenNCC);
		
		txtSdtNCC = new JLabel("Số điện thoại:");
		txtSdtNCC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSdtNCC.setBounds(398, 87, 267, 29);
		panel_1.add(txtSdtNCC);
		
		txtDiaChiNCC = new JLabel("Địa chỉ:");
		txtDiaChiNCC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDiaChiNCC.setBounds(398, 126, 267, 25);
		panel_1.add(txtDiaChiNCC);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(31, 330, 695, 235);
		panel_1_1.setOpaque(true);
		panel_1_1.setBackground(new Color(255, 255, 255, 0));
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 675, 231);
		panel_1_1.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"STT", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thanh tiền"
				}));
		scrollPane.setViewportView(table);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(41, 566, 685, 257);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);

		txtTongSP = new JLabel("Tổng sản phẩm:");
		txtTongSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTongSP.setBounds(10, 0, 171, 29);
		panel_1_2.add(txtTongSP);

		JLabel lblNewLabel_3 = new JLabel("Đại diện bên A");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(36, 79, 145, 26);
		panel_1_2.add(lblNewLabel_3);

		JLabel lblkngDu = new JLabel("(Ký, đóng dấu, nghi rõ họ tên)");
		lblkngDu.setHorizontalAlignment(SwingConstants.CENTER);
		lblkngDu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblkngDu.setBounds(499, 106, 156, 26);
		panel_1_2.add(lblkngDu);

		JLabel lblNewLabel_3_1 = new JLabel("Đại diện bên B");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(499, 78, 145, 26);
		panel_1_2.add(lblNewLabel_3_1);

		lblTenQLK = new JLabel("Bên A");
		lblTenQLK.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenQLK.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenQLK.setBounds(10, 207, 230, 29);
		panel_1_2.add(lblTenQLK);

		lblTenNCC = new JLabel("Bên B");
		lblTenNCC.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNCC.setBounds(434, 207, 238, 29);
		panel_1_2.add(lblTenNCC);
		
		JLabel lblBngCh = new JLabel("Ghi chú:");
		lblBngCh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBngCh.setBounds(10, 32, 51, 25);
		panel_1_2.add(lblBngCh);
		
		JLabel lblGhiChu = new JLabel("");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGhiChu.setBounds(71, 32, 614, 25);
		panel_1_2.add(lblGhiChu);
		
		JLabel lblkngDu_1 = new JLabel("(Ký, đóng dấu, nghi rõ họ tên)");
		lblkngDu_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblkngDu_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblkngDu_1.setBounds(25, 113, 156, 26);
		panel_1_2.add(lblkngDu_1);
		
		txtTongTien = new JLabel("Tổng giá trị:");
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTongTien.setBounds(191, 0, 171, 29);
		panel_1_2.add(txtTongTien);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(31, 833, 706, 2);
		contentPane.add(panel_3);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(733, 0, 4, 835);
		contentPane.add(panel_2_1);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(Color.BLACK);
		panel_2_1_1.setBounds(31, 0, 4, 835);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(41, 86, 685, 77);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblThoiGianThongKe = new JLabel("Từ ngày:................. Đến.....................................");
		lblThoiGianThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThoiGianThongKe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThoiGianThongKe.setBounds(10, 50, 665, 27);
		panel_2.add(lblThoiGianThongKe);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Báo cáo tình hình hoạt động nhập kho của cửa hàng");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(10, 5, 665, 35);
		panel_2.add(lblNewLabel_1_1_2);

		setResizable(false);
		setVisible(true);
	}

	/* public void taoBaoCao(List<InnerViewThongKePhieuNhap> dssp, TaiKhoanDTO kh, Date startDate, Date endDate){
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
		txtSoHoaDon.setText("Mã số: " + randomString);
		// Chuyển đổi nó thành java.time.LocalDate
		LocalDate localDate = LocalDate.now();

		// Lấy ngày, tháng, và năm
		int day = localDate.getDayOfMonth();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();

		txtNgayLap.setText("Ngày ..." + day + "...Tháng ..." + month + "...Năm  " + year + ".......");

		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String formattedStartDate = outputFormat.format(startDate);
        String formattedEndDate = outputFormat.format(endDate);
		lblThoiGianThongKe.setText("Từ ngày:.."+formattedStartDate+"...... Đến.."+formattedEndDate+"..........");

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		txtTenQLK.setText("Tên Đại diện: "+kh.getTenTK());
		txtSdtQLK.setText("Số điện thoại: "+kh.getSdt());
		if(kh.getRole().equals("quanlykho")){
			txtChucVuQLK.setText("Quản lý kho");
		}else if(kh.getRole().equals("giamdoc")){
			txtChucVuQLK.setText("Chức vụ: Giám đốc");
		}
		int tongSP =0;
		long tongGiaTri =0;
		for (InnerViewThongKePhieuNhap innerViewThongKePhieuNhap : dssp) {
			tongSP+= innerViewThongKePhieuNhap.getSoLuong();
			tongGiaTri+= innerViewThongKePhieuNhap.getThanhTien();
			model.addRow(new Object[]{
				innerViewThongKePhieuNhap.getStt(),
				innerViewThongKePhieuNhap.getTenSP(),
				innerViewThongKePhieuNhap.getSoLuong(),
				innerViewThongKePhieuNhap.getDonGia(),
				innerViewThongKePhieuNhap.getThanhTien()
			});
		}
		txtTongTien.setText("Tổng giá trị: "+tongGiaTri+"");
		txtTongSP.setText("Tổng sản phẩm: "+tongSP+"");
		lblTenQLK.setText(kh.getTenTK());
	} */
}

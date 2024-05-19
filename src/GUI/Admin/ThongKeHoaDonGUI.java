package GUI.Admin;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DATA.DAO.ChiTietHoaDonDAO;
import DATA.DAO.HoaDonDAO;
import DATA.DAO.NuocGiaiKhatDAO;
import DATA.DTO.ChiTietHoaDonDTO;
import DATA.DTO.HoaDonDTO;
import DATA.DTO.NuocGiaiKhatDTO;
import DATA.DTO.TaiKhoanDTO;
import GUI.Login;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class ThongKeHoaDonGUI extends JFrame {
	private NuocGiaiKhatDAO ngkDAO = new NuocGiaiKhatDAO();
	private List<NuocGiaiKhatDTO> ngk = new ArrayList<>(ngkDAO.getData());
	private HoaDonDAO phDAO = new HoaDonDAO();
	private List<HoaDonDTO> ph = new ArrayList<>(phDAO.getData());
	private ChiTietHoaDonDAO ctphDAO = new ChiTietHoaDonDAO();
	private List<ChiTietHoaDonDTO> ctph = new ArrayList<>(ctphDAO.getData());

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTuNgay;
	private JTextField txtDen;
	private JTextField txtNam;
	private JTable tableBangThongKe;
	private JTable tableHoaDon;
	private JButton btnLoc;
	private JTextArea txtYKien;
	private JButton btnQuayLai;
	private JLabel lblTongSpMua;
	private JLabel lblTongChi;
	private JLabel lblTongHoaDon;
	private JButton btnXuatBaoCao;
	private JComboBox<String> comboBox;

	/**
	 * Create the frame.
	 */
	public ThongKeHoaDonGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1100, 800);
		setTitle("Thống kê bán hàng");
		ImageIcon img = new ImageIcon("./src/img/icon_ThongKe.png");
		setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(164, 195, 178));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thống kê Bán hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 351, 76);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(10, 96, 673, 499);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblBngThngK_1 = new JLabel("Bảng thống kê:");
		lblBngThngK_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBngThngK_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBngThngK_1.setBounds(10, 20, 147, 48);
		panel.add(lblBngThngK_1);

		JLabel lblNewLabel_1 = new JLabel("Theo Quý:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(177, 10, 61, 25);
		panel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 653, 411);
		panel.add(scrollPane);

		panel.setOpaque(true);
		panel.setBackground(new Color(107, 144, 128));

		tableBangThongKe = new JTable();
		tableBangThongKe.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
				}));
		scrollPane.setViewportView(tableBangThongKe);

		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Chọn", "1", "2", "3", "4" }));
		comboBox.setBounds(248, 11, 71, 24);
		panel.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("Từ ngày:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(339, 10, 61, 25);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Đến ngày:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(339, 41, 61, 25);
		panel.add(lblNewLabel_2_1);

		txtTuNgay = new JTextField();
		txtTuNgay.setBounds(410, 10, 116, 25);
		panel.add(txtTuNgay);
		txtTuNgay.setColumns(10);

		txtDen = new JTextField();
		txtDen.setColumns(10);
		txtDen.setBounds(410, 38, 116, 25);
		panel.add(txtDen);

		JLabel lblNewLabel_1_1 = new JLabel("Năm:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(177, 45, 61, 25);
		panel.add(lblNewLabel_1_1);

		txtNam = new JTextField();
		txtNam.setBounds(248, 45, 71, 23);
		panel.add(txtNam);
		txtNam.setColumns(10);

		btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLoc.setBounds(546, 20, 93, 31);
		btnLoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				searchDate();
			}

		});
		panel.add(btnLoc);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(693, 96, 387, 499);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		panel_1.setOpaque(true);
		panel_1.setBackground(new Color(107, 144, 128));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 78, 362, 411);
		panel_1.add(scrollPane_1);

		tableHoaDon = new JTable();
		tableHoaDon.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã hóa đơn", "Ngày lập", "Tổng tiền"
				}));
		scrollPane_1.setViewportView(tableHoaDon);

		JLabel lblDanhSchPhiu = new JLabel("Danh sách hóa đơn");
		lblDanhSchPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchPhiu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDanhSchPhiu.setBounds(10, 10, 226, 48);
		panel_1.add(lblDanhSchPhiu);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 605, 1070, 158);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3_2 = new JLabel("Tổng thu:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_2.setBounds(10, 127, 141, 31);
		panel_2.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_1 = new JLabel("Tổng sản phẩm đã bán:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(10, 86, 141, 31);
		panel_2.add(lblNewLabel_3_1);

		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(107, 144, 128));

		JLabel lblNewLabel_3 = new JLabel("Tổng hóa đơn đã lập:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 46, 141, 31);
		panel_2.add(lblNewLabel_3);

		JLabel lblBngThngK_1_1 = new JLabel("Thông tin báo cáo");
		lblBngThngK_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBngThngK_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBngThngK_1_1.setBounds(10, 0, 141, 40);
		panel_2.add(lblBngThngK_1_1);

		JLabel lblNewLabel_3_3 = new JLabel("Ý kiến, Đánh giá:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_3.setBounds(299, 17, 99, 31);
		panel_2.add(lblNewLabel_3_3);

		txtYKien = new JTextArea();
		txtYKien.setLineWrap(true);
		txtYKien.setBounds(408, 20, 652, 80);
		panel_2.add(txtYKien);

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnQuayLai.setBounds(961, 117, 99, 31);
		btnQuayLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new QLCHGUI();
				dispose();
			}

		});
		panel_2.add(btnQuayLai);

		lblTongSpMua = new JLabel("");
		lblTongSpMua.setBounds(161, 76, 93, 32);
		panel_2.add(lblTongSpMua);

		lblTongChi = new JLabel("");
		lblTongChi.setBounds(161, 116, 93, 32);
		panel_2.add(lblTongChi);

		lblTongHoaDon = new JLabel("");
		lblTongHoaDon.setBounds(161, 36, 93, 32);
		panel_2.add(lblTongHoaDon);

		btnXuatBaoCao = new JButton("Xuất báo cáo");
		btnXuatBaoCao.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnXuatBaoCao.setBounds(828, 117, 99, 31);
		btnXuatBaoCao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				taoBaoCao();
			}

		});
		panel_2.add(btnXuatBaoCao);

		LocalDate currentDate = LocalDate.now();
		int yearNow = currentDate.getYear();

		String first = yearNow + "-01-31";
		String last = yearNow + "-12-31";
		Date firstDayOfYear = Date.valueOf(first);
		Date lastDayOfYear = Date.valueOf(last);

		getData(firstDayOfYear, lastDayOfYear);

		setVisible(true);
	}

	
	public void getData(Date startDate, Date endDate) {
		DefaultTableModel model = (DefaultTableModel) tableBangThongKe.getModel();
		DefaultTableModel modelHoaDon = (DefaultTableModel) tableHoaDon.getModel();
		model.setRowCount(0);
		modelHoaDon.setRowCount(0);
		int i = 0;
		int tongHoaDon = 0;
		int tongSPNhap = 0;
		long tongChiSP = 0;
		for (NuocGiaiKhatDTO nuocGiaiKhat : ngk) {
			int tongSP = 0;
			long tongChi = 0;
			for (HoaDonDTO HoaDon : ph) {
				Date date = Date.valueOf(HoaDon.getNgaylap() + "");
				// Sử dụng lớp Calendar để lấy năm từ đối tượng Date
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				if (HoaDon.getNgaylap().compareTo(startDate) > 0
						&& HoaDon.getNgaylap().compareTo(endDate) < 0) {
					for (ChiTietHoaDonDTO chiTietHoaDon : ctph) {
						if (chiTietHoaDon.getSoHD().equals(HoaDon.getSoHD())
								&& chiTietHoaDon.getMaNGK().equals(nuocGiaiKhat.getMaNGK())) {
							tongSP += chiTietHoaDon.getSoluong();
							tongChi += chiTietHoaDon.getThanhtien();
							break;
						}
					}

				}
			}
			double donGia = tongSP != 0 ? (double) tongChi / tongSP : 0;
			double roundedNumber = Math.round(donGia * 100.0) / 100.0;
			i++;
			tongSPNhap += tongSP;
			tongChiSP += tongChi;
			if (tongSP > 0) {
				model.addRow(new Object[] {
						i,
						nuocGiaiKhat.getMaNGK(),
						nuocGiaiKhat.getTenNGK(),
						tongSP,
						roundedNumber,
						tongChi
				});
			}

		}
		for (HoaDonDTO HoaDon : ph) {
			Date date = Date.valueOf(HoaDon.getNgaylap() + "");
			// Sử dụng lớp Calendar để lấy năm từ đối tượng Date
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			if (HoaDon.getNgaylap().compareTo(startDate) > 0 && HoaDon.getNgaylap().compareTo(endDate) < 0) {
				tongHoaDon++;
				modelHoaDon.addRow(new Object[] {
					HoaDon.getSoHD(),
					HoaDon.getNgaylap(),
					HoaDon.getTongtien(),
					HoaDon.getMoTa()
				});
			}

		}
		lblTongHoaDon.setText(tongHoaDon + "");
		lblTongSpMua.setText(tongSPNhap + "");
		lblTongChi.setText(tongChiSP + "");
		txtYKien.setText("");
	}

	public void searchDate() {
		String selectType = (String) comboBox.getSelectedItem();
		String nam = txtNam.getText();
		String tuNgay = txtTuNgay.getText();
		String denNgay = txtDen.getText();
		if (selectType.equals("Chọn") && nam.equals("") && tuNgay.equals("") && denNgay.equals("")) {
			JOptionPane.showMessageDialog(null, "Hãy nhập thông tin tìm kiếm");
			return;
		}
		if (!selectType.equals("Chọn")) {
			if (!nam.equals("")) {
				int quarter = Integer.valueOf(selectType);
				int year = Integer.valueOf(nam);
				Date[] quarterDates = getQuarterDates(year, quarter);
				getData(quarterDates[0], quarterDates[1]);
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ Quý và Năm");
				return;
			}
		} else {
		}
		if (!tuNgay.equals("") && !denNgay.equals("")) {
			if (isValidDateFormat(tuNgay) && isValidDateFormat(denNgay)) {
				Date startDate = Date.valueOf(tuNgay);
				Date endDate = Date.valueOf(denNgay);
				getData(startDate, endDate);
			} else {
				JOptionPane.showMessageDialog(null, "Định dạng ngày YYYY-MM-DD");
				return;
			}
		} else {
		}
	}

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

	public Date[] getQuarterDates(int year, int quarter) {
		// Tạo một đối tượng Calendar và đặt năm
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);

		// Đặt tháng và ngày đầu tiên của Chọn
		int month = (quarter - 1) * 3; // Tháng đầu tiên của Chọn
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDayOfQuarter = new Date(calendar.getTimeInMillis());

		// Đặt tháng và ngày cuối cùng của quý
		calendar.add(Calendar.MONTH, 3); // Thêm 3 tháng để lùi về cuối quý
		calendar.add(Calendar.DATE, -1); // Trừ đi 1 ngày để lấy ngày cuối cùng của quý
		Date lastDayOfQuarter = new Date(calendar.getTimeInMillis());

		// Trả về mảng chứa ngày đầu tiên và ngày cuối cùng của quý
		return new Date[] { firstDayOfQuarter, lastDayOfQuarter };
	}

	public void taoBaoCao() {
		TaiKhoanDTO kh = new TaiKhoanDTO();
		if (Login.getObject() instanceof TaiKhoanDTO) {

			kh = (TaiKhoanDTO) Login.getObject();
		}
		List<InnerViewThongKeHoaDon> dssp = new ArrayList<>();
		DefaultTableModel model = (DefaultTableModel) tableBangThongKe.getModel();
		DefaultTableModel modelHoaDon = (DefaultTableModel) tableHoaDon.getModel();
		int countRowPH = modelHoaDon.getRowCount();
		Date startDate = Date.valueOf(modelHoaDon.getValueAt(0, 1) + "");
		Date endDate = Date.valueOf(modelHoaDon.getValueAt(countRowPH - 1, 1) + "");
		int countRow = model.getRowCount();
		for (int i = 0; i < countRow; i++) {
			int stt = Integer.valueOf(model.getValueAt(i, 0) + "");
			String tenSP = model.getValueAt(i, 2) + "";
			int soLuong = Integer.valueOf(model.getValueAt(i, 3) + "");
			float donGia = Float.valueOf(model.getValueAt(i, 4) + "");
			long thanhTien = Long.valueOf(model.getValueAt(i, 5) + "");
			InnerViewThongKeHoaDon inp = new InnerViewThongKeHoaDon(stt, tenSP, soLuong, donGia, thanhTien);
			dssp.add(inp);
		}
		String yKien = txtYKien.getText();
		new FormBaoCaoDoanhThu().taoBaoCao(dssp, kh, startDate, endDate, yKien);
	}

	public static class InnerViewThongKeHoaDon {
		private int stt;
		private String tenSP;
		private int soLuong;
		private float donGia;
		private long thanhTien;

		public InnerViewThongKeHoaDon() {
		}

		public InnerViewThongKeHoaDon(int stt, String tenSP, int soLuong, float donGia, long thanhTien) {
			this.stt = stt;
			this.tenSP = tenSP;
			this.soLuong = soLuong;
			this.donGia = donGia;
			this.thanhTien = thanhTien;
		}

		public int getStt() {
			return stt;
		}

		public void setStt(int stt) {
			this.stt = stt;
		}

		public String getTenSP() {
			return tenSP;
		}

		public void setTenSP(String tenSP) {
			this.tenSP = tenSP;
		}

		public int getSoLuong() {
			return soLuong;
		}

		public void setSoLuong(int soLuong) {
			this.soLuong = soLuong;
		}

		public float getDonGia() {
			return donGia;
		}

		public void setDonGia(float donGia) {
			this.donGia = donGia;
		}

		public long getThanhTien() {
			return thanhTien;
		}

		public void setThanhTien(long thanhTien) {
			this.thanhTien = thanhTien;
		}

		@Override
		public String toString() {
			return "InnerViewThongKeHoaDon [stt=" + stt + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", donGia="
					+ donGia + ", thanhTien=" + thanhTien + "]";
		}

	}

}
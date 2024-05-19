package GUI.QuanLyKhoHang;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.PhieuNhapBUS;
import DATA.DAO.ChiTietPhieuNhapDAO;
import DATA.DAO.NhaCungCapDAO;
import DATA.DAO.NuocGiaiKhatDAO;
import DATA.DAO.PhieuNhapDAO;
import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.ChiTietPhieuNhapDTO;
import DATA.DTO.NhaCungCapDTO;
import DATA.DTO.PhieuNhapDTO;
import DATA.DTO.TaiKhoanDTO;
import controller.PhieuNhapController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PhieuNhapGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table_DanhSach;
	public JTable table_ChiTiet;
	private JTextField txt_TK_MaPhieu;
	private JTextField txt_TK_NgayLap;
	private JTextField txt_TK_NgayBD;
	private JTextField txt_TK_NgayKT;
	private JTextField txt_TK_MaNCC;
	private JTextField txt_TK_MaNV;

	private JTextField txt_TTCT_MaPhieu;
	private JTextField txt_TTCT_MaNV;
	private JTextField txt_TTCT_NgayLap;
	private JTextField txt_TTCT_MaNCC;
	private JTextField txt_TTCT_MaSP;
	private JTextField txt_TTCT_SoLuong;
	private JTextField txt_TTCT_DonGia;

	public JButton btn_TimKiem = new JButton("Tìm kiếm");
	public JButton btn_Huy_TK = new JButton("Hủy");
	public JButton btn_Them = new JButton("THÊM");
	public JButton btn_Sua = new JButton("SỬA");
	public JButton btn_Xoa = new JButton("XÓA");
	public JButton btn_TroVe = new JButton("Trở Về");

	private PhieuNhapDAO dspn = new PhieuNhapDAO();
	private List<PhieuNhapDTO> pn = new ArrayList<>();
	private ChiTietPhieuNhapDAO dsctpn = new ChiTietPhieuNhapDAO();
	private List<ChiTietPhieuNhapDTO> ctpn = new ArrayList<>();
	private NuocGiaiKhatDAO dssp = new NuocGiaiKhatDAO();
	private TaiKhoanDAO tkDAO = new TaiKhoanDAO();
	private List<TaiKhoanDTO> tk = new ArrayList<>(tkDAO.getData());
	private NhaCungCapDAO nccDAO = new NhaCungCapDAO();
	private List<NhaCungCapDTO> ncc = new ArrayList<>(nccDAO.getData());
	private PhieuNhapBUS pnBUS = new PhieuNhapBUS();
	private JTextField txt_TTCT_ThanhTienHienThi;

	/**
	 * Create the frame.
	 */
	public PhieuNhapGUI() {
		setTitle("Phiếu Nhâp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 566);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 204, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 192, 24);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lb_DSPN = new JLabel("Danh sách phiếu nhâp");
		lb_DSPN.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_DSPN.setBounds(10, 0, 176, 20);
		panel.add(lb_DSPN);

		panel.setBackground(new Color(171, 196, 255));

		table_DanhSach = new JTable();
		table_DanhSach.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã", "Ngày Lập", "Mã NV", "Mã NCC", "Tổng Tiền"
				}));
		JScrollPane scrollPane = new JScrollPane(table_DanhSach);
		scrollPane.setBounds(0, 25, 460, 235);
		contentPane.add(scrollPane);

		table_ChiTiet = new JTable();
		table_ChiTiet.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã", "Mã SP", "Số Lượng", "Đơn Giá", "Thành Tiền"
				}));
		JScrollPane scrollPane_1 = new JScrollPane(table_ChiTiet);
		scrollPane_1.setBounds(0, 300, 460, 187);
		contentPane.add(scrollPane_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(470, 0, 304, 32);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lb_TimKiem = new JLabel("Tìm Kiếm:");
		lb_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_TimKiem.setBounds(0, 0, 89, 32);
		panel_3.add(lb_TimKiem);

		panel_3.setBackground(new Color(171, 196, 255));

		btn_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_TimKiem.setBounds(81, 7, 107, 23);
		panel_3.add(btn_TimKiem);

		panel_3.setBackground(new Color(171, 196, 255));

		btn_Huy_TK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Huy_TK.setBounds(198, 7, 96, 23);
		panel_3.add(btn_Huy_TK);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(470, 53, 325, 187);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		txt_TK_MaPhieu = new JTextField();
		txt_TK_MaPhieu.setBounds(68, 1, 76, 17);
		panel_5.add(txt_TK_MaPhieu);
		txt_TK_MaPhieu.setColumns(10);

		JLabel lb_TTTK_MaPhieu = new JLabel("Mã Phiếu:");
		lb_TTTK_MaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTTK_MaPhieu.setBounds(0, 2, 76, 14);
		panel_5.add(lb_TTTK_MaPhieu);

		JLabel lb_TTTK_NgayLap = new JLabel("Ngày lập:");
		lb_TTTK_NgayLap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTTK_NgayLap.setBounds(0, 30, 66, 14);
		panel_5.add(lb_TTTK_NgayLap);

		panel_5.setBackground(new Color(171, 196, 255));

		txt_TK_NgayLap = new JTextField();
		txt_TK_NgayLap.setColumns(10);
		txt_TK_NgayLap.setBounds(68, 29, 76, 17);
		panel_5.add(txt_TK_NgayLap);

		JLabel lb_TTTK_NgayBatDau = new JLabel("Ngày bắt đầu:");
		lb_TTTK_NgayBatDau.setBounds(0, 65, 76, 14);
		panel_5.add(lb_TTTK_NgayBatDau);

		JLabel lb_TTTK_NgayKetThuc = new JLabel("Ngày kết thúc:");
		lb_TTTK_NgayKetThuc.setBounds(129, 65, 86, 14);
		panel_5.add(lb_TTTK_NgayKetThuc);

		txt_TK_NgayBD = new JTextField();
		txt_TK_NgayBD.setBounds(0, 90, 86, 20);
		panel_5.add(txt_TK_NgayBD);
		txt_TK_NgayBD.setColumns(10);

		txt_TK_NgayKT = new JTextField();
		txt_TK_NgayKT.setColumns(10);
		txt_TK_NgayKT.setBounds(129, 90, 86, 20);
		panel_5.add(txt_TK_NgayKT);

		JLabel lb_TTTK_MaNV = new JLabel("Mã NV:");
		lb_TTTK_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTTK_MaNV.setBounds(154, 2, 46, 14);
		panel_5.add(lb_TTTK_MaNV);

		JLabel lb_TTTK_MaNCC = new JLabel("Mã NCC:");
		lb_TTTK_MaNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTTK_MaNCC.setBounds(154, 30, 61, 14);
		panel_5.add(lb_TTTK_MaNCC);

		txt_TK_MaNCC = new JTextField();
		txt_TK_MaNCC.setColumns(10);
		txt_TK_MaNCC.setBounds(221, 28, 73, 17);
		panel_5.add(txt_TK_MaNCC);

		txt_TK_MaNV = new JTextField();
		txt_TK_MaNV.setColumns(10);
		txt_TK_MaNV.setBounds(221, 0, 73, 17);
		panel_5.add(txt_TK_MaNV);

		JLabel lb_Dau = new JLabel(" -");
		lb_Dau.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_Dau.setBounds(96, 89, 21, 14);
		panel_5.add(lb_Dau);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBounds(470, 300, 325, 139);
		contentPane.add(panel_6_1);
		panel_6_1.setLayout(null);

		JLabel lb_TTCT_MaPhieu = new JLabel("Mã Phiếu:");
		lb_TTCT_MaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_MaPhieu.setBounds(0, 0, 60, 26);
		panel_6_1.add(lb_TTCT_MaPhieu);

		JLabel lb_TTCT_MaNV = new JLabel("Mã NV:");
		lb_TTCT_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_MaNV.setBounds(0, 27, 60, 26);
		panel_6_1.add(lb_TTCT_MaNV);

		JLabel lb_TTCT_NgayLap = new JLabel("Ngày Lập:");
		lb_TTCT_NgayLap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_NgayLap.setBounds(161, 0, 60, 26);
		panel_6_1.add(lb_TTCT_NgayLap);

		JLabel lb_TTCT_MaNCC = new JLabel("Mã NCC:");
		lb_TTCT_MaNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_MaNCC.setBounds(161, 27, 60, 26);
		panel_6_1.add(lb_TTCT_MaNCC);

		txt_TTCT_MaPhieu = new JTextField();
		txt_TTCT_MaPhieu.setBounds(54, 4, 86, 20);
		panel_6_1.add(txt_TTCT_MaPhieu);
		txt_TTCT_MaPhieu.setColumns(10);

		txt_TTCT_MaNV = new JTextField();
		txt_TTCT_MaNV.setColumns(10);
		txt_TTCT_MaNV.setBounds(54, 31, 86, 20);
		panel_6_1.add(txt_TTCT_MaNV);

		txt_TTCT_NgayLap = new JTextField();
		txt_TTCT_NgayLap.setColumns(10);
		txt_TTCT_NgayLap.setBounds(218, 4, 89, 20);
		txt_TTCT_NgayLap.setEditable(false);
		LocalDate currDate = LocalDate.now();
		Date newDate = Date.valueOf(currDate);
		txt_TTCT_NgayLap.setText(newDate.toString());
		panel_6_1.add(txt_TTCT_NgayLap);

		txt_TTCT_MaNCC = new JTextField();
		txt_TTCT_MaNCC.setColumns(10);
		txt_TTCT_MaNCC.setBounds(218, 31, 89, 20);
		panel_6_1.add(txt_TTCT_MaNCC);

		JLabel lb_TTCT_MaSP = new JLabel("Mã SP:");
		lb_TTCT_MaSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_MaSP.setBounds(0, 60, 60, 26);
		panel_6_1.add(lb_TTCT_MaSP);

		txt_TTCT_MaSP = new JTextField();
		txt_TTCT_MaSP.setColumns(10);
		txt_TTCT_MaSP.setBounds(54, 64, 86, 20);
		panel_6_1.add(txt_TTCT_MaSP);

		JLabel lb_TTCT_SoLuong = new JLabel("Số Lượng:");
		lb_TTCT_SoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_SoLuong.setBounds(161, 60, 60, 26);
		panel_6_1.add(lb_TTCT_SoLuong);
		panel_6_1.setBackground(new Color(171, 196, 255));

		txt_TTCT_SoLuong = new JTextField();
		txt_TTCT_SoLuong.setColumns(10);
		txt_TTCT_SoLuong.setBounds(218, 64, 89, 20);
		panel_6_1.add(txt_TTCT_SoLuong);

		JLabel lb_TTCT_DonGia = new JLabel("Đơn Giá:");
		lb_TTCT_DonGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_DonGia.setBounds(0, 97, 60, 26);
		panel_6_1.add(lb_TTCT_DonGia);

		JLabel lb_TTCT_ThanhTien = new JLabel("Thành Tiền:");
		lb_TTCT_ThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TTCT_ThanhTien.setBounds(161, 97, 70, 26);
		panel_6_1.add(lb_TTCT_ThanhTien);

		txt_TTCT_DonGia = new JTextField();
		txt_TTCT_DonGia.setColumns(10);
		txt_TTCT_DonGia.setBounds(54, 101, 86, 20);
		panel_6_1.add(txt_TTCT_DonGia);

		txt_TTCT_ThanhTienHienThi = new JTextField();
		txt_TTCT_ThanhTienHienThi.setBounds(228, 97, 79, 20);
		panel_6_1.add(txt_TTCT_ThanhTienHienThi);
		txt_TTCT_ThanhTienHienThi.setColumns(10);
		txt_TTCT_ThanhTienHienThi.setEditable(false);

		btn_TroVe.setBounds(0, 493, 84, 32);
		contentPane.add(btn_TroVe);
		btn_TroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_TroVe.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lb_TTTK = new JLabel("Thông tin tìm kiếm:");
		lb_TTTK.setBounds(470, 28, 120, 21);
		contentPane.add(lb_TTTK);
		lb_TTTK.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lb_CTPN = new JLabel("Chi tiết phiếu nhập");
		lb_CTPN.setBounds(10, 271, 150, 19);
		contentPane.add(lb_CTPN);
		lb_CTPN.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lb_TTCT = new JLabel("Thông tin chi tiết");
		lb_TTCT.setBounds(470, 268, 228, 25);
		contentPane.add(lb_TTCT);
		lb_TTCT.setFont(new Font("Tahoma", Font.BOLD, 15));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(470, 438, 325, 89);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btn_Them.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_Them.setBounds(10, 11, 89, 37);
		panel_1.add(btn_Them);

		btn_Sua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Sua.setBounds(117, 11, 89, 37);
		panel_1.add(btn_Sua);

		btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Xoa.setBounds(223, 11, 89, 37);
		panel_1.add(btn_Xoa);

		ActionListener act = new PhieuNhapController(this);
		btn_Huy_TK.addActionListener(act);
		btn_Sua.addActionListener(act);
		btn_Them.addActionListener(act);
		btn_TimKiem.addActionListener(act);
		btn_TroVe.addActionListener(act);
		btn_Xoa.addActionListener(act);

		MouseListener mol = new PhieuNhapController(this);
		table_DanhSach.addMouseListener(mol);
		table_ChiTiet.addMouseListener(mol);

		getData(pnBUS.getDataPnDAO());
		setVisible(true);
	}

	public void comeBack() {
		this.setVisible(false);
		new QLKHGUI().openMenu();
	}

	public void getData(List<PhieuNhapDTO> data) {
		DefaultTableModel model_PhieuNhap = (DefaultTableModel) table_DanhSach.getModel();
		DefaultTableModel model_ChiTiet = (DefaultTableModel) table_ChiTiet.getModel();
		model_PhieuNhap.setRowCount(0); // Xóa tất cả các hàng trước khi điền dữ liệu mới
		model_ChiTiet.setRowCount(0);
		for (PhieuNhapDTO phieuNhap : data) {
			model_PhieuNhap.addRow(new Object[] {
					phieuNhap.getMaPN() + "",
					phieuNhap.getNgayNhap(),
					phieuNhap.getMaNN() + "",
					phieuNhap.getMaNCC() + "",
					phieuNhap.getTongTien() + ""
			});
		}
	}

	public void getDataSelectRowTable(List<ChiTietPhieuNhapDTO> data) {
		txt_TTCT_MaSP.setText("");
		txt_TTCT_SoLuong.setText("");
		txt_TTCT_DonGia.setText("");
		txt_TTCT_ThanhTienHienThi.setText("");
		DefaultTableModel model_phieuNhap = (DefaultTableModel) table_DanhSach.getModel();
		DefaultTableModel model_chiTietPhieuNhap = (DefaultTableModel) table_ChiTiet.getModel();
		model_chiTietPhieuNhap.setRowCount(0);
		int i_row = table_DanhSach.getSelectedRow();
		String soPN = model_phieuNhap.getValueAt(i_row, 0) + "";
		for (ChiTietPhieuNhapDTO chiTietPhieuNhap : data) {
			if (chiTietPhieuNhap.getMaPN().equals(soPN)) {
				model_chiTietPhieuNhap.addRow(new Object[] {
						soPN,
						chiTietPhieuNhap.getMaSP() + "",
						chiTietPhieuNhap.getSoLuong() + "",
						chiTietPhieuNhap.getDonGia() + "",
						chiTietPhieuNhap.getThanhTien() + ""
				});
			}
		}
		txt_TTCT_MaPhieu.setText(soPN);
		txt_TTCT_NgayLap.setText(model_phieuNhap.getValueAt(i_row, 1) + "");
		txt_TTCT_MaNV.setText(model_phieuNhap.getValueAt(i_row, 2) + "");
		txt_TTCT_MaNCC.setText(model_phieuNhap.getValueAt(i_row, 3) + "");
	}

	public void setTxtFormTable() {
		DefaultTableModel modelChiTietPhieuNhap = (DefaultTableModel) table_ChiTiet.getModel();
		int i_row = table_ChiTiet.getSelectedRow();
		if (i_row != -1) {
			txt_TTCT_MaSP.setText(modelChiTietPhieuNhap.getValueAt(i_row, 1) + "");
			txt_TTCT_SoLuong.setText(modelChiTietPhieuNhap.getValueAt(i_row, 2) + "");
			txt_TTCT_DonGia.setText(modelChiTietPhieuNhap.getValueAt(i_row, 3) + "");
			int temp_SL = Integer.parseInt(txt_TTCT_SoLuong.getText());
			long temp_donGia = Long.parseLong(txt_TTCT_DonGia.getText());
			txt_TTCT_ThanhTienHienThi.setText((temp_SL * temp_donGia) + "");

		}
	}

	public void clearTxt() {
		txt_TTCT_MaPhieu.setText("");
		txt_TTCT_MaNV.setText("");
		txt_TTCT_MaNCC.setText("");
		txt_TTCT_MaSP.setText("");
		txt_TTCT_SoLuong.setText("");
		txt_TTCT_DonGia.setText("");
		txt_TTCT_ThanhTienHienThi.setText("");
		LocalDate currDate = LocalDate.now();
		Date newDate = Date.valueOf(currDate);
		txt_TTCT_NgayLap.setText(newDate.toString());

		txt_TK_MaNCC.setText("");
		txt_TK_MaNV.setText("");
		txt_TK_MaPhieu.setText("");
		txt_TK_NgayBD.setText("");
		txt_TK_NgayKT.setText("");
		txt_TK_NgayLap.setText("");
	}

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

	// Method to get the value of a field based on its name
    public String getFieldValue(String fieldName) {
        switch (fieldName) {
            case "txt_TK_MaPhieu":
                return txt_TK_MaPhieu.getText();
            case "txt_TK_NgayLap":
                return txt_TK_NgayLap.getText();
            case "txt_TK_NgayBD":
                return txt_TK_NgayBD.getText();
            case "txt_TK_NgayKT":
                return txt_TK_NgayKT.getText();
            case "txt_TK_MaNCC":
                return txt_TK_MaNCC.getText();
            case "txt_TK_MaNV":
                return txt_TK_MaNV.getText();
            case "txt_TTCT_MaPhieu":
                return txt_TTCT_MaPhieu.getText();
            case "txt_TTCT_MaNV":
                return txt_TTCT_MaNV.getText();
            case "txt_TTCT_NgayLap":
                return txt_TTCT_NgayLap.getText();
            case "txt_TTCT_MaNCC":
                return txt_TTCT_MaNCC.getText();
            case "txt_TTCT_MaSP":
                return txt_TTCT_MaSP.getText();
            case "txt_TTCT_SoLuong":
                return txt_TTCT_SoLuong.getText();
            case "txt_TTCT_DonGia":
                return txt_TTCT_DonGia.getText();
            default:
                return "";
        }
    }

    // Method to set the value of a field based on its name
    public void setFieldValue(String fieldName, String value) {
        switch (fieldName) {
            case "txt_TK_MaPhieu":
                txt_TK_MaPhieu.setText(value);
                break;
            case "txt_TK_NgayLap":
                txt_TK_NgayLap.setText(value);
                break;
            case "txt_TK_NgayBD":
                txt_TK_NgayBD.setText(value);
                break;
            case "txt_TK_NgayKT":
                txt_TK_NgayKT.setText(value);
                break;
            case "txt_TK_MaNCC":
                txt_TK_MaNCC.setText(value);
                break;
            case "txt_TK_MaNV":
                txt_TK_MaNV.setText(value);
                break;
            case "txt_TTCT_MaPhieu":
                txt_TTCT_MaPhieu.setText(value);
                break;
            case "txt_TTCT_MaNV":
                txt_TTCT_MaNV.setText(value);
                break;
            case "txt_TTCT_NgayLap":
                txt_TTCT_NgayLap.setText(value);
                break;
            case "txt_TTCT_MaNCC":
                txt_TTCT_MaNCC.setText(value);
                break;
            case "txt_TTCT_MaSP":
                txt_TTCT_MaSP.setText(value);
                break;
            case "txt_TTCT_SoLuong":
                txt_TTCT_SoLuong.setText(value);
                break;
            case "txt_TTCT_DonGia":
                txt_TTCT_DonGia.setText(value);
                break;
        }
    }

	//Messages
	public void errorMessage(String message){
		JOptionPane.showMessageDialog(null, message, "Thông Báo", JOptionPane.WARNING_MESSAGE);
	}
	public void successMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
    }
	public int confirmMessage(String message){
		return JOptionPane.showConfirmDialog(null, message, "Thông Báo", JOptionPane.YES_NO_OPTION);
	}

	// Sự Kiến Nút Xóa
	public void deleteData() {
		int selectedRow_DanhSach = table_DanhSach.getSelectedRow();
		int selectedRow_ChiTiet = table_ChiTiet.getSelectedRow();
		boolean checkDel = false;
		if (selectedRow_DanhSach == -1 && selectedRow_ChiTiet == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một phiếu nhập hoặc một chi tiết phiếu nhập để xóa.");
		} else if (selectedRow_DanhSach != -1 && selectedRow_ChiTiet == -1) {
			int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phiếu nhập này?",
					"Xác nhận xóa", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				// Lấy mã phiếu nhập từ hàng được chọn trong table_DanhSach
				String maPN = (table_DanhSach.getValueAt(selectedRow_DanhSach, 0) + ""); // (int)
																							// table_DanhSach.getValueAt(selectedRow_DanhSach,
																							// 0);
				// Thực hiện xóa phiếu nhập
				dspn.deleteData(maPN);
				checkDel = true;


				if (checkDel == true) {
					JOptionPane.showMessageDialog(null, "Đã Xóa Thành Công", "Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa Không Thành Công", "Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else if (selectedRow_DanhSach != -1 && selectedRow_ChiTiet != -1) {
			int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa chi tiết phiếu nhập này?",
					"Xác nhận xóa", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				// Lấy mã phiếu nhập từ hàng được chọn trong table_DanhSach
				String maPN = (table_DanhSach.getValueAt(selectedRow_DanhSach, 0) + "");
				// Lấy mã sản phẩm từ hàng được chọn trong table_ChiTiet
				String maSP = (table_ChiTiet.getValueAt(selectedRow_ChiTiet, 1) + "");
				// int soLuong = Integer.valueOf(table_ChiTiet.getValueAt(selectedRow_ChiTiet,
				// 0) + "");
				// Thực hiện xóa chi tiết phiếu nhập
				dsctpn.deleteChiTietPhieuNhap(maPN, maSP);
				checkDel = true;
				dspn.updatePrice(maPN);
				if (checkDel == true) {
					JOptionPane.showMessageDialog(null, "Đã Xóa Thành Công", "Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa Không Thành Công", "Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		//getData();
		clearTxt();
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

	// Kiểm tra mã quản lý kho có tồn tại hay không
	public boolean checkPosition(String maCheck) {
		if (maCheck.startsWith("ql")) {
			for (TaiKhoanDTO tK : tk) {
				if (tK.getRole().equals("quanlykho")) {
					if (maCheck.equals(tK.getMa())) {
						return true;
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Mã nhân viên quản lý kho không tồn tại!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (maCheck.startsWith("ncc")) {
			for (NhaCungCapDTO ncc : ncc) {
				if (ncc.getMaNCC().equals(maCheck)) {
					return true;
				}
			}
			JOptionPane.showMessageDialog(null, "Mã nhà cung cấp không tồn tại!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return false;
	}
}

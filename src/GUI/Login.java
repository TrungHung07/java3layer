//Hoan thanh
package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATA.DAO.TaiKhoanDAO;
import DATA.DTO.TaiKhoanDTO;
// import GUI.Admin.AdminGUI;
import GUI.Admin.QLCHGUI;
import GUI.Customer.CustomerGUI;
import GUI.QuanLyKhoHang.QLKHGUI;
import controller.LoginController;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JFrame {
	private static Object obj = null;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	public JButton btnLogin;

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 399);
		ImageIcon img = new ImageIcon("./src/img/Settings.png");
		setIconImage(img.getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel login = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;

				// Tạo màu gradient từ đỏ đến xanh dương
				GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK, getWidth(), getHeight(), Color.WHITE);

				// Sử dụng màu gradient để vẽ nền của JPanel
				g2d.setPaint(gradient);
				g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};

		ActionListener atc = new LoginController(this);

		login.setBackground(new Color(255, 255, 255, 100));
		login.setBounds(0, 0, 400, 358);
		contentPane.add(login);
		login.setLayout(null);

		JPanel login_panel1 = new JPanel();
		login_panel1.setBackground(new Color(255, 255, 255, 100));
		login_panel1.setBounds(0, 0, 400, 94);
		login.add(login_panel1);
		login_panel1.setLayout(null);

		JLabel lblNewLabel = new JLabel("CHÀO MỪNG TRỞ LẠI");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(43, 10, 314, 74);
		login_panel1.add(lblNewLabel);

		JPanel login_panel3 = new JPanel();
		login_panel3.setBackground(new Color(255, 255, 255, 100));
		login_panel3.setBounds(0, 93, 400, 150);
		login.add(login_panel3);
		login_panel3.setLayout(null);

		JPanel panel_user = new JPanel();
		panel_user.setBackground(new Color(255, 255, 255, 0));
		panel_user.setBounds(58, 0, 285, 63);
		login_panel3.add(panel_user);
		panel_user.setLayout(null);

		JLabel username_text = new JLabel("Tên tài khoản hoặc địa chỉ Email");
		username_text.setForeground(new Color(0, 0, 0));
		username_text.setBackground(new Color(255, 255, 255, 0));
		username_text.setBounds(0, 0, 285, 31);
		username_text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_user.add(username_text);

		username = new JTextField();
		username.setBounds(0, 31, 285, 31);
		panel_user.add(username);
		username.setColumns(10);

		JPanel panel_pass = new JPanel();
		panel_pass.setBackground(new Color(255, 255, 255, 0));
		panel_pass.setBounds(58, 66, 285, 63);
		login_panel3.add(panel_pass);
		panel_pass.setLayout(null);

		JLabel password_text = new JLabel("Mật khẩu");
		password_text.setForeground(new Color(0, 0, 0));
		password_text.setBackground(new Color(255, 255, 255, 0));
		password_text.setBounds(0, 0, 285, 31);
		password_text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_pass.add(password_text);

		password = new JPasswordField();
		password.setBounds(0, 31, 285, 31);
		panel_pass.add(password);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255, 100));
		panel_4.setBounds(0, 242, 400, 116);
		login.add(panel_4);
		panel_4.setLayout(null);

		btnLogin = new JButton("Đăng nhập");
		btnLogin.setBounds(113, 10, 174, 34);
		btnLogin.addActionListener(atc);

		btnLogin.setFocusable(true);
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					setVisible(false);
					new QLCHGUI();
				}
			}
		});
		panel_4.add(btnLogin);

		JLabel signup = new JLabel("Tạo Tài Khoản");
		signup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		signup.setForeground(Color.BLACK);
		signup.setForeground(new Color(0, 0, 255));
		signup.setBackground(new Color(240, 240, 240));
		signup.setHorizontalAlignment(SwingConstants.CENTER);
		signup.setBounds(89, 49, 102, 22);
		signup.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				return;

			}

			@Override
			public void mousePressed(MouseEvent e) {
				return;

			}

			@Override
			public void mouseExited(MouseEvent e) {
				return;

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				return;

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new Register();
				dispose();
			}
		});
		panel_4.add(signup);

		JLabel forgot_password = new JLabel("Quên mật khẩu");
		forgot_password.setBounds(208, 54, 93, 13);
		panel_4.add(forgot_password);
		forgot_password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		forgot_password.setForeground(Color.BLACK);
		forgot_password.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				return;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				return;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				return;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				return;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Tính năng đang được cập nhật", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JPanel background = new JPanel();
		background.setBackground(new Color(255, 255, 255, 100));
		background.setBounds(401, 0, 303, 358);
		contentPane.add(background);
		background.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3
				.setIcon(new ImageIcon("./src/img/LogoLogin.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(23, 48, 250, 250);
		background.add(lblNewLabel_3);
		setVisible(true);
	}

	// set True tu Frame khac
	public void openFrame() {
		this.setVisible(true);
	}

	//GETTER && SETTER
	public String getUsername() {
        return username.getText(); // Trả về nội dung của trường username
    }

    public String getPassword() {
        return String.valueOf(password.getPassword()); // Trả về nội dung của trường password
    }

	public void error(String message) {
		JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.ERROR_MESSAGE);
	}

	public void openUser(){
		new CustomerGUI();
		this.dispose();
	}
	public void openSaler(){
		new QLCHGUI();
		this.dispose();
	}
	public void openAdministrator(){
		new QLKHGUI();
		this.dispose();
	}
	// public void openAdmin(){
	// 	new AdminGUI();
	// 	this.dispose();
	// }

	public static Object getObject() {
		return obj;
	}

	public static void setObject(Object object) {
		obj = object;
	}

}

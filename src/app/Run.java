package app;

import javax.swing.UIManager;

import GUI.Login;

import GUI.Admin.GioHangGUI;
import GUI.Admin.QLCHGUI;
import GUI.QuanLyKhoHang.NhaCungCapGUI;

public class Run {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // new Login();
            //new AdminGUI();
            new NhaCungCapGUI();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
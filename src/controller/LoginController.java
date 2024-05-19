package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import BUS.LoginBUS;
import DATA.DTO.TaiKhoanDTO;
import GUI.Login;

public class LoginController  implements ActionListener, MouseListener{

    private Login log;
    private LoginBUS logBUS = new LoginBUS();
    

    public LoginController(Login log) {
        this.log = log;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.log.btnLogin){
            if(this.log.getUsername().equals("")){
                this.log.error("Vui lòng nhập tên đăng nhập");
                return;
            }
            if(this.log.getPassword().equals("")){
                this.log.error("Vui lòng nhập mật khẩu");
                return;
            }
            TaiKhoanDTO taikhoan = new TaiKhoanDTO();
            taikhoan.setMa(this.log.getUsername());
            taikhoan.setMatkhau(this.log.getPassword());
            TaiKhoanDTO result = new TaiKhoanDTO();
            result = this.logBUS.checkAccount(taikhoan);
            if(result == null){
                this.log.error("Tên đăng nhập hoặc mật khẩu không đúng");
                return;
            }else{
                if(result.getRole().equals("khachhang")){
                    Login.setObject((TaiKhoanDTO)result);
                    this.log.openUser();
                    return;
                }
                if(result.getRole().equals("quanlykho")){
                    Login.setObject((TaiKhoanDTO)result);
                    this.log.openAdministrator();
                    return;
                }
                if(result.getRole().equals("nguoiban")){
                    Login.setObject((TaiKhoanDTO)result);
                    this.log.openSaler();
                }
                if(result.getRole().equals("admin")){
                    Login.setObject((TaiKhoanDTO)result);
                    this.log.openAdmin();
                    return;
                }
            }
        }
    }
    
}

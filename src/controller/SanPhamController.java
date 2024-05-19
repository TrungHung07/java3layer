package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import BUS.SanPhamBUS;
import DATA.DTO.NuocGiaiKhatDTO;
import GUI.QuanLyKhoHang.SanPhamGUI;

public class SanPhamController implements ActionListener, MouseListener {
    private SanPhamGUI vsp;
    private SanPhamBUS spBUS = new SanPhamBUS();

    public SanPhamController(SanPhamGUI vsp) {
        this.vsp = vsp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vsp.btnTroLai) {
            this.vsp.troLai();
        }
        if (e.getSource() == this.vsp.btnHuyBo) {
            this.vsp.clearTxt();
        }
        // Tuong tac voi BUS
        if (e.getSource() == this.vsp.btnThem) {
            if (this.vsp.getField("txtMaSP").equals("") || this.vsp.getField("txtTenSP").equals("")
                    || this.vsp.getField("txtSLTon").equals("") || this.vsp.getField("txtDonVi").equals("")
                    || this.vsp.getField("txtHang").equals("") || this.vsp.getField("txtLoai").equals("")
                    || this.vsp.getField("txtNguoiBan").equals("") || this.vsp.getField("txtQuanLy").equals("") ||
                    this.vsp.getField("txtDonGia").equals("")) {
                this.vsp.errorMessage("Vui lòng nhập đầy đủ thông tin");
                return;
            }
            if (!(Pattern.matches("\\d+", this.vsp.getField("txtSLTon")))
                    || !(Pattern.matches("\\d+", this.vsp.getField("txtDonGia")))) {
                this.vsp.errorMessage("Số lượng, đơn giá sai định dạng. Vui lòng thử lại");
                return;
            }
            if (this.vsp.confirmMessage("Xác nhận thêm mới") == JOptionPane.YES_OPTION) {
                NuocGiaiKhatDTO ngk = new NuocGiaiKhatDTO(this.vsp.getField("txtMaSP"), this.vsp.getField("txtTenSP"),
                        this.vsp.getField("txtDonVi"), Integer.parseInt(this.vsp.getField("txtSLTon")),
                        Long.parseLong(this.vsp.getField("txtDonGia")), this.vsp.getField("txtLoai"),
                        this.vsp.getField("txtNguoiBan"), this.vsp.getField("txtHang"), this.vsp.getField("txtQuanLy"),
                        null, true);
                if (this.spBUS.insertProduct(ngk)) {
                    this.vsp.successMessage("Thêm sản phẩm thành công");
                    this.vsp.clearTxt();
                    this.vsp.getData(spBUS.getData());
                } else {
                    this.vsp.errorMessage("Thêm sản phẩm thất bại. Vui lòng thử lại");
                    return;
                }
            } else {
                return;
            }

        }

        if (e.getSource() == this.vsp.btnSua) {
            if (this.vsp.getField("txtMaSP").equals("") || this.vsp.getField("txtTenSP").equals("")
                    || this.vsp.getField("txtSLTon").equals("") || this.vsp.getField("txtDonVi").equals("")
                    || this.vsp.getField("txtHang").equals("") || this.vsp.getField("txtLoai").equals("")
                    || this.vsp.getField("txtNguoiBan").equals("") || this.vsp.getField("txtQuanLy").equals("") ||
                    this.vsp.getField("txtDonGia").equals("")) {
                this.vsp.errorMessage("Vui lòng nhập đầy đủ thông tin");
                return;
            }
            if (!(Pattern.matches("\\d+", this.vsp.getField("txtSLTon")))
                    || !(Pattern.matches("\\d+", this.vsp.getField("txtDonGia")))) {
                this.vsp.errorMessage("Số lượng, đơn giá sai định dạng. Vui lòng thử lại");
                return;
            }
            if (this.vsp.confirmMessage("Xác nhận sửa sản phẩm") == JOptionPane.YES_OPTION) {
                NuocGiaiKhatDTO ngk = new NuocGiaiKhatDTO(this.vsp.getField("txtMaSP"), this.vsp.getField("txtTenSP"),
                        this.vsp.getField("txtDonVi"), Integer.parseInt(this.vsp.getField("txtSLTon")),
                        Long.parseLong(this.vsp.getField("txtDonGia")), this.vsp.getField("txtLoai"),
                        this.vsp.getField("txtNguoiBan"), this.vsp.getField("txtHang"), this.vsp.getField("txtQuanLy"),
                        null, true);
                if (this.spBUS.updateProduct(ngk)) {
                    this.vsp.successMessage("Sửa sản phẩm thành công");
                    this.vsp.clearTxt();
                    this.vsp.getData(spBUS.getData());
                } else {
                    this.vsp.errorMessage("Sửa sản phẩm thất bại. Vui lòng thử lại");
                    return;
                }
            }
        }

        if (e.getSource() == this.vsp.btnLuu) {
            this.vsp.insertAndSave();
        }

        if (e.getSource() == this.vsp.btnXoa) {
            if (this.vsp.getField("txtMaSP").equals("")) {
                this.vsp.errorMessage("Vui lòng nhập mã cần xóa");
                return;
            }
            if (this.vsp.confirmMessage("Xác nhận xóa sản phẩm") == JOptionPane.YES_OPTION) {

                if (this.spBUS.deleteProduct(this.vsp.getField("txtMaSP"))) {
                    this.vsp.successMessage("Xóa sản phẩm thành công");
                    this.vsp.clearTxt();
                    this.vsp.getData(spBUS.getData());
                } else {
                    this.vsp.errorMessage("Xóa sản phẩm thất bại. Vui lòng thử lại");
                    return;
                }
            }
        }

        if (e.getSource() == this.vsp.btnTimKiem) {
            String txtTKMaSP = this.vsp.getField("txtTKMaSP");
            String txtTKMaNB = this.vsp.getField("txtTKMaNB");
            String txtTKGiaTu = this.vsp.getField("txtTKGiaTu");
            String txtTKGiaDen = this.vsp.getField("txtTKGiaDen");

            // Kiểm tra xem có bất kỳ ô nào được nhập không
            if (txtTKMaSP.equals("") && txtTKMaNB.equals("") && txtTKGiaTu.equals("") && txtTKGiaDen.equals("")) {
                this.vsp.errorMessage("Vui lòng nhập thông tin tìm kiếm");
                return;
            }
            long giaTu = 0;
            long giaDen = 9999999;

            // Kiểm tra hợp lệ của giá
            if (!txtTKGiaTu.equals("") && !txtTKGiaDen.equals("")) {
                if (!Pattern.matches("\\d+", txtTKGiaTu) || !Pattern.matches("\\d+", txtTKGiaDen)) {
                    this.vsp.errorMessage("Giá từ, đến sai định dạng. Vui lòng thử lại");
                    return;
                } else {
                    giaTu = Long.parseLong(txtTKGiaTu);
                    giaDen = Long.parseLong(txtTKGiaDen);
                    if (giaTu > giaDen) {
                        this.vsp.errorMessage("Giá từ phải nhỏ hơn giá đến. Vui lòng thử lại");
                        return;
                    }
                }
            }

            // Nếu đã nhập thông tin hoặc khoảng giá hợp lệ, thực hiện tìm kiếm
            if (spBUS.searchProduct(txtTKMaSP, txtTKMaNB, giaTu, giaDen).isEmpty()) {
                this.vsp.errorMessage("Không tìm thấy sản phẩm. Vui lòng thử lại");
                return;
            } else {
                this.vsp.getData(spBUS.searchProduct(txtTKMaSP, txtTKMaNB, giaTu, giaDen));
            }
        }

        if (e.getSource() == this.vsp.btnHuyTimKiem) {
            this.vsp.getData(spBUS.getData());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //
        if (e.getSource() == this.vsp.table) {
            this.vsp.getTxtFormTable(spBUS.getData());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }
}

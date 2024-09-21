package Sach;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmSach2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaSach,txtTuaSach,txtTacGia,txtNamXB,txtNhaXB,txtSoTrang,txtDonGia, txtTim;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSach2 frame = new frmSach2();
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
	public frmSach2() {
		this(new QuanLySach()); // Default initialization
		setTitle("Quản lý sách");
    }

	public frmSach2(QuanLySach s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(103, 25, 504, 30);
		contentPane.add(panel);
		
		JLabel lblMaSach = new JLabel("Ma Sach: ");
		panel.add(lblMaSach);
		lblMaSach.setPreferredSize(new Dimension(74, 14));
		
		txtMaSach = new JTextField(45);
		panel.add(txtMaSach);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(103, 55, 253, 30);
		contentPane.add(panel_1);
		
		JLabel lblTuaSach = new JLabel("Tua Sach: ");
		panel_1.add(lblTuaSach);
		lblTuaSach.setPreferredSize(new Dimension(74, 14));
		
		txtTuaSach = new JTextField(15);
		panel_1.add(txtTuaSach);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(354, 55, 253, 30);
		contentPane.add(panel_2);
		
		JLabel lblTacGia = new JLabel("Tac Gia: ");
		panel_2.add(lblTacGia);
		lblTacGia.setPreferredSize(new Dimension(74, 14));
		
		txtTacGia = new JTextField(15);
		panel_2.add(txtTacGia);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(103, 85, 253, 30);
		contentPane.add(panel_3);
		
		JLabel lblNamXB = new JLabel("Nam Xuat Ban: ");
		panel_3.add(lblNamXB);
		lblNamXB.setPreferredSize(new Dimension(90, 14));
		
		txtNamXB = new JTextField(15);
		panel_3.add(txtNamXB);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(355, 85, 252, 30);
		contentPane.add(panel_4);
		
		JLabel lblNhaXB_1 = new JLabel("Nha Xuat Ban: ");
		lblNhaXB_1.setPreferredSize(new Dimension(90, 14));
		panel_4.add(lblNhaXB_1);
		
		txtNhaXB = new JTextField(15);
		panel_4.add(txtNhaXB);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(103, 115, 253, 30);
		contentPane.add(panel_5);
		
		JLabel lblSoTrang_1 = new JLabel("So Trang: ");
		lblSoTrang_1.setPreferredSize(new Dimension(74, 14));
		panel_5.add(lblSoTrang_1);
		
		txtSoTrang = new JTextField(15);
		panel_5.add(txtSoTrang);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(354, 115, 253, 30);
		contentPane.add(panel_6);
		
		JLabel lblDonGia = new JLabel("Don Gia: ");
		panel_6.add(lblDonGia);
		lblDonGia.setPreferredSize(new Dimension(74, 14));
		
		txtDonGia = new JTextField(15);
		panel_6.add(txtDonGia);
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ms,ts,tg,naxb,nhxb,st,dg,isbn;
                
                ms = txtMaSach.getText();
                ts = txtTuaSach.getText();
                tg = txtTacGia.getText();
                naxb = txtNamXB.getText();
                nhxb = txtNhaXB.getText();
                st = txtSoTrang.getText();
                dg = txtDonGia.getText();
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // Kiểm tra mã sách đã tồn tại hay chưa
				boolean maSachTonTai = false;
				for (int i = 0; i < model.getRowCount(); i++) {
					if (ms.equals(model.getValueAt(i, 0))) {
						maSachTonTai = true;
						break;
					}
				}

				if (maSachTonTai) {
					JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại. Vui lòng nhập mã sách khác.");
				} else {
					model.addRow(new Object[] {ms,ts,tg,naxb,nhxb,st,dg});
					clearTextFields();
				}
			}		
		});
		btnThem.setBounds(10, 164, 83, 23);
		contentPane.add(btnThem);
		
		JButton btnSuaDong = new JButton("Sua Dong");
		btnSuaDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ms,ts,tg,naxb,nhxb,st,dg,isbn;
                
                ms = txtMaSach.getText();
                ts = txtTuaSach.getText();
                tg = txtTacGia.getText();
                naxb = txtNamXB.getText();
                nhxb = txtNhaXB.getText();
                st = txtSoTrang.getText();
                dg = txtDonGia.getText();

				int dongChon = table.getSelectedRow();
				if(dongChon>-1) {
					table.setValueAt(ms, dongChon, 0);
                    table.setValueAt(ts, dongChon, 1);
                    table.setValueAt(tg, dongChon, 2);
                    table.setValueAt(naxb, dongChon, 3);
                    table.setValueAt(nhxb, dongChon, 4);
                    table.setValueAt(st, dongChon, 5);
                    table.setValueAt(dg, dongChon, 6);
				}else {
					JOptionPane.showMessageDialog(null, "Hãy chọn 1 dòng muốn sửa lại giá trị");
				}
			}
		});
		btnSuaDong.setBounds(103, 164, 99, 23);
		contentPane.add(btnSuaDong);
		
		JButton btnXoaDong = new JButton("Xoa Dong");
		btnXoaDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "Không có dòng nào để xóa");
					return;
				}
				int dongXoa = table.getSelectedRow();
				if(dongXoa == -1) {
					JOptionPane.showMessageDialog(null, "Hãy chọn 1 dòng muốn xóa");
				}else {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.removeRow(dongXoa);
				}
			}
		});
		btnXoaDong.setBounds(212, 164, 91, 23);
		contentPane.add(btnXoaDong);
		
		JLabel lblNhapMaSach = new JLabel("Nhap ma sach can tim: ");
		lblNhapMaSach.setBounds(382, 168, 141, 14);
		contentPane.add(lblNhapMaSach);
		
		txtTim = new JTextField(10);
		txtTim.setBounds(521, 165, 86, 20);
		contentPane.add(txtTim);
		
		JButton button = new JButton("Tim");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSachTim = txtTim.getText();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				boolean found = false;
				
				for (int i = 0; i < model.getRowCount(); i++) {
					if (model.getValueAt(i, 0).toString().equals(maSachTim)) {
						table.setRowSelectionInterval(i, i);
						found = true;
						break;
					}
				}
				
				if (!found) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy mã sách: " + maSachTim);
				}
			}
		});
		button.setBounds(617, 164, 86, 23);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 203, 504, 465);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ma Sach", "Tua Sach", "Tac Gia", "NamXB", "NhaXB", "So Trang", "Don Gia"
			}
		));
		scrollPane.setViewportView(table);
	}
	// Phương thức clear các trường nhập liệu
		private void clearTextFields() {
			txtMaSach.setText("");
			txtTuaSach.setText("");
			txtTacGia.setText("");
			txtNamXB.setText("");
			txtNhaXB.setText("");
			txtSoTrang.setText("");
			txtDonGia.setText("");
			txtTim.setText("");
			txtMaSach.requestFocus(); // Đưa con trỏ về trường mã sách
		}
}

package Sach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class frmSach extends JFrame implements ActionListener,MouseListener{
	private QuanLySach s;
	private List<Sach> list;
	private JTable table;
	private JTextField txtMaSach,txtTuaSach,txtTacGia,txtNamXB,txtNhaXB,txtSoTrang,txtDonGia,txtISBN, txtTim;
	private JButton btnThem,btnXoa,btnXoaTrang,btnLuu,btnSua,btnTim;
	private DefaultTableModel tableModel;
	private static final String FILENAME="dulieu1.txt";
	
	public frmSach(QuanLySach s) {
		setTitle("Quan li sach");
		setSize(800,750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		
		JPanel pnlNorth;
		add(pnlNorth= new JPanel(), BorderLayout.NORTH);
		javax.swing.border.Border NorthBorder= BorderFactory.createLineBorder(Color.red);
		TitledBorder northTitleBorder= new TitledBorder(NorthBorder, "RECORD EDITOR");
		pnlNorth.setBorder(northTitleBorder);
		Box b= Box.createVerticalBox();
		Box b1,b2,b3,b4,b5,b6,b7;
		JLabel lblMaSach,lblTuaSach,lblTacGia,lblNamXB, lblNhaXB, lblSoTrang, lblDonGia,lblISBN;
		b.add(b1 =Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaSach= new JLabel("Ma Sach: "));
		b1.add(txtMaSach= new JTextField(10));
		

		b.add(b2=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTuaSach= new JLabel("Tua Sach: "));
		b2.add(txtTuaSach= new JTextField(15));
		
		b2.add(lblTacGia= new JLabel("Tac Gia: "));
		b2.add(txtTacGia= new JTextField(15));

		b.add(b3=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));

		b3.add(lblNamXB= new JLabel("Nam Xuat Ban: "));
		b3.add(txtNamXB= new JTextField(10));
		b3.add(lblNhaXB= new JLabel("Nha Xuat Ban: "));
		b3.add(txtNhaXB= new JTextField(15));
		
		b.add(b4=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		
		b4.add(lblSoTrang= new JLabel("So Trang: "));
		b4.add(txtSoTrang= new JTextField(15));
		b4.add(lblDonGia= new JLabel("Don Gia: "));
		b4.add(txtDonGia= new JTextField(15));
		
		b.add(b5=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		
		b5.add(lblISBN= new JLabel("International Standard Book Number: "));
		b5.add(txtISBN= new JTextField(15));
		
		lblMaSach.setPreferredSize(lblNamXB.getPreferredSize());
		lblTuaSach.setPreferredSize(lblNamXB.getPreferredSize());
		lblTacGia.setPreferredSize(lblNamXB.getPreferredSize());
		lblNamXB.setPreferredSize(lblNamXB.getPreferredSize());
		lblNhaXB.setPreferredSize(lblNamXB.getPreferredSize());
		lblSoTrang.setPreferredSize(lblNamXB.getPreferredSize());
		lblDonGia.setPreferredSize(lblNamXB.getPreferredSize());

		
		
		b.add(b6=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(20));
		String [] headers="MaSach;TuaSach;TacGia;NamXB;NhaXB;SoTrang;DonGia;ISBN;".split(";");
		tableModel =new DefaultTableModel(headers,0);
		JScrollPane scroll= new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JPanel pnS = new JPanel();
		add(pnS , BorderLayout.SOUTH);
		//javax.swing.border.Border southBorder= BorderFactory.createLineBorder(Color.blue);
		//TitledBorder southTitleBorder= new TitledBorder(southBorder, "DANH SACH CAC CUON SACH");
		//pnS.setBorder(southTitleBorder);
		pnS.add(scroll);
		pnlNorth.add(b);
		
		JSplitPane split= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.CENTER);
		JPanel pnlLeft, pnlRight;
		split.add(pnlLeft= new JPanel());
		split.add(pnlRight= new JPanel());
		pnlRight.add(new JLabel("Nhap ma so can tim: "));
		pnlRight.add(txtTim= new JTextField(10));
		pnlRight.add(new JButton("Tim"));		
		pnlLeft.add(btnThem= new JButton("Them"));
		pnlLeft.add(btnXoaTrang= new JButton("Xoa Trang"));
		pnlLeft.add(btnXoa= new JButton("Xoa"));
		pnlLeft.add(btnLuu=new JButton("Luu"));
		LoadDatabase();
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);

	

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o= e.getSource();
		if(o.equals(btnThem))
			themActions();
		if(o.equals(btnXoa))
			xoaActions();
		if(o.equals(btnXoaTrang))
			xoaTrangActions();	
		if(o.equals(btnLuu))
			luuActions(s.getList());
	
			
	}
	

	private void xoaTrangActions() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamXB.setText("");
		txtNhaXB.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		txtMaSach.requestFocus();
		
	}
	private void themActions() {
		try {
			int maSach= Integer.parseInt(txtMaSach.getText());
			String tuaSach= txtTuaSach.getText();
			String tacGia= txtTacGia.getText();
			int namXB = Integer.parseInt(txtNamXB.getText());
			String nhaXB= txtNhaXB.getText();
			int soTrang = Integer.parseInt(txtNamXB.getText());
			double donGia= Double.parseDouble(txtSoTrang.getText());
			String iSBN= txtISBN.getText();
			Sach s1 = new Sach(maSach, tuaSach, tacGia,namXB,nhaXB, soTrang,donGia,iSBN);
			if(s.themSach(s1)) {
				String[] row= {Integer.toString(maSach),tuaSach,tacGia,Integer.toString(namXB),nhaXB,Integer.toString(soTrang),Double.toString(donGia),iSBN+""};
				tableModel.addRow(row);
				xoaTrangActions();
			}
			else {
				JOptionPane.showMessageDialog(null, "Trung ma Sach.");
				txtMaSach.selectAll();
				txtMaSach.requestFocus();
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Loi nhap du lieu.");
			return;
		}
	}
	private void xoaActions(){
		int row= table.getSelectedRow();
		if(row!=-1) {
			int maSach= Integer.parseInt((String)table.getModel().getValueAt(row, 0));
			int hoiNhac=JOptionPane.showConfirmDialog(this, "Chac chan xoa khong","Chu y",JOptionPane.YES_NO_OPTION);
			if(hoiNhac==JOptionPane.YES_OPTION) {
				if(s.xoaSach(maSach)) {
					tableModel.removeRow(row);
				}
			}
			
		}
	}
	void LoadDatabase() {
		BufferedReader br=null;
		s=new QuanLySach();
		try {
			if(new File(FILENAME).exists()) {
				br=new BufferedReader (new FileReader(FILENAME));
				br.readLine();
			
			
				while(br.ready()){
					String line = br.readLine();
					if(line !=null&& !line.trim().equals("")) {
						String[]a= line.split(";");
						Sach s1= new Sach(Integer.parseInt(a[0]),a[1],a[2],Integer.parseInt(a[3]),a[4],Integer.parseInt(a[5]),Double.parseDouble(a[6]),a[7]);
						s.themSach(s1);
						tableModel.addRow(a);
					}
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	void luuActions(ArrayList<Sach> ds) {
		BufferedWriter bw;
		try{
			bw=new BufferedWriter(new FileWriter(FILENAME));
			bw.write("MaSach;TuaSach;TacGia;NamXB;NhaXB;SoTrang;DonGia;ISBN\n");
			for(Sach s1: ds) {
				bw.write(s1.toString()+"\n");
			}
			bw.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row= table.getSelectedRow();
		txtMaSach.setText(table.getValueAt(row, 0).toString());
		txtTuaSach.setText(table.getValueAt(row, 1).toString());
		txtTacGia.setText(table.getValueAt(row, 2).toString());
		txtNamXB.setText(table.getValueAt(row, 3).toString());
		txtNhaXB.setText(table.getValueAt(row, 4).toString());
		txtSoTrang.setText(table.getValueAt(row, 5).toString());
		txtDonGia.setText(table.getValueAt(row, 6).toString());
		txtISBN.setText(table.getValueAt(row, 7).toString());
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*private boolean validData(){
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		String nam = txtNamXB.getText().trim();
		String gia = txtDonGia.getText().trim();
		String isbn = txtISBN.getText().trim();
		String soTrang = txtSoTrang.getText().trim();
		if (!(maSach.length() > 0 && tuaSach.matches("[A-Z]\\d{3}"))) {
			showMessage("Error: Ma sach theo mau: [A-Z]\\\\d{3}", txtMaSach);
			JOptionPane.showMessageDialog(this, "Error: Ma sach theo mau: [A-Z]\\\\\\\\d{3};");
			return false;
		}
		if (!(tuaSach.length() > 0 && tuaSach.matches("[a-zA-Z]+"))) {
			showMessage("Error: Tua sach theo mau: [a-zA-Z]+", txtTuaSach);
			return false;
			
		}
		if(!(tacGia.length() > 0 && tacGia.matches("[a-zA-Z']+"))) {
			showMessage("Error: tac gia theo mau:[a-zA-Z']+ ", txtTacGia);
			return false;
			
		}
		if (nam.length() > 0) {
			try {
				int x = Integer.parseInt(nam);
				int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
				if(!(x>=1900 && x < namHienTai)) {
					showMessage("Error: nam xuat ban >= 1900 && <=" + namHienTai, txtNamXB);
					JOptionPane.showMessageDialog(this,"Error: nam xuat ban >= 1900 && <=" + namHienTai);
					return false;
				}
			}catch(NumberFormatException ex){
				showMessage("Error: Nam xuat ban phai nhap so", txtNamXB);
				return false;
			}
			
		}
		if(gia.length() > 0)
		{
			try {
				double y = Double.parseDouble(gia);
				if(y<0) {
					showMessage("Error: don gia phai > 0", txtDonGia);
					return false;
				}
			}catch(NumberFormatException ex){
				showMessage("Error: Don gia phai nhap so", txtDonGia);
				return false;
			}
			
		}
		if(isbn.length() > 0)
			if(!isbn.matches("\\d+(-\\d+{3,4}")) {
				showMessage("Error: ISBN co mau dang X-X-X-X", txtISBN);
				return false;
			}
		return true;
	}
*/

	

}


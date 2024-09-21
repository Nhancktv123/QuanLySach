package Sach;

import java.util.ArrayList;

public class QuanLySach {
	private ArrayList<Sach> list;
	public QuanLySach() {
		list= new ArrayList<Sach>();
	}
	public boolean themSach(Sach s1) {
		if(list.contains(s1))
			return false;
		list.add(s1);
		return true;
	}
	public boolean xoaSach(int maSach) {
		Sach s1= new Sach(maSach);
		if(list.contains(s1)) {
			list.remove(s1);
			return true;
		}
		return false;
	}
	public Sach timkiem(int maSach) {
		Sach nv =new Sach (maSach);
		if(list.contains(nv)) {
			return list.get(list.indexOf(nv));
		}
		return null;
	}
	public ArrayList<Sach> getList(){
		return list;
	}
}


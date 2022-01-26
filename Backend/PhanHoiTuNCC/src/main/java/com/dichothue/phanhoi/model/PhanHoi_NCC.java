package com.dichothue.phanhoi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phanhoi_NCC")

public class PhanHoi_NCC
{
	private int MaPhanHoi_NCC;
	private java.sql.Date ThoiGian;
	private int MaNCC;
	private String NoiDung;
	private String TrangThai;
	
	//Constructor
	public PhanHoi_NCC() {}
	
	public PhanHoi_NCC(int MaPhanHoi_NCC_,java.sql.Date ThoiGian_,int MaNCC_,String NoiDung_,String TrangThai_)
	{
		this.MaPhanHoi_NCC = MaPhanHoi_NCC_;
		this.ThoiGian = ThoiGian_;
		this.MaNCC = MaNCC_;
		this.NoiDung = NoiDung_;
		this.TrangThai = TrangThai_;
	}
	
	//Get&Set for properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="maphanhoi_NCC")
	public int getMaPhanHoi_NCC()
	{
		return this.MaPhanHoi_NCC;
	}
	public void setMaPhanHoi_NCC(int value)
	{
		this.MaPhanHoi_NCC = value;
	}

	@Column(name = "thoigian", nullable = true)
	public java.sql.Date getThoiGian()
	{
		return this.ThoiGian;
	}
	public void setThoiGian(java.sql.Date value)
	{
		this.ThoiGian = value;
	}

	@Column(name = "MaNCC", nullable = true)
	public int getMaNCC()
	{
		return this.MaNCC;
	}
	public void setMaNCC(int value)
	{
		this.MaNCC = value;
	}

	@Column(name = "noidung", nullable = true)
	public String getNoiDung()
	{
		return this.NoiDung;
	}
	public void setNoiDung(String value)
	{
		this.NoiDung = value;
	}

	@Column(name = "trangthai", nullable = true)
	public String getTrangThai()
	{
		return this.TrangThai;
	}
	public void setTrangThai(String value)
	{
		this.TrangThai = value;
	}

	//toString() Override
	@Override
	public String toString() {
		return "PhanHoi_NCC [MaPhanHoi_NCC=" + MaPhanHoi_NCC + ", ThoiGian=" + ThoiGian + ", MaNCC=" + MaNCC + ", TrangThai=" + TrangThai + "]";
	}
}
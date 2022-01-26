using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UngDung_DiChoThue.Models
{
	public class HoSo_NCC
	{
		public int MaHS_NCC { get; set; }
		public int MaNCC { get; set; }
		public string AnhHS { get; set; }
		public DateTime NgayNhan { get; set; }
		public DateTime NgayKiemTra { get; set; }
		public string TrangThai { get; set; }

		public HoSo_NCC(int MaHS_NCC_, int MaNCC_, string AnhHS_, DateTime NgayNhan_, DateTime NgayKiemTra_, string TrangThai_)
		{
			this.MaHS_NCC = MaHS_NCC_;
			this.MaNCC = MaNCC_;
			this.AnhHS = AnhHS_;
			this.NgayNhan = NgayNhan_;
			this.NgayKiemTra = NgayKiemTra_;
			this.TrangThai = TrangThai_;
		}
	}
}
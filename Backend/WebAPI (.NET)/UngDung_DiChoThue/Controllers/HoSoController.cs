using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using UngDung_DiChoThue.Models;

namespace UngDung_DiChoThue.Controllers
{
    public class HoSoController : ApiController
    {
        SqlConnection con = new SqlConnection(@"Data Source=DESKTOP-R4GG4RM;Initial Catalog=QL_DiChoThue;Integrated Security=True");

        public HttpResponseMessage GetData(string query)
        {
            SqlDataAdapter da = new SqlDataAdapter(query, con);

            DataTable dt = new DataTable();
            da.Fill(dt);

            return Request.CreateResponse(HttpStatusCode.OK, dt);
        }

        [Route("api/HoSo/{MaNCC}")]
        public HttpResponseMessage Get(int MaNCC)
        {
            string query = @"
                        SELECT HS.NgayNhan, HS.AnhHS, HS.TrangThai, HS.NgayKiemTra, NCC.TenNCC
                        FROM HoSo_NCC HS
                        JOIN NhaCungCap NCC ON NCC.MaNCC = HS.MaNCC
                        WHERE HS.MaNCC = '" + MaNCC + "'";
            return GetData(query);
        }

        [Route("api/HoSo/ThemHoSo")]
        public HttpResponseMessage Post([FromBody] HoSo_NCC hoSo)
        {
            try
            {
                DataTable table = new DataTable();

                string query = @"
                                INSERT INTO dbo.HoSo_NCC 
                                (MaNCC, AnhHS, NgayNhan, NgayKiemTra, TrangThai) 
                                VALUES
                                (" + hoSo.MaNCC + "," + hoSo.AnhHS + "," + hoSo.NgayNhan + "," + hoSo.NgayKiemTra + "," + hoSo.TrangThai + ")";

                SqlCommand command = new SqlCommand(query, con);
                con.Open();
                command.ExecuteNonQuery();
                con.Close();

                return Request.CreateResponse(HttpStatusCode.OK);
            }
            catch(Exception)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest);
            }
        }

        [Route("api/HoSo/DuyetHoSo/{MaHS_NCC}")]
        public HttpResponseMessage Put(int maHS_NCC)
        {
            try
            {
                string query = @"
                                UPDATE HoSo_NCC
                                SET TrangThai = 'Hợp lệ'
                                WHERE MaHS_NCC = " + maHS_NCC.ToString() ;

                SqlCommand command = new SqlCommand(query, con);
                con.Open();
                command.ExecuteNonQuery();
                con.Close();

                return Request.CreateResponse(HttpStatusCode.OK);
            }
            catch (Exception)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest);
            }
        }
    }
}

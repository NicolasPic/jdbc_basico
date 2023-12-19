package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try 
		{
			conn = DB.getConnection();
		/* SELLER
			st = conn.prepareStatement(	"INSERT INTO seller (Name,Email,BirthDate,BaseSalary,DepartmentId) "
					+ "VALUES (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Carl Purple");
			st.setString(2, "Carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 2000);
			st.setInt(5,4);
			
			int rws = st.executeUpdate();
			
			if(rws > 0)
			{
				ResultSet rs =st.getGeneratedKeys();
				while (rs.next()) 
				{
					int id = rs.getInt(1);
					System.out.println("Pronto! Id: " + id);
				}
			}
			else
			{
				System.out.println("Sem alteracoes");
			}
			*/
			
			//departament
			st = conn.prepareStatement(	"INSERT INTO department (Name)"
					+ "VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1,"d1");
			
			int rws = st.executeUpdate();
			
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		//catch (ParseException e)
		//{
		//	e.printStackTrace();
		//}
		finally
		{
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}

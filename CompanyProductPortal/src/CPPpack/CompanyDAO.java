package CPPpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyDAO {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyproduct","root", "hash");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static int register(CompanyPojo c) {
		// TODO Auto-generated method stub
		int st = 0;
		Connection con = getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into company(cname, country) values (?,?)");
			p.setString(1, c.getCname());
			p.setString(2, c.getCountry());
			st = p.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
			
	}
	
	public static ArrayList<CompanyPojo> getCompanyList(){
		Connection con = getConnection();
		ArrayList<CompanyPojo> clist = new ArrayList<CompanyPojo>();
		try {
			PreparedStatement p = con.prepareStatement("select cid, cname from company");
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				CompanyPojo c = new CompanyPojo();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				clist.add(c);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
	}

	public static int registerProduct(ProductPojo p) {
		// TODO Auto-generated method stub
		int st = 0;
		Connection con = getConnection();
		try {
			PreparedStatement pa = con.prepareStatement("insert into product(pname, price, cid) values (?,?,?)");
			pa.setString(1, p.getPname() );
			pa.setFloat(2, p.getPrice());
			pa.setInt(3, p.getCid());
			st = pa.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
	
	public static ArrayList<ProductPojo> getProductCompany(){
		Connection con = getConnection();
		ArrayList<ProductPojo> pc_list = new ArrayList<ProductPojo>();
		try {
			PreparedStatement ps = con.prepareStatement("select p.pid, p.pname, p.price, c.cid, c.cname from product p INNER JOIN company c ON p.cid=c.cid");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductPojo pc = new ProductPojo();
				pc.setPid(rs.getInt(1));
				pc.setPname(rs.getString(2));
				pc.setPrice(rs.getFloat(3));
				pc.setCid(rs.getInt(4));
				pc.setCname(rs.getString(5));
				pc_list.add(pc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pc_list;
		
	}
}

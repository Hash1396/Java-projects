package Servletjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentPojo {
	
	
		
	//inits
	private int id;
	private String uname;
	private String fname;
	private String lname;
	private String gender;
	private String email;
	private String cont;
	private String coll;
	private String profile;
	private String pass;
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getColl() {
		return coll;
	}
	public void setColl(String coll) {
		this.coll = coll;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	//get authorized user and return that user
	public static StudentPojo getLoginDetails(String uname, String pass)throws Exception {
		
		//declares
				Connection conn;
				PreparedStatement pst;
				ResultSet rs;
		
		//create connection 
		       conn = Connect.getConnection();
		
		//create and execute query to search for auth user
		    pst = conn.prepareStatement("SELECT * from login where uname=? AND pass=?");
		    pst.setString(1, uname);
		    pst.setString(2, pass);
		    rs = pst.executeQuery();
		    if(!rs.next()){

		    	return null;
		   
		    }else {
		    	 StudentPojo sp = new StudentPojo();
			       sp.setId(rs.getInt(1));
			       sp.setUname(rs.getString(2));
			       return sp;
			}
	}
	
	public static int signUp(StudentPojo e) {
		
		int status = 0;
		Connection con = Connect.getConnection();
		
			try {
				
				PreparedStatement p = con.prepareStatement("insert into login(uname, pass) values(?,?)");
				p.setString(1, e.getUname());
				p.setString(2, e.getPass());
				status = p.executeUpdate();
				con.close();
			
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		return status;

		
	}
	
	public static int register(StudentPojo e) {
		// TODO Auto-generated method stub
		int status = 0;
		Connection con = Connect.getConnection();
		
		try {
			
			PreparedStatement p = con.prepareStatement("insert into user(id, fname, lname, gender, email, cont, coll, profile) values (?,?,?,?,?,?,?,?)");
			p.setInt(1, e.getId());
			p.setString(2, e.getFname());
			p.setString(3, e.getLname());
			p.setString(4, e.getGender());
			p.setString(5, e.getEmail());
			p.setString(6, e.getCont());
			p.setString(7, e.getColl());
			p.setString(8, e.getProfile());
			status = p.executeUpdate();
			con.close();
		
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return status;
	}


	public static ArrayList<StudentPojo> showProfiles() {
		// TODO Auto-generated method stub
		
		Connection con = Connect.getConnection();
		ArrayList<StudentPojo> list = new ArrayList<StudentPojo>();
		
		try {
			
			java.sql.PreparedStatement p= con.prepareStatement("select * from user");
			
			java.sql.ResultSet rs = p.executeQuery();
			
			
			while(rs.next())
			{
				StudentPojo e = new StudentPojo();
				e.setId(rs.getInt(1));
				e.setFname(rs.getString(2));
				e.setLname(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setCont(rs.getString(6));
				e.setColl(rs.getString(7));
				e.setProfile(rs.getString(8));
				
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	public static int deleteStud(int id) {
		// TODO Auto-generated method stub
		int status = 0;
		Connection con = Connect.getConnection();
		try {
			PreparedStatement p = con.prepareStatement("delete from user where id=?");
			p.setInt(1, id);
			status = p.executeUpdate();
		
		} catch (SQLException e){
			
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deleteAcc(int id) {
		// TODO Auto-generated method stub
		int status = 0;
		Connection con = Connect.getConnection();
		try {
			PreparedStatement p = con.prepareStatement("delete from login where id=?");
			p.setInt(1, id);
			status = p.executeUpdate();
		
		} catch (SQLException e){
			
			e.printStackTrace();
		}
		return status;
	}
	
	public static StudentPojo getUserByID(StudentPojo s) {
		Connection con = Connect.getConnection();
		StudentPojo e = new StudentPojo();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from user where id=?");
			ps.setInt(1, s.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setFname(rs.getString(2));
				e.setLname(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setCont(rs.getString(6));
				e.setColl(rs.getString(7));
				e.setProfile(rs.getString(8));
				
		
			}else {
				return null;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	
	public static int studUpdate(StudentPojo e) {
		Connection con = Connect.getConnection();
		int st=0;
		/*
		System.out.println("EmpUpdate Method...");
		System.out.println("eid = "+e.getId());
		System.out.println("Fname = "+e.getFname());
		System.out.println("Lname = "+e.getLname());
		System.out.println("Mob = "+e.getMob());
		System.out.println("Email = "+e.getEmail());
		System.out.println("Gender = "+e.getGender());
		System.out.println("Profile = "+e.getProfile());
		*/
		try {
			PreparedStatement ps = con.prepareStatement("update user set fname=?, lname=?, gender=?, email=?, cont=?, coll=?, profile=? where id=?");
			
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3, e.getGender());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getCont());
			ps.setString(6, e.getColl());
			ps.setString(7, e.getProfile());
			ps.setInt(8, e.getId());
			
			st = ps.executeUpdate();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return st;
		
	}
	

}

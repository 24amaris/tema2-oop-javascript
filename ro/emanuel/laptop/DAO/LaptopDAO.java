package ro.emanuel.laptop.DAO;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.laptop.pojo.Laptop;

	
	public class LaptopDAO {
		
	    public static List<Laptop> getLaptop() throws SQLException {
	        List<Laptop> laptop = new ArrayList<>();
	        
	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	        ResultSet rs = stmt.executeQuery("select * from Laptop");
	        while(rs.next()) {
	         
	            int id = rs.getInt("id");
	            String brand = rs.getString("brand");
	            String model = rs.getString("model");
	            int storage = rs.getInt("storage");
	            Laptop laptop1 = new Laptop(id, brand, model, storage);
	            laptop.add(laptop1); 
	        }
	        
	        DBHelper.closeConnection(); 
	        
	        return laptop; 
	    }

	    public static int deleteLaptop(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	     
	        int deletedRows = stmt.executeUpdate("delete from Laptop where id = " + id);
	        
	        DBHelper.closeConnection();
	        
	        return deletedRows; 
	    }

	    public static int createLaptop(Laptop laptopToCreate) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        String query = "insert into Laptop (brand, model, storage) values(?,?,?)";
	        PreparedStatement ps = conn.prepareStatement(query);
	        
	        ps.setString(1, laptopToCreate.getBrand());
	        ps.setString(2, laptopToCreate.getModel());
	        ps.setInt(3, laptopToCreate.getStorage());
	        
	        int affectedRows = ps.executeUpdate();
	        
	        DBHelper.closeConnection();
	        
	        return affectedRows; 
	    }

	    public static int updateLaptop(Laptop laptop) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        String query = "update Laptop set brand = ?, model = ?, storage = ? where id = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        
	        ps.setString(1, laptop.getBrand());
	        ps.setString(2, laptop.getModel());
	        ps.setInt(3, laptop.getStorage());
	        ps.setInt(4, laptop.getId());
	        
	       
	        int rowsUpdated = ps.executeUpdate();
	        
	        DBHelper.closeConnection();
	        
	        return rowsUpdated;
	    }

	    public static Laptop getById(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();

	       
	        List<Laptop> laptop = getLaptop();
	        for(Laptop b : laptop) {
	            if(b.getId() == id) {
	                return b; 
	            }
	        }
	        return null;

		}
	}

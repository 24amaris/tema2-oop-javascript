package ro.emanuel.puzzle.DAO;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.puzzle.pojo.Puzzle;

public class PuzzleDAO {
		
	    public static List<Puzzle> getPuzzle() throws SQLException {
	        List<Puzzle> puzzle = new ArrayList<>();
	        
	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	        ResultSet rs = stmt.executeQuery("select * from Puzzle");
	        while(rs.next()) {
	         
	            int id = rs.getInt("id");
	            String brand = rs.getString("brand");
	            String material = rs.getString("material");
	            int size = rs.getInt("size");
	            Puzzle puzzle1 = new Puzzle(id, brand, material, size);
	            puzzle.add(puzzle1); 
	        }
	        
	        DBHelper.closeConnection(); 
	        
	        return puzzle; 
	    }

	    public static int deletePuzzle(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	     
	        int deletedRows = stmt.executeUpdate("delete from Puzzle where id = " + id);
	        
	        DBHelper.closeConnection();
	        
	        return deletedRows; 
	    }

	    public static int createLaptop(Puzzle puzzleToCreate) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        String query = "insert into Puzzle (brand, material, size) values(?,?,?)";
	        PreparedStatement ps = conn.prepareStatement(query);
	        
	        ps.setString(1, puzzleToCreate.getBrand());
	        ps.setString(2, puzzleToCreate.getMaterial());
	        ps.setInt(3, puzzleToCreate.getSize());
	        
	        int affectedRows = ps.executeUpdate();
	        
	        DBHelper.closeConnection();
	        
	        return affectedRows; 
	    }

	    public static int updatePuzzle(Puzzle puzzle) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        String query = "update Puzzle set brand = ?, material = ?, size = ? where id = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        
	        ps.setString(1, puzzle.getBrand());
	        ps.setString(2, puzzle.getMaterial());
	        ps.setInt(3, puzzle.getSize());
	        ps.setInt(4, puzzle.getId());
	        
	       
	        int rowsUpdated = ps.executeUpdate();
	        
	        DBHelper.closeConnection();
	        
	        return rowsUpdated;
	    }

	    public static Puzzle getById(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();

	       
	        List<Puzzle> puzzle = getPuzzle();
	        for(Puzzle b : puzzle) {
	            if(b.getId() == id) {
	                return b; 
	            }
	        }
	        return null;

		}
	}


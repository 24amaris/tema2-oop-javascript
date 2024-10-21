package ro.emanuel.cub.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.cub.pojo.RubiksCube;
import ro.emanuel.helper.DBHelper;

public class RubiksCubeDAO {
  
    public static List<RubiksCube> getRubiksCube() throws SQLException {
        List<RubiksCube> rubiks = new ArrayList<>();
        
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from RubiksCube");
        while(rs.next()) {
         
            int id = rs.getInt("id");
            String brand = rs.getString("brand");
            int weight = rs.getInt("weight");
            int sides = rs.getInt("sides");
            RubiksCube rubiks1 = new RubiksCube(id, brand, weight, sides);
            rubiks.add(rubiks1); 
        }
        
        DBHelper.closeConnection(); 
        
        return rubiks; 
    }

    public static int deleteRubiks(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
     
        int deletedRows = stmt.executeUpdate("delete from RubiksCube where id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows; 
    }

    public static int createRubiksCube(RubiksCube rubiksToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into RubiksCube (brand, weight, sides) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, rubiksToCreate.getBrand());
        ps.setInt(2, rubiksToCreate.getWeight());
        ps.setInt(3, rubiksToCreate.getSides());
        
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows; 
    }

    public static int updateRubiksCube(RubiksCube rubiks) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update RubiksCube set brand = ?, weight = ?, sides = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, rubiks.getBrand());
        ps.setInt(2, rubiks.getWeight());
        ps.setInt(3, rubiks.getSides());
        ps.setInt(4, rubiks.getId());
        
       
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated;
    }

    public static RubiksCube getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();

       
        List<RubiksCube> rubiks = getRubiksCube();
        for(RubiksCube b : rubiks) {
            if(b.getId() == id) {
                return b; 
            }
        }
        return null;

	}
}

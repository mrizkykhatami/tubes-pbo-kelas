/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import utils.Koneksi;
/**
 *
 * @author HYPE AMD
 */
public class KaryawanDAO {
    // 1. READ (Ambil semua data User)
    public List<User> getAllUser() {
        List<User> listUser = new ArrayList<>();
        String sql = "SELECT * FROM User";

        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User k = new User();

                k.setIdUser(rs.getInt("id_user"));
                k.setNamaUser(rs.getString("nama_user"));
                k.setUsername(rs.getString("username"));
                k.setPass(rs.getString("pass"));
                k.setRole(rs.getString("role"));
                
                listUser.add(k);
            }
        } catch (SQLException e) {
            System.out.println("Error Get All User: " + e.getMessage());
        }
        return listUser;
    }

    // 2. CREATE (Tambah User baru)
    public void addUser(User User) {
        // Kolom create_at dan update_at diasumsikan otomatis dihandle oleh MySQL (DEFAULT CURRENT_TIMESTAMP)
        String sql = "INSERT INTO User (nama_user) VALUES (?)";

        try (Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, User.getNamaUser());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Add User: " + e.getMessage());
        }
    }

    // 3. UPDATE (Ubah data User)
    public void updateUser(User User) {
        String sql = "UPDATE User SET nama_user = ? WHERE id_user = ?"; 

        try (Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, User.getNamaUser());
            ps.setInt(2, User.getIdUser());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Update User: " + e.getMessage());
        }
    }

    // 4. DELETE (Hapus User)
    public void deleteUser(int idUser) {
        String sql = "DELETE FROM User WHERE id_user = ?";

        try (Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUser);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Delete User: " + e.getMessage());
        }
    }
    
    // 5. SEARCH (Pencarian berdasarkan nama - Opsional tapi berguna untuk GUI)
    public List<User> searchUser(String keyword) {
        List<User> listUser = new ArrayList<>();
        String sql = "SELECT * FROM User WHERE nama_user LIKE ?";

        try (Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%"); // Pencarian partial
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User k = new User();
                    k.setIdUser(rs.getInt("id_user"));
                    k.setNamaUser(rs.getString("nama_user"));
                    listUser.add(k);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Search User: " + e.getMessage());
        }
        return listUser;
    }
}

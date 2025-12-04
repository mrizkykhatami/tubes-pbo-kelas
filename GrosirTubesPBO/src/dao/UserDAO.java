package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import utils.Koneksi;
import org.mindrot.jbcrypt.BCrypt; // Pastikan library sudah diimport

public class UserDAO {

    // LOGIKA LOGIN
    public User login(String username, String rawPassword) {
        // Query hanya mencari berdasarkan username, password dicek di Java
        String sql = "SELECT * FROM user WHERE username = ?";
        
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // 1. Ambil password terenkripsi dari database
                    String storedHash = rs.getString("pass");
                    
                    // 2. Verifikasi password inputan user (raw) dengan hash di DB
                    if (BCrypt.checkpw(rawPassword, storedHash)) {
                        // Password COCOK
                        int idUser = rs.getInt("id_user");
                        String namaUser = rs.getString("nama_user");
                        String role = rs.getString("role");
                        
                        // Kembalikan object User
                        return new User(idUser, namaUser, username, storedHash, role);
                    } else {
                        // Password SALAH
                        System.out.println("Login gagal: Password salah");
                        return null;
                    }
                } else {
                    // Username TIDAK DITEMUKAN
                    System.out.println("Login gagal: Username tidak ditemukan");
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat login: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }

    // LOGIKA REGISTER
    public boolean register(User user) {
        // Cek dulu apakah username sudah ada (Opsional, tapi disarankan agar pesan error lebih jelas)
        if (isUsernameExists(user.getUsername())) {
            System.err.println("Registrasi gagal: Username " + user.getUsername() + " sudah digunakan.");
            return false;
        }

        String sql = "INSERT INTO user (nama_user, username, pass, role) VALUES (?, ?, ?, ?)";
        
        // ENKRIPSI PASSWORD DISINI
        // salt digenerate otomatis oleh BCrypt
        String hashedPassword = BCrypt.hashpw(user.getPass(), BCrypt.gensalt());

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getNamaUser());
            ps.setString(2, user.getUsername());
            ps.setString(3, hashedPassword); // Simpan password yang sudah di-hash
            
            // Set default role jika user.getRole() null, atau ambil dari object user
            String role = (user.getRole() == null || user.getRole().isEmpty()) ? "user" : user.getRole();
            ps.setString(4, role); 

            int affectedRows = ps.executeUpdate();
            
            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Error saat registrasi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Method bantuan untuk mengecek username duplikat sebelum insert
    public boolean isUsernameExists(String username) {
        String sql = "SELECT 1 FROM user WHERE username = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // True jika username ada
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
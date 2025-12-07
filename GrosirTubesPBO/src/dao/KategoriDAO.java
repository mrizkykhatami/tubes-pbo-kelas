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
import model.Kategori;
import utils.Koneksi;

/**
 *
 * @author Personal
 */
public class KategoriDAO {

    // 1. READ (Ambil semua data kategori)
    public List<Kategori> getAllKategori() {
        List<Kategori> listKategori = new ArrayList<>();
        String sql = "SELECT * FROM kategori";

        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Kategori k = new Kategori();
                // Sesuaikan string dengan nama kolom di database (ERD)
                k.setIdKategori(rs.getInt("id_kategori"));
                k.setNamaKategori(rs.getString("nama_kategori"));
                
                listKategori.add(k);
            }
        } catch (SQLException e) {
            System.out.println("Error Get All Kategori: " + e.getMessage());
        }
        return listKategori;
    }

    // 2. CREATE (Tambah kategori baru)
    public void addKategori(Kategori kategori) {
        // Kolom create_at dan update_at diasumsikan otomatis dihandle oleh MySQL (DEFAULT CURRENT_TIMESTAMP)
        String sql = "INSERT INTO kategori (nama_kategori) VALUES (?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kategori.getNamaKategori());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Add Kategori: " + e.getMessage());
        }
    }

    // 3. UPDATE (Ubah data kategori)
    public void updateKategori(Kategori kategori) {
        String sql = "UPDATE kategori SET nama_kategori = ? WHERE id_kategori = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kategori.getNamaKategori());
            ps.setInt(2, kategori.getIdKategori());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Update Kategori: " + e.getMessage());
        }
    }

    // 4. DELETE (Hapus kategori)
    public void deleteKategori(int idKategori) {
        String sql = "DELETE FROM kategori WHERE id_kategori = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idKategori);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Delete Kategori: " + e.getMessage());
        }
    }
    
    // 5. SEARCH (Pencarian berdasarkan nama - Opsional tapi berguna untuk GUI)
    public List<Kategori> searchKategori(String keyword) {
        List<Kategori> listKategori = new ArrayList<>();
        String sql = "SELECT * FROM kategori WHERE nama_kategori LIKE ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%"); // Pencarian partial
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Kategori k = new Kategori();
                    k.setIdKategori(rs.getInt("id_kategori"));
                    k.setNamaKategori(rs.getString("nama_kategori"));
                    listKategori.add(k);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Search Kategori: " + e.getMessage());
        }
        return listKategori;
    }
    
    // Cek apakah kategori dipakai di produk
    public boolean isKategoriDigunakan(int idKategori) {
        boolean isUsed = false;
        String sql = "SELECT COUNT(*) AS total FROM produk WHERE id_kategori = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idKategori);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt("total");
                    if (total > 0) {
                        isUsed = true; // Kategori sedang digunakan!
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Cek Kategori: " + e.getMessage());
        }
        return isUsed;
    }
    
}
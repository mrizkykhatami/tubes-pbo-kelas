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
import model.Supplier;
import utils.Koneksi;

/**
 *
 * @author Personal
 */
public class SupplierDAO {

    // 1. READ (Ambil semua data supplier)
    public List<Supplier> getAllSupplier() {
        List<Supplier> listSupplier = new ArrayList<>();
        String sql = "SELECT * FROM supplier";

        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Supplier s = new Supplier();
                s.setIdSupplier(rs.getInt("id_supplier"));
                s.setNamaSupplier(rs.getString("nama_supplier"));
                s.setTelepon(rs.getString("telepon"));
                s.setAlamat(rs.getString("alamat"));
                
                listSupplier.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error Get All Supplier: " + e.getMessage());
        }
        return listSupplier;
    }

    // 2. CREATE (Tambah supplier baru)
    public void addSupplier(Supplier supplier) {
        String sql = "INSERT INTO supplier (nama_supplier, telepon, alamat) VALUES (?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, supplier.getNamaSupplier());
            ps.setString(2, supplier.getTelepon());
            ps.setString(3, supplier.getAlamat());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Add Supplier: " + e.getMessage());
        }
    }

    // 3. UPDATE (Ubah data supplier)
    public void updateSupplier(Supplier supplier) {
        String sql = "UPDATE supplier SET nama_supplier = ?, telepon = ?, alamat = ? WHERE id_supplier = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, supplier.getNamaSupplier());
            ps.setString(2, supplier.getTelepon());
            ps.setString(3, supplier.getAlamat());
            ps.setInt(4, supplier.getIdSupplier());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Update Supplier: " + e.getMessage());
        }
    }

    // 4. DELETE (Hapus supplier)
    public void deleteSupplier(int idSupplier) {
        String sql = "DELETE FROM supplier WHERE id_supplier = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idSupplier);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Delete Supplier: " + e.getMessage());
        }
    }

    // 5. SEARCH (Pencarian berdasarkan nama supplier)
    public List<Supplier> searchSupplier(String keyword) {
        List<Supplier> listSupplier = new ArrayList<>();
        String sql = "SELECT * FROM supplier WHERE nama_supplier LIKE ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Supplier s = new Supplier();
                    s.setIdSupplier(rs.getInt("id_supplier"));
                    s.setNamaSupplier(rs.getString("nama_supplier"));
                    s.setTelepon(rs.getString("telepon"));
                    s.setAlamat(rs.getString("alamat"));
                    
                    listSupplier.add(s);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Search Supplier: " + e.getMessage());
        }
        return listSupplier;
    }
}
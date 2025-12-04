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
import model.Produk;
import utils.Koneksi;

/**
 *
 * @author Personal
 */
public class ProdukDAO {

    // 1. READ (Ambil semua data produk)
    public static List<Produk> getAllProduk() {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk";

        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produk p = new Produk();
                p.setIdProduk(rs.getInt("id_produk"));
                p.setIdKategori(rs.getInt("id_kategori"));
                p.setIdSupplier(rs.getInt("id_supplier"));
                p.setNamaProduk(rs.getString("nama_produk"));
                p.setHarga(rs.getInt("harga"));
                p.setStok(rs.getInt("stok"));
                
                listProduk.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error Get All Produk: " + e.getMessage());
        }
        return listProduk;
    }

    // 2. CREATE (Tambah produk baru)
    public void addProduk(Produk produk) {
        // id_produk auto increment, create_at/update_at otomatis
        String sql = "INSERT INTO produk (id_kategori, id_supplier, nama_produk, harga, stok) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, produk.getIdKategori());
            ps.setInt(2, produk.getIdSupplier());
            ps.setString(3, produk.getNamaProduk());
            ps.setDouble(4, produk.getHarga());
            ps.setInt(5, produk.getStok());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Add Produk: " + e.getMessage());
        }
    }

    // 3. UPDATE (Ubah data produk)
    public void updateProduk(Produk produk) {
        String sql = "UPDATE produk SET id_kategori = ?, id_supplier = ?, nama_produk = ?, harga = ?, stok = ? WHERE id_produk = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, produk.getIdKategori());
            ps.setInt(2, produk.getIdSupplier());
            ps.setString(3, produk.getNamaProduk());
            ps.setDouble(4, produk.getHarga());
            ps.setInt(5, produk.getStok());
            ps.setInt(6, produk.getIdProduk()); // Parameter WHERE
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Update Produk: " + e.getMessage());
        }
    }

    // 4. DELETE (Hapus produk)
    public void deleteProduk(int idProduk) {
        String sql = "DELETE FROM produk WHERE id_produk = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idProduk);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Delete Produk: " + e.getMessage());
        }
    }

    // 5. SEARCH (Pencarian berdasarkan nama produk)
    public List<Produk> searchProduk(String keyword) {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk WHERE nama_produk LIKE ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Produk p = new Produk();
                    p.setIdProduk(rs.getInt("id_produk"));
                    p.setIdKategori(rs.getInt("id_kategori"));
                    p.setIdSupplier(rs.getInt("id_supplier"));
                    p.setNamaProduk(rs.getString("nama_produk"));
                    p.setHarga(rs.getInt("harga"));
                    p.setStok(rs.getInt("stok"));
                    
                    listProduk.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Search Produk: " + e.getMessage());
        }
        return listProduk;
    }
    
    public static Produk getProdukById(int idProduk) {
        String sql = "SELECT * FROM produk WHERE id_produk = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idProduk);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Produk p = new Produk();
                    p.setIdProduk(rs.getInt("id_produk"));
                    p.setIdKategori(rs.getInt("id_kategori"));
                    p.setIdSupplier(rs.getInt("id_supplier"));
                    p.setNamaProduk(rs.getString("nama_produk"));
                    p.setHarga(rs.getInt("harga"));
                    p.setStok(rs.getInt("stok"));
                    return p;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Get Produk By Id: " + e.getMessage());
        }
        return null;
    }

}
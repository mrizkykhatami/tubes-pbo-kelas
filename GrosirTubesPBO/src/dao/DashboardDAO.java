/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Personal
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produk;
import utils.Koneksi;

public class DashboardDAO {

    // Ambil Total Uang Masuk Hari Ini
    public double getOmsetHariIni() {
        double total = 0;
        String sql = "SELECT SUM(total_harga) AS total FROM penjualan WHERE DATE(tanggal) = CURDATE()";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println("Error Omset: " + e.getMessage());
        }
        return total;
    }

    // Ambil Jumlah Transaksi Hari Ini
    public int getTransaksiHariIni() {
        int jumlah = 0;
        String sql = "SELECT COUNT(*) AS total FROM penjualan WHERE DATE(tanggal) = CURDATE()";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                jumlah = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error Count Transaksi: " + e.getMessage());
        }
        return jumlah;
    }

    // Ambil Total Jumlah Produk
    public int getTotalProduk() {
        int jumlah = 0;
        String sql = "SELECT COUNT(*) AS total FROM produk";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                jumlah = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error Count Produk: " + e.getMessage());
        }
        return jumlah;
    }

    // Ambil Daftar Produk yang Stoknya Menipis (Misal di bawah 10)
    public List<Produk> getProdukStokTipis(int batasStok) {
        List<Produk> list = new ArrayList<>();
        String sql = "SELECT * FROM produk WHERE stok <= ? ORDER BY stok ASC";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, batasStok);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Produk p = new Produk();
                    p.setIdProduk(rs.getInt("id_produk"));
                    p.setNamaProduk(rs.getString("nama_produk"));
                    p.setStok(rs.getInt("stok"));
                    p.setHarga(rs.getInt("harga"));
                    list.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Stok Tipis: " + e.getMessage());
        }
        return list;
    }
}

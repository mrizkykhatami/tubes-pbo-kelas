/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DetailPenjualan;
import model.Penjualan;
import utils.Koneksi;
/**
 *
 * @author Personal
 */
public class LaporanPenjualanDAO {
    public List<Penjualan> getAllPenjualan() {
        List<Penjualan> list = new ArrayList<>();
        // Join dengan tabel user untuk dapat nama kasir
        String sql = "SELECT p.*, u.nama_user FROM penjualan p " +
                     "JOIN user u ON p.id_user = u.id_user " +
                     "ORDER BY p.tanggal ASC";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Penjualan p = new Penjualan();
                p.setIdPenjualan(rs.getInt("id_penjualan"));
                p.setIdUser(rs.getInt("id_user"));
                p.setTanggal(rs.getString("tanggal"));
                p.setTotalHarga(rs.getInt("total_harga"));
                
                p.setNamaUser(rs.getString("nama_user")); 
                
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error Get Laporan: " + e.getMessage());
        }
        return list;
    }
    
    public List<DetailPenjualan> getDetailTransaksi(int idPenjualan) {
        List<DetailPenjualan> list = new ArrayList<>();
        // Join dengan produk untuk dapat nama produk
        String sql = "SELECT dp.*, pr.nama_produk FROM detail_penjualan dp " +
                     "JOIN produk pr ON dp.id_produk = pr.id_produk " +
                     "WHERE dp.id_penjualan = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idPenjualan);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetailPenjualan dp = new DetailPenjualan();
                    dp.setIdProduk(rs.getInt("id_produk"));
                    dp.setNamaProduk(rs.getString("nama_produk"));
                    dp.setJumlah(rs.getInt("jumlah"));
                    dp.setHargaSatuan(rs.getInt("harga_satuan"));
                    dp.setSubtotal(rs.getInt("subtotal"));
                    
                    list.add(dp);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Get Detail: " + e.getMessage());
        }
        return list;
    }
}

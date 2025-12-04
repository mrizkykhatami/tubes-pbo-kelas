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
import java.sql.Statement;
import model.DetailPenjualan;
import model.Penjualan;
import utils.Koneksi;

public class PenjualanDAO {

    public boolean simpanTransaksi(Penjualan p) {
        Connection conn = null;
        PreparedStatement psPenjualan = null;
        PreparedStatement psDetail = null;
        PreparedStatement psUpdateStok = null;
        
        boolean isSuccess = false;

        try {
            conn = Koneksi.getConnection();
            
            conn.setAutoCommit(false);

            String sqlPenjualan = "INSERT INTO penjualan (id_user, tanggal, total_harga) VALUES (?, NOW(), ?)";
            psPenjualan = conn.prepareStatement(sqlPenjualan, Statement.RETURN_GENERATED_KEYS);
            
            psPenjualan.setInt(1, p.getIdUser());
            psPenjualan.setInt(2, p.getTotalHarga());
            psPenjualan.executeUpdate();

            int idPenjualanBaru = 0;
            try (ResultSet rs = psPenjualan.getGeneratedKeys()) {
                if (rs.next()) {
                    idPenjualanBaru = rs.getInt(1);
                }
            }

            String sqlDetail = "INSERT INTO detail_penjualan (id_penjualan, id_produk, jumlah, harga_satuan, subtotal) VALUES (?, ?, ?, ?, ?)";
            String sqlStok = "UPDATE produk SET stok = stok - ? WHERE id_produk = ?";
            
            psDetail = conn.prepareStatement(sqlDetail);
            psUpdateStok = conn.prepareStatement(sqlStok);

            // Looping barang di keranjang
            for (DetailPenjualan d : p.getListDetail()) {
                // Batch Insert Detail
                psDetail.setInt(1, idPenjualanBaru);
                psDetail.setInt(2, d.getIdProduk());
                psDetail.setInt(3, d.getJumlah());
                psDetail.setInt(4, d.getHargaSatuan());
                psDetail.setInt(5, d.getSubtotal());
                psDetail.addBatch(); // Masukkan ke antrian batch
                
                psUpdateStok.setInt(1, d.getJumlah()); // Kurangi stok sejumlah beli
                psUpdateStok.setInt(2, d.getIdProduk());
                psUpdateStok.addBatch();
            }

            psDetail.executeBatch();
            psUpdateStok.executeBatch();

            conn.commit();
            isSuccess = true;

        } catch (SQLException e) {
            System.out.println("Transaksi Gagal! Melakukan Rollback. Error: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Gagal Rollback: " + ex.getMessage());
                }
            }
        } finally {
            try {
                if (psPenjualan != null) psPenjualan.close();
                if (psDetail != null) psDetail.close();
                if (psUpdateStok != null) psUpdateStok.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
        
        return isSuccess;
    }
}

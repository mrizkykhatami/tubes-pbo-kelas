package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.DetailPembelian;
import model.Pembelian;
import model.Produk;
import utils.Koneksi;

public class PembelianDAO {
    
    public boolean simpanTransaksi(Pembelian pembelian) {
        Connection conn = null;
        PreparedStatement psPembelian = null;
        PreparedStatement psDetail = null;
        PreparedStatement psUpdateStok = null;
        ResultSet rs = null;
        
        try {
            conn = Koneksi.getConnection();
            conn.setAutoCommit(false); // Mulai transaksi
            
            // 1. Insert ke tabel pembelian
            String sqlPembelian = "INSERT INTO pembelian (id_user, id_supplier, total_harga) VALUES (?, ?, ?)";
            psPembelian = conn.prepareStatement(sqlPembelian, Statement.RETURN_GENERATED_KEYS);
            psPembelian.setInt(1, pembelian.getIdUser());
            psPembelian.setInt(2, pembelian.getIdSupplier());
            psPembelian.setInt(3, pembelian.getTotalHarga());
            psPembelian.executeUpdate();
            
            // Ambil ID pembelian yang baru saja di-generate
            rs = psPembelian.getGeneratedKeys();
            int idPembelian = 0;
            if (rs.next()) {
                idPembelian = rs.getInt(1);
            }
            
            // 2. Insert ke tabel detail_pembelian dan update stok
            String sqlDetail = "INSERT INTO detail_pembelian (id_pembelian, id_produk, jumlah, harga_satuan, subtotal) VALUES (?, ?, ?, ?, ?)";
            String sqlUpdateStok = "UPDATE produk SET stok = stok + ? WHERE id_produk = ?";
            
            psDetail = conn.prepareStatement(sqlDetail);
            psUpdateStok = conn.prepareStatement(sqlUpdateStok);
            
            for (DetailPembelian detail : pembelian.getListDetail()) {
                // Insert detail pembelian
                psDetail.setInt(1, idPembelian);
                psDetail.setInt(2, detail.getIdProduk());
                psDetail.setInt(3, detail.getJumlah());
                psDetail.setInt(4, detail.getHargaSatuan());
                psDetail.setInt(5, detail.getSubTotal());
                psDetail.executeUpdate();
                
                // Update stok produk (tambah stok)
                psUpdateStok.setInt(1, detail.getJumlah());
                psUpdateStok.setInt(2, detail.getIdProduk());
                psUpdateStok.executeUpdate();
            }
            
            conn.commit(); // Commit transaksi
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error Simpan Transaksi Pembelian: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback jika error
                } catch (SQLException ex) {
                    System.out.println("Error Rollback: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (psPembelian != null) psPembelian.close();
                if (psDetail != null) psDetail.close();
                if (psUpdateStok != null) psUpdateStok.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error Close Connection: " + e.getMessage());
            }
        }
    }
}
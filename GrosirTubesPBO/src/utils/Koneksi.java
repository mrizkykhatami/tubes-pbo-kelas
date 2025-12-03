/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Personal
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/db_grosir";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        try {
            // Load driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Selalu buat dan kembalikan koneksi BARU
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException e) {
            // Ubah ClassNotFoundException menjadi SQLException agar bisa ditangkap oleh DAO
            throw new SQLException("Driver MySQL tidak ditemukan", e);
        }
    }
}

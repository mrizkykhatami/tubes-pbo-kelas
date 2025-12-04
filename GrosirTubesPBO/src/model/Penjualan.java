/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HYPE AMD
 */
public class Penjualan {
    private int idPenjualan;
    private int idUser;
    private String tanggal;
    private int totalHarga;
    private String createAt;
    private String updateAt;

    public Penjualan() {
    }

    public Penjualan(int idPenjualan, int idUser, String tanggal, int totalHarga, String createAt, String updateAt) {
        this.idPenjualan = idPenjualan;
        this.idUser = idUser;
        this.tanggal = tanggal;
        this.totalHarga = totalHarga;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    // Setters
    public void setIdPenjualan(int idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void settanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
    
    // Getters
    public int getIdPenjualan() {
        return idPenjualan;
    }

    public int getIdUser() {
        return idUser;
    }

    public String gettanggal() {
        return tanggal;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }
}

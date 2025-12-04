/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Pembelian {
    private int idPembelian;
    private int idUser;
    private int idSupplier;
    private int totalHarga;
    private String createAt;
    private String updateAt;

    public Pembelian() {
    }

    public Pembelian(int idPembelian, int idUser, int idSupplier, int totalHarga, String createAt, String updateAt) {
        this.idPembelian = idPembelian;
        this.idUser = idUser;
        this.idSupplier = idSupplier;
        this.totalHarga = totalHarga;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    // Setters
    public void setIdPembelian(int idPembelian) {
        this.idPembelian = idPembelian;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
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
    public int getIdPembelian() {
        return idPembelian;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getidSupplier() {
        return idSupplier;
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


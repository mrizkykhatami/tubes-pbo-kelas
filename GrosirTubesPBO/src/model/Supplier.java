/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Personal
 */
public class Supplier {
    private int idSupplier;
    private String namaSupplier;
    private String telepon;
    private String alamat;

    // Constructor Kosong
    public Supplier() {
    }

    // Constructor Lengkap (Untuk mengambil data dari DB)
    public Supplier(int idSupplier, String namaSupplier, String telepon, String alamat) {
        this.idSupplier = idSupplier;
        this.namaSupplier = namaSupplier;
        this.telepon = telepon;
        this.alamat = alamat;
    }

    // Constructor untuk Insert
    public Supplier(String namaSupplier, String telepon, String alamat) {
        this.namaSupplier = namaSupplier;
        this.telepon = telepon;
        this.alamat = alamat;
    }

    // Setter dan Getter
    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

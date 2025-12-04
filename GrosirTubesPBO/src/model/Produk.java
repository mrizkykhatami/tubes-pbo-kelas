/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Personal
 */
public class Produk {
    private int idProduk;
    private int idKategori;
    private int idSupplier;
    private String namaProduk;
    private int harga;
    private int stok;

    // Constructor Kosong
    public Produk() {
    }

    // Constructor Lengkap (Untuk mengambil data dari DB)
    public Produk(int idProduk, int idKategori, int idSupplier, String namaProduk, int harga, int stok) {
        this.idProduk = idProduk;
        this.idKategori = idKategori;
        this.idSupplier = idSupplier;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    // Constructor untuk Insert
    public Produk(int idKategori, int idSupplier, String namaProduk, int harga, int stok) {
        this.idKategori = idKategori;
        this.idSupplier = idSupplier;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    // Setter dan Getter
    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}

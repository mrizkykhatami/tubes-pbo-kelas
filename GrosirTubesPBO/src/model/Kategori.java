/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Personal
 */
public class Kategori {
    private int idKategori; 
    private String namaKategori;

    // Constructor Kosong
    public Kategori() {
    }

    // Constructor Lengkap (Untuk mengambil data dari DB)
    public Kategori(int idKategori, String namaKategori) {
        this.idKategori = idKategori;
        this.namaKategori = namaKategori;
    }
    
    // Constructor untuk Insert
    public Kategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    // Setter dan Getter
    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }
}

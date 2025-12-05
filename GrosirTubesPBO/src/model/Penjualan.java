package model;

import java.util.ArrayList;
import java.util.List;

public class Penjualan {
    private int idPenjualan;
    private int idUser; // Kasir yang login
    private String tanggal;
    private int totalHarga;
    
    private String namaUser;
    
    // List untuk menampung barang-barang yang dibeli dalam 1 struk ini
    private List<DetailPenjualan> listDetail = new ArrayList<>();

    public Penjualan() {
    }
    
    // Setter dan Getter
    public int getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(int idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public List<DetailPenjualan> getListDetail() {
        return listDetail;
    }

    public void setListDetail(List<DetailPenjualan> listDetail) {
        this.listDetail = listDetail;
    }
    
    public String getNamaUser() {
        return namaUser;
    }
    
    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }
    
    // Helper untuk menambah item ke list
    public void addDetail(DetailPenjualan detail) {
        this.listDetail.add(detail);
    }
}
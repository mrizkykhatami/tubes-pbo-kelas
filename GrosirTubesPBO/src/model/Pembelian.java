package model;

import java.util.List;

public class Pembelian {
    private int idPembelian;
    private int idUser;
    private int idSupplier;
    private String tanggal;
    private int totalHarga;
    private String createAt;
    private String updateAt;
    
    private String namaUser;
    
    // Untuk menyimpan list detail pembelian
    private List<DetailPembelian> listDetail;
    
    // Constructor kosong
    public Pembelian() {
    }
    
    // Constructor lengkap
    public Pembelian(int idPembelian, int idUser, int idSupplier, String tanggal, int totalHarga, String createAt, String updateAt) {
        this.idPembelian = idPembelian;
        this.idUser = idUser;
        this.idSupplier = idSupplier;
        this.tanggal = tanggal;
        this.totalHarga = totalHarga;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
    
    // Constructor untuk insert
    public Pembelian(int idUser, int idSupplier, int totalHarga) {
        this.idUser = idUser;
        this.idSupplier = idSupplier;
        this.totalHarga = totalHarga;
    }
    
    // Getter dan Setter
    public int getIdPembelian() {
        return idPembelian;
    }
    
    public void setIdPembelian(int idPembelian) {
        this.idPembelian = idPembelian;
    }
    
    public int getIdUser() {
        return idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public String getNamaUser() {
        return namaUser;
    }
    
    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }
    
    public int getIdSupplier() {
        return idSupplier;
    }
    
    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
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
    
    public String getCreateAt() {
        return createAt;
    }
    
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
    
    public String getUpdateAt() {
        return updateAt;
    }
    
    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
    
    public List<DetailPembelian> getListDetail() {
        return listDetail;
    }
    
    public void setListDetail(List<DetailPembelian> listDetail) {
        this.listDetail = listDetail;
    }
}
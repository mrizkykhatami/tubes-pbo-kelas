package model;

public class DetailPenjualan {
    private int idDetail;
    private int idPenjualan;
    private int idProduk;
    private int jumlah;
    private int hargaSatuan;
    private int subtotal;
    
    // Tambahan: Nama Produk (Untuk tampilan di Tabel Keranjang GUI, tidak masuk DB detail_penjualan)
    private String namaProduk; 

    public DetailPenjualan() {
    }

    // Constructor untuk Insert ke Keranjang
    public DetailPenjualan(int idProduk, String namaProduk, int jumlah, int hargaSatuan, int subtotal) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.subtotal = subtotal;
    }

    // Setter dan Getter
    public int getIdDetail() {
        return idDetail;
    }
    
    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdPenjualan() {
        return idPenjualan;
    }
    
    public void setIdPenjualan(int idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public int getIdProduk() {
        return idProduk;
    }
    
    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public int getJumlah() {
        return jumlah;
    }
    
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }
    
    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public int getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    
    public String getNamaProduk() {
        return namaProduk;
    }
    
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }
}
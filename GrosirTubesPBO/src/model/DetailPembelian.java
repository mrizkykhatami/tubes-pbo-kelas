package model;

public class DetailPembelian {
    private int idDetailPembelian;
    private int idPembelian;
    private int idProduk;
    private int jumlah;
    private int hargaSatuan;
    private int subTotal;
    private String createAt;
    private String updateAt;
    
    private String namaProduk;
    private String namaSupplier;

    public DetailPembelian(){
        
    }

    public DetailPembelian(int idDetailPembelian, int idPembelian, int idProduk, int jumlah, int hargaSatuan, int subTotal, String createAt, String updateAt){
        this.idDetailPembelian = idDetailPembelian;
        this.idPembelian = idPembelian;
        this.idProduk = idProduk;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.subTotal = subTotal;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
    
    public DetailPembelian(int idProduk, String namaProduk, String namaSupplier, int jumlah, int hargaSatuan, int subTotal) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.namaSupplier = namaSupplier;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.subTotal = subTotal;
    }

    // Setter
    public void setIdDetailPembelian(int idDetailPembelian){
        this.idDetailPembelian = idDetailPembelian;
    }
    public void setIdPembelian(int idPembelian){
        this.idPembelian = idPembelian;
    }
    public void setIdProduk(int idProduk){
        this.idProduk = idProduk;
    }
    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }
    public void setHargaSatuan(int hargaSatuan){
        this.hargaSatuan = hargaSatuan;
    }
    public void setSubTotal(int subTotal){
        this.subTotal = subTotal;
    }
    public void setCreateAt(String createAt){
        this.createAt = createAt;
    }
    public void setUpdateAt(String updateAt){
        this.updateAt = updateAt;
    }
    public void setNamaProduk(String namaProduk){
        this.namaProduk = namaProduk;
    }
    public void setNamaSupplier(String namaSupplier){
        this.namaSupplier = namaSupplier;
    }
    
    // Getter
    public int getIdDetailPembelian(){
        return this.idDetailPembelian;
    }
    public int getIdPembelian(){
        return this.idPembelian;
    }
    public int getIdProduk(){
        return this.idProduk;
    }
    public int getJumlah(){
        return this.jumlah;
    }
    public int getHargaSatuan(){
        return this.hargaSatuan;
    }
    public int getSubTotal(){
        return this.subTotal;
    }
    public String getCreateAt(){
        return this.createAt;
    }
    public String getUpdateAt(){
        return this.updateAt;
    }
    public String getNamaProduk(){
        return this.namaProduk;
    }
    public String getNamaSupplier(){
        return this.namaSupplier;
    }
}
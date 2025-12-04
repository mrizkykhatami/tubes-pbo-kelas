package model;

public class DetailPenjualan {
    private int idDetailPenjualan;
    private int idPenjualan;
    private int idProduk;
    private int jumlah;
    private int hargaSatuan;
    private int subTotal;
    private String createAt;
    private String updateAt;

    public DetailPenjualan(){
        
    }

    public DetailPenjualan(int idDetailPenjualan, int idPenjualan, int idProduk, int jumlah, int hargaSatuan, int subTotal, String createAt, String updateAt){
        this.idDetailPenjualan = idDetailPenjualan;
        this.idPenjualan = idPenjualan;
        this.idProduk = idProduk;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.subTotal = subTotal;
        this.createAt=createAt;
        this.updateAt=updateAt;
    }

    // Setter
    public void setIdDetailPenjualan(int idDetailPenjualan){
        this.idDetailPenjualan = idDetailPenjualan;
    }
    public void setIdPenjualan(int idPenjualan){
        this.idPenjualan = idPenjualan;
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
    // getter
    public int setIdDetailPenjualan(){
        return this.idDetailPenjualan;
    }
    public int setIdPenjualan(){
        return this.idPenjualan;
    }
    public int setIdProduk(){
        return this.idProduk;
    }
    public int setJumlah(){
        return this.jumlah;
    }
    public int setHargaSatuan(){
        return this.hargaSatuan;
    }
    public int setSubTotal(){
        return this.subTotal;
    }
    public String setCreateAt(){
        return this.createAt;
    }
    public String setUpdateAt(){
        return this.updateAt;
    }

}

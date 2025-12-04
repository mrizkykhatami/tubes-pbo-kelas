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

    public DetailPembelian(){
        
    }

    public DetailPembelian(int idDetailPembelian, int idPembelian, int idProduk, int jumlah, int hargaSatuan, int subTotal, String createAt, String updateAt){
        this.idDetailPembelian = idDetailPembelian;
        this.idPembelian = idPembelian;
        this.idProduk = idProduk;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.subTotal = subTotal;
        this.createAt=createAt;
        this.updateAt=updateAt;
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
    // getter
    public int setIdDetailPembelian(){
        return this.idDetailPembelian;
    }
    public int setIdPembelian(){
        return this.idPembelian;
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

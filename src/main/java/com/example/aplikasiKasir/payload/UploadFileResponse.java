package com.example.aplikasiKasir.payload;

public class UploadFileResponse {
    private Long id;
    private String namaBarang;
    private int harga;
    private int stok;
    private int ukuran;
    private String fileDownloadUri;

    public UploadFileResponse(Long id, String namaBarang, int harga, int stok, int ukuran, String fileDownloadUri) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
        this.ukuran = ukuran;
        this.fileDownloadUri = fileDownloadUri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHarga() {
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

    public int getUkuran() {
        return ukuran;
    }

    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }
}

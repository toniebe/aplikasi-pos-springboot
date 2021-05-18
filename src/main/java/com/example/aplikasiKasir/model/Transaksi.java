package com.example.aplikasiKasir.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Transaksi {

    @Id
    @SequenceGenerator(
            name ="transaksi_sequence",
            sequenceName ="transaksi_sequence",
            allocationSize =1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaksi_sequence"
    )
    private long id;
    private String barang;
    private String pembeli;
    private String deskripsi;
    private int harga;
    private LocalDate tanggal = LocalDate.now();

    public Transaksi() {

    }

    public Transaksi(long id, String barang, String pembeli, String deskripsi, int harga, LocalDate tanggal) {
        this.id = id;
        this.barang = barang;
        this.pembeli = pembeli;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.tanggal = tanggal;
    }

    public Transaksi(String barang, String pembeli, String deskripsi, int harga, LocalDate tanggal) {
        this.barang = barang;
        this.pembeli = pembeli;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.tanggal = tanggal;
    }

    public Transaksi(String barang, String pembeli, String deskripsi, int harga) {
        this.barang = barang;
        this.pembeli = pembeli;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "id=" + id +
                ", barang='" + barang + '\'' +
                ", pembeli='" + pembeli + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", harga=" + harga +
                ", tanggal=" + tanggal +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getPembeli() {
        return pembeli;
    }

    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public LocalDate getTanggal() {
        return LocalDate.now();
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }
}

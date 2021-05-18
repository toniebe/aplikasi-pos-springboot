package com.example.aplikasiKasir.model;

import javax.persistence.*;

@Entity
@Table
public class Barang {
    @Id
    @SequenceGenerator(
            name ="barang_sequence",
            sequenceName ="barang_sequence",
            allocationSize =1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "barang_sequence"
    )
    private Long id;
    private String namaBarang;
    private int harga;
    private int stok;
    private int ukuran;

    public Barang() {
    }

    public Barang(Long id, String namaBarang, int harga, int stok, int ukuran) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
        this.ukuran = ukuran;
    }

    public Barang(String namaBarang, int harga, int stok, int ukuran) {
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
        this.ukuran = ukuran;
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

    @Override
    public String toString() {
        return "Barang{" +
                "id=" + id +
                ", namaBarang='" + namaBarang + '\'' +
                ", harga=" + harga +
                ", stok=" + stok +
                ", ukuran=" + ukuran +
                '}';
    }
}

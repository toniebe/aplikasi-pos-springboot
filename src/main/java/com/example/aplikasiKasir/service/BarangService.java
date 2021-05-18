package com.example.aplikasiKasir.service;

import com.example.aplikasiKasir.model.Barang;
import com.example.aplikasiKasir.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BarangService {
    private final BarangRepository barangRepository;

    @Autowired
    public BarangService(BarangRepository barangRepository) {
        this.barangRepository = barangRepository;
    }

    public List<Barang> getBarang(){
        return barangRepository.findAll();
    }

    public void tambahBarang(Barang barang){
        barangRepository.save(barang);
    }

    public boolean hapusBarang(Long barangId){
        boolean exists = barangRepository.existsById(barangId);
        if(exists){
            barangRepository.deleteById(barangId);
            return true;
        }
        return false;
    }

    @Transactional
    public void updateBarang(Long barangId,String nama,int harga){
        Barang barang = barangRepository.findById(barangId).orElseThrow(
                ()->new IllegalStateException("student with id " + barangId + " does not exists")
        );

        if(nama != null && nama.length() > 0 && !Objects.equals(barang.getNamaBarang(),nama)){
            barang.setNamaBarang(nama);
        }

        if(harga != 0 && !Objects.equals(barang.getHarga(),harga)){
           barang.setHarga(harga);
        }
    }

    public Optional<Barang> getBarangById(Long id){
        Optional<Barang> barangs = barangRepository.findById(id);
        return barangs;
    }

}

package com.example.aplikasiKasir.service;

import com.example.aplikasiKasir.model.Transaksi;
import com.example.aplikasiKasir.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    private final TransaksiRepository transaksiRepository;

    @Autowired
    public TransaksiService(TransaksiRepository transaksiRepository) {
        this.transaksiRepository = transaksiRepository;
    }

    public List<Transaksi> getTransaksi(){ return transaksiRepository.findAll(); }

    public void addNewTransaksi(Transaksi transaksi){
        transaksiRepository.save(transaksi);
    }
}

package com.example.aplikasiKasir.controller;


import com.example.aplikasiKasir.model.Transaksi;
import com.example.aplikasiKasir.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/transaksi")
public class TransaksiController {

    private final TransaksiService transaksiService;

    @Autowired
    public TransaksiController(TransaksiService transaksiService) {
        this.transaksiService = transaksiService;
    }

    @GetMapping
    public List<Transaksi> getTransaksi(){
        return transaksiService.getTransaksi();
    }

    @PostMapping
    public void registerNewTransaksi(@RequestBody Transaksi transaksi){
        System.out.println(transaksi);
        transaksiService.addNewTransaksi(transaksi);
    }

}

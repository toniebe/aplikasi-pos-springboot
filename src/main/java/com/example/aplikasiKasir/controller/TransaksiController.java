package com.example.aplikasiKasir.controller;


import com.example.aplikasiKasir.model.Transaksi;
import com.example.aplikasiKasir.service.TransaksiService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getTransaksi(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","success");
        jsonObject.put("data",transaksiService.getTransaksi());
        jsonObject.put("status","200");
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registerNewTransaksi(@RequestBody Transaksi transaksi){
        System.out.println(transaksi);
        transaksiService.addNewTransaksi(transaksi);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "success");
        jsonObject.put("data", transaksi);
        jsonObject.put("status", "201");
        return new ResponseEntity<>(jsonObject, HttpStatus.CREATED);
    }

}

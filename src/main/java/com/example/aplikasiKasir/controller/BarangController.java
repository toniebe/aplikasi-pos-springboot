package com.example.aplikasiKasir.controller;

import com.example.aplikasiKasir.model.Barang;
import com.example.aplikasiKasir.service.BarangService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/barang")
public class BarangController {
    private final BarangService barangService;

    @Autowired
    public BarangController(BarangService barangService) {
        this.barangService = barangService;
    }

    @GetMapping
    public ResponseEntity<?> getBarang(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","success");
        jsonObject.put("data",barangService.getBarang());
        jsonObject.put("status","200");
        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addBarang(@RequestBody Barang barang){
        barangService.tambahBarang(barang);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","success");
        jsonObject.put("data",barang);
        jsonObject.put("status","201");
        return new ResponseEntity<>(jsonObject,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBarang(@PathVariable("id") Long id){
        JSONObject jsonObject = new JSONObject();
        if (barangService.hapusBarang(id)){
            jsonObject.put("message","success");
            jsonObject.put("status","200");
            return new ResponseEntity<>(jsonObject, HttpStatus.ACCEPTED);
        }
        jsonObject.put("message","failed id not exist");
        jsonObject.put("status","200");
        return new ResponseEntity<>(jsonObject,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putBarang(@PathVariable("id") Long id,@RequestParam String namaBarang,@RequestParam int harga){
        JSONObject jsonObject = new JSONObject();
        System.out.println(id + " " + namaBarang + " " + harga);

        barangService.updateBarang(id,namaBarang,harga);
        jsonObject.put("message","success");
        jsonObject.put("status","200");
        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }

}

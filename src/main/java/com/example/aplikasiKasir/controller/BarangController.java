package com.example.aplikasiKasir.controller;

import com.example.aplikasiKasir.model.Barang;
import com.example.aplikasiKasir.payload.UploadFileResponse;
import com.example.aplikasiKasir.service.BarangService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PutMapping(path = "/upload/{id}")
    public UploadFileResponse uploadFoto(@PathVariable("id") Long id , @RequestParam("file") MultipartFile file){
        Barang barang = barangService.uploadFoto(id,file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/barang/downloadFile/")
                .path(barang.getId().toString())
                .toUriString();
        barangService.urlGambar(id,fileDownloadUri);

        return new UploadFileResponse(id,barang.getNamaBarang(),barang.getHarga(),barang.getStok(),barang.getUkuran(),fileDownloadUri);

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
        barangService.updateBarang(id,namaBarang,harga);
        jsonObject.put("message","success");
        jsonObject.put("status","200");
        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBarangId(@PathVariable("id") Long id){
        Barang barang = barangService.getBarangById(id);
        UploadFileResponse uploadFileResponse = new UploadFileResponse(barang.getId(),barang.getNamaBarang(),barang.getHarga(),barang.getStok(),barang.getUkuran(),barang.getUrlGambar());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","success");
        jsonObject.put("status","200");
        jsonObject.put("data",barangService.getBarangById(id));
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") Long id){
        Barang barang = barangService.getBarangById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(barang.getFileType()))
                .body(new ByteArrayResource(barang.getData()));
    }

}

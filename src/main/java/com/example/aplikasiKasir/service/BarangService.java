package com.example.aplikasiKasir.service;

import com.example.aplikasiKasir.exception.FileStorageException;
import com.example.aplikasiKasir.exception.MyFileNotFoundException;
import com.example.aplikasiKasir.model.Barang;
import com.example.aplikasiKasir.repository.BarangRepository;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
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

    @Transactional
    public Barang uploadFoto(Long id,MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Barang barang = barangRepository.findById(id).orElseThrow(
                ()->new IllegalStateException("barang with id " + id + " does not exists")
        );
        try{
            if (fileName.contains("..")){
                throw new FileStorageException("sorry file name contains invalid path sequence" + fileName);
            }
          barang.setData(file.getBytes());
            barang.setFileType(file.getContentType());
            return barang;
        }catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ". please try again ",ex);
        }
    }

    @Transactional
    public Barang urlGambar(Long id,String uri){
        Barang barang = barangRepository.findById(id).orElseThrow(
                ()->new IllegalStateException("barang with id " + id + " does not exists")
        );
        barang.setUrlGambar(uri);
        return barang;
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
                ()->new IllegalStateException("barang with id " + barangId + " does not exists")
        );

        if(nama != null && nama.length() > 0 && !Objects.equals(barang.getNamaBarang(),nama)){
            barang.setNamaBarang(nama);
        }

        if(harga != 0 && !Objects.equals(barang.getHarga(),harga)){
           barang.setHarga(harga);
        }
    }

    public Barang getBarangById(Long id){
        Barang barangs = barangRepository.findById(id).orElseThrow(
                () ->new MyFileNotFoundException("File not found with id " + id)
        );
        return barangs;
    }

}

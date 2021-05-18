package com.example.aplikasiKasir.repository;

import com.example.aplikasiKasir.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {
}

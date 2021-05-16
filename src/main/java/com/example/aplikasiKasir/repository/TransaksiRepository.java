package com.example.aplikasiKasir.repository;

import com.example.aplikasiKasir.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
}

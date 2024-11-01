package com.bgnc.ismerproject.repository;

import com.bgnc.ismerproject.model.Barkod;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BarkodRepository extends JpaRepository<Barkod,Long> {

    Barkod findByBarkodNo(@NotNull(message = "Barkod no is required field") String barkodNo);
}

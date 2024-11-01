package com.bgnc.ismerproject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "barkod")
public class Barkod extends BaseEntity {

    @Column(name = "barkodNo",unique = true)
    @NotNull(message = "Barkod no is required field")
    private String barkodNo;

}

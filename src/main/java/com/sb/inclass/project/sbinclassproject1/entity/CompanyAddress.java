package com.sb.inclass.project.sbinclassproject1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CompanyAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long address_id;

    private String address1;

    private String address2;

    private String address3;

    private String state;

    private String city;

    private Integer zip;

    @ManyToOne
    @JoinColumn(name = "fk_company_id", referencedColumnName = "company_id", nullable = false)
    private Company company;
}

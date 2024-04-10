package com.sb.inclass.project.sbinclassproject1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private Integer ein;

    private String email;

    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_emp_add_id")
    private EmployeeAddress employeeAddress;

    @ManyToMany
    @JoinTable(name = "employee_skillset",
    joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"))
    private List<SkillSet> skillSets;
}

package dev.fullstackcode.eis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter
@Setter
@ToString
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birth_date;
    private LocalDate hire_date;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;



    public Employee() {

    }

    public Employee(Integer id, String first_name, String last_name, Gender gender, LocalDate birth_date, LocalDate hire_date,
                    Department department) {
        super();
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.hire_date = hire_date;
        this.department = department;
    }

    public Employee(Integer id, String first_name, String last_name, Gender gender, LocalDate birth_date, LocalDate hire_date
    ) {
        super();
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.hire_date = hire_date;
    }





//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", first_name='" + first_name + '\'' +
//                ", last_name='" + last_name + '\'' +
//                ", gender=" + gender +
//                ", birth_date=" + birth_date +
//                ", hire_date=" + hire_date +
//                ", department=" + department +
//                '}';
//    }
}
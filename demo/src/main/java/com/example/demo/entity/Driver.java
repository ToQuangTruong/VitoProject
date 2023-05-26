package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "driver")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long driverId;

    @Column
    private String name;

    @Column
    private String licenseId;

    @Column
    private String licenseType;

    @Column
    private String address;

    @Column
    private Date dateOfBirth;

    @Column
    private Integer workTime;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<DriverCoach> driverCoach;
}

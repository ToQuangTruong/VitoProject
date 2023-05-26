package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "coach")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private Long coachId;

    @Column
    private String model;

    @Column
    private String manufacturer;

    @Column
    private String version;

    @Column
    private Integer seatNumber;

    @Column
    private Integer yearUsed;

    @Column
    private Date lastMaintenanceDay;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private List<Trip> trips;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private List<DriverCoach> driverCoach;
}

package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "driver_coach")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(DriverCoachPKId.class)
public class DriverCoach {

    @Id
    @Column(name = "coach_id", insertable = false, updatable = false)
    private Long coachId;

    @Id
    @Column(name = "driver_id", insertable = false, updatable = false)
    private Long driverId;

    @Column
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
    private Coach coach;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    private Driver driver;
}

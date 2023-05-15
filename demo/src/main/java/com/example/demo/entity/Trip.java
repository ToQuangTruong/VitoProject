package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "trip")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "route_id", insertable = false, updatable = false)
    private Long routeId;

    @Column
    private Integer guestNumber;

    @Column
    private Double price;

    @Column(name = "coach_id", insertable = false, updatable = false)
    private Long coachId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
    private Coach coach;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    private Route route;
}

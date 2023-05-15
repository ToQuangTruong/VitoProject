package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "route")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long routeId;

    @Column
    private String firstPoint;

    @Column
    private String endPoint;

    @Column
    private Double distance;

    @Column
    private String complicateLevel;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Trip> trips;
}

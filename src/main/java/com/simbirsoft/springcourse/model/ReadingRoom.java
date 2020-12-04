package com.simbirsoft.springcourse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ReadingRoom")
public class ReadingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    private Library library;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id", referencedColumnName = "id")
    private Reader reader;

    @Column(name = "residueReader")
    private Integer residueReader;

}

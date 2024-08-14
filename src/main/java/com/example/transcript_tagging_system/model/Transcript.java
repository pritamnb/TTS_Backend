

package com.example.transcript_tagging_system.model;

import lombok.Data;

//import javax.persistence.*;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Data
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Segment> segments;
}

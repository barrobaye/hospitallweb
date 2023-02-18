package model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String libelle;


    @ManyToMany(mappedBy = "specialites")
    private List<Medecin> medecins;




    @ManyToOne
    @JoinColumn(name = "service")
    private Service service;
}

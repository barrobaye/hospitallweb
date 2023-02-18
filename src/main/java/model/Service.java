package model;

import javax.persistence.*;
import java.util.List;
@Entity

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50 , nullable = false)
    private String libelle;


    @OneToMany(mappedBy = "service")

    List<Medecin> medecins;

    @OneToMany(mappedBy = "service")
    List<Specialite> specialites;
}

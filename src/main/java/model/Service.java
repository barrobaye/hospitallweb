package model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
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

package model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String adresse;

    private String matricule;

    private int salaire;

    @Temporal(TemporalType.DATE)
    private Date datenaissance;

    @Temporal(TemporalType.DATE)
    private Date dateembauche;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service")
    private Service service;


    @JoinTable(
            name = "medecin_specialite",
            joinColumns = @JoinColumn(name = "specialite"),
            inverseJoinColumns = @JoinColumn(name = "medecin")
    )
    @ManyToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE },fetch = FetchType.LAZY)
    private List<Specialite> specialites;
}

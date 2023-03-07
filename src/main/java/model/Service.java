package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    List<Medecin> medecins;

     @JsonIgnore
    @OneToMany(mappedBy = "service",fetch = FetchType.LAZY)
    List<Specialite> specialites;
}

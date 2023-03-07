package model;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

@JsonIgnore
    @ManyToMany(mappedBy = "specialites",fetch = FetchType.LAZY)
    private List<Medecin> medecins;




    @ManyToOne
    @JoinColumn(name = "service")
    private Service service;
}

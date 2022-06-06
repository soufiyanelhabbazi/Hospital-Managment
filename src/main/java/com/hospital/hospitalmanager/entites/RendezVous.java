package com.hospital.hospitalmanager.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    @Id
    private String id;

    @Temporal(TemporalType.DATE)
    private Date dateRdV;

    @Enumerated(EnumType.STRING)
    private StatusRDV status;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

    @OneToOne (mappedBy = "rendezVous")
    private Consultation consulation;
}

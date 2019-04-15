package com.epul.oeuvres.metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by christian on 19/02/2017.
 */
@Entity
@Table(name = "oeuvrevente", schema = "baseoeuvre", catalog = "")
public class OeuvreventeEntity {
    private int idOeuvrevente;
    private String titreOeuvrevente;
    private String etatOeuvrevente;
    private double prixOeuvrevente;
    private Integer idProprietaire;
    private ProprietaireEntity proprietaireByIdProprietaire;
    private Collection<ReservationEntity> reservationsByIdOeuvrevente;

    @Id
    @Column(name = "id_oeuvrevente")
    public int getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(int idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    @Basic
    @Column(name = "titre_oeuvrevente")
    public String getTitreOeuvrevente() {
        return titreOeuvrevente;
    }

    public void setTitreOeuvrevente(String titreOeuvrevente) {
        this.titreOeuvrevente = titreOeuvrevente;
    }

    @Basic
    @Column(name = "etat_oeuvrevente")
    public String getEtatOeuvrevente() {
        return etatOeuvrevente;
    }

    public void setEtatOeuvrevente(String etatOeuvrevente) {
        this.etatOeuvrevente = etatOeuvrevente;
    }

    @Basic
    @Column(name = "prix_oeuvrevente")
    public double getPrixOeuvrevente() {
        return prixOeuvrevente;
    }

    public void setPrixOeuvrevente(double prixOeuvrevente) {
        this.prixOeuvrevente = prixOeuvrevente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OeuvreventeEntity that = (OeuvreventeEntity) o;

        if (idOeuvrevente != that.idOeuvrevente) return false;
        if (Double.compare(that.prixOeuvrevente, prixOeuvrevente) != 0) return false;
        if (titreOeuvrevente != null ? !titreOeuvrevente.equals(that.titreOeuvrevente) : that.titreOeuvrevente != null)
            return false;
        if (etatOeuvrevente != null ? !etatOeuvrevente.equals(that.etatOeuvrevente) : that.etatOeuvrevente != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idOeuvrevente;
        result = 31 * result + (titreOeuvrevente != null ? titreOeuvrevente.hashCode() : 0);
        result = 31 * result + (etatOeuvrevente != null ? etatOeuvrevente.hashCode() : 0);
        temp = Double.doubleToLongBits(prixOeuvrevente);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Basic
    @Column(name = "id_proprietaire", updatable = false, insertable = false)
    public Integer getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @ManyToOne
    @JoinColumn(name = "id_proprietaire", referencedColumnName = "id_proprietaire")
    public ProprietaireEntity getProprietaireByIdProprietaire() {
        return proprietaireByIdProprietaire;
    }

    public void setProprietaireByIdProprietaire(ProprietaireEntity proprietaireByIdProprietaire) {
        this.proprietaireByIdProprietaire = proprietaireByIdProprietaire;
    }

    @OneToMany(mappedBy = "oeuvreventeByIdOeuvrevente")
    public Collection<ReservationEntity> getReservationsByIdOeuvrevente() {
        return reservationsByIdOeuvrevente;
    }

    public void setReservationsByIdOeuvrevente(Collection<ReservationEntity> reservationsByIdOeuvrevente) {
        this.reservationsByIdOeuvrevente = reservationsByIdOeuvrevente;
    }
}

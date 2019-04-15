package com.epul.oeuvres.metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by christian on 19/02/2017.
 */
@Entity
@Table(name = "proprietaire", schema = "baseoeuvre", catalog = "")
public class ProprietaireEntity {
    private int idProprietaire;
    private String nomProprietaire;
    private String prenomProprietaire;
    private Collection<OeuvrepretEntity> oeuvrepretsByIdProprietaire;
    private Collection<OeuvreventeEntity> oeuvreventesByIdProprietaire;

    @Id
    @Column(name = "id_proprietaire", insertable = false, updatable = false)
    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @Basic
    @Column(name = "nom_proprietaire")
    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    @Basic
    @Column(name = "prenom_proprietaire")
    public String getPrenomProprietaire() {
        return prenomProprietaire;
    }

    public void setPrenomProprietaire(String prenomProprietaire) {
        this.prenomProprietaire = prenomProprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProprietaireEntity that = (ProprietaireEntity) o;

        if (idProprietaire != that.idProprietaire) return false;
        if (nomProprietaire != null ? !nomProprietaire.equals(that.nomProprietaire) : that.nomProprietaire != null)
            return false;
        if (prenomProprietaire != null ? !prenomProprietaire.equals(that.prenomProprietaire) : that.prenomProprietaire != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProprietaire;
        result = 31 * result + (nomProprietaire != null ? nomProprietaire.hashCode() : 0);
        result = 31 * result + (prenomProprietaire != null ? prenomProprietaire.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "proprietaireByIdProprietaire")
    public Collection<OeuvrepretEntity> getOeuvrepretsByIdProprietaire() {
        return oeuvrepretsByIdProprietaire;
    }

    public void setOeuvrepretsByIdProprietaire(Collection<OeuvrepretEntity> oeuvrepretsByIdProprietaire) {
        this.oeuvrepretsByIdProprietaire = oeuvrepretsByIdProprietaire;
    }

    @OneToMany(mappedBy = "proprietaireByIdProprietaire")
    public Collection<OeuvreventeEntity> getOeuvreventesByIdProprietaire() {
        return oeuvreventesByIdProprietaire;
    }

    public void setOeuvreventesByIdProprietaire(Collection<OeuvreventeEntity> oeuvreventesByIdProprietaire) {
        this.oeuvreventesByIdProprietaire = oeuvreventesByIdProprietaire;
    }
}

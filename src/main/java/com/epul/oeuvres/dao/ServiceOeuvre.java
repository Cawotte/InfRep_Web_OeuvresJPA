package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ProprietaireEntity;
import com.epul.oeuvres.metier.ReservationEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceOeuvre extends EntityService{

    public List<OeuvreventeEntity> consulterListeOeuvres() throws MonException {
        List<OeuvreventeEntity> mesOeuvres = null;
        try
        {
            EntityTransaction transac = startTransaction();
            transac.begin();
            mesOeuvres = (List<OeuvreventeEntity>)
                    entitymanager.createQuery(
                            "SELECT a FROM OeuvreventeEntity a " +
                                    "ORDER BY a.titreOeuvrevente").getResultList();
            entitymanager.close();
        }
        catch (RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mesOeuvres;
    }

    public void deleteOeuvre(int idOeuvre) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            OeuvreventeEntity oeuvre = entitymanager.find(OeuvreventeEntity.class, idOeuvre);
            if (oeuvre != null) {
                entitymanager.remove(oeuvre);
            }
            transac.commit();
            entitymanager.close();

        }
        catch (RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public OeuvreventeEntity getOeuvreById(int id) throws MonException {
        //List<AdherentEntity> adherents = null;
        OeuvreventeEntity oeuvre = new OeuvreventeEntity();
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            oeuvre = entitymanager.find(OeuvreventeEntity.class, id);
            entitymanager.close();
        }catch (RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oeuvre;
    }

    public void updateOeuvre(OeuvreventeEntity oeuvre)
    {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.merge(oeuvre);
            transac.commit();
            entitymanager.close();
        }
        catch(RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e){
            new MonException("Erreur de lecture", e.getMessage());
        }
    }

    public void insertOeuvre(OeuvreventeEntity oeuvre)
    {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.persist(oeuvre);
            transac.commit();
            entitymanager.close();
        }
        catch(RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e){
            new MonException("Erreur de lecture", e.getMessage());
        }
    }

    public ProprietaireEntity getProprietaireById(int id) throws MonException {
        //List<AdherentEntity> adherents = null;
        ProprietaireEntity proprietaire = new ProprietaireEntity();
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            proprietaire = entitymanager.find(ProprietaireEntity.class, id);
            entitymanager.close();
        }catch (RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proprietaire;
    }

    public List<ProprietaireEntity> consulterListeProprietaire() throws MonException {
        List<ProprietaireEntity> mesProprietaires = null;
        try
        {
            EntityTransaction transac = startTransaction();
            transac.begin();
            mesProprietaires = (List<ProprietaireEntity>)
                    entitymanager.createQuery(
                            "SELECT a FROM ProprietaireEntity a ").getResultList();
            entitymanager.close();
        }
        catch (RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mesProprietaires;
    }

    public List<ReservationEntity> consulterListeReservation() throws MonException {
        List<ReservationEntity> mesReservations = null;
        try
        {
            EntityTransaction transac = startTransaction();
            transac.begin();
            mesReservations = (List<ReservationEntity>)
                    entitymanager.createQuery(
                            "SELECT a FROM ReservationEntity a ").getResultList();
            entitymanager.close();
        }
        catch (RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mesReservations;
    }

    public ReservationEntity getReservationById(int idOeuvre, int idAdherent) {
        ReservationEntity reservation = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            List<ReservationEntity> reservations = (List<ReservationEntity>)entitymanager.createQuery("SELECT a FROM ReservationEntity a WHERE a.idAdherent =" + idAdherent + "AND a.idOeuvrevente = " + idOeuvre).getResultList();
            reservation = reservations.get(0);
            entitymanager.close();
        }catch (RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservation;
    }

    public void validerReservation(int idOeuvre, int idAdherent) throws MonException{
        try  {
            ReservationEntity reservation = getReservationById(idOeuvre, idAdherent);
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            reservation.setStatut("confirmee");
            entitymanager.merge(reservation);
            transaction.commit();
            entitymanager.close();
        } catch(RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e){
            new MonException("Erreur de lecture", e.getMessage());
        }
    }

    public void annulerReservation(int idOeuvre, int idAdherent) throws MonException{
        try  {
            ReservationEntity reservation = getReservationById(idOeuvre, idAdherent);
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            reservation.setStatut("annulee");
            entitymanager.merge(reservation);
            transaction.commit();
            entitymanager.close();
        } catch(RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e){
            new MonException("Erreur de lecture", e.getMessage());
        }
    }

}

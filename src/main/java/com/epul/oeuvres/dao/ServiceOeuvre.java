package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ProprietaireEntity;

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

}

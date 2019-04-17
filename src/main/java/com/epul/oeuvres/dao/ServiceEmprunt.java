package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.OeuvrepretEntity;
import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ProprietaireEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceEmprunt extends EntityService{

    public List<OeuvrepretEntity> consulterListeEmprunts() throws MonException {
        List<OeuvrepretEntity> mesEmprunts = null;
        try
        {
            EntityTransaction transac = startTransaction();
            transac.begin();
            mesEmprunts = (List<OeuvrepretEntity>)
                    entitymanager.createQuery(
                            "SELECT a FROM OeuvrepretEntity a " +
                                    "ORDER BY a.titreOeuvrepret").getResultList();
            entitymanager.close();
        }
        catch (RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mesEmprunts;
    }

    public void deleteEmprunt(int idEmprunt) throws MonException {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            OeuvrepretEntity oeuvre = entitymanager.find(OeuvrepretEntity.class, idEmprunt);
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

    public void updateEmprunt(OeuvrepretEntity emprunt)
    {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.merge(emprunt);
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

    public void insertEmprunt(OeuvrepretEntity emprunt)
    {
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            entitymanager.persist(emprunt);
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

    public OeuvrepretEntity getEmpruntById(int id) throws MonException {
        OeuvrepretEntity emprunt = new OeuvrepretEntity();
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            emprunt = entitymanager.find(OeuvrepretEntity.class, id);
            entitymanager.close();
        }catch (RuntimeException e)
        {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emprunt;
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

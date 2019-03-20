package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import java.util.*;
import javax.persistence.*;
import com.epul.oeuvres.metier.*;


import javax.persistence.EntityTransaction;

public class Service extends EntityService{

	/* Insertion d'un adherent
	 * param Adherent unAdherent
	 * */
	public void insertAdherent(AdherentEntity unAdherent) throws MonException {
		try
		{
			EntityTransaction transac = startTransaction();
			transac.begin();
			entitymanager.persist(unAdherent);
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

	public void updateAdherent(AdherentEntity modifiedAdherent) throws MonException {
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			entitymanager.merge(modifiedAdherent);
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

	public void deleteAdherent(int idAdherent) throws MonException {
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();
			AdherentEntity adherent = entitymanager.find(AdherentEntity.class, idAdherent);
			if (adherent != null) {
				entitymanager.remove(adherent);
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

	/* Lister les adherents
	 * */
	public List<AdherentEntity> consulterListeAdherents() throws MonException {
		List<AdherentEntity> mesAdherents = null;
		try
		{
			EntityTransaction transac = startTransaction();
			transac.begin();
			mesAdherents = (List<AdherentEntity>)
					entitymanager.createQuery(
							"SELECT a FROM AdherentEntity a " +
									"ORDER BY a.nomAdherent").getResultList();
			entitymanager.close();
		}
		catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mesAdherents;
	}

	/* Consultation d'une adherent par son numéro
	*/
	public AdherentEntity getAdherentById(int id) throws MonException {
		//List<AdherentEntity> adherents = null;
		AdherentEntity adherent = new AdherentEntity();
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();

			//adherents = (List<AdherentEntity>)entitymanager.createQuery("SELECT a FROM AdherentEntity a WHERE a.idAdherent=" + id ).getResultList();
			//adherent = adherents.get(0);
			adherent = entitymanager.find(AdherentEntity.class, id);
			entitymanager.close();
		}catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adherent;
	}

	public UtilisateurEntity getUtilisateur( String login) throws MonException
	{
		UtilisateurEntity unUtilisateur=null;
	try {
		EntityTransaction transac = startTransaction();
		transac.begin();

		Query query = entitymanager.createNamedQuery("UtilisateurEntity.rechercheNom");
		query.setParameter("name", login);
		unUtilisateur = (UtilisateurEntity) query.getSingleResult();
		if (unUtilisateur == null) {
			new MonException("Utilisateur Inconnu", "Erreur ");
	}
		entitymanager.close();

	}
		catch(RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e){
		new MonException("Erreur de lecture", e.getMessage());
	}
		return unUtilisateur;
	}


}

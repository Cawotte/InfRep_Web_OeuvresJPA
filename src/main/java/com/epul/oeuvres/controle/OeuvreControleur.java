package com.epul.oeuvres.controle;


import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.dao.ServiceOeuvre;
import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.AdherentEntity;
import com.epul.oeuvres.metier.OeuvreventeEntity;
import com.epul.oeuvres.metier.ProprietaireEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

///
/// Les m�thode du contr�leur r�pondent � des sollicitations
/// des pages JSP

@SuppressWarnings("Duplicates")
@Controller
public class OeuvreControleur {


	@RequestMapping(value = "listerOeuvres.htm")
	public ModelAndView afficherLesStages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			ServiceOeuvre unService = new ServiceOeuvre();
			request.setAttribute("mesOeuvres", unService.consulterListeOeuvres());
			destinationPage = "vues/listerOeuvre";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";

		}
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "supprimerOeuvre.htm")
	public ModelAndView supprimerOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {


		String destinationPage = "";
		try {
			ServiceOeuvre unService = new ServiceOeuvre();
			unService.deleteOeuvre(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
			return new ModelAndView(destinationPage);
		}
		return afficherLesStages(request, response);

	}

	@RequestMapping(value = "updateOeuvre.htm")
	public ModelAndView updateOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String destinationPage = "";
		try {
			ServiceOeuvre unService = new ServiceOeuvre();
			OeuvreventeEntity oeuvre = new OeuvreventeEntity();
			oeuvre.setIdOeuvrevente(Integer.parseInt(request.getParameter("oeuvreId")));
			oeuvre.setProprietaireByIdProprietaire(unService.getProprietaireById(Integer.parseInt(request.getParameter("proprietaire"))));
			oeuvre.setTitreOeuvrevente(request.getParameter("titre"));
			oeuvre.setEtatOeuvrevente(request.getParameter("etat"));
			oeuvre.setPrixOeuvrevente(Double.parseDouble(request.getParameter("prix")));
			unService.updateOeuvre(oeuvre);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
			return new ModelAndView(destinationPage);
		}

		return afficherLesStages(request, response);
	}

	@RequestMapping(value = "modifierOeuvre.htm")
	public ModelAndView modifierOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			destinationPage = "vues/modifierOeuvre";

			ServiceOeuvre unService = new ServiceOeuvre();
			OeuvreventeEntity oeuvre = unService.getOeuvreById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("oeuvre", oeuvre);
			List<ProprietaireEntity> mesProprietaires = unService.consulterListeProprietaire();
			request.setAttribute("proprietaires", mesProprietaires);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}

		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "ajouterOeuvre.htm")
	public ModelAndView ajouterOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			ServiceOeuvre unService = new ServiceOeuvre();
			List<ProprietaireEntity> mesProprietaires = unService.consulterListeProprietaire();
			request.setAttribute("proprietaires", mesProprietaires);
			destinationPage = "vues/ajouterOeuvre";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}

		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "insererOeuvre.htm")
	public ModelAndView insertOeuvre(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String destinationPage = "";
		try {
			ServiceOeuvre unService = new ServiceOeuvre();
			OeuvreventeEntity oeuvre = new OeuvreventeEntity();
			oeuvre.setProprietaireByIdProprietaire(unService.getProprietaireById(Integer.parseInt(request.getParameter("proprietaire"))));
			oeuvre.setTitreOeuvrevente(request.getParameter("titre"));
			oeuvre.setEtatOeuvrevente("L");
			oeuvre.setPrixOeuvrevente(Double.parseDouble(request.getParameter("prix")));
			unService.insertOeuvre(oeuvre);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
			return new ModelAndView(destinationPage);
		}
		return afficherLesStages(request, response);
	}

}

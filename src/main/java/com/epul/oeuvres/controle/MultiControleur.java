package com.epul.oeuvres.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epul.oeuvres.utilitaires.FonctionsUtiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.meserreurs.*;
import com.epul.oeuvres.metier.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

///
/// Les méthode du contrôleur répondent à des sollicitations
/// des pages JSP

@SuppressWarnings("Duplicates")
@Controller
public class MultiControleur {

//	private static final Logger logger = LoggerFactory.getLogger(MultiControleur.class);

	@RequestMapping(value = "listerAdherent.htm")
	public ModelAndView afficherLesStages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			Service unService = new Service();
			request.setAttribute("mesAdherents", unService.consulterListeAdherents());
			destinationPage = "vues/listerAdherent";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";

		}
		return new ModelAndView(destinationPage);
	}



	@RequestMapping(value = "insererAdherent.htm")
	public ModelAndView insererAdherent(HttpServletRequest request,
										HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			AdherentEntity unAdherent = new AdherentEntity();
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			Service unService = new Service();
			unService.insertAdherent(unAdherent);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}
		destinationPage = "index";
		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "updateAdherent.htm")
	public ModelAndView updateAdherent(HttpServletRequest request,
										HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			AdherentEntity unAdherent = new AdherentEntity();
			unAdherent.setNomAdherent(request.getParameter("txtnom"));
			unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
			unAdherent.setVilleAdherent(request.getParameter("txtville"));
			unAdherent.setIdAdherent(Integer.parseInt(request.getParameter("id")));

			Service unService = new Service();
			unService.updateAdherent(unAdherent);

		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
			return new ModelAndView(destinationPage);
		}

		return afficherLesStages(request, response);
	}

	@RequestMapping(value = "modifierAdherent.htm")
	public ModelAndView modifierAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			destinationPage = "vues/modifierAdherent";

			Service unService = new Service();
			AdherentEntity adherent = unService.getAdherentById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("adherent", adherent);
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}

		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "ajouterAdherent.htm")
	public ModelAndView ajouterAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			destinationPage = "vues/ajouterAdherent";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
		}

		return new ModelAndView(destinationPage);
	}

	@RequestMapping(value = "supprimerAdherent.htm")
	public ModelAndView supprimerAdherent(HttpServletRequest request, HttpServletResponse response) throws Exception {


		String destinationPage = "";
		try {
			Service unService = new Service();
			unService.deleteAdherent(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "vues/Erreur";
			return new ModelAndView(destinationPage);
		}
		return afficherLesStages(request, response);

	}


	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "index.htm", method = RequestMethod.GET)
	public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("index");
	}

	// /
		// / Affichage de la page d'accueil
		// /
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return new ModelAndView("index");
		}
	// /
	// / Affichage de la page d'accueil
	// /
	@RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
	public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("vues/Erreur");
	}


}

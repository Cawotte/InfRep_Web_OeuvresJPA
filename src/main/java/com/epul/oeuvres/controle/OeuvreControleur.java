package com.epul.oeuvres.controle;


import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.AdherentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

///
/// Les méthode du contrôleur répondent à des sollicitations
/// des pages JSP

@SuppressWarnings("Duplicates")
@Controller
public class OeuvreControleur {


	@RequestMapping(value = "listerOeuvres.htm")
	public ModelAndView afficherLesStages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage;
		try {
			// HttpSession session = request.getSession();
			Service unService = new Service();
			request.setAttribute("mesOeuvres", unService.consulterListeOeuvres());
			destinationPage = "vues/listerOeuvre";
		} catch (MonException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "Erreur";

		}
		return new ModelAndView(destinationPage);
	}




}

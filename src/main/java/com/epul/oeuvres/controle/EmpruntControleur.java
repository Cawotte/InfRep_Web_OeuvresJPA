package com.epul.oeuvres.controle;


import com.epul.oeuvres.dao.Service;
import com.epul.oeuvres.dao.ServiceEmprunt;
import com.epul.oeuvres.dao.ServiceOeuvre;
import com.epul.oeuvres.meserreurs.MonException;
import com.epul.oeuvres.metier.AdherentEntity;
import com.epul.oeuvres.metier.OeuvrepretEntity;
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
public class EmpruntControleur {


    @RequestMapping(value = "listerEmprunts.htm")
    public ModelAndView afficherLesEmprunts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            ServiceEmprunt unService = new ServiceEmprunt();
            request.setAttribute("mesEmprunts", unService.consulterListeEmprunts());
            destinationPage = "vues/emprunts/listerEmprunts";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";

        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "supprimerEmprunt.htm")
    public ModelAndView supprimerEmprunt(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            ServiceEmprunt unService = new ServiceEmprunt();
            unService.deleteEmprunt(Integer.parseInt(request.getParameter("id")));
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
            return new ModelAndView(destinationPage);
        }
        return afficherLesEmprunts(request, response);

    }

    @RequestMapping(value = "updateEmprunt.htm")
    public ModelAndView updateEmprunt(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String destinationPage = "";
        try {
            ServiceEmprunt unService = new ServiceEmprunt();
            OeuvrepretEntity emprunt = new OeuvrepretEntity();
            emprunt.setIdOeuvrepret(Integer.parseInt(request.getParameter("empruntId")));
            emprunt.setProprietaireByIdProprietaire(unService.getProprietaireById(Integer.parseInt(request.getParameter("proprietaire"))));
            emprunt.setTitreOeuvrepret(request.getParameter("titre"));
            unService.updateEmprunt(emprunt);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
            return new ModelAndView(destinationPage);
        }

        return afficherLesEmprunts(request, response);
    }

    @RequestMapping(value = "modifierEmprunt.htm")
    public ModelAndView modifierEmprunt(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "vues/emprunts/modifierEmprunt";

            ServiceEmprunt unService = new ServiceEmprunt();

            OeuvrepretEntity emprunt = unService.getEmpruntById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("emprunt", emprunt);

            List<ProprietaireEntity> mesProprietaires = unService.consulterListeProprietaire();
            request.setAttribute("proprietaires", mesProprietaires);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "ajouterEmprunt.htm")
    public ModelAndView ajouterEmprunt(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            ServiceEmprunt unService = new ServiceEmprunt();
            List<ProprietaireEntity> mesProprietaires = unService.consulterListeProprietaire();
            request.setAttribute("proprietaires", mesProprietaires);
            destinationPage = "vues/emprunts/ajouterEmprunt";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "insererEmprunt.htm")
    public ModelAndView insererEmprunt(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String destinationPage = "";
        try {
            ServiceEmprunt unService = new ServiceEmprunt();
            OeuvrepretEntity emprunt = new OeuvrepretEntity();
            emprunt.setProprietaireByIdProprietaire(unService.getProprietaireById(Integer.parseInt(request.getParameter("proprietaire"))));
            emprunt.setTitreOeuvrepret(request.getParameter("titre"));
            unService.insertEmprunt(emprunt);
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
            return new ModelAndView(destinationPage);
        }
        return afficherLesEmprunts(request, response);
    }

}

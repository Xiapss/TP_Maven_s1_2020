package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String monParam) {
		
		System.out.println("Appel GET");
		
		System.out.println("Mon param : " + monParam);
		
		ArrayList<Ville> villes = villeBLOService.getInfoVilles(monParam);
		
		return villes;
	}
	
	// Methode POST
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody Ville ville) {
		System.out.println("Appel POST");
		//System.out.println(ville.getNomCommune());
		if(villeBLOService.ajoutVille(ville)) {
			System.out.println("ligne ajouté");
		}else {
			System.out.println("erreur lors de l'ajout de la ligne");
		}
		
	}
	
	
	
	// Methode DELETE
		@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
		@ResponseBody
		public void appelDelte(@RequestParam(required = true, value = "codeCommune") String monParam) {
			System.out.println("Appel DELETE");
			System.out.println(monParam);
			if(villeBLOService.suppVille(monParam)) {
				System.out.println("ligne supprimée");
			}else {
				System.out.println("Impossible de supprimer la ligne");
			}
		}
		
		// Methode PUT
		@RequestMapping(value = "/ville", method = RequestMethod.PUT)
		@ResponseBody
		public void appelPut(@RequestBody Ville ville) {
			System.out.println("Appel PUT");
			
			if(villeBLOService.modifierVille(ville)) {
				System.out.println("ligne modifiée");
			}else {
				System.out.println("Impossible de modifier la ligne");
			}
		}
}

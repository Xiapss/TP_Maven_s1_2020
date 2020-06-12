package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	
	public ArrayList<Ville> getInfoVilles(String param) {
		ArrayList<Ville> villes;
			
		if(param!=null) {
			villes = villeDAO.getInfoVilles(param);
		}else {
			villes = villeDAO.getInfoVilles();
		}
		
		
		return villes;
	}
	
	public boolean ajoutVille(Ville ville) {
		return villeDAO.ajoutVille(ville);
	}
	
	public boolean suppVille(String monParam) {
		return villeDAO.suppVille(monParam);
	}
	
	public boolean modifierVille(Ville ville) {
		return villeDAO.modifierVille(ville);
	}
}

package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	
	public ArrayList<Ville> getInfoVilles(String param);
	
	public boolean ajoutVille(Ville ville);
	
	public boolean suppVille(String monParam);
	
	public boolean modifierVille(Ville ville);
	
}


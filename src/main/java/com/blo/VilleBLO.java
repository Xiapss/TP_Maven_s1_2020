package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	
	public ArrayList<Ville> getInfoVilles(String param);
	
	public void ajoutVille(Ville ville);
	
}


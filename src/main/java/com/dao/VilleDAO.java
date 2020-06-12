package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> getInfoVilles();
	
	public ArrayList<Ville> getInfoVilles(String param);
	
	public void ajoutVille(Ville ville);

}

package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.ConfigBDD;
import com.dto.Ville;

@Repository
public class VilleDAOIplm implements VilleDAO {
	public ArrayList<Ville> getInfoVilles() {
		
		
		ArrayList<Ville> villes = new ArrayList<Ville>();
		
		String requete = "SELECT * FROM ville_france";
		Connection con = ConfigBDD.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			while (rs.next()) {
				Ville ville = new Ville();
				ville.setCodeCommune(rs.getString("code_commune_insee"));
				ville.setNomCommune(rs.getString("nom_commune"));
				ville.setCodePostal(rs.getString("code_postal"));
				ville.setLatitude(rs.getString("latitude"));
				ville.setLongitude(rs.getString("longitude"));
				ville.setLibellAacheminement(rs.getString("libelle_acheminement"));
				ville.setLigne_5(rs.getString("ligne_5"));
				villes.add(ville);
				//System.out.println("reponse : " + rs.getString("nom_commune"));
			}
			return villes;
		}catch(SQLException e) {
			System.out.println("Une erreur s'est produite.");
			return null;
		}
		
	}
	
	public ArrayList<Ville> getInfoVilles(String param) {
ArrayList<Ville> villes = new ArrayList<Ville>();
		
		String requete = "SELECT * FROM ville_france WHERE code_postal = "+param;
		Connection con = ConfigBDD.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			while (rs.next()) {
				Ville ville = new Ville();
				ville.setCodeCommune(rs.getString("code_commune_insee"));
				ville.setNomCommune(rs.getString("nom_commune"));
				ville.setCodePostal(rs.getString("code_postal"));
				ville.setLatitude(rs.getString("latitude"));
				ville.setLongitude(rs.getString("longitude"));
				ville.setLibellAacheminement(rs.getString("libelle_acheminement"));
				ville.setLigne_5(rs.getString("ligne_5"));
				villes.add(ville);
				//System.out.println("reponse : " + rs.getString("nom_commune"));
			}
			return villes;
		}catch(SQLException e) {
			System.out.println("Une erreur s'est produite.");
			return null;
		}
	}
	
	public void ajoutVille(Ville ville) {
		
	}
	
	
}

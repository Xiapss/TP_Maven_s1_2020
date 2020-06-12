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
	
	public boolean ajoutVille(Ville ville) {
		System.out.println("Nom de la ville a insérer : "+ville.getNomCommune());
		String requete = "INSERT INTO ville_france VALUES('"+ville.getCodeCommune()+"','"+ville.getNomCommune()+"','"+ville.getCodePostal()
		+"','"+ville.getLibellAacheminement()+"','"+ville.getLigne_5()+"','"+ville.getLatitude()+"','"+ville.getLongitude()+"')";	
		System.out.println(requete);
		
		Connection con = ConfigBDD.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			if(stmt.executeUpdate(requete)==1) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Une erreur s'est produite lors de l'insertion.");
			return false;
		}
		
		
	}
	
	public boolean suppVille(String monParam) {
		System.out.println("Suppression de la ville avec le code : "+ monParam);
		String requete = "DELETE FROM ville_france WHERE code_commune_insee = '"+monParam+"'";
		System.out.println(requete);
		
		Connection con = ConfigBDD.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			if(stmt.executeUpdate(requete)==1) {
				return true;
				
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("Une erreur s'est produite lors de la suppression.");
			return false;
		}
	}
	
	
	public boolean modifierVille(Ville ville) {
        try {
            Connection con = ConfigBDD.getConnection();
            Statement stmt = con.createStatement();
            String requete ="UPDATE ville_france SET Nom_commune='" + ville.getNomCommune() + "', Code_postal='"
                    + ville.getCodePostal() + "', Libelle_acheminement='" + ville.getLibellAacheminement()
                    + "', Ligne_5 = '" + ville.getLigne_5() + "', Latitude='" + ville.getLatitude() + "', Longitude='"
                    + ville.getLongitude() + "'  WHERE Code_commune_INSEE='" + ville.getCodeCommune() + "'";
            
            System.out.println(requete);
            if(stmt.executeUpdate(requete)==1) {
            	return true;
            }else {
            	return false;
            }
            
 

        } catch (SQLException e) {
        	
            e.printStackTrace();
            return false;
        }
    }
	
	
}

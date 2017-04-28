package com.example.matt.suivaa;

public class Visiteur
{
	private String id;
	private String nom;
	private String prenom;

	public Visiteur(String id, String nom, String prenom)
    {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setNiveauV(String prenom) {
		this.prenom = prenom;
	}

	public String toString(){
		return "Visiteur " + id + " : " + nom + " " + prenom;
	}
}

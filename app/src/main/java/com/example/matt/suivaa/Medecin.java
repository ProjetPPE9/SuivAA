package com.example.matt.suivaa;

public class Medecin
{
	private int id;
	private String nom;
	private String prenom;
	private int idVisiteur;
    private int idCabinet;

	public Medecin(int id, String nom, String prenom, int idVisiteur, int idCabinet) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.idVisiteur = idVisiteur;
		this.idCabinet = idCabinet;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(int idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public int getIdCabinet() {
        return idCabinet;
    }

    public void setIdCabinet(int idCabinet) {
        this.idCabinet = idCabinet;
    }

    public String toString(){
		return "Médecin " + id + " : " + nom + " " + prenom;
	}
}

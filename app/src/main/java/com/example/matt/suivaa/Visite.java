package com.example.matt.suivaa;

import java.sql.Date;
import java.sql.Time;

public class Visite
{
	private int id;
    private Date date;
    private int rendezVous;
	private Time heureArriveeCabinet;
    private Time heureDebutEntretien;
    private Time heureDepartCabinet;
	private int idVisiteur;
    private int idMedecin;

    public Visite(int id, Date date, int rendezVous, Time heureArriveeCabinet, Time heureDebutEntretien, Time heureDepartCabinet, int idVisiteur, int idMedecin) {
        this.id = id;
        this.date = date;
        this.rendezVous = rendezVous;
        this.heureArriveeCabinet = heureArriveeCabinet;
        this.heureDebutEntretien = heureDebutEntretien;
        this.heureDepartCabinet = heureDepartCabinet;
        this.idVisiteur = idVisiteur;
        this.idMedecin = idMedecin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(int rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Time getHeureArriveeCabinet() {
        return heureArriveeCabinet;
    }

    public void setHeureArriveeCabinet(Time heureArriveeCabinet) {
        this.heureArriveeCabinet = heureArriveeCabinet;
    }

    public Time getHeureDebutEntretien() {
        return heureDebutEntretien;
    }

    public void setHeureDebutEntretien(Time heureDebutEntretien) {
        this.heureDebutEntretien = heureDebutEntretien;
    }

    public Time getHeureDepartCabinet() {
        return heureDepartCabinet;
    }

    public void setHeureDepartCabinet(Time heureDepartCabinet) {
        this.heureDepartCabinet = heureDepartCabinet;
    }

    public int getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(int idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String toString(){
		return "Médecin " + id + " : " + date.toString();
	}
}

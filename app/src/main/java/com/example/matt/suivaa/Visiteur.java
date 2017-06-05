package com.example.matt.suivaa;

public class Visiteur
{
	private String id;
	private String login;
	private String mdp;

	public Visiteur(String id, String login, String mdp)
    {
		this.id = id;
		this.login = login;
		this.mdp = mdp;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMdp() {
		return this.mdp;
	}
	
	public void setNiveauV(String mdp) {
		this.mdp = mdp;
	}

	public String toString(){
		return "Visiteur " + id + " : " + login + " " + mdp;
	}
}

package com.example.matt.suivaa;

public class Cabinet
{
	private int id;
	private String adresse;
	private String ville;
	private String codePostal;
    private Double latitude;
    private Double longitude;

	public Cabinet(int id, String adresse, String ville, String codePostal, Double latitude, Double longitude )
    {
		this.id = id;
		this.adresse = adresse;
		this.ville = ville;
        this.codePostal = codePostal;
        this.latitude = latitude;
        this.longitude = longitude;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getVille() {
		return this.ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

	public String toString(){
		return "Cabinet " + id + " : " + adresse + " " + ville + " " + codePostal;
	}
}

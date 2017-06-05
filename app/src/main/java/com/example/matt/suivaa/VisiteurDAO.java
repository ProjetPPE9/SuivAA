package com.example.matt.suivaa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class VisiteurDAO
{
	private static String base = "Visiteur";
	private static int version = 1;
	private BdSQLiteOpenHelper accesBD;

	/**
	 * Constructeur de la classe qui crée un objet BdSQLiteOpenHelper
	 * @param ct
     */
	public VisiteurDAO(Context ct) {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);

    }
	/**
	 * Ajoute un cabinet dans la BDD
	 * @param id,login,mdp
	 */
	public void addVisiteur(String id,String login,String mdp){
		SQLiteDatabase bd = accesBD.getWritableDatabase();

		String req = "insert into Visiteur(id, login, mdp)"
				+ " values('"+id+"','"+login+"','"+mdp+"');";

		bd.execSQL(req);
		bd.close();
	}

	/**
	 * Récupère un visiteur de la BDD
	 * @return leCabinet
	 */
	public Visiteur getVisiteur(){
		Visiteur leVisiteur = null;
		Cursor curseur;
		curseur = accesBD.getReadableDatabase().rawQuery("select * from visiteur",null);
		if (curseur.getCount() > 0) {
			curseur.moveToFirst();
			leVisiteur = new Visiteur(curseur.getString(0),curseur.getString(1), curseur.getString(2));
		}
		return leVisiteur;
	}

}

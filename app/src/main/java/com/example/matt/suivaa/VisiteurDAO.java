package com.example.matt.suivaa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class VisiteurDAO
{
	private static String base = "BDCabinet";
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
				+ " values("+id+",'"+login+"','"+mdp+"');";

		bd.execSQL(req);
		bd.close();
	}

}

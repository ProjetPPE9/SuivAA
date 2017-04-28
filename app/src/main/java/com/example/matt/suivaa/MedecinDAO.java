package com.example.matt.suivaa;

import android.content.Context;

public class MedecinDAO
{
	private static String base = "BDMedecin";
	private static int version = 1;
	private BdSQLiteOpenHelper accesBD;

	/**
	 * Constructeur de la classe qui crée un objet BdSQLiteOpenHelper
	 * @param ct
     */
	public MedecinDAO(Context ct) {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }
}

package com.example.matt.suivaa;

import android.content.Context;

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
}

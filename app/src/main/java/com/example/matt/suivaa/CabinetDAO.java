package com.example.matt.suivaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CabinetDAO
{
	private static String base = "Cabinet";
	private static int version = 1;
	private BdSQLiteOpenHelper accesBD;

	/**
	 * Constructeur de la classe qui crée un objet BdSQLiteOpenHelper
	 * @param ct
     */
	public CabinetDAO(Context ct) {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }


    /**
     * Ajoute un cabinet dans la BDD
     * @param unCabinet
     */
    public void addCabinet(Cabinet unCabinet){
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        String req = "insert into Cabinet(id, adresse, ville, codePostal, latitude, longitude)"
                + " values("+unCabinet.getId()+",'"+unCabinet.getAdresse()+"','"+unCabinet.getVille()+"','"+unCabinet.getCodePostal()+"',"+unCabinet.getLatitude()+","+unCabinet.getLongitude()+");";

        bd.execSQL(req);
        bd.close();
    }


    /**
     * Récupère un cabinet de la BDD
     * @param id
     * @return leCabinet
     */
    public Cabinet getCabinet(int id){
        Cabinet leCabinet = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from cabinet where id="+id+";",null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leCabinet = new Cabinet(curseur.getInt(0),curseur.getString(1), curseur.getString(2), curseur.getString(3), curseur.getDouble(4), curseur.getDouble(5));
        }
        return leCabinet;
    }
}

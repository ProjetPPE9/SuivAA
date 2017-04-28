package com.example.matt.suivaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BdSQLiteOpenHelper extends SQLiteOpenHelper {

    // Table Visiteur
    public static final String VISITEUR_TABLE_NAME = "Visiteur";
	public static final String VISITEUR_KEY = "id";
	public static final String VISITEUR_NOM = "nom";
	public static final String VISITEUR_PRENOM = "prenom";
    public static final String VISITEUR_TABLE_DROP = "DROP TABLE IF EXISTS " + VISITEUR_TABLE_NAME + ";";
	public static final String VISITEUR_TABLE_CREATE =
			"CREATE TABLE IF NOT EXISTS " + VISITEUR_TABLE_NAME + " (" +

					VISITEUR_KEY + " TEXT PRIMARY KEY, " +
					VISITEUR_NOM + " TEXT NOT NULL, " +
					VISITEUR_PRENOM + " TEXT NOT NULL);";


    // Table Cabinet
    public static final String CABINET_TABLE_NAME = "Cabinet";
    public static final String CABINET_KEY = "id";
    public static final String CABINET_ADRESSE = "adresse";
    public static final String CABINET_VILLE = "ville";
    public static final String CABINET_CODEPOSTAL = "codePostal";
    public static final String CABINET_LATITUDE = "latitude";
    public static final String CABINET_LONGITUDE = "longitude";
    public static final String CABINET_TABLE_DROP = "DROP TABLE IF EXISTS " + CABINET_TABLE_NAME + ";";
    public static final String CABINET_TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + CABINET_TABLE_NAME + " (" +

                    CABINET_KEY + " INTEGER PRIMARY KEY NOT NULL, " +
                    CABINET_ADRESSE + " TEXT NOT NULL, " +
                    CABINET_VILLE + " TEXT NOT NULL, " +
                    CABINET_CODEPOSTAL + " INTEGER NOT NULL, " +
                    CABINET_LATITUDE + " REAL NOT NULL, " +
                    CABINET_LONGITUDE + " REAL NOT NULL);";


    // Table Medecin
    public static final String MEDECIN_TABLE_NAME = "Medecin";
    public static final String MEDECIN_KEY = "id";
    public static final String MEDECIN_NOM = "nom";
    public static final String MEDECIN_PRENOM = "prenom";
    public static final String MEDECIN_ID_VISITEUR = "idVisiteur";
    public static final String MEDECIN_ID_CABINET = "idCabinet";
    public static final String MEDECIN_TABLE_DROP = "DROP TABLE IF EXISTS " + MEDECIN_TABLE_NAME + ";";
    public static final String MEDECIN_TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + MEDECIN_TABLE_NAME + " (" +

                    MEDECIN_KEY + " INTEGER PRIMARY KEY, " +
                    MEDECIN_NOM + " TEXT NOT NULL, " +
                    MEDECIN_PRENOM + " TEXT NOT NULL, " +
                    MEDECIN_ID_VISITEUR + " TEXT NOT NULL, " +
                    MEDECIN_ID_CABINET + " INTEGER NOT NULL, " +
                    "FOREIGN KEY(" + MEDECIN_ID_VISITEUR + ") REFERENCES " + VISITEUR_TABLE_NAME + "(" + VISITEUR_KEY + ")" +
                    "FOREIGN KEY(" + MEDECIN_ID_CABINET + ") REFERENCES " + CABINET_TABLE_NAME + "(" + CABINET_KEY + "));";


    // Table Visite
    public static final String VISITE_TABLE_NAME = "Visite";
    public static final String VISITE_KEY = "id";
    public static final String VISITE_DATE = "date";
    public static final String VISITE_RENDEZVOUS = "rendezVous";
    public static final String VISITE_HEURE_ARRIVEE_CABINET = "heureArriveeCabinet";
    public static final String VISITE_HEURE_DEBUT_ENTRETIEN = "heureDebutEntretien";
    public static final String VISITE_HEURE_DEPART_CABINET = "heureDepartCabinet";
    public static final String VISITE_ID_VISITEUR = "idVisiteur";
    public static final String VISITE_ID_MEDECIN = "idMedecin";
    public static final String VISITE_TABLE_DROP = "DROP TABLE IF EXISTS " + VISITE_TABLE_NAME + ";";
    public static final String VISITE_TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + VISITE_TABLE_NAME + " (" +

                    VISITE_KEY + " INTEGER PRIMARY KEY, " +
                    VISITE_DATE + " TEXT NOT NULL, " +
                    VISITE_RENDEZVOUS + " INTEGER NOT NULL, " +
                    VISITE_HEURE_ARRIVEE_CABINET + " TEXT, " +
                    VISITE_HEURE_DEBUT_ENTRETIEN + " TEXT, " +
                    VISITE_HEURE_DEPART_CABINET + " TEXT, " +
                    VISITE_ID_VISITEUR + " TEXT NOT NULL, " +
                    VISITE_ID_MEDECIN + " INTEGER NOT NULL, " +
                    "FOREIGN KEY(" + VISITE_ID_VISITEUR + ") REFERENCES " + VISITEUR_TABLE_NAME + "(" + VISITEUR_KEY + ")" +
                    "FOREIGN KEY(" + VISITE_ID_MEDECIN + ") REFERENCES " + MEDECIN_TABLE_NAME + "(" + MEDECIN_KEY + "));";
	

	public BdSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Crée les tables
		db.execSQL(VISITEUR_TABLE_CREATE);
        db.execSQL(CABINET_TABLE_CREATE);
        db.execSQL(MEDECIN_TABLE_CREATE);
        db.execSQL(VISITE_TABLE_CREATE);
		
		db.execSQL("insert into visiteur(id,nom,prenom) values(1,'D','Andre');"); // Insère une ligne dans la table visiteur
		
		//ContentValues value = new ContentValues(); // sert de "liste" de valeur contenant des lignes à ajouter à la table viticulteur
		//value.put("nomV", "Esquerra"); // le nom du viticulteur à ajouter
		//value.put("niveauV",50); // le niveau du viticulteur à ajouter
		//db.insert("viticulteur", null, value); // ajoute à la BDD la ligne composé des deux valeurs précédentes
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) // Permet de mettre à jour une BDD
	{
        db.execSQL(VISITE_TABLE_DROP);
        db.execSQL(MEDECIN_TABLE_DROP);
        db.execSQL(VISITEUR_TABLE_DROP);
        db.execSQL(CABINET_TABLE_DROP);
        onCreate(db);
	}

}

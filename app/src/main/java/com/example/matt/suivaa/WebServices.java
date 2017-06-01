package com.example.matt.suivaa;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Maxime on 04/05/2017.
 */
public class WebServices extends AsyncTask<String, Void, String>
{

    @Override
    protected void onPreExecute()
    {
        Log.d("PreExecute", "Début du traitement asynchrone");
    }


    @Override
    protected String doInBackground(String... valeur)
    {
        return appelWS("http://192.168.19.2/gsbappv3/webservices/"+ valeur[0] +"?login="+ valeur[1] +"&mdp=" + valeur[2]);
        //return appelWS("http://10.0.2.2/WebService/wsIMCMD.php?poids="+ valeur[0] +"&taille=" + valeur[1]);
    }


    protected void onPostExecute(String result)
    {
        Log.d("PostExecute", result);
    }

    private String appelWS(String uneURL)
    {
        String result="";

        try
        {
            InputStream in;
            URL url = new URL(uneURL);
            URLConnection connection = url.openConnection();

            HttpURLConnection httpConnection = (HttpURLConnection) connection;

            // Connexion à l'url
            httpConnection.connect();
            int responseCode = httpConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                in = httpConnection.getInputStream();
                result = convertStreamToString(in);
                Log.d("execute_appelWS",result);
            }
        }
        catch (Exception e)
        {
            Log.d("execute_appelWSerror", "erreur"+e.getMessage());
        }

        return result;
    }


    private String convertStreamToString(InputStream is)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        try
        {
            String ligne = reader.readLine();

            while (ligne != null)
            {
                Log.d("execute_convertStream",ligne);
                sb.append(ligne + "\n"); ligne = reader.readLine();
            }

            reader.close();
        }
        catch (IOException e) { }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
                Log.d("execute_convertStreamEr","catch");
            }
        }

        return sb.toString();
    }
}

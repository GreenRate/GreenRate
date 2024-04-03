package fr.macario.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

import java.net.*;
import java.io.*;

public class InfoProductGet {

    public String barcodeValue = new scanerFragment().getBarcodeValue();
    public String productName;
    public String Jsondata;
    public InfoProductGet() {

        try {
            // Créer l'URL pour l'API Open Food Facts
            URL url = new URL("https://world.openfoodfacts.org/api/v0/product/" + barcodeValue + ".json");

            // Ouverture de la connexion
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Vérification du code de réponse
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lecture de la réponse
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Analyse de la réponse JSON
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONObject product = jsonResponse.getJSONObject("product");
                productName = product.getString("product_name");

                // Affichage du nom du produit
                System.out.println("Nom du produit : " + productName);
            } else {
                System.out.println("La requête n'a pas réussi, code de réponse : " + responseCode);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public String getProductName() {
        return productName;
    }
}

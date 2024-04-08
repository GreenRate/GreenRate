package fr.macario.myapplication;

import androidx.annotation.NonNull;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class InfoProductGet
{
    public String productName;
    public String getProductName() {return productName;}

    public InfoProductGet () {
        OkHttpClient client = new OkHttpClient();
        String barcodeValue = new scanerFragment().getBarcodeValue();
        String url = "https://world.openfoodfacts.net/api/v2/product/"+ barcodeValue +"?fields=product_name,nutriscore_data";
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    String responseData = response.body().string();
                    try {
                        JSONObject jsonResponse = new JSONObject(responseData);
                        System.out.println(jsonResponse);
                        JSONObject productObject = jsonResponse.getJSONObject("product");
                        productName = productObject.getString("product_name_fr");


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
    }


}
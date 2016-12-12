package sample;

import com.sun.deploy.net.HttpUtils;
import com.sun.jndi.toolkit.url.Uri;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by y2793623b on 24/10/16.
 */
public class CardAPI {


    private final String BASE_URL = "https://api.magicthegathering.io/v1/cards";


    ArrayList<Card> getAllCards() throws IOException {

        return doCall(BASE_URL);
    }


    /*
    ArrayList<Card> getCartasPorTipo(String tipo, String color) {

        return doCall(BASE_URL + "?rarity" + tipo + "&colors" + color);
    }
    */

    private ArrayList<Card> doCall(String url) {

        String JsonResponse = null;
        try {

            JsonResponse = HttpUtil.get(url);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return processJson(JsonResponse);

    }

    private ArrayList<Card> processJson(String jsonResponse) {

        ArrayList<Card> cartas = new ArrayList<>();

        try {

            JSONObject data = new JSONObject(jsonResponse);
            JSONArray jsonCartas = data.getJSONArray("cards");
            for (int x = 0; x < jsonCartas.length(); x ++)
            {
                JSONObject jsonCard = jsonCartas.getJSONObject(x);

                Card carta = new Card();

                carta.setName(jsonCard.getString("name"));
                carta.setType(jsonCard.getString("type"));
                carta.setRarity(jsonCard.getString("rarity"));
                carta.setSet(jsonCard.getString("set"));
                if(jsonCard.has("text"))
                {
                    carta.setText(jsonCard.getString("text"));
                }else
                    carta.setText(null);

                if(jsonCard.has("colors"))
                {
                    carta.setColors(jsonCard.getString("colors"));
                }else
                    carta.setColors(null);

                if(jsonCard.has("imageUrl"))
                {
                    carta.setImageUrl(jsonCard.getString("imageUrl"));
                }else
                    carta.setImageUrl(null);




                cartas.add(carta);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cartas;

    }



}

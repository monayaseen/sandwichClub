package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich=new Sandwich();

        try {
            JSONObject mainJson = new JSONObject(json);
            JSONObject name = mainJson.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs_JA = name.getJSONArray("alsoKnownAs");
            List<String>  alsoKnownAs = new ArrayList<>();
            if (alsoKnownAs_JA.length() != 0){
                  alsoKnownAs = ArrayToList(alsoKnownAs_JA);

            }
           String description =mainJson.getString("description");
           String Image = mainJson.getString("image");
            String  placeOfOrigin = mainJson.getString("placeOfOrigin");
            JSONArray ingredients_JA = mainJson.getJSONArray("ingredients");
            List<String> ingredients ;

            if (ingredients_JA.length() != 0) {
//                for (int i = 0; i < ingredients_JA.length(); i++) {
//                    ingredients.add(ingredients_JA.getString(i));
//                }
                 ingredients = ArrayToList(ingredients_JA);


                 sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, Image, ingredients);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
    private static List<String> ArrayToList(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }
}

package vttp.csf.MiniProject2.Server.services;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.csf.MiniProject2.Server.models.hotelLst;
import vttp.csf.MiniProject2.Server.models.reviews;

@Service
public class APIservice {

    @Value("${APIKEY}")
    private String key;

    public ArrayList<hotelLst> getAPI(String keyword){
        RestTemplate template = new RestTemplate();
        String url = UriComponentsBuilder.fromUriString("https://api.stb.gov.sg/content/accommodation/v2/search")
        .queryParam("searchType", "keyword").queryParam("searchValues", keyword).toUriString();
        RequestEntity<Void> Req = RequestEntity.get(url)
        .header("x-api-key", key).build();
        ResponseEntity<String> Response = template.exchange(Req, String.class);
        InputStream input;

        JsonObject jsonObject;
        JsonArray jsonArray;
        JsonReader reader=null;

        try {
            input = new ByteArrayInputStream(Response.getBody().getBytes());
            reader = Json.createReader(input);
        } catch (Exception e) {
            // TODO: handle exception
        }
        jsonObject = reader.readObject();
        jsonArray = jsonObject.getJsonArray("data");

        ArrayList<hotelLst> hotelArray = new ArrayList<>();

        for (int index = 0; index < jsonArray.size(); index++) {

            // JsonArray images = jsonArray.getJsonObject(index).getJsonArray("images");
            JsonArray jsonArr = jsonArray.getJsonObject(index).getJsonArray("reviews");
            ArrayList<reviews> rArr = new ArrayList<>();

            for(int i = 0; i < jsonArr.size(); i++){
                System.out.println();
                reviews r = new reviews(
                    jsonArr.getJsonObject(i).getString("authorName"),
                    jsonArr.getJsonObject(i).getString("authorURL"),
                    jsonArr.getJsonObject(i).getString("language"),
                    jsonArr.getJsonObject(i).getString("profilePhoto"),
                    jsonArr.getJsonObject(i).getInt("rating"),
                    jsonArr.getJsonObject(i).getString("text"),
                    jsonArr.getJsonObject(i).getString("time")
                    );
                rArr.add(r);
            }

            // System.out.println(jsonArr.getJsonObject(0).getString("authorName"));
            hotelLst temporaryModel = new hotelLst
            (jsonArray.getJsonObject(index).getString("uuid"),
            jsonArray.getJsonObject(index).getString("name"),
            jsonArray.getJsonObject(index).getString("type"),
            jsonArray.getJsonObject(index).get("tags") + "",
            jsonArray.getJsonObject(index).getString("description"),
            jsonArray.getJsonObject(index).getString("body"),
            jsonArray.getJsonObject(index).getJsonNumber("rating").doubleValue(),
            jsonArray.getJsonObject(index).get("location") + "",
            jsonArray.getJsonObject(index).get("address") + "",
            // jsonArray.getJsonObject(index).get("thumbnails") + "",
            // images,
            jsonArray.getJsonObject(index).get("metadata") + "",
            jsonArray.getJsonObject(index).getString("categoryDescription"),
            
            rArr,
            // jsonArray.getJsonObject(index).getString("leadInRoomRates"),
            
            // jsonArray.getJsonObject(index).getString("leadInRoomSize"),
            // jsonArray.getJsonObject(index).getInt("noOfRooms"),
            // jsonArray.getJsonObject(index).getString("amenities"),
            jsonArray.getJsonObject(index).get("contact") + "",
            jsonArray.getJsonObject(index).getString("nearestMrtStation"),
            jsonArray.getJsonObject(index).getString("officialWebsite"),
            jsonArray.getJsonObject(index).getString("officialEmail"));
            hotelArray.add(temporaryModel);

            // System.out.println(jsonArray.getJsonObject(index).getString("uuid"));
            // System.out.println(jsonArray.getJsonObject(index).getString("name"));
            // System.out.println(jsonArray.getJsonObject(index).getString("type"));
            // System.out.println(jsonArray.getJsonObject(index).get("tags"));
            // System.out.println(jsonArray.getJsonObject(index).getString("description"));
            // System.out.println(jsonArray.getJsonObject(index).getString("body"));
            // System.out.println(jsonArray.getJsonObject(index).getJsonNumber("rating"));
            // System.out.println(jsonArray.getJsonObject(index).get("location"));
            // System.out.println(jsonArray.getJsonObject(index).get("address"));
            // System.out.println(jsonArray.getJsonObject(index).get("thumbnails"));
            // System.out.println(jsonArray.getJsonObject(index).get("images"));
            // // System.out.println(jsonArray.getJsonObject(index).get("videos"));
            // // System.out.println(jsonArray.getJsonObject(index).get("documents"));
            // // System.out.println(jsonArray.getJsonObject(index).getString("source"));
            // System.out.println(jsonArray.getJsonObject(index).get("metadata"));
            // System.out.println(jsonArray.getJsonObject(index).getString("categoryDescription"));
            // // System.out.println(jsonArray.getJsonObject(index).getString("dataset"));
            // System.out.println(jsonArray.getJsonObject(index).getString("leadInRoomRates"));
            // System.out.println(jsonArray.getJsonObject(index).get("reviews"));
            // // System.out.println(jsonArray.getJsonObject(index).getString("companyDisplayName"));
            // // System.out.println(jsonArray.getJsonObject(index).get("supportedLanguage"));
            // System.out.println(jsonArray.getJsonObject(index).getString("leadInRoomSize"));
            // System.out.println(jsonArray.getJsonObject(index).getInt("noOfRooms"));
            // System.out.println(jsonArray.getJsonObject(index).getString("amenities"));
            // System.out.println(jsonArray.getJsonObject(index).get("contact"));
            // System.out.println(jsonArray.getJsonObject(index).getString("nearestMrtStation"));
            // System.out.println(jsonArray.getJsonObject(index).getString("officialWebsite"));
            // System.out.println(jsonArray.getJsonObject(index).getString("officialEmail"));
            // // System.out.println(jsonArray.getJsonObject(index).getString("staYear"));
            // // System.out.println(jsonArray.getJsonObject(index).getString("group"));
            // // System.out.println(jsonArray.getJsonObject(index).getString("temporarilyClosed"));
            // // System.out.println(jsonArray.getJsonObject(index).get("links"));

        }

        // for (int i = 0; i < hotelArray.size(); i++) {

        //     for (int index = 0; index < hotelArray.get(i).getImages().size(); index++) {
        //         System.out.println(hotelArray.get(i).getImages().getJsonObject(index).getString("url"));
            
        //     }

            
        // }
        System.out.println(jsonObject.get("status"));
        return hotelArray;
    }
}
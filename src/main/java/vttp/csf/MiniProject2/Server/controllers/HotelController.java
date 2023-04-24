package vttp.csf.MiniProject2.Server.controllers;

import java.io.StringReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;
import jakarta.json.JsonReader;
import vttp.csf.MiniProject2.Server.models.hotelLst;
import vttp.csf.MiniProject2.Server.models.loginData;
import vttp.csf.MiniProject2.Server.repositories.UserRepo;
import vttp.csf.MiniProject2.Server.services.APIservice;
import vttp.csf.MiniProject2.Server.services.SQLservice;

@RestController
public class HotelController {
    
    @Autowired
    APIservice APIservice;

    @Autowired
    UserRepo userRepo;

    @Autowired
    SQLservice sqlService;
    // @GetMapping("/")
    // public ResponseEntity<String> getAPI(){
    //     JsonObject Out = Json.createObjectBuilder().add("name", "John").build();
    //     APIservice.getAPI("Marina");
    //     return ResponseEntity.ok().body(Out.toString());
    // }

    @PostMapping("/login")
    @CrossOrigin(origins="*")
    public ResponseEntity<String> getLogin(@RequestBody loginData loginData){
        
        System.out.println(loginData.getEmail());
        System.out.println("User entered the password: " + loginData.getPassword());


        String email = loginData.getEmail();
        String password = sqlService.hello(email);

        JsonObject j;
        if(password.equals(loginData.getPassword())){
             j = Json.createObjectBuilder().add("result", "success").build();

        } else {
             j = Json.createObjectBuilder().add("result", "unsuccessful").build();

        }
        return ResponseEntity.ok().body(j.toString());
    }

    // @PostMapping("/register")
    // @CrossOrigin(origins="*")
    // public ResponseEntity<String> getRegister(@RequestBody registerData registerData){


    // }

    @GetMapping(path="/getData/{searchBarInfo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins="*")
    public ResponseEntity<String> getData(@PathVariable String searchBarInfo) {
        hotelLst hotelArr = new hotelLst();
        hotelArr.setHotelArr( APIservice.getAPI(searchBarInfo));

        JsonArrayBuilder jsonArray = Json.createArrayBuilder();
        String location = "";
        for (int index = 0; index < hotelArr.getHotelArr().size(); index++) {

            JsonObjectBuilder temp = Json.createObjectBuilder();
            JsonObjectBuilder temp2 = Json.createObjectBuilder();
            JsonArrayBuilder jsonArrB = Json.createArrayBuilder();
            for(int i = 0; i < hotelArr.getHotelArr().get(index).reviews.size(); i++){
                temp2 = Json.createObjectBuilder()
                    .add("authorName", hotelArr.getHotelArr().get(index).getReviews().get(i).authorName)
                    .add("authorURL", hotelArr.getHotelArr().get(index).getReviews().get(i).authorURL)
                    .add("language", hotelArr.getHotelArr().get(index).getReviews().get(i).language)
                    .add("profilePhoto", hotelArr.getHotelArr().get(index).getReviews().get(i).profilePhoto)
                    .add("rating", hotelArr.getHotelArr().get(index).getReviews().get(i).rating)
                    .add("text", hotelArr.getHotelArr().get(index).getReviews().get(i).text)
                    .add("time", hotelArr.getHotelArr().get(index).getReviews().get(i).time);
                jsonArrB.add(temp2.build());

            }
            JsonArray out = jsonArrB.build();
            temp.add("reviews", out);

            try{

                location = sqlService.getImage(hotelArr.getHotelArr().get(index).name);

            } catch (Exception e) {

                location = "";

            }
            

            JsonObject out2 = temp
            .add("uuid", hotelArr.getHotelArr().get(index).uuid)
            .add("name", hotelArr.getHotelArr().get(index).name)
            .add("type", hotelArr.getHotelArr().get(index).type)
            .add("description", hotelArr.getHotelArr().get(index).description)
            .add("body", hotelArr.getHotelArr().get(index).body)
            .add("rating", hotelArr.getHotelArr().get(index).rating)
            .add("categoryDescription", hotelArr.getHotelArr().get(index).categoryDescription)
            // .add("leadInRoomSize", hotelArr.getHotelArr().get(index).leadInRoomSize)
            .add("nearestMRTStation", hotelArr.getHotelArr().get(index).nearestMRTStation)
            .add("officialWebsite", hotelArr.getHotelArr().get(index).officialWebsite)
            .add("officialEmail", hotelArr.getHotelArr().get(index).officialEmail)
            .add("image", location)
            .build();
            jsonArray.add(out2);
        }
        JsonArray jsonArray2 = jsonArray.build();

        // JsonObject Out = Json.createObjectBuilder().add("name", "John")
        // // .add("metadata", hotelArr.getHotelArr().get(0).metadata)
        // // .add("location", hotelArr.getHotelArr().get(0).location)
        // // .add("address", hotelArr.getHotelArr().get(0).address)
        // .add("reviews", hotelArr.getHotelArr().get(0).reviews)
        // .build();

        JsonReader jr = Json.createReader
        (new StringReader(hotelArr.getHotelArr().get(0).metadata));
        JsonObject jo = jr.readObject();
        JsonReader jr1 = Json.createReader
        (new StringReader(hotelArr.getHotelArr().get(0).location));
        JsonObject jo1 = jr1.readObject();
        JsonReader jr2 = Json.createReader
        (new StringReader(hotelArr.getHotelArr().get(0).address));
        JsonObject jo2 = jr2.readObject();


        System.out.println(jo.getString("updatedDate"));
        System.out.println(jo.getString("createdDate"));
        System.out.println(jo1.get("latitude"));
        System.out.println(jo1.get("longitude"));
        System.out.println(jo2.get("streetName"));
        System.out.println(jo2.get("postalCode"));

        return ResponseEntity.ok().body(jsonArray2.toString());
      
    }
}
package vttp.csf.MiniProject2.Server.models;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.json.Json;
import jakarta.json.JsonArray;

public class hotelLst implements Serializable {

    public String uuid;
    public String name;
    public String type;
    public String tags;
    public String description;
    public String body;
    public double rating; 
    public String location; 
    public String address;
    // public String thumbnails;
    // public JsonArray images;
    public String metadata;
    public String categoryDescription;
    // public String leadInRoomRates;
    public ArrayList<reviews> reviews;
    // public String leadInRoomSize;
    // public int noOfRooms;
    // public String amenities;
    public String contact; 
    public String nearestMRTStation;
    public String officialWebsite;
    public String officialEmail;
    public ArrayList<hotelLst> hotelArr;

        
public hotelLst() {
    
}

public hotelLst(String uuid, String name, String type, String tags, String description, 
    String body, double rating, String location, String address, String metadata,
    String categoryDescription, ArrayList<reviews> reviews, String contact, String nearestMRTStation, String officialWebsite, String officialEmail ) {

        this.uuid = uuid;
        this.name = name;
        this.type = type;
        this.tags = tags;
        this.description = description;
        this.body = body;
        this.rating = rating;
        this.location = location;
        this.address = address;
        // this.thumbnails = thumbnails;
        // this.images = images;
        this.metadata = metadata;
        this.categoryDescription = categoryDescription;
        // this.leadInRoomRates = leadInRoomRates; 
        this.reviews = reviews;
        // this.leadInRoomSize = leadInRoomSize;
        // this.noOfRooms = noOfRooms;
        // this.amenities = amenities;
        this.contact = contact;
        this.nearestMRTStation = nearestMRTStation;
        this.officialWebsite = officialWebsite;
        this.officialEmail = officialEmail;
    }

public String getUuid() {
    return uuid;
}

public void setUuid(String uuid) {
    this.uuid = uuid;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getType() {
    return type;
}

public void setType(String type) {
    this.type = type;
}

public String getTags() {
    return tags;
}

public void setTags(String tags) {
    this.tags = tags;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getBody() {
    return body;
}

public void setBody(String body) {
    this.body = body;
}

public double getRating() {
    return rating;
}

public void setRating(double rating) {
    this.rating = rating;
}

public String getLocation() {
    return location;
}

public void setLocation(String location) {
    this.location = location;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

// public String getThumbnails() {
//     return thumbnails;
// }

// public void setThumbnails(String thumbnails) {
//     this.thumbnails = thumbnails;
// }

// public JsonArray getImages() {
//     return images;
// }

// public void setImages(JsonArray images) {
//     this.images = images;
// }

public String getMetadata() {
    return metadata;
}

public void setMetadata(String metadata) {
    this.metadata = metadata;
}

public String getCategoryDescription() {
    return categoryDescription;
}

public void setCategoryDescription(String categoryDescription) {
    this.categoryDescription = categoryDescription;
}

// public String getLeadInRoomRates() {
//     return leadInRoomRates;
// }

// public void setLeadInRoomRates(String leadInRoomRates) {
//     this.leadInRoomRates = leadInRoomRates;
// }

public ArrayList<reviews> getReviews() {
    return reviews;
}

public void setReviews(ArrayList<reviews> reviews) {
    this.reviews = reviews;
}

// public String getLeadInRoomSize() {
//     return leadInRoomSize;
// }

// public void setLeadInRoomSize(String leadInRoomSize) {
//     this.leadInRoomSize = leadInRoomSize;
// }

// public int getNoOfRooms() {
//     return noOfRooms;
// }

// public void setNoOfRooms(int noOfRooms) {
//     this.noOfRooms = noOfRooms;
// }

// public String getAmenities() {
//     return amenities;
// }

// public void setAmenities(String amenities) {
//     this.amenities = amenities;
// }

public String getContact() {
    return contact;
}

public void setContact(String contact) {
    this.contact = contact;
}

public String getNearestMRTStation() {
    return nearestMRTStation;
}

public void setNearestMRTStation(String nearestMRTStation) {
    this.nearestMRTStation = nearestMRTStation;
}

public String getOfficialWebsite() {
    return officialWebsite;
}

public void setOfficialWebsite(String officialWebsite) {
    this.officialWebsite = officialWebsite;
}

public String getOfficialEmail() {
    return officialEmail;
}

public void setOfficialEmail(String officialEmail) {
    this.officialEmail = officialEmail;
}

public ArrayList<hotelLst> getHotelArr() {
    return hotelArr;
}

public void setHotelArr(ArrayList<hotelLst> hotelArr) {
    this.hotelArr = hotelArr;
}

}
    


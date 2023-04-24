package vttp.csf.MiniProject2.Server.models;

public class reviews {
    
    public String authorName;
    public String authorURL;
    public String language;
    public String profilePhoto;
    public int rating;
    public String text;
    public String time;

    
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorURL() {
        return authorURL;
    }
    public void setAuthorURL(String authorURL) {
        this.authorURL = authorURL;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getProfilePhoto() {
        return profilePhoto;
    }
    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }


    public reviews(String authorName, String authorURL, String language, String profilePhoto, int rating, String text, String time){
        this.authorName = authorName;
        this.authorURL = authorURL;
        this.language = language;
        this.profilePhoto = profilePhoto;
        this.rating = rating;
        this.text = text;
        this.time = time;
    }
}

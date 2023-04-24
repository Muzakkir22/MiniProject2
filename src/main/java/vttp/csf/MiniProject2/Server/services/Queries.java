package vttp.csf.MiniProject2.Server.services;

public class Queries {

    public static final String SQL_SELECT_USER_DETAIL = "select * from hoteldata.usersdetails where email = ?";
    public static final String SQL_GET_IMAGE = "select * from hoteldata.locationimages where locationname = ?";
}

package vttp.csf.MiniProject2.Server.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import static vttp.csf.MiniProject2.Server.services.Queries.*;

@Repository
public class UserRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getUsersByEmail(String email) {

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_USER_DETAIL, email);
        while(rs.next()){
            System.out.println(rs.getString("password"));
            return rs.getString("password");
        }

        return null;
    }

    public String getImage(String location) {

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_IMAGE, location);
        while(rs.next()){
            System.out.println(rs.getString("imageurl"));
            return rs.getString("imageurl");
        }

        return "";
    }

    

    
}

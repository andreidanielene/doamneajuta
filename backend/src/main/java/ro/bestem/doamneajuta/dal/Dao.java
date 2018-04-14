package ro.bestem.doamneajuta.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ro.bestem.doamneajuta.util.TeamDetails;
import ro.bestem.doamneajuta.util.User;
import ro.bestem.doamneajuta.util.UserRegister;

import java.util.List;

/**
 * Created by Andrei-Daniel Ene on 4/14/2018.
 */
@Component
public class Dao {

    private static final String SELECT_USER = "SELECT username, password FROM user WHERE username = ? AND password = ?";
    private static final String TEAMS_DETAILS = "SELECT * FROM TEAMS";


    /*
    EXAMPLE:

    public List<Customer> findAll(){

        String sql = "SELECT * FROM CUSTOMER";

        List<Customer> customers  = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Customer.class));

        return customers;
    }
     */

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserRegister checkUserCredentials(User user) {
        UserRegister response = null;
        try {
            response = (UserRegister) jdbcTemplate.queryForObject( SELECT_USER, new Object[]{user.getUsername(), user.getPassword()}, new BeanPropertyRowMapper(UserRegister.class) );
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return response;
    }

    public List<TeamDetails> getTeamDetails() {
        List<TeamDetails> teamDetailsList = jdbcTemplate.query(TEAMS_DETAILS, new BeanPropertyRowMapper(TeamDetails.class));
        return teamDetailsList;
    }
}

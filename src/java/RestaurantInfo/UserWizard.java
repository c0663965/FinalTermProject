/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantInfo;

/**
 *
 * @author gurvinder singh
 */
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import RestaurantInfo.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saurabh
 */
@ManagedBean
@ViewScoped
public class UserWizard implements Serializable {

    private User user = new User();

    private boolean skip;

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     */
    public void save() {
        Connection conn;
        try {
            conn = utils.getConnection();
            Statement st = conn.createStatement();

            int val1 = st.executeUpdate("INSERT into users (email,first_name,last_name) VALUES(" + user.getEmail() + "," + user.getFirstname() + "," + user.getLastname() + "", Statement.RETURN_GENERATED_KEYS);
            int val = st.executeUpdate("INSERT into comments (user_id,restaurant_id,comment) VALUES(" + val1 + ",'1'," + user.getInfo() + "");

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);

        }

        FacesMessage msg = new FacesMessage("Successfully posted your comment", "Welcome :" + user.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     *
     * @return
     */
    public boolean isSkip() {
        return skip;
    }

    /**
     *
     * @param skip
     */
    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    /**
     *
     * @param event
     * @return
     */
    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
}

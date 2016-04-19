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

/**
 *
 * @author Saurabh
 */
public class User implements Serializable {

    private String firstname;

    private String lastname;

    private String comm;

    private String email;
    
    private int restaurentId;

    public User() {

    }

    public User(String firstname, String lastname, String comm, String email, int restaurentId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.comm = comm;
        this.email = email;
        this.restaurentId = restaurentId;
    }

    
    
    public int getRestaurentId() {
        return restaurentId;
    }

    public void setRestaurentId(int restaurentId) {
        this.restaurentId = restaurentId;
    }
    public User(String comm){
        this.comm = comm;
    }
    /**
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     */
    public String getInfo() {
        return comm;
    }

    /**
     *
     * @param comm
     */
    public void setInfo(String comm) {
        this.comm = comm;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}

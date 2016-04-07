/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantInfo;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saurabh
 */
@ManagedBean
@ApplicationScoped
public class PostController {
    private List<post> posts;
    private post currentPost;
    private String searchValue;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    
    
    /**
     * Retrieve the List of Post objects
     *
     * @return the List of Post objects
     */
    public List<post> getPosts() {
        return posts;
    }

    /**
     * Retrieve the current Post
     *
     * @return the registered Current Post
     */
    public post getCurrentPost() {
        return currentPost;
    }

    /**
     * No-arg Constructor -- sets up list from DB
     */
    public PostController(){
        currentPost = new post(-1, "", "", "", "", "", "", "", -1.0, -1.0, "", "", "", "");
        getPostFromDB();
    }
    
    /**
     * Wipe the Posts list and update it from the DB
     */
    public void getPostFromDB(){
        Connection conn;
        try {
            conn = utils.getConnection();
        
        
        posts=new ArrayList<>();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select *from bistro");
        while(rs.next()){
            post p=new post( rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("menu"),
                    rs.getString("price"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("postal_code"),
                    rs.getString("country_code"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude"),
                    rs.getString("mobile_url"),
                    rs.getString("rating"),
                    rs.getString("rating_image_url"),
                    rs.getString("snippet_text"));
            posts.add(p);
                    
                    }
        } catch (SQLException ex) {
            Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
             // This Fails Silently -- Sets Post List as Empty
            posts = new ArrayList<>();
        }
        
    }
    
    
    /**
     * Retrieve a Post by ID
     *
     * @param id the ID to search for
     * @return the post -- null if not found
     */
    public post getPostById(int id) {
        for (post p : posts) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    /**
     * Retrieve a Post by title
     *
     * @param title the title to search for
     * @return the post -- null if not found
     */
    public String getPostByTitle(String title) {
        for (post p : posts) {
            if (p.getName().equals(title)) {
                currentPost = p;
                return "newjsf";
            }
        }
        return null;
    }

    /**
     * Navigate to a specific post to view
     *
     * @param post the post to view
     * @return the navigation rule
     */
    public String viewPost(post post) {
        currentPost = post;
       
        return "each";
    }

    
    
}

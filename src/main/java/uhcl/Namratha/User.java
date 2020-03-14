/******************************************************************************\
* Programmer: Naomi Wiggins
*
* Course: CSCI 4391.05
*
* Date: March 31, 2019
*
* Assignment: Project 3: Java Server Faces
*
* Environment: Java with NetBeans IDE
*
* Files Included: index.xhtml, login.xhtml, survey-page.xhtml, 
* survey-results.xhtml,header-temp.xhtml, page-template.xhtml, 
* survey-header-temp.xhtml, syle.css, ModelDB.java, User.java, Manager.java
*
********************************************************************************
* 
* Purpose: The User class contains the username and password of a user account
* for this survey application. The username component of a User is also used
* to fetch their information from the database.
*
* Input: String username, String password
*
* Preconditions/Assumptions:  N/A
*
* Output: User Object
*
* Algorithm:
* Construct User Object
* Get and Set User fields
*******************************************************************************/ 

package uhcl.wiggins;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@Named
@SessionScoped
@ManagedBean
public class User implements Serializable {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;

    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
    
    public User() {
        username = "";
        password = "";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the class
    \**************************************************************************/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() 
    /**************************************************************************\
    * Purpose: To Override the object's default toString() method to return 
    * a more readable representation of the object
    * Parameters: N/A
    * Action: Returns a string representation of the object
    \**************************************************************************/
    {
        return "Username: " + username + "; Password: " + password;
    }
    
}

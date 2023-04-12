/******************************************************************************\
* Programmer: Namratha
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
* Purpose: The Manager class is the Controller component of this application and
* is responsible for interacting with both the modelDB class (Model component)
* and the xhtml files.
*
* Input: N/A
*
* Preconditions/Assumptions: This class is the ONLY Java class that will be 
* interacting with both the .xhtml files and the database
*
* Output: N/A
*
* Algorithm:
* Store user response
* Authenticate user
* 
*******************************************************************************/ 

package uhcl.wiggins;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;


@SessionScoped
@ManagedBean
public class Manager implements Serializable {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private variables of the class used to process data from .xthml files
    \**************************************************************************/
    
    private static final long serialVersionUID = 1L;
    
    private String username, password;
    
    private ArrayList<String> surveyAs = new ArrayList<String>();

    private User currentUser;
    
    private User user;
    
    private String answer;
    
    private String question;

    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * Methods used by the View files to send data to this Manager class for 
    * processing
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
        surveyAs.add(answer);
    }
    
    public boolean isSignedIn() 
    /**************************************************************************\
    * Purpose: Checks to see if User is signed in
    * Parameters: N/A
    * Action: Checks to see if currentUser object is null
    \**************************************************************************/
    {
        return currentUser != null;
    }
    
    public User getCurrentUser() 
    /**************************************************************************\
    * Purpose: To fetch the currentUser object
    * Parameters: N/A
    * Action: Returns the currentUser object
    \**************************************************************************/
    {
        return currentUser;
    }
    
    public String login(String username, String password) 
    /**************************************************************************\
    * Purpose: Verify user's login credentials are correct
    * Parameters: String username, String password
    * Action: Checks User database for instance of User's entered username and 
    * password. If found, login is successful.
    \**************************************************************************/
    {
       boolean userExist = ModelDB.userExist(username);
       if (userExist) {
            user = ModelDB.getUser(username);
            if (user.getPassword().equals(password)) {
               currentUser = user;
               return "survey-page.xhtml";
            }
       }
       FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("No such account exist with that username and password. Please try again."));
        return "login.xhtml";
    }
    
    public List<String> getAnswers() 
    /**************************************************************************\
    * Purpose: To fetch answers ArrayList
    * Parameters: N/A
    * Action: Returns the survey answers list
    \**************************************************************************/
    {
    return this.surveyAs;
    }
    
    public List<String> getQuestions() 
    /**************************************************************************\
    * Purpose: To fetch questions ArrayList
    * Parameters: N/A
    * Action: Returns the survey questions list
    \**************************************************************************/
    {
    return ModelDB.getSurveyQs();
    }
 
}

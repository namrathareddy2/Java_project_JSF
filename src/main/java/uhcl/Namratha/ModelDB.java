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
* Purpose: The ModelDB serves as the Model component of this application. It is 
* responsible for storing and returning the data. 
*
* Input: N/A
*
* Preconditions/Assumptions: Users and their completed surveys will be stored
* in HashMaps
*
* Output: N/A
*
* Algorithm:
* Create user DB, (hashmap) and populate with accounts
* get a user by their username
* check if a user exist in the database
*******************************************************************************/ 

package uhcl.wiggins;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ModelDB implements Serializable {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private HashMaps of the class
    \**************************************************************************/
    
    private static final Map<String, User> users = new HashMap<>();
    private static final Map<String, List> surveys = new HashMap<>();
    private static ArrayList<String> surveyQs = new ArrayList<String>(); 
    

    public static String loadDB() 
    /**************************************************************************\
    * Purpose: To populate the system with fictional user accounts
    * Parameters: N/A
    * Action: Creates  5 new User accounts and stores them in the users HashMap
    \**************************************************************************/
    {
        users.put("LatcherL2347", new User("LatcherL2347", "gohawks!"));
        users.put("NixonN9272", new User("NixonN9272", "uhcl4life"));
        users.put("RusellR5251", new User("RusellR5251", "password"));
        users.put("AnneC0945", new User("AnneC0945", "onDegree2!"));
        users.put("WigginsN7499", new User("WigginsN7499", "the1Real!"));
        
        loadSurveyQs();
        
        return "login.xhtml";
    }
    
    public static User getUser(String username) 
    /**************************************************************************\
    * Purpose: returns User from users HashMap with provided username
    * Parameters: String username
    * Action: searches the users HashMap for a key that matches the provided
    * username and returns that User object
    \**************************************************************************/
    {
        return users.get(username);
    }
    
    public static boolean userExist(String username) 
    /**************************************************************************\
    * Purpose: To check whether or not an account with the provided username 
    * exists in the database
    * Parameters: String username
    * Action: searches the users HashMap for a key that matches the provided
    * username and returns boolean value dependent on if said key is found
    \**************************************************************************/
    {
        return users.containsKey(username);
    }
    
    public static void saveSurvey (String username, List survey) 
    /**************************************************************************\
    * Purpose: To save User's completed survey results in the database
    * Parameters: String username, List survey
    * Action: Stores username and survey ArrayList object into surveys HashMap
    \**************************************************************************/
    {
        surveys.put(username, survey);
    } 
    
    public static ArrayList getSurveyQs() 
    /**************************************************************************\
    * Purpose: To fetch the ArrayList of questions
    * Parameters: N/A
    * Action: Returns the getSurveyQs ArrayList
    \**************************************************************************/
    {
        return surveyQs;
    }  
    
    public static void loadSurveyQs() 
    /**************************************************************************\
    * Purpose: To load survey questions into list
    * Parameters: N/A
    * Action: loads survey questions into list to output with responses
    \**************************************************************************/
    {
        surveyQs.add("1. The instructor stimulated my interest in the subject.");
        surveyQs.add("2. The instructor managed classroom time and pace well.");
        surveyQs.add("3. The instructor was organized and prepared for every class.");
        surveyQs.add("4. The instructor encouraged discussions and responded to questions.");
        surveyQs.add("5. The instructor demonstrated in-depth knowledge of the subject.");
        surveyQs.add("6. The instructor appeared enthusiastic and interested.");
        surveyQs.add("7. The instructor used a variety of instructional methods to reach the course objectives (e.g. group discussions, student presentations, etc.)");
        surveyQs.add("8. The instructor challenged students to do their best work.");
        surveyQs.add("9. The instructor was accessible outside of class");
        surveyQs.add("10. Did the instructor actively attempt to prevent cheating in this course?");
        surveyQs.add("Teaching Approaches Comments:");
        surveyQs.add("11. Information about the assessment was communicated clearly");
        surveyQs.add("12. Feedback was provided within the stated timeframe.");
        surveyQs.add("13. Feedback showed how to improve my work (e .g. corrections including comments).");
        surveyQs.add("Feedback and Assessments Comments:");
        surveyQs.add("14. The course was supported by adequate library resources.");
        surveyQs.add("15. Blackboard resources for the course were useful.");
        surveyQs.add("16. Instructor gave guidance on where to find resources.");
        surveyQs.add("Resources and Administration Comments:");
        surveyQs.add("17. The syllabus was explained at the beginning of the course.");
        surveyQs.add("18. The course was delivered as outlined in the syllabus.");
        surveyQs.add("19. Instructor explained the grading criteria of the course.");
        surveyQs.add("20. Exams related to the course learning outcomes");
        surveyQs.add("21. Projects and assignments related to the course learning outcomes");
        surveyQs.add("Additional Questions Comments:");
        surveyQs.add("22. This was a worthwhile class");
        surveyQs.add("23. Would you recommend this course to a fellow student?");
        surveyQs.add("24. Overall, how do you rate your experience in this course?");
        surveyQs.add("25. How many hours did you spend per week on preparation/homework for this course?");
        surveyQs.add("Overall Experience Comments:");
        surveyQs.add("26. I contributed constructively during in-class activities.");
        surveyQs.add("27. I feel I am achieving the learning outcomes");
        surveyQs.add("What changes would you recommend to improve this course?");
        surveyQs.add("What did you like best about your instructors teaching?");
        surveyQs.add("What did you like least about your instructor’s teaching?");
        surveyQs.add("Any further, constructive commentary?");
    }
}

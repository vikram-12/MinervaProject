# MinervaProject
Minerva is an android application that allows students to share interview experience &amp; knowledge about particular skills that they have  with other students.It has a lot of documents  which can help the user to learn and prepare for placement exams and interviews.

This app is coded using Java .
For storing data and backend  we have used Google Firebase.

### User Interface Representation 

To make the application interactive, different controls have been used and designed using the layout file. Following are the important controls that are designed and used in this application: 
 Text View: The text view component belongs to the view group as a part of GUI. It displays the text or content view of any activity to the user and allows them to edit.
Edit Text: This allows itself to be editable in the text box.  Button: One of the important components in which the application needs. It is mainly associated with action when the user clicks it. We can represent the button using any text which holds the action class on it.
Image Button: Suppose, if we want to have an image for the button which we have designed, we can include using this control by adding the source or path of the image file within the tags in the layout file.
List View: This is a key component under the view group which helps in displaying the information about anything when we click the action button. It also allows us to scroll through the screen and have a look about the information displayed. Using the list adapter, the content is pulled from the database

 ### Description of Features and the Approach

#### User Login/Registration:
If the user wants to use the Minerva, one must download the application from the apk provided, install and register it by providing login information. As shown in Figure4.2 and figure 4.3 , the login information includes username and password. For the new user, the user must sign up by providing Full Name, Email Id and Password. Once, he registers, the registered information is stored in the server and can be validated, checking for the valid credentials for the next time he logins with the application.

#### Home page:
This is the first page that a user sees after he is logged in.  
                             
#### Newsfeed:
If the user wants to see various posts and experiences shared by other users he can find it here. As it is seen in the below figure,the user can like the Post by clicking on the heart icon given just below the post.initially the heart icon has no fill in colour, once the user clicks on the icon it turns red which indicates that the user has liked it. If the user taps on it again it becomes colourless thus indicating that the user has unliked it.
                     
#### Placement and Exam related docs:
If the user wants to download the already uploaded documents which are related to placement and exams he can simply click on the download option available on the page.

#### Share Your Experience:
If the user wants to share his/her experience of the placement procedures, wishes to review any company he/she has already worked in or working for or any other related info that he thinks is relevant to the platform can simply type in the section given  with his/ her name and click on the post button as shown in the below diagram.    
                                                                    
 #### More:
This tab offers the user with other important information as shown in the figure below
1  About: If the user clicks on this option he can read about the motivation behind  this app.
2 Help: If the user is facing any kind of problem and wants to contact the admin to get it resolved he can use this option to directly mail his query to the admin using his registered e-mail id. Once the user has sent the mail regarding his complaint he will receive an acknowledgement mail.
3 Logout: If the user wants to logout form the app he can simply click on the logout button.


## CONCLUSION AND FUTURE WORK


#### Conclusion
We have learned a lot from this project on how to develop Android Application and publish it in real time, use Web Services , develop an interactive UI using various libraries and SDKs and requirement gatherings.
As mentioned earlier, there are numerous platforms that allow social participation with all kinds of purposes but an exclusive platform designed for a particular university where all of the student community can interact over important topics was missing. We hope that this platform would fill in that gap and help students in a way that is both convenient and efficient.

#### Future Work
There are several desirable features that Minerva could have are,
The app would become more interactive if the comment section could be added in the news feed page below each post.
Minerva could attract more audience if audio and video messages could be shared by the user.
The resources section of the app could be equipped with a search feature so that the users can simply search for what they want rather than scrolling through it.


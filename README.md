- this project is about a website for our university ISIMM

- the home page has general informations about ISIMM and it's accessible for all users

- to access to the admin page all u have to do is write "admin" with ur keyboard when u r in the home page (exactly like the konami code)

- same thing with the student page , just write "etudiant" in the home page

- we did it like the konami code because we didn't want the normal user to be able to find it easily , like putting the admin and student page in a button or in the menu bar in the home page.

  No we wanted it kinda hidden.

- after writing "admin" u will get a login page , if u enter a student's username and password u will get a customised 403 error page

- if u log in with the right admin username and password u will get to the admin page

- the admin can :

  - manage the students : add a student , edit a student , delete a student , check the students list , search for a student , add the marks of students , add the timetables of students

  - manage the accounts : create a student's account , delete a student's account , edit a student's account , check the list of all accounts ( the admin is the one responsible for the registration of the
students. the students shouldn't be able to register themselves so the admin create their accounts and gives them the username and password in real life or by email (this is a way to prevent normal users from registration))

  (the passwords are encrypted (i used spring security) so even the admin himself won't be able to know a student password after adding it to the database unless he memorized it or saved it somewhere else.
so if a student forget their password they can contact the admin and ask them for a new password )

  - manage the news (the updates) : add a new , delete a new , edit a new , check the news list , check the notifcations (in the notifications the admin will find the messages sent by normal users from the
 "contact us" in the menu bar of the home page

- the student can :

  - check their profile informations

  - check the timetable

  - check their marks

  - check the news 

- coding and running the project part :

  - make sure u installed and configured mysql and spring boot (if u get some problems in the project with mysql u can try installing wampserver )
 
  - change the "application.properties" file with ur own informations (username , password)
 
  - create the database "isimm_db"
 
  - add the admin account manually into the database : in the table "account" add the cin , username and password. in the table "role" add the cin , username and the user_role ( must be : "ROLE_ADMIN")
 
  - when adding the timetable or the marks , u will get a list of all the grades well the only one working is "ingenieur informatique 1" and i explained in the code in comments how to make all the grades accessible ( i mean for the admin to be able to add timetables and marks for everyone ). i just didn't do it myself because i don't know the subjects of the other grades but i made it clear in the comments how to code it as it is the same way i coded timetable and marks for "ingenieur info 1"

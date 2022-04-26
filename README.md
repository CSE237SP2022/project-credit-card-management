# project-credit-card-management

By: Andrew Yoo, David Wrenner, and DeBose Tuller

## Iteration 3

### How to run the program

cd into the repository containing the cloned project and enter: 
```git pull```

Run the bash script provided in the command line to compile and run the java code:
```bash run.sh```

When you reach the start screen, make a new account by entering 1 and pressing enter.

Create a new user account by entering in the requested information. Remember the username
and password for this new account. Once the new account has been created, enter 0 and 
type in the username and password for the account you just created. 
  
### Tasks Completed For This Iteration

- Users can create a new account. Accounts are stored on a seperate file so if the user logs out 
of the program and logs in, they can log into the account previousely created. 
- The correct card information for both debit card and credit card are returned to the user when
card information is requested. 

### Tasks In Progress That Do Not Fully Work

- There were some functionality for this project that were planned out, but were not fully implemented.
One of these functionalities was a transactions storage class that tracked how much money was 
added or spent by each card. Another was a functionality to use the pin number associated with a 
card to access the card's functions. These functionalities were planned to be included in the final
iteration of the project, but were left out to ensure more attention could be spent on making sure the 
critical parts of the project such as the file storage system worked well.
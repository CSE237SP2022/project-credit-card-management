# project-credit-card-management

By: Andrew Yoo, David Wrenner, and DeBose Tuller

## Second Iteration

### How to run the program
Run the bash script provided in the command line to compile and run the java code:
$ bash run.sh

When prompted to enter a username and password, enter the following:
- Enter your username: dwusername
- Enter your password: dwpassword

A banking management system that runs in the command line.

Run the bash script provided in the command line to compile and run the java code:
$ bash run.sh

Currently, the user can only view the details of a dummy account that is pre-loaded into the system.
  -Username: dwusername
  -Password: dwpassword
  
### Tasks Completed For This Iteration

- The card management system can read in credit/debit card information from a file and create corresponding card objects.
- The different user account features (username, password, and income) can be changed.

### Tasks In Progress That Do Not Fully Work

- Currently, it is not possible for the user to create new accounts. There is already one account created for testing
purposes, but the mecnanism for storing new users and user information has not been implemented.
- We are also in the process of writing code that will write to the card text files whenever new cards are created.

### Tasks Left To Do

- Make the ability to create users.
- Create text files that store the user's information whenever a user is created
- Create Transactions whenever a user spends money with their credit and debit card
- Store Transactions for users in a file.

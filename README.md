# project-credit-card-management

A banking management system that runs in the command line.

Run the bash script provided in the command line to compile and run the java code:
$ bash run.sh

Currently, the user can only view the details of a dummy account that is pre-loaded into the system.
  -Username: dwusername
  -Password: dwpassword
 
For Iteration I, the user should be able to log in to an account using the credentials provided above. Once logged in, the user will have the option to see all the card owned by that user. The user will also have the option to create a new debit or credit card. This will generate a unique card number. Once a card is generated, the user can access the card by tying in an already existing card number. For debit cards, users can deposit and withdraw. For credit cards, users can spend and pay the balance according to a set credit limit.

Andrew worked on the Card, Debit Card, and Credit Card class heirarchy.
David added file storage and user login.
DuBose made the Transaction class and base for the Management System.
 
For the next iteration, we would like to add support for executing and storing a Transaction log, additional debit and credit cards features, and changing user profile information. The user interface will also need to be updated to reflect the new functions we will be adding to our card management project. 

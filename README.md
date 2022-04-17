# ENSF 409 Project - Group #7

![hamper](http://loveyourgut.com/wp-content/uploads/imagesCAGT4VWB.jpg)

The goal of this project was as follows (taken directly from the Project Handout):\
• Design and document an object-oriented Java application \
• Connect to and import data from a given database\
• Process and output data according to user input\
• Incorporate GUI interaction with user

These goals were met by creating a program that would create food hampers based off of nutritional needs for a group with varying parameters; utilizing a database and GUI to complete said program.

## A word about JUnit usage + Mockito

Through creating this programs Unit Tests, for Order.java in particular; Mockito was used as opposed to JUnit in order to mock the database connection rather than actually connecting to the database to carry out tests. It is not convention to use databases directly for Unit Tests, as was discovered through research.\

In "Referenced Libraries", Mockito referenced library can be found, as well as JUnit referenced library.\
Implementation would have been done through Maven to address any dependancies, however this was ideal given time constraints.


## Contributors

Ahmad Janjua\
Farica Mago\
Pedro Ghodsi\
Zohaib Ashfaq

## Run GUI

The program is run through the GUI.java file when compiled and the output of the hampers is written into "Finalized Hamper Order.txt"

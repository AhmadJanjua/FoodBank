package edu.ucalgary.ensf409;
/**
@author Ahmad Janjua
@version 1.3
@since 1.0
*/

/*
Client enum gathers all the info about the different client and
stores it for easy access.
*/

public enum Client
{
    // Different types of client. *ID gathered from sql data*
    ADULT_MALE(1),
    ADULT_FEMALE(2),
    CHILD_OVER_8(3),
    CHILD_UNDER_8(4);

    // Calories for each nutrition group.
    final int CALORIES;
    final double
            GRAIN,
            FRUIT_VEG,
            PROTEIN,
            OTHERS;

    /*
    * Constructor that gathers the data from the database,
    * then closes the connection.
    */
    Client(int id) {
        var enum_connection = new DataBase();
        double factor;

        int[] clientNeeds = enum_connection.selectNeeds(id);

        CALORIES = clientNeeds[4];

        //Converts percentages given to calories
        factor = (double) CALORIES/100;

        GRAIN = clientNeeds[0]*factor;
        FRUIT_VEG = clientNeeds[1]*factor;
        PROTEIN = clientNeeds[2]*factor;
        OTHERS = clientNeeds[3]*factor;

        enum_connection.close();
    }
}
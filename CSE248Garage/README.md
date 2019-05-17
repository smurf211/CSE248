<<<<<<< HEAD
# fgsdgdsfg
=======
# CSE 248 Garage


User objects are stored via a Hashmap, originally intended for use with thousands of users.

ParkingSpace objects are store via an array, as the maximum number of parking spaces could never be large enough to effect performance.

Garage class contains all critical objects, as this makes passing information between intents easier. Every view must be passed a Garage object that is identical to the garage used in the previous view.

Garage was originally saved to a binary file to allow objects to be maintained after the program is closed.

A webserver database has been implemented. It is a MYSQL database available via my personal website and controlled using PHPMYADMIN.
Upon startup of the application, the database tables are loaded and converted to JSON Strings via PHP scripting. Once the JSON strings are avaiable to the local client, they are parsed to properly create all objects needed.

In a future update, would like to load objects as needed, however in its current state performance is not an issue.

The program still functions as originally intended before implementing the database, however with every object that is created or modified, a connection is made to the database via a specific PHP script for each object/table being modified. The PHP script writes all critical values in the objects coresponding table. 

ParkingSpace tables are only created for spaces that have a vehicle present in them. Garage_data contains all necessary empty space information. 

To view a graphical representation of my Databases relationships open the CSE248GarageDatabaseRelationships.jpg in the same folder as this readme.

Relationships exist between user_data table with user_id corresponding to a respective user_parked_id and user_removed_id in the History table, user_id corresponds to a user_id present in every vehicle as well, this is only the user who parked the car. History contains both parked and removed ids as well as a vehicle_id. ParkingSpace_data contains a vehicle_id which coresponds the vehicle parked in the space.
>>>>>>> ceadbd2077337fc3b247c5b9cf4c0dd3ec734531

Basic_Motion
============

Basic_Motion is an exploration of Kinematic motion.

This project currently uses the Processing library and requires that Processing be installed properly for Basic_Motion to run. However, this project is being designed to allow just about any Graphics processing API to be used as a replacement:

Processing is Open Source Software.
The PDE (Processing Development Environment) is released under the GNU GPL (General Public License). 
The export libraries (also known as 'core') are released under the GNU LGPL (Lesser General Public License). 
There's more information about Processing and Open Source in the FAQ and more information about the GNU GPL and GNU LGPL at opensource.org. 
Please contribute to Processing!


More about Basic_Motion:  Basic_Motion is a homework assignment for CSC 484. It is actually the first and most basic assignment.  I am building this on a couple different computers and want to have a constant backup, in case something goes wrong. 

The design of this project began as a desire to create a simple game engine with easily extensible parts that could be interchanged.  I felt that this would provide me with a flexible and powerful core to make my future projects for this class a bit easier. The design was very basic at first, I identified several relationships that I really wanted to maintain and some that I did not.

The relationship that I did not want to maintain was that of a graphics API.  I honestly like Processing, but I wanted the flexibility to work with other API's if needed. So, you will notice that the coupling between the Viewer and the Skin is through the use of a Grphix wrapper. This allows the design to be changed easily, by extending Skin and the Viewer to use the new API, the rest stays the same. 

I also wanted to have a flexible core AI component that would allow me to easily extend functionality as we cover more complex concepts in class. For this I created a series of relationships within the structure package which allow the game loop to run without any further help from the AI_Controller. Yes, some of the functionality is spread between the AI_Controller, Movement, and Kinematic files. But by providing a Movement interface you can quickly create other types of movement. The same process will be used in the near future to provide Decision and Strategy interfaces. The AI_Controller will have these and these will, again use an interface implemented on the CHaracter class.  

This relationship allows the AI_Controller to have the Movement and Movable objects as it should, and allows AI_Controller to easilly sort out what to do with each, and will also allow for different types of Movable objects, ..., to be used.

If you found yourself reading this, you should at least give this project a quick examination. Keep in mind that I am a student and have never designed a Game Engine before. My requirements were my own, and I was not concerned with efficiency as much as extensibility.

Feel free to download this code and play around with it.



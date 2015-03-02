# RhombusExcercise
Rhombus excercise

Write a program that outputs this rhombus.
 

                            1

                        1   2   1

                    1   2   4   2   1

                1   2   4   8   4   2   1

            1   2   4   8  16   8   4   2   1

        1   2   4   8  16  32  16   8   4   2   1

    1   2   4   8  16  32  64  32  16   8   4   2   1

    1   2   4   8  16  32  64  32  16   8   4   2   1

        1   2   4   8  16  32  16   8   4   2   1

            1   2   4   8  16   8   4   2   1

                1   2   4   8   4   2   1

                    1   2   4   2   1

                        1   2   1

                            1





Short description to run it:

1) compile the project.
2) in command line execute:
 java -jar domain-X.X.X-SNAPSHOT.jar.original
        (or with a main argument)
 java -jar domain-X.X.X-SNAPSHOT.jar.original 32






Long description to run (rest service included):

It's a maven project composed with 2 modules.

The parent project is "rhombus".

The "domain" module has the  "accelone.exercise.rhombus.Rhombus" class which represent the rhombus or diamond with numbers. This class has also the algorithm to create the matrix that represent the rhombus. Basically, the constructor takes in some numbers (this number is the one in the center of the rhombus).
On the other hand there are a set of classes and interfaces (designed based on the "strategy pattern") to print the rhombus to different outputs, such as console, txt file or even a String (with this string you could serialize it and persist or transport via http). The class "accelone.exercise.rhombus.printer.BasicPrinterImpl" has the algorithm to "fill" the missing spaces with blank spaces so the printing looks symmetric. This is one by the method "prettyPrintConverter(...)" which accept 2 parameters, the first one is the rhombus itself and the second one is an output abstraction (it could be any implementation you want, like I said it could be console output, string, txt file, etc).
Lastly, inside this same module we have a class to run a main method and test the printing in console output ("accelone.exercise.PrintRhombus").

The "rest" module has an http get endpoint "/rhombus" which returns the rhombus in plain txt format. To test it, you can run the jar file that has the embedded tomcat (rest-X.X.X-SNAPSHOT.jar). and then curl it: curl http://localhost:8080/rhombus?rhombusHeart=64 if you don't have curl then run it with any browser or http client.
There is also an integration test that test the http get call and validate the result using mockito.   


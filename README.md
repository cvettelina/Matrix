# Matrix
1. Write an application that:
  - Accepts two 3x3 matrix as input from the console (format is not important)
  - Calls a method with the matrixes as an argument, which multiplies the matrixes concurrently (each cell of the result must be calculated as a separate task) and returns the resulting matrix
  - Then calls another method that calculates the sum of each column of the result concurrently (as separate tasks) and returns the resulting array
  - Prints the array in the console
  - Manage all threads with thread pools
  - Allow the user to specify the size of the matrixes as input before the actual matrixes (square matrixes only; both matrixes are the same size)
  - Allow the application to perform the task multiple times one after the other (after the result is shown, the user can choose to repeat the process or exit)
2. Extra credit (not implemented yet):
Separate the application in two distinctive parts – client and server:
The client accepts user input and sends the matrixes to the server via multiple sockets – each column (or row) is sent via a separate socket
The server multiplies the matrixes and returns the result to the client
The client calculates the sums and displays them
Allow the server to handle multiple jobs at the same time (from different clients)

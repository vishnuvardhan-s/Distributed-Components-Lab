<b> Socket Instructions </b> <br>
gcc server.c -o server <br> gcc client.c -o client <br> ./server <br> ./client

<b> RPCGEN Instructions </b>
sudo rpcbind <br> rpcgen -a -C filename.x <br> edit the server and client files <br> make -f Makefile.filename to compile <br>
./filename_server in one terminal and ./filename_client in another terminal <br>

<b> RMI Instructions </b>
javac  *.java <br>
start rmiregistry <br>
start java RMI_Server <br>
java RMI_Client 127.0.0.1 <br>

<b> EJB </b>
<br>
Step 1: Create new Project -> JAVA Class Library <br>
Step 2: Create new Project -> JAVA EE -> Enterprise Application <br>
Step 3: Click next and then uncheck Web Application Module and Finish <br> 
Step 4: Right Click the Bean symbol and then click new->Session bean <br>
Step 5: Give some package name, check Remote option, then Finish <br>
Step 6: Right Click, Insert code -> Add Business Method <br>
Step 7: Give function name, return type, parameters add give name and type <br>
Step 8: Right click on Triangle Symbol and give Deploy <br>
Step 9: Create a new project -> JAVA EE -> Enterprise Application Client <br>
Step 10: Give next and finish <br>
Step 11: Right click -> Insert code -> Call Enterprise Bean <br>
Step 12: Call the functions that you want using the object that is created. <br>
Note: Deploy again to reset the variable values. <br>

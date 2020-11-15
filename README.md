<b> Socket Instructions </b>

gcc server.c -o server\ngcc client.c -o client
./server
./client


<b> RPCGEN Instructions </b>

sudo rpcbind
rpcgen -a -C filename.x
edit the server and client files
make -f Makefile.filename to compile
./filename_server in one terminal and ./filename_client in another terminal


<b> RMI Instructions </b>

javac  *.java
start rmiregistry
start java RMI_Server
java RMI_Client 127.0.0.1


<b> EJB </b>

Step 1: Create new Project -> JAVA Class Library
Step 2: Create new Project -> JAVA EE -> Enterprise Application
Step 3: Click next and then uncheck Web Application Module and Finish
Step 4: Right Click the Bean symbol and then click new->Session bean
Step 5: Give some package name, check Remote option, then Finish
Step 6: Right Click, Insert code -> Add Business Method
Step 7: Give function name, return type, parameters add give name and type
Step 8: Right click on Triangle Symbol and give Deploy
Step 9: Create a new project -> JAVA EE -> Enterprise Application Client
Step 10: Give next and finish
Step 11: Right click -> Insert code -> Call Enterprise Bean
Step 12: Call the functions that you want using the object that is created.
Note: Deploy again to reset the variable values.

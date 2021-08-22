#include<unistd.h>
#include<stdio.h>
#include<sys/socket.h>
#include<stdlib.h>
#include<netinet/in.h>
#include<string.h>
#define PORT 4444
int main(int argc, char const *argv[])
{
        int server_fd, new_socket, valread;
        struct sockaddr_in address;
        int opt=1;
        int addrlen = sizeof(address);
        char buf[1024]={0};
        if((server_fd=socket(AF_INET, SOCK_STREAM, 0))==0)
        {
                perror("Socket failed");
                exit(EXIT_FAILURE);
        }
        address.sin_family=AF_INET;
        address.sin_addr.s_addr=INADDR_ANY;
        address.sin_port=htons(PORT);
        if(bind(server_fd,(struct sockaddr *)&address, sizeof(address))<0)
        {
                perror("Bind failed");
                exit(EXIT_FAILURE);
        }
        if(listen(server_fd, 3) <0)
        {
                perror("Listen");
                exit(EXIT_FAILURE);
        }
        if((new_socket=accept(server_fd, (struct sockaddr *)&address, (socklen_t*)&addrlen))<0)
        {
                perror("Accept");
                exit(EXIT_FAILURE);
        }
	FILE *fp;
        read(new_socket,buf,100);
        fp=fopen("servermessage.txt","w");
        fprintf(fp,"%s",buf);
        printf("File recieved\n");
        return 0;
}



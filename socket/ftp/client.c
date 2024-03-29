#include<stdio.h>
#include<sys/socket.h>
#include<arpa/inet.h>
#include<unistd.h>
#include<string.h>
#define PORT 4444
int main(int argc, char const *argv[])
{
        int sock=0, valread;
        struct sockaddr_in serv_addr;
        char buf[1024]={0};
        if((sock=socket(AF_INET, SOCK_STREAM, 0))<0)
        {
                printf("\nSocket creation error\n");
                return -1;
        }
        serv_addr.sin_family = AF_INET;
        serv_addr.sin_port = htons(PORT);
        if(inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr)<=0)
        {
                printf("\nInvalid address\n");
                return -1;
        }
        if(connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr))<0)
        {
                printf("\nConnection failed\n");
                return -1;
        }
        FILE *f;
        f=fopen("clientmessage.txt","r");
        fscanf(f,"%s",buf);
        write(sock,buf,100);
        printf("File sent\n");
        return 0;
}


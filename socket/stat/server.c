#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<netinet/in.h>
#include<unistd.h>
#include<string.h>
#include<arpa/inet.h>
#define PORT 5555  //4 digit number
struct product {
        int id;
        char name[100];
        int available;
}products[10];
void main() {
        products[0].id = 1;
        strcpy(products[0].name,"toothbrush");
        products[0].available = 10;

        products[1].id = 2;
        strcpy(products[1].name,"paste");
        products[1].available = 10;

        products[2].id = 3;
        strcpy(products[2].name,"soap");
        products[2].available = 10;

        products[3].id = 4;
        strcpy(products[3].name,"bath");
        products[3].available = 10;


        int sockfd,connfd,sin_size;
        char result[100];
        sockfd=socket(AF_INET,SOCK_STREAM,0);
        struct sockaddr_in servaddr;
        struct sockaddr_in clientaddr;
        servaddr.sin_family = AF_INET;
        servaddr.sin_addr.s_addr = inet_addr("127.0.0.1");
        servaddr.sin_port = htons(PORT);
        bind(sockfd,(struct sockaddr *)&servaddr,sizeof(servaddr));
        listen(sockfd,5); //listen
        sin_size = sizeof(struct sockaddr_in);
        connfd = accept(sockfd, (struct sockaddr *)&clientaddr,&sin_size);
        
        while(1) {
        char prod[100];
        int required;
        read(connfd,prod,sizeof(prod));
        read(connfd,&required,sizeof(required));
        int index = -1;
        for(int i=0;i<4;i++) {
                if(strcmp(products[i].name,prod)==0) {
                        index = i;
                        break;
                }
        }
	if(index==-1) {
                strcpy(result,"Product not found!");
        }
        else {
                if(required/2 > products[index].available) {
                        strcpy(result,"Pathala");
                }
                else {
                        products[index].available -= required;
                        strcpy(result,"Product bought!");
                }
        }
        write(connfd,&result,sizeof(result));
        }
        close(sockfd);
}

#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<netinet/in.h>
#include<unistd.h>
#include<string.h>
#include<strings.h>
#include<arpa/inet.h>
#define PORT 5555
void main()
{
        int sockfd,sin_size,con;
        char operat;
        char result[100];
        sockfd=socket(AF_INET,SOCK_STREAM,0);
        struct sockaddr_in servaddr;
        servaddr.sin_family=AF_INET;
        servaddr.sin_addr.s_addr=inet_addr("127.0.0.1");
        servaddr.sin_port=htons(PORT);
        sin_size=sizeof(struct sockaddr_in);
        connect(sockfd,(struct sockaddr *) &servaddr, sin_size);

        
        while(1) {
                char product[100];
                printf("Enter the prodcut to buy: ");
                scanf("%s",product);
                int required;
                printf("Enter the quantity to buy: ");
                scanf("%d",&required);
                write(sockfd,product,sizeof(product));
                write(sockfd,&required,sizeof(required));
                read(sockfd,result,sizeof(result));
                printf("%s\n",result);
        }
        close(sockfd);
}

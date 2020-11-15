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
        int op1,op2,result;
        sockfd=socket(AF_INET,SOCK_STREAM,0);
        struct sockaddr_in servaddr;
        servaddr.sin_family=AF_INET;
        servaddr.sin_addr.s_addr=inet_addr("127.0.0.1");
        servaddr.sin_port=htons(PORT);
        sin_size=sizeof(struct sockaddr_in);
        connect(sockfd,(struct sockaddr *) &servaddr, sin_size);
        // char name[100];
        // strcpy(name,"logesh");
        // printf("%s",name);
        while(1) {
                printf("Enter operands and operation to perform\n");
                scanf("%d %d %c",&op1,&op2,&operat); 
                write(sockfd,&operat,sizeof(operat));
                write(sockfd,&op1,sizeof(op1));
                write(sockfd,&op2,sizeof(op2));
                read(sockfd,&result,sizeof(result));
                printf("Result : %d\n",result);
        }
        close(sockfd);
}

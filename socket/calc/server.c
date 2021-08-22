#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<netinet/in.h>
#include<unistd.h>
#include<string.h>
#include<arpa/inet.h>
#define PORT 5555  //4 digit number
void main()
{
        int sockfd,connfd,sin_size;
        char operator;
        int op1,op2,result;
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


        
        read(connfd,&operator,sizeof(operator));
        read(connfd,&op1,sizeof(op1));
        read(connfd,&op2,sizeof(op2));
	if(operator=='+')
        {
                result=op1 + op2;
        }
        else if(operator=='-')
        {
                result=op1 - op2;
        }
        else if(operator=='*')
        {
                result=op1 * op2;
        }
        else if(operator=='/')
        {
                result=op1 / op2;
        }
        else
        {
                printf("Invalid operator\n");
                result=-1;
        }
        write(connfd,&result,sizeof(result));
        close(sockfd);
}

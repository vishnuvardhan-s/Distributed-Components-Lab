/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "chat.h"

message *
send_1_svc(message *argp, struct svc_req *rqstp)
{
	static message  result;
	printf("Client says: %s\n",argp->m);
	printf("Enter a text to send: ");
	scanf("%s",result.m);
	return &result;
}

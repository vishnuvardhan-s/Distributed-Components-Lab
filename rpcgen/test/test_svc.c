/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "test.h"
#include <stdio.h>
#include <stdlib.h>
#include <rpc/pmap_clnt.h>
#include <string.h>
#include <memory.h>
#include <sys/socket.h>
#include <netinet/in.h>

#ifndef SIG_PF
#define SIG_PF void(*)(int)
#endif

static void
test_1(struct svc_req *rqstp, register SVCXPRT *transp)
{
	union {
		name intialize_1_arg;
		int request_1_arg;
		qanda judge_1_arg;
		name score_1_arg;
		int leaderboard_1_arg;
	} argument;
	char *result;
	xdrproc_t _xdr_argument, _xdr_result;
	char *(*local)(char *, struct svc_req *);

	switch (rqstp->rq_proc) {
	case NULLPROC:
		(void) svc_sendreply (transp, (xdrproc_t) xdr_void, (char *)NULL);
		return;

	case intialize:
		_xdr_argument = (xdrproc_t) xdr_name;
		_xdr_result = (xdrproc_t) xdr_void;
		local = (char *(*)(char *, struct svc_req *)) intialize_1_svc;
		break;

	case request:
		_xdr_argument = (xdrproc_t) xdr_int;
		_xdr_result = (xdrproc_t) xdr_question;
		local = (char *(*)(char *, struct svc_req *)) request_1_svc;
		break;

	case judge:
		_xdr_argument = (xdrproc_t) xdr_qanda;
		_xdr_result = (xdrproc_t) xdr_void;
		local = (char *(*)(char *, struct svc_req *)) judge_1_svc;
		break;

	case score:
		_xdr_argument = (xdrproc_t) xdr_name;
		_xdr_result = (xdrproc_t) xdr_int;
		local = (char *(*)(char *, struct svc_req *)) score_1_svc;
		break;

	case leaderboard:
		_xdr_argument = (xdrproc_t) xdr_int;
		_xdr_result = (xdrproc_t) xdr_leader;
		local = (char *(*)(char *, struct svc_req *)) leaderboard_1_svc;
		break;

	default:
		svcerr_noproc (transp);
		return;
	}
	memset ((char *)&argument, 0, sizeof (argument));
	if (!svc_getargs (transp, (xdrproc_t) _xdr_argument, (caddr_t) &argument)) {
		svcerr_decode (transp);
		return;
	}
	result = (*local)((char *)&argument, rqstp);
	if (result != NULL && !svc_sendreply(transp, (xdrproc_t) _xdr_result, result)) {
		svcerr_systemerr (transp);
	}
	if (!svc_freeargs (transp, (xdrproc_t) _xdr_argument, (caddr_t) &argument)) {
		fprintf (stderr, "%s", "unable to free arguments");
		exit (1);
	}
	return;
}

int
main (int argc, char **argv)
{
	register SVCXPRT *transp;

	pmap_unset (test, TEST_VERS);

	transp = svcudp_create(RPC_ANYSOCK);
	if (transp == NULL) {
		fprintf (stderr, "%s", "cannot create udp service.");
		exit(1);
	}
	if (!svc_register(transp, test, TEST_VERS, test_1, IPPROTO_UDP)) {
		fprintf (stderr, "%s", "unable to register (test, TEST_VERS, udp).");
		exit(1);
	}

	transp = svctcp_create(RPC_ANYSOCK, 0, 0);
	if (transp == NULL) {
		fprintf (stderr, "%s", "cannot create tcp service.");
		exit(1);
	}
	if (!svc_register(transp, test, TEST_VERS, test_1, IPPROTO_TCP)) {
		fprintf (stderr, "%s", "unable to register (test, TEST_VERS, tcp).");
		exit(1);
	}

	svc_run ();
	fprintf (stderr, "%s", "svc_run returned");
	exit (1);
	/* NOTREACHED */
}

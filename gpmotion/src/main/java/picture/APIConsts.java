package picture;

/**
 * Created by bintou on 2016/10/10.
 */

public class APIConsts {

    //			ERROR CODES
    public	static	final	int	ccERR_OK		=	0;		//	everything went OK
    public	static	final	int	ccERR_GENERAL	=	-1;		//	general internal error
    public	static	final	int	ccERR_STATUS	=	-2;		//	status is not correct
    public	static	final	int	ccERR_NET_ERROR	=	-3;		//	network data transfer error
    public	static	final	int	ccERR_TEXT_SIZE	=	-4;		//	text is not of an appropriate size
    public	static	final	int	ccERR_OVERLOAD	=	-5;		//	server's overloaded
    public	static	final	int	ccERR_BALANCE	=	-6;		//	not enough funds to complete the request
    public	static	final	int	ccERR_TIMEOUT	=	-7;		//	requiest timed out
    public	static	final	int	ccERR_UNKNOWN	=	-200;	//	unknown error

    //			picture processing TIMEOUTS
    public	static	final	int	ptoDEFAULT		=	0;		//	default timeout, server-specific
    public	static	final	int	ptoLONG			=	1;		//	long timeout for picture, server-specfic
    public	static	final	int	pto30SEC		=	2;		//	30 seconds timeout for picture
    public	static	final	int	pto60SEC		=	3;		//	60 seconds timeout for picture
    public	static	final	int	pto90SEC		=	4;		//	90 seconds timeout for picture

    //			picture processing TYPES
    public	static	final	int	ptUNSPECIFIED	=	0;		//	picture type unspecified
}

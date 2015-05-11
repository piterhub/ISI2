package org.sample.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://ws.sample.org/", 
			portName = "HelloServiceImplPort", 
			serviceName = "HelloServiceImplService",
			wsdlLocation = "http://ws.sample.org/HelloServiceImplService")
//@SOAPBinding(style=Style.RPC, use=Use.LITERAL)	
public class HelloServiceImpl {
	
	@WebMethod(action = "getVersion")
	public String getVersion() {
        return "1.0";
    }
 
	@WebMethod(action = "hello")
    public String hello(String user) {
        return "Hello " + user + "!";
    }
}

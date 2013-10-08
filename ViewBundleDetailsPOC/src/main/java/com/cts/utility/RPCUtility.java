package com.cts.utility;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RPCUtility {
    private final XmlUrlResponse xmlUrlResponse;
	
	@Autowired
	public RPCUtility(XmlUrlResponse xmlUrlResponse) {
		this.xmlUrlResponse = xmlUrlResponse;
	}
	
	 public Object getOutput(String methodName, Vector<Hashtable<String, Object>> methodParams) throws XmlRpcException, IOException {
	        return xmlUrlResponse.getOutput(methodName, methodParams);
	 }

}

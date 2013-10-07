package com.cts.utility;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

public class RPCUtility {
    private final XmlUrlResponse xmlUrlResponse;
	
	@Autowired
	public RPCUtility(XmlUrlResponse xmlUrlResponse) {
		this.xmlUrlResponse = xmlUrlResponse;
	}
	 public Object getOutputXmlFromRpc(String serviceUrl, String methodName, Vector methodParams){
	        return xmlUrlResponse.getOutputXml(serviceUrl, methodName, methodParams);
	    }

}

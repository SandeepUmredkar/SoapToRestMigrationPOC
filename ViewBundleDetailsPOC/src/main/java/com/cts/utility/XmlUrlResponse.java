package com.cts.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class XmlUrlResponse {
	XmlRpcClient xmlRpcClient;
	@Autowired
	public XmlUrlResponse(@Value("${soa.url}") String urlForService) throws MalformedURLException{
		this.xmlRpcClient = new XmlRpcClient(urlForService);;
	}
	
	public Object getOutput(String methodName, Vector<Hashtable<String, Object>> methodParams) throws XmlRpcException, IOException {
			return xmlRpcClient.execute(methodName, methodParams);
	}
}

package com.cts.utility;

import java.util.Hashtable;
import java.util.Vector;

public class XmlUrlResponse {
	private static Hashtable o_xmlrpcClients = new Hashtable();
	public Object getOutputXml(String serviceUrl, String methodName, Vector methodParams) {
			XmlRpcClient x_xmlRpcClient = new XmlRpcClient(serviceUrl);
			o_xmlrpcClients.put( serviceUrl, x_xmlRpcClient );
			return x_xmlRpcClient.execute(methodName, methodParams);
	}
}

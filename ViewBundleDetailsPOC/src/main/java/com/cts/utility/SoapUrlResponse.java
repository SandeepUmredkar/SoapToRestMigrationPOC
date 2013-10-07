package com.cts.utility;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.springframework.stereotype.Component;

@Component
public class SoapUrlResponse {
	private SOAPConnection soapConnection;
	
	public SoapUrlResponse() throws UnsupportedOperationException, SOAPException {
		soapConnection = SOAPConnectionFactory.newInstance().createConnection();
	}
	
	public SOAPMessage getSoapResponse(String soapUrl, SOAPMessage requestSoapMessage) throws SOAPException{
		return soapConnection.call(requestSoapMessage, soapUrl);
	}
}

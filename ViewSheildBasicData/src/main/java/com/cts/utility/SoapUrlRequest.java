package com.cts.utility;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.springframework.stereotype.Component;
@Component
public class SoapUrlRequest {
	
	private final SOAPMessage soapRequest;
    private final SOAPEnvelope soapEnvelope;
    private final SOAPBody soapBody;
    private final MimeHeaders mimeHeaders;
    
	public SoapUrlRequest() throws SOAPException {
		soapRequest = MessageFactory.newInstance().createMessage();
		mimeHeaders = soapRequest.getMimeHeaders();
		soapEnvelope = soapRequest.getSOAPPart().getEnvelope();
		soapBody = soapEnvelope.getBody();
	}

	public SOAPMessage getSoapRequest() throws SOAPException {
        SOAPElement getJsonForSoapElement = soapBody.addChildElement("getJsonForSOAP");
        SOAPElement nameElement = getJsonForSoapElement.addChildElement("name");
        nameElement.addTextNode("getJsonForSOAP");
        mimeHeaders.addHeader("SOAPAction", "http://localhost:8080/StubForViewAllowance");
        soapRequest.saveChanges();
        return soapRequest;
	}
}

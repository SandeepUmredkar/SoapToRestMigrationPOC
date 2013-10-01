package com.cts.utility;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.springframework.stereotype.Component;
@Component
public class SoapClientUtility {
	
    public SOAPMessage getSoapForUrl(String url) throws UnsupportedOperationException, SOAPException {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
            soapConnection.close();
            return soapResponse;
    }

    private SOAPMessage createSOAPRequest() throws SOAPException{
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        SOAPBody soapBody = soapEnvelope.getBody();
        SOAPElement getJsonForSoapElement = soapBody.addChildElement("getJsonForSOAP");
        SOAPElement nameElement = getJsonForSoapElement.addChildElement("name");
        nameElement.addTextNode("getJsonForSOAP");
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", "http://localhost:8080/StubForViewAllowance");
        soapMessage.saveChanges();
        return soapMessage;
    }
}


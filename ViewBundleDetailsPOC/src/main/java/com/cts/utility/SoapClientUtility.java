package com.cts.utility;
import java.io.IOException;

import javax.xml.soap.*;

import org.springframework.stereotype.Component;
@Component
public class SoapClientUtility {
	
	public static void main(String args[]) throws UnsupportedOperationException, SOAPException, IOException{
		SoapClientUtility clientUtility = new SoapClientUtility();
		clientUtility.getSoapForUrl("http://localhost:8080/StubForViewAllowance/services/SOAPServiceJsonProvider");
	}

    public void getSoapForUrl(String url) throws UnsupportedOperationException, SOAPException, IOException {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url1 = "http://localhost:8080/StubForViewAllowance/services/SOAPServiceJsonProvider";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url1);
           // soapConnection.close();
            //return soapResponse;
    }

    private SOAPMessage createSOAPRequest() throws SOAPException, IOException{
    	 MessageFactory messageFactory = MessageFactory.newInstance();
         SOAPMessage soapMessage = messageFactory.createMessage();
         SOAPPart soapPart = soapMessage.getSOAPPart();
         // SOAP Envelope
         SOAPEnvelope envelope = soapPart.getEnvelope();
         // SOAP Body
         SOAPBody soapBody = envelope.getBody();
         SOAPElement getJsonForSoapElement = soapBody.addChildElement("getJsonForSOAP");
         SOAPElement nameElement = getJsonForSoapElement.addChildElement("name");
         nameElement.addTextNode("getJsonForSOAP");
         MimeHeaders headers = soapMessage.getMimeHeaders();
         headers.addHeader("SOAPAction", "http://localhost:8080/StubForViewAllowance/services/SOAPServiceJsonProvider");
         soapMessage.saveChanges();

         /* Print the request message */
         System.out.print("Request SOAP Message = ");
         //soapMessage.writeTo(System.out);
         System.out.println();
         return soapMessage;
    }
}
package com.cts.utility;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SoapClientUtility {
    private final SoapUrlRequest soapUrlRequest;
    private final SoapUrlResponse soapUrlResponse;
	
	@Autowired
	public SoapClientUtility(SoapUrlRequest soapUrlRequest, SoapUrlResponse soapUrlResponse) throws UnsupportedOperationException, SOAPException {
		this.soapUrlRequest = soapUrlRequest;
		this.soapUrlResponse = soapUrlResponse;
	}
	
    public SOAPMessage getSoapMessageForUrl() throws SOAPException{
        return soapUrlResponse.getSoapResponse(null, soapUrlRequest.getSoapRequest());
    }
}


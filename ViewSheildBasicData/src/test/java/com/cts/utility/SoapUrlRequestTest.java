package com.cts.utility;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.junit.Assert;

public class SoapUrlRequestTest {
	//@Test
	public void itShouldCreateTheSoapRequest() throws SOAPException{
		SoapUrlRequest soapUrlRequest = new SoapUrlRequest();
		SOAPMessage soapRequest = soapUrlRequest.getSoapRequest();
		Assert.assertNotNull(soapRequest.getMimeHeaders().getHeader("SOAPAction"));
	}
}
package com.cts.utility;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class SoapClientUtilityTest {
	
	@Mock
	SoapUrlResponse soapUrlResponse;
	@Mock
	SoapUrlRequest soapUrlRequest;
	@Mock
	SOAPMessage requestSoapMessage;
	@Mock
	SOAPMessage responseSoapMessage;
	
	@Test
	public void itShouldCreateSoapRequestAndGetSoapResponse() throws SOAPException{
		//given
		SoapClientUtility soapClientUtility = new SoapClientUtility(soapUrlRequest, soapUrlResponse);
		String soapUrl = "http://localhost:8080/StubForViewAllowance/services/SOAPServiceJsonProvider";
		//when
		when(soapUrlRequest.getSoapRequest()).thenReturn(requestSoapMessage);
		when(soapUrlResponse.getSoapResponse(soapUrl, requestSoapMessage)).thenReturn(responseSoapMessage);
		//verify
		Assert.assertEquals(responseSoapMessage, soapClientUtility.getSoapMessageForUrl(soapUrl));
	}
}

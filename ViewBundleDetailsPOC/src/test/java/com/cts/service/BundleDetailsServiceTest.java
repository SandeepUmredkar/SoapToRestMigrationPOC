package com.cts.service;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.w3c.dom.Node;

import com.cts.model.Bundle;
import com.cts.utility.SoapClientUtility;
@RunWith(MockitoJUnitRunner.class)
public class BundleDetailsServiceTest {
	private BundleDetailsService bundleDetailsService;
	@Mock
	SoapClientUtility soapClientUtility;
	@Mock
	SOAPMessage soapMessage;
	@Mock
	SOAPBody soapBody; 
	@Mock
	Node firstNode;
	@Mock
	Node SecondNode;
	@Mock
	Node thirdNode;
	String urlForSoapService = "http://localhost:8080/StubForViewAllowance/services/SOAPServiceJsonProvider";
	@Test
	public void itShouldReturnBundleFromXMLProducedFromSoapCall() throws UnsupportedOperationException, SOAPException, JAXBException{
		//given
		bundleDetailsService = new BundleDetailsService(soapClientUtility, urlForSoapService);
		String xmlForBundle = "<bundle><bundlevalue>mockValue</bundlevalue></bundle>";
		
		//when
		when(soapClientUtility.getSoapMessageForUrl(urlForSoapService)).thenReturn(soapMessage);
		when(soapMessage.getSOAPBody()).thenReturn(soapBody);
		when(soapBody.getFirstChild()).thenReturn(firstNode);
		when(firstNode.getFirstChild()).thenReturn(SecondNode);
		when(SecondNode.getFirstChild()).thenReturn(thirdNode);
		when(thirdNode.getTextContent()).thenReturn(xmlForBundle);
		Bundle actualBundle = bundleDetailsService.getBundle("447000000000");
		
		//verify
		verify(soapClientUtility).getSoapMessageForUrl(urlForSoapService);
		verify(soapMessage).getSOAPBody();
		verify(soapBody).getFirstChild();
		verify(firstNode).getFirstChild();
		verify(SecondNode).getFirstChild();
		verify(thirdNode).getTextContent();
		assertThat(actualBundle.bundleValue).isEqualTo("mockValue");
	}
}
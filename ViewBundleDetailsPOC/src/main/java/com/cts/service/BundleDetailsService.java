package com.cts.service;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.SOAPException;
import javax.xml.transform.stream.StreamSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.DOMException;

import com.cts.model.Bundle;
import com.cts.utility.SoapClientUtility;
@Component
public class BundleDetailsService {
	private final SoapClientUtility soapClientUtility;
	private final JAXBContext jaxbContext;
	private final Unmarshaller unmarshaller;
	private final String urlForSoapService;
	@Autowired
	public BundleDetailsService(SoapClientUtility soapClientUtility,@Value("${soa.url}") String urlForSoapService) throws JAXBException{
		this.soapClientUtility = soapClientUtility;
		this.urlForSoapService = urlForSoapService;
		jaxbContext = JAXBContext.newInstance(Bundle.class);
		unmarshaller = jaxbContext.createUnmarshaller();
	}
	
	public Bundle getBundle(String msisdn) throws DOMException, SOAPException, JAXBException  {
		String xmlStr = soapClientUtility.getSoapMessageForUrl(urlForSoapService).getSOAPBody().getFirstChild().getFirstChild().getFirstChild().getTextContent();
		return (Bundle) unmarshaller.unmarshal(new StreamSource(new StringReader(xmlStr)));
	}
}

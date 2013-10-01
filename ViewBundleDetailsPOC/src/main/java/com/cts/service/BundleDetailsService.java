package com.cts.service;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.model.Bundle;
import com.cts.utility.SoapClientUtility;
@Component
public class BundleDetailsService {
	private final SoapClientUtility soapClientUtility;
	@Autowired
	public BundleDetailsService(SoapClientUtility soapClientUtility){
		this.soapClientUtility = soapClientUtility;
	}
	public Bundle getBundle(String msisdn) throws UnsupportedOperationException, SOAPException, JAXBException {
		SOAPMessage soapResponse = soapClientUtility.getSoapForUrl("http://localhost:8080/StubForViewAllowance/services/SOAPServiceJsonProvider");
		JAXBContext jc = JAXBContext.newInstance(Bundle.class);
		Unmarshaller u = jc.createUnmarshaller();
		StringBuffer xmlStr = new StringBuffer(soapResponse.getSOAPBody().getFirstChild().getFirstChild().getFirstChild().getTextContent());
		Bundle bundle = (Bundle) u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())));
		return bundle;
	}
}

package com.cts.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.xmlrpc.XmlRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.constants.InputParameters;
import com.cts.model.Bundle;
import com.cts.model.Shield;
import com.cts.utility.RPCUtility;

@Component
public class BundleDetailsService {
	private final JAXBContext jaxbContext;
	private final Unmarshaller unmarshaller;
	private final RPCUtility rpcUtility;
	private final String methodName;
	@Autowired
	public BundleDetailsService(RPCUtility rpcUtility,@Value("${methodName}") String methodName) throws JAXBException{
		this.rpcUtility = rpcUtility;
		this.methodName = methodName;
		jaxbContext = JAXBContext.newInstance(Bundle.class);
		unmarshaller = jaxbContext.createUnmarshaller();
	}
	
	public Bundle getBundle(Shield shield) throws XmlRpcException, IOException, JAXBException {
		Hashtable<String, Object> methodParmeters = new Hashtable<String, Object>();
		methodParmeters.put(InputParameters.MSISDN, shield.getMsisdn());
		methodParmeters.put(InputParameters.DATE, new Date());
        methodParmeters.put(InputParameters.STATUS, shield.getStatus());
        methodParmeters.put(InputParameters.VAGE_VERIFICATION, shield.getVagever());
        methodParmeters.put(InputParameters.SURNAME, shield.getSurname());
        methodParmeters.put(InputParameters.FORENAME, shield.getForename());
        methodParmeters.put(InputParameters.TITLE, shield.getTitle());
        methodParmeters.put(InputParameters.HOUSE_NUMBER, shield.getHouseNumber());
        methodParmeters.put(InputParameters.HOUSE_NAME, shield.getHouseName());
        methodParmeters.put(InputParameters.STREET_NAME, shield.getStreetName());
        methodParmeters.put(InputParameters.POST_CODE, shield.getPostCode());
        methodParmeters.put(InputParameters.DATE_OF_BIRTH, new Date());
        methodParmeters.put(InputParameters.CARD_NUMBER, shield.getCardNumber());
        methodParmeters.put(InputParameters.AGE_VERIFICATION_METHOD, shield.getAgeVerMethod());
        methodParmeters.put(InputParameters.AGE_VERIFICATION_PIN, shield.getAgeVerPin());
        methodParmeters.put(InputParameters.PARENTAL_CONTROL_PIN, shield.getParentalControlPin());
        methodParmeters.put(InputParameters.USE_DATA_MARKETING, Boolean.FALSE);
        methodParmeters.put(InputParameters.ACTIONED_BY, shield.getActionedBy());
        methodParmeters.put(InputParameters.CHANNEL_ID, shield.getChannelId());
        methodParmeters.put(InputParameters.ACTION_CHANNEL_ID, shield.getActionChannelID());
        methodParmeters.put(InputParameters.PAYMENT_TYPE, shield.getPaymentType());
        methodParmeters.put(InputParameters.BUSINESS_USER_FLAG, shield.getBusinessUserFlag());
        methodParmeters.put(InputParameters.AV_ATTEMPT_NO, shield.getAvAttemptNo());
        
        Vector<Hashtable<String, Object>> methodParams = new Vector<Hashtable<String, Object>>();
        methodParams.add(methodParmeters);
        
		String xmlStr = rpcUtility.getOutputXmlFromRpc(methodName, methodParams).toString();
		return (Bundle) unmarshaller.unmarshal(new StreamSource(new StringReader(xmlStr)));
	}
}

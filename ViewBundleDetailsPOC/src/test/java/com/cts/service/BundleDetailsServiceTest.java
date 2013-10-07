package com.cts.service;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.apache.xmlrpc.XmlRpcException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cts.constants.InputParameters;
import com.cts.model.Bundle;
import com.cts.model.Shield;
import com.cts.utility.RPCUtility;
@RunWith(MockitoJUnitRunner.class)
public class BundleDetailsServiceTest {
	private BundleDetailsService bundleDetailsService;
	@Mock
	RPCUtility rpcUtility;
	String urlForSoapService = "http://localhost:8080/StubForViewAllowance/services/SOAPServiceJsonProvider";
	@Test
	public void itShouldReturnBundleFromXMLProducedFromXmlRpcCall() throws UnsupportedOperationException, SOAPException, JAXBException, XmlRpcException, IOException{
		//given
		String methodName = "getShieldBasicData";
		bundleDetailsService = new BundleDetailsService(rpcUtility, methodName);
		String xmlForBundle = "<bundle><bundlevalue>mockValue</bundlevalue></bundle>";
		Shield shield = new Shield();
		shield.setMsisdn("447730336486");
		shield.setDate(new Date());
		shield.setStatus(2);
		shield.setVagever("U");
		shield.setSurname("");
		shield.setForename("");
		shield.setTitle("");
		shield.setHouseNumber(0);
		shield.setHouseName("");
		shield.setStreetName("");
		shield.setPostCode("");
		shield.setDateOfBirth(new Date());
		shield.setCardNumber("33333");
		shield.setAgeVerMethod("A");
		shield.setAgeVerPin("0000");
		shield.setParentalControlPin("01234");
		shield.setUseDataMarketing(Boolean.FALSE);
		shield.setActionedBy("tesco");
		shield.setChannelId("TES");
		shield.setActionChannelID("O2S");
		shield.setPaymentType(1);
		shield.setBusinessUserFlag(0);
		shield.setAvAttemptNo(1);
		
		Hashtable<String, Object> methodParmeters = new Hashtable<String, Object>();
		methodParmeters.put(InputParameters.MSISDN, "447730336486");
      	methodParmeters.put(InputParameters.DATE, new Date());
        methodParmeters.put(InputParameters.STATUS, 2);
        methodParmeters.put(InputParameters.VAGE_VERIFICATION, "U");
        methodParmeters.put(InputParameters.SURNAME, "");
        methodParmeters.put(InputParameters.FORENAME, "");
        methodParmeters.put(InputParameters.TITLE, "");
        methodParmeters.put(InputParameters.HOUSE_NUMBER, 0);
        methodParmeters.put(InputParameters.HOUSE_NAME, "");
        methodParmeters.put(InputParameters.STREET_NAME, "");
        methodParmeters.put(InputParameters.POST_CODE, "");
        methodParmeters.put(InputParameters.DATE_OF_BIRTH, new Date());
        methodParmeters.put(InputParameters.CARD_NUMBER, "33333");
        methodParmeters.put(InputParameters.AGE_VERIFICATION_METHOD, "A");
        methodParmeters.put(InputParameters.AGE_VERIFICATION_PIN, "0000");
        methodParmeters.put(InputParameters.PARENTAL_CONTROL_PIN, "01234");
        methodParmeters.put(InputParameters.USE_DATA_MARKETING, Boolean.FALSE);
        methodParmeters.put(InputParameters.ACTIONED_BY, "tesco");
        methodParmeters.put(InputParameters.CHANNEL_ID, "TES");
        methodParmeters.put(InputParameters.ACTION_CHANNEL_ID, "O2S");
        methodParmeters.put(InputParameters.PAYMENT_TYPE, 1);
        methodParmeters.put(InputParameters.BUSINESS_USER_FLAG, 0);
        methodParmeters.put(InputParameters.AV_ATTEMPT_NO, 1);
        Vector<Hashtable<String, Object>> methodParams = new Vector<Hashtable<String, Object>>();
        methodParams.add(methodParmeters);
		
		//when
		when(rpcUtility.getOutputXmlFromRpc(methodName, methodParams)).thenReturn(xmlForBundle);
		Bundle actualBundle = bundleDetailsService.getBundle(shield);
		
		//verify
		verify(rpcUtility).getOutputXmlFromRpc(methodName, methodParams);
		assertThat(actualBundle.bundleValue).isEqualTo("mockValue");
	}
}
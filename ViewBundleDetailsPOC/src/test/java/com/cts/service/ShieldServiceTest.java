package com.cts.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.xml.bind.JAXBException;

import org.apache.xmlrpc.XmlRpcException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cts.constants.InputParameters;
import com.cts.model.Shield;
import com.cts.utility.RPCUtility;
@RunWith(MockitoJUnitRunner.class)
public class ShieldServiceTest {
	private ShieldService shieldService;
	@Mock
	RPCUtility rpcUtility;
	String urlForSoapService = "http://localhost:8080/StubForViewAllowance/services/SOAPServiceJsonProvider";
	@Test
	public void itShouldReturnShieldFromXMLProducedFromXmlRpcCall() throws JAXBException, XmlRpcException, IOException {
		//given
		String methodName = "getShieldBasicData";
		
		shieldService = new ShieldService(rpcUtility, methodName);
		String jsonForShield = "{STATUS=30, AV_ATTEMPT_NO=0, MAX_AV_ATTEMPT=10, BUSINESS_USER_FLAG=0, PREVIOUS_STATUS=1}";
		Shield shield = new Shield();
		String msisdn = "447730336486";
		shield.setMsisdn(msisdn);
		
		Hashtable<String, Object> methodParmeters = new Hashtable<String, Object>();
		methodParmeters.put(InputParameters.MSISDN, "447730336486");
        Vector<Hashtable<String, Object>> methodParams = new Vector<Hashtable<String, Object>>();
        methodParams.add(methodParmeters);
		
		//when
		when(rpcUtility.getOutput(methodName, methodParams)).thenReturn(jsonForShield);
		Shield basicData = shieldService.getBasicData(msisdn);
		
		//verify
		Assert.assertEquals((Integer)30, basicData.getStatus());
		verify(rpcUtility).getOutput(methodName, methodParams);
		
	}
}
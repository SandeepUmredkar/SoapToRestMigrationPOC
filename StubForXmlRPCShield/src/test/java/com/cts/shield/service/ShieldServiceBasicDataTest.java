package com.cts.shield.service;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.junit.Assert;
import org.junit.Test;

public class ShieldServiceBasicDataTest {
	
	ShieldServiceBasicData shieldServiceBasicData = new ShieldServiceBasicData();
	@Test
	public void itShouldReturnMapWithStatusAs0(){
		//when
		Hashtable<String, Object> methodParmeters = new Hashtable<String, Object>();
		methodParmeters.put("MSISDN", 0);
		String actualMap = shieldServiceBasicData.getMapForShield(methodParmeters);
		//verify
		Assert.assertEquals("{STATUS=0}", actualMap);
	}
	
	@Test
	public void thisMethodToTestWhetherTheServiceIsWorking() throws XmlRpcException, IOException{
		XmlRpcClient server = new XmlRpcClient("http://localhost:8071/RPC2"); //
		Vector<Object> methodParams = new Vector<Object>();
		Hashtable<String, Object> methodParmeters = new Hashtable<String, Object>();
		methodParmeters.put("MSISDN", 4470);
		methodParams.add(methodParmeters);
		Object result = server.execute("shield.getMapForShield", methodParams);
		System.out.println("The result is: "+result.toString());
	}

}

package com.cts.shield.service;

import java.io.IOException;
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
		String actualMap = shieldServiceBasicData.getMapForShield();
		//verify
		Assert.assertEquals("{STATUS=0}", actualMap);
	}
	
	//@Test
	public void thisMethodToTestWhetherTheServiceIsWorking() throws XmlRpcException, IOException{
		XmlRpcClient server = new XmlRpcClient("http://localhost:8081/RPC2"); //
		Object result = server.execute("shield.getMapForShield", new Vector<Object>());
		System.out.println("The result is: "+result.toString());
	}

}

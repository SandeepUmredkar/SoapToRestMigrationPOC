package com.cts.service;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.xml.bind.JAXBException;

import org.apache.xmlrpc.XmlRpcException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.constants.InputParameters;
import com.cts.model.Shield;
import com.cts.utility.RPCUtility;
import com.google.common.base.Splitter;
import com.google.gson.Gson;

@Component
public class ShieldService {
	private final RPCUtility rpcUtility;
	private final String methodName;
	private final Gson gson;
	private final ObjectMapper objectMapper; 
	
	@Autowired
	public ShieldService(RPCUtility rpcUtility,@Value("${methodName}") String methodName) throws JAXBException{
		this.rpcUtility = rpcUtility;
		this.methodName = methodName;
		gson = new Gson();
		objectMapper = new ObjectMapper();
	}
	
	public Shield getBasicData(String msisdn) throws XmlRpcException, IOException {
		Hashtable<String, Object> methodParmeters = new Hashtable<String, Object>();
		methodParmeters.put(InputParameters.MSISDN, msisdn);
        Vector<Hashtable<String, Object>> methodParams = new Vector<Hashtable<String, Object>>();
        methodParams.add(methodParmeters);
        String mapString = rpcUtility.getOutput(methodName, methodParams).toString();
		@SuppressWarnings("rawtypes")
		Map mapFromString = Splitter.on(',').trimResults().withKeyValueSeparator("=").split(mapString.replace("{", "").replace("}", ""));
		return objectMapper.readValue(gson.toJson(mapFromString), Shield.class);
	}
}

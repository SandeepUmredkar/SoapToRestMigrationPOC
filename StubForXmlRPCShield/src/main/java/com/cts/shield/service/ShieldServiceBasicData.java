package com.cts.shield.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.xmlrpc.WebServer;

public class ShieldServiceBasicData {
	
	private static WebServer webServer;
	
	public String getMapForShield(){
		Map<String, Object> shieldMap = new HashMap<String, Object>();
		shieldMap.put("STATUS", 0);
		return shieldMap.toString();
	}
	
	public static void main(String args[]){
		webServer = new WebServer(8081);
		webServer.addHandler("shield", new ShieldServiceBasicData());
		webServer.start();
	}
}

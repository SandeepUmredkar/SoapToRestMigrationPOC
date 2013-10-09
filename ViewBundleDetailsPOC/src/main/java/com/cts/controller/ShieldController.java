package com.cts.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.apache.xmlrpc.XmlRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.model.Shield;
import com.cts.service.ShieldService;

@Controller
public class ShieldController {
	
	private ShieldService shieldService;
	static Logger log = Logger.getLogger(ShieldController.class);

	@Autowired
	public ShieldController(ShieldService shieldService){
		this.shieldService = shieldService;
		
	}
	
	@RequestMapping(value="/getshieldbasicdata/{msisdn}", method=RequestMethod.GET)
	@ResponseBody
	public Shield getShieldBasicData(@PathVariable String msisdn) throws XmlRpcException, IOException, JAXBException {
		log.info("Entering into REST Service to fetch the Shield Basic Data");
		Shield basicData = shieldService.getBasicData(msisdn);
		log.info("Exiting the REST service of Shield Basic Data");
		return basicData;
	}
}

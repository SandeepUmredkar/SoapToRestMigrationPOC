package com.cts.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.xmlrpc.XmlRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.model.Bundle;
import com.cts.model.Shield;
import com.cts.service.BundleDetailsService;

@Controller
public class BundleDetailsController {
	
	private BundleDetailsService bundleDetailsService;

	@Autowired
	public BundleDetailsController(BundleDetailsService bundleDetailsService){
		this.bundleDetailsService = bundleDetailsService;
		
	}
	
	@RequestMapping(value="/getbundle/{msisdn}/{status}/{vagever}/{surname}/{forename}/{title}/{houseNumber}/{houseName}/{streetName}/{postCode}/{cardNumber}/{ageVerMethod}/{ageVerPin}/{parentalControlPin}/{actionedBy}/{channelId}/{actionChannelID}/{paymentType}/{businessUserFlag}/{avAttemptNo}", method=RequestMethod.GET)
	@ResponseBody
	public Bundle getBundle(Shield shield) throws XmlRpcException, IOException, JAXBException {
		return bundleDetailsService.getBundle(shield);
	}
}

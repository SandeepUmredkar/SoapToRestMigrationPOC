package com.cts.controller;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.model.Bundle;
import com.cts.service.BundleDetailsService;

@Controller
public class BundleDetailsController {
	
	private BundleDetailsService bundleDetailsService;

	@Autowired
	public BundleDetailsController(BundleDetailsService bundleDetailsService){
		this.bundleDetailsService = bundleDetailsService;
		
	}
	
	@RequestMapping(value="/getbundle/{msisdn}", method=RequestMethod.GET)
	@ResponseBody
	public Bundle getBundle(@PathVariable String msisdn) throws UnsupportedOperationException, SOAPException, JAXBException {
		return bundleDetailsService.getBundle(msisdn);
	}
}

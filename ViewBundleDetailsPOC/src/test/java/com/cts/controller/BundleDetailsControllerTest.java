package com.cts.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.apache.xmlrpc.XmlRpcException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cts.model.Bundle;
import com.cts.model.Shield;
import com.cts.service.BundleDetailsService;
@RunWith(MockitoJUnitRunner.class)
public class BundleDetailsControllerTest {
	BundleDetailsController bundleDetailsController;
	@Mock
	BundleDetailsService bundleDetailsService;
	@Test
	public void itShouldReturnBundle() throws UnsupportedOperationException, SOAPException, JAXBException, XmlRpcException, IOException{
		//given
		Shield shield = new Shield();
		bundleDetailsController = new BundleDetailsController(bundleDetailsService);
		Bundle bundle = new Bundle();
		bundle.bundleValue = "Bundle";
		
		//when and verify
		when(bundleDetailsService.getBundle(shield)).thenReturn(bundle);
		Assert.assertEquals(bundle.bundleValue, bundleDetailsController.getBundle(shield).bundleValue);
		verify(bundleDetailsService).getBundle(shield);
	}
}

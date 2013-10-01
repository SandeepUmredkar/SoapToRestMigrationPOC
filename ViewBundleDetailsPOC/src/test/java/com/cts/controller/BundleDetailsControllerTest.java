package com.cts.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cts.model.Bundle;
import com.cts.service.BundleDetailsService;
@RunWith(MockitoJUnitRunner.class)
public class BundleDetailsControllerTest {
	BundleDetailsController bundleDetailsController;
	@Mock
	BundleDetailsService bundleDetailsService;
	@Test
	public void itShouldReturnBundle() throws UnsupportedOperationException, SOAPException, JAXBException{
		//given
		String msisdn = "447000000021";
		bundleDetailsController = new BundleDetailsController(bundleDetailsService);
		Bundle bundle = new Bundle();
		bundle.setBundle("Bundle");
		
		//when and verify
		when(bundleDetailsService.getBundle(msisdn)).thenReturn(bundle);
		Assert.assertEquals(bundle.getBundle(), bundleDetailsController.getBundle(msisdn).getBundle());
		verify(bundleDetailsService).getBundle(msisdn);
	}
}

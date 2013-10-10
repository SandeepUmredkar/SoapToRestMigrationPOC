package com.cts.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.apache.xmlrpc.XmlRpcException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cts.model.Shield;
import com.cts.service.ShieldService;
@RunWith(MockitoJUnitRunner.class)
public class ShieldControllerTest {
	ShieldController shieldController;
	@Mock
	ShieldService shieldService;
	@Test
	public void itShouldReturnShield() throws UnsupportedOperationException, SOAPException, JAXBException, XmlRpcException, IOException{
		//given
		Shield shield = new Shield();
		String msisdn = "4470000000000";
		shieldController = new ShieldController(shieldService);
		
		//when and verify
		shieldController.getShieldBasicData(msisdn);
		when(shieldService.getBasicData(msisdn)).thenReturn(shield);
		verify(shieldService).getBasicData(msisdn);
	}
}

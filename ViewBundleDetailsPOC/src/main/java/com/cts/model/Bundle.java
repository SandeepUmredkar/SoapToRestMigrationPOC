package com.cts.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bundle")
public class Bundle {
	@XmlElement(name = "bundlevalue")
	private String bundleValue;
}

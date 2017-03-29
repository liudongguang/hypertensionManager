package com.ldg.api.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties peonyProperties = new Properties();
	private static Properties hospitalInterfaceProperties = new Properties();
	private static String hosptalServer;
	static {
		ClassPathResource hospitalInterface = new ClassPathResource("kangkang.properties");
		try {
			hospitalInterfaceProperties.load(hospitalInterface.getInputStream());
			hosptalServer = hospitalInterfaceProperties.getProperty("hospitalServer");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getPeonyPropertiesVal(String key) {
		return peonyProperties.getProperty(key);
	}

	public static String getHospitalInterfacePropertiesVal(String key) {
		StringBuilder sb = new StringBuilder(hosptalServer);
		return sb.append(hospitalInterfaceProperties.getProperty(key)).toString();
	}

	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getHospitalInterfacePropertiesVal("getOneMonthHisChuYuanPatient"));
	}
}

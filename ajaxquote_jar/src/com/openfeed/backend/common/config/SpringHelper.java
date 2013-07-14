package com.openfeed.backend.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * @author Master
 *
 */
public class SpringHelper {

	/**
	 * Helper instance
	 */
	private static SpringHelper helper = null;

	/**
	 * Spring Application Context
	 */
	private ApplicationContext context = null;

	/**
	 * Private singleton instance
	 */
	private SpringHelper() {
	}

	/**
	 * Singleton Instance
	 * 
	 * @return
	 */
	public static SpringHelper getInstance() {
		if (helper == null) {
			helper = new SpringHelper();
			helper.initContext();
		}
		return helper;
	}

	private void initContext() {
		// get the service from the application context (IE Spring)
		List<String> urlList = new ArrayList<String>();

		urlList
		.add(SpringHelper.class
				.getClass()
				.getResource(
						"/com/openfeed/front/backend/config/bean-config-data-access.xml")
				.toString());

		// dao*/
		urlList
				.add((new SpringHelper().getClass()
						.getResource("/com/openfeed/front/backend/config/bean-configuration-dao.xml"))
						.toString());
		// service
		urlList
				.add((new SpringHelper().getClass()
						.getResource("/com/openfeed/front/backend/config/bean-configuration-service.xml"))
						.toString());

		String[] configUrls = new String[urlList.size()];
		urlList.toArray(configUrls);
		context = new FileSystemXmlApplicationContext(configUrls);
	}

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		context = ctx;
	}

	public ApplicationContext getContext() {
		return context;
	}

}

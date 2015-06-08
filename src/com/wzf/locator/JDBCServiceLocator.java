package com.wzf.locator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import sun.jdbc.odbc.ee.DataSource;

public class JDBCServiceLocator {

	private InitialContext context;

	private Map cache;

	private static JDBCServiceLocator _serLocator;

	static {
		_serLocator = new JDBCServiceLocator();

	}

	private JDBCServiceLocator() {
		cache = Collections.synchronizedMap(new HashMap());
	}

	public DataSource getDataSource(String factoryName) {

		DataSource dataSource = null;

		try {
			if (cache.containsKey(factoryName)) {
				dataSource = (DataSource) cache.get(factoryName);
			} else {
				dataSource = (DataSource) context
						.lookup(factoryName);
				cache.put(factoryName, dataSource);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataSource;
	}
}

package com.wzf.locator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSQueueServiceLocator {

	private InitialContext context;

	private Map cache;

	private static JMSQueueServiceLocator _serLocator;

	static {
		_serLocator = new JMSQueueServiceLocator();

	}

	private JMSQueueServiceLocator() {
		cache = Collections.synchronizedMap(new HashMap());
	}

	public QueueConnectionFactory getQueueConnectionFactory(String factoryName) {

		QueueConnectionFactory queueFactory = null;

		try {
			if (cache.containsKey(factoryName)) {
				queueFactory = (QueueConnectionFactory) cache.get(factoryName);
			} else {
				queueFactory = (QueueConnectionFactory) context
						.lookup(factoryName);
				cache.put(factoryName, queueFactory);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return queueFactory;
	}

	public Queue getQueue(String topicName) {

		Queue queue = null;

		try {
			if (cache.containsKey(topicName)) {
				queue = (Queue) cache.get(topicName);
			} else {
				queue = (Queue) context.lookup(topicName);
				cache.put(topicName, queue);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return queue;

	}
}

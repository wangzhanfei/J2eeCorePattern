package com.wzf.locator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSServiceLocator {

	private InitialContext context;

	private Map cache;

	private static JMSServiceLocator _serLocator;

	static {
		_serLocator = new JMSServiceLocator();

	}

	private JMSServiceLocator() {
		cache = Collections.synchronizedMap(new HashMap());
	}

	public TopicConnectionFactory getTopicConnectionFactory(String factoryName) {

		TopicConnectionFactory topicFactory = null;

		try {
			if (cache.containsKey(factoryName)) {
				topicFactory = (TopicConnectionFactory) cache.get(factoryName);
			} else {
				topicFactory = (TopicConnectionFactory) context
						.lookup(factoryName);
				cache.put(factoryName, topicFactory);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return topicFactory;
	}

	public Topic getTopic(String topicName) {

		Topic topic = null;

		try {
			if (cache.containsKey(topicName)) {
				topic = (Topic) cache.get(topicName);
			} else {
				topic = (Topic) context.lookup(topicName);
				cache.put(topicName, topic);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return topic;

	}

}

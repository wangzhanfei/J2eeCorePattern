package com.wzf.locator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class EJBServiceLocator {

	private InitialContext context;

	private Map cache;

	private static EJBServiceLocator _serLocator;

	static {
		try {
			_serLocator = new EJBServiceLocator();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static EJBServiceLocator getInstance() {

		return _serLocator;
	}

	private EJBServiceLocator() throws NamingException {

		context = new InitialContext();
		cache = Collections.synchronizedMap(new HashMap());
	}

	public EJBLocalHome getLocalHome(String jndiHomeName) {

		EJBLocalHome localHome = null;
		try {
			if (cache.containsKey(jndiHomeName)) {
				localHome = (EJBLocalHome) cache.get(jndiHomeName);
			} else {
				localHome = (EJBLocalHome) context.lookup(jndiHomeName);
				cache.put(jndiHomeName, localHome);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localHome;
	}

	public EJBHome getRemoteHome(String jndiHomeName, Class homeClassName) {

		EJBHome remoteEjbHome = null;

		try {
			if (cache.containsKey(jndiHomeName)) {
				remoteEjbHome = (EJBHome) cache.get(jndiHomeName);
			} else {

				Object object = context.lookup(jndiHomeName);

				Object obj = PortableRemoteObject.narrow(object, homeClassName);
				remoteEjbHome = (EJBHome) obj;
				cache.put(jndiHomeName, remoteEjbHome);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return remoteEjbHome;
	}

	public EJBObject getService(String id) throws Exception {

		if (id == null) {
			throw new Exception("invalid id:cannot create handle");
		}

		try {
			byte[] bs = id.getBytes();
			InputStream is = new ByteArrayInputStream(bs);
			ObjectInputStream ois = new ObjectInputStream(is);
			Handle handle = (Handle) ois.readObject();
			return handle.getEJBObject();
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public String getId(EJBObject session) {

		String id = null;

		try {
			Handle handle = session.getHandle();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			ObjectOutputStream os = new ObjectOutputStream(bos);
			os.writeObject(handle);
			os.flush();
			os.close();
			id = new String(bos.toByteArray());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}

package org.dieschnittstelle.jee.esa.wsv.client;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.entities.crm.Address;
import org.dieschnittstelle.jee.esa.entities.crm.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.wsv.client.service.ITouchpointCRUDWebService;

import org.dieschnittstelle.jee.esa.wsv.interpreter.JAXRSClientInterpreter;
import java.lang.reflect.Proxy;

public class AccessRESTServiceWithInterpreter {

    protected static Logger logger = Logger
            .getLogger(AccessRESTServiceWithInterpreter.class);

    /**
     * @param args
     */
    public static void main(String[] args) {

		/*
		 * TODO: create an instance of the invocation handler passing the service
		 * interface and the base url
		 */
        JAXRSClientInterpreter invocationHandler = null;

		/*
		 * TODO: create a client for the web service using Proxy.newProxyInstance()
		 */
        ITouchpointCRUDWebService serviceClient = null;

        show("serviceClient: " + serviceClient);

        step();

        // 1) read out all touchpoints
        List<StationaryTouchpoint> tps = serviceClient.readAllTouchpoints();
        show("read all: " + tps);


        // TODO: comment-in the call to delete() once this is handled by the invocation handler
//		// 2) delete the touchpoint if there is one
//		if (tps.size() > 0) {
//          step();
//			show("deleted: "
//					+ serviceClient.deleteTouchpoint(tps.get(0).getId()));
//		}
//
//		// 3) create a new touchpoint
        step();

        Address addr = new Address("Luxemburger Strasse", "10", "13353",
                "Berlin");
        StationaryTouchpoint tp = new StationaryTouchpoint(-1,
                "BHT Verkaufsstand", addr);
        tp = (StationaryTouchpoint)serviceClient.createTouchpoint(tp);
        show("created: " + tp);

        // TODO: comment-in the call to read() once this is handled
//		/*
//		 * 4) read out the new touchpoint
//		 */
//		show("read created: " + serviceClient.readTouchpoint(tp.getId()));
//

        // TODO: comment-in the call to update() once this is handled
//		/*
//		 * 5) update the touchpoint
//		 */
//		// change the name
//		step();
//		tp.setName("BHT Mensa");
//
//
//		tp = serviceClient.updateTouchpoint(tp.getId(), tp);
//		show("updated: " + tp);

    }

    public static void show(Object content) {
        System.err.println(content + "\n");
    }

    public static void step() {
        try {
            System.out.println("/>");
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

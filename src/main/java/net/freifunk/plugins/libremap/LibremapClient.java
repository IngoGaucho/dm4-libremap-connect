package net.freifunk.plugins.libremap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import de.deepamehta.core.osgi.PluginActivator;

import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/libremap")
@Consumes("application/json")
@Produces("application/json")
public class LibremapClient extends PluginActivator {
	
	private Logger logger = Logger.getLogger(getClass().getName()); // Logger a.k.a Konsolenausgabe
	
	private static final String GET_ALL_URL = "http://127.0.0.1:5984/openwifimap/_all_docs";
	private static final String GET_NODE_DETAIL = "http://127.0.0.1:5984/openwifimap/"; // detail + uuid
	
    @GET
    @Path("/couchdb/all")
    @Override
	public void getAllNodesFromCouchDB () {
		try {
			logger.info("Hallo aus dem Methodenaufruf getAllNodesFromCoudhDB..");
			// 1) Ziel-URL einrichten
			URL request = new URL(GET_ALL_URL);
			// 2) HTTP Connection öffnen
			HttpURLConnection conn = (HttpURLConnection) request.openConnection();
			conn.setRequestMethod("GET");
			// 3) HTTP Connection lesen
			int status = conn.getResponseCode();
			System.out.println("HTTP Status " + status);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			// 4) String aus Antwort konstruieren
			StringBuffer result = new StringBuffer();
			for (String input; (input = rd.readLine()) != null;) {
				result.append(input);
			}
			// 5) Buffer schließen
			rd.close();
			// JSONArray list = JSONArray.parse(result);
			// for (JSONObject object : list) {
			// 		String freifunkId = object.getString("_id");
			//		getNodeDetailsFromCouchDB(freifunkId)
			// }
			System.out.println("Response \n" + result.toString());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception.. " + e.getCause().getMessage());
		}
	}

	private void getNodeDetailsFromCouchDB(String freifunkId) {
		// do-ocracy
		// new URL(GET_NODE_DETAIL + "/" + freifunkId);
		// see line 41 and following
		// ...
		// ..
		// JSONObject object = JSONObject.parse(result);
		// createNodeTopic(object);	
	}
	
	private void createNodeTopic(JSONObject node) {
		
		// String name = object.getString("name");
		// String firmwareValue = object.getString("firmware");
		// String freifunkId = object.getString("_id");
		// JSONObject node = 

		// store couchdb-freifunk node as deepamehta topic of type "Node"
		// CompositeValueModel nodeModel = new CompositeValueModel();
		// nodeModel.put("net.freifunk.libremap.node_name", name);
		// Topic node = dms.createTopic("net.freifunk.libremap.node");
	}
	
}

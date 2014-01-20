import java.net.URLConnection;
import java.net.URLEncoder;


public class Req {

	/**
	 * @param args
	 */
	
	
	
	
	public static String get(String req){
		
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		
		//Encodage
		String data ="";
		data = URLEncoder.encode("login", "UTF-8")+"="+URLEncoder.encode("Dev001","UTF-8");
		data += "&amp;";
		data+= URLEncoder.encode("Mot de passe	", "UTF-8")+"="+URLEncoder.encode("developer","UTF-8");
		
		//Creation req
		URL url = new URL(req);
		URLConnection connect = url.openConnection();
		connect.setDoOutput(true);
		
		//Envoi req
		writer = new OutputStreamWriter(connect.getOutputStream());
		writer.write(data);
		writer.flush();
		
		String source ="";
		URL oracle = new URL(req);
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(
		new InputStreamReader(
		yc.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
		source +=inputLine;
		in.close();
		return source;		
		// TODO Auto-generated method stub

	}

}

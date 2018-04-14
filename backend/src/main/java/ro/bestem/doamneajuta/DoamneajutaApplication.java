package ro.bestem.doamneajuta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

@SpringBootApplication
public class DoamneajutaApplication {

	public static void main(String[] args) {

		//USE https
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
				(hostname, sslSession) -> true
		);

		TrustManager[] trustAllCerts = new TrustManager[] {
				new X509TrustManager() {
					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						return new X509Certificate[0];
					}
					public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
						// not need to implement
					}
					public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
						// not need to implement
					}
				}
		};

		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		SpringApplication.run(DoamneajutaApplication.class, args);
	}
}

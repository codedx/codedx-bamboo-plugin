package com.codedx.plugins.bamboo.security;

import org.apache.log4j.Logger;
import javax.net.ssl.*;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

public class SSLContextFactory {

	private static final Logger _logger = org.apache.log4j.Logger.getLogger(SSLContextFactory.class);

	public static SSLContext getSSLContext(String fingerprint) throws GeneralSecurityException {

		_logger.info(String.format("getSSLContext(...) called.  fingerprint: %s", fingerprint != null ? fingerprint : ""));

		// Won't work if the fingerprint has the colons, spaces, or other aesthetic separator characters between every two hex characters
		fingerprint = fingerprint.replaceAll("[^A-Fa-f0-9]", "");

		SingleCertManager manager = new SingleCertManager("floopydoop");

		FingerprintStrategy certificateStrategy = new FingerprintStrategy(fingerprint);

		List<X509TrustManager> trustManagersForComposite = new LinkedList<>();
		X509TrustManager systemTrustManager = getDefaultTrustManager();
		ReloadableX509TrustManager customTrustManager = new ReloadableX509TrustManager(manager, certificateStrategy);
		trustManagersForComposite.add(systemTrustManager);
		trustManagersForComposite.add(customTrustManager);
		X509TrustManager trustManager = new CompositeX509TrustManager(trustManagersForComposite);

		SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
		sslContext.init(null, new TrustManager[] { trustManager }, null);

		return sslContext;
	}

	private static X509TrustManager getDefaultTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
		TrustManagerFactory defaultFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		defaultFactory.init((KeyStore) null);

		TrustManager[] managers = defaultFactory.getTrustManagers();
		for (TrustManager mgr : managers) {
			if (mgr instanceof X509TrustManager) {
				return (X509TrustManager) mgr;
			}
		}
		return null;
	}
}

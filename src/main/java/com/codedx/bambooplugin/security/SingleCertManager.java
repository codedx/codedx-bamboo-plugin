package com.codedx.bambooplugin.security;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;

/**
 * ExtraCertManager implementation that only allows a single accepted
 * certificate at once. Any time a certificate is added (be it temporarily or
 * permanently), any previous certificates will be forgotten. At any given time,
 * the {@link #asKeyStore()} method should return a KeyStore with 0 or 1
 * certificates registered.
 */
public class SingleCertManager {

	private Certificate tempCert = null;
	private char[] password;
	private KeyStore keyStore;

	public SingleCertManager(String password) {
		this.password = password.toCharArray();
	}


	public void addTemporaryCert(Certificate cert) {
		tempCert = cert;
	}

	public void addPermanentCert(Certificate cert) throws IOException, GeneralSecurityException {
		tempCert = null;

		// create a keystore and put the cert in it
		keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		keyStore.load(null, password);
		keyStore.setCertificateEntry("default", cert);

	}

	public void purgeTemporaryCerts() {
		tempCert = null;
	}

	public void purgePermanentCerts() {

	}

	public void purgeAllCerts() {
		tempCert = null;
	}

	public KeyStore asKeyStore() throws GeneralSecurityException {
		return keyStore;
	}
}


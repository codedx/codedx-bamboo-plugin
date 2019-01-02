package com.codedx.bambooplugin.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Formatter;
import java.util.logging.Logger;


public class FingerprintStrategy {

	private String fingerprint;
	private final static Logger logger = Logger.getLogger(FingerprintStrategy.class.getName());

	public FingerprintStrategy(String fingerprint) {
		this.fingerprint = fingerprint;
		if (fingerprint == null) {
			this.fingerprint = "";
		}
	}

	public CertificateAcceptance checkAcceptance(Certificate genericCert, CertificateException certError) {
		if (genericCert instanceof X509Certificate) {
			X509Certificate cert = (X509Certificate) genericCert;
			try {
				String certFingerprint = toHexString(getSHA1(cert.getEncoded()));
				logger.info("Certificate fingerprint:  " + certFingerprint.toUpperCase());
				logger.info("User-entered fingerprint: " + fingerprint.toUpperCase());
				if (certFingerprint.toUpperCase().equals(fingerprint.toUpperCase())) {
					return CertificateAcceptance.ACCEPT_PERMANENTLY;
				}
			} catch (CertificateEncodingException exception) {
				logger.warning("Problem reading certificate: " + exception);
				exception.printStackTrace();
			}
		} else {
			logger.warning("Certificate presented was not X509: " + genericCert);
		}
		return CertificateAcceptance.REJECT;
	}

	public static byte[] getSHA1(byte[] input) {

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.reset();
			return md.digest(input);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static String toHexString(byte[] bytes) {
		return toHexString(bytes, "");
	}

	public static String toHexString(byte[] bytes, String sep) {
		Formatter f = new Formatter();
		for (int i = 0; i < bytes.length; i++) {
			f.format("%02x", bytes[i]);
			if (i < bytes.length - 1) {
				f.format(sep);
			}
		}
		String result = f.toString();
		f.close();
		return result;
	}
}

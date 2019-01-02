package com.codedx.bambooplugin.security;

public enum CertificateAcceptance {

	/**
	 * The invalid certificate should be rejected.
	 */
	REJECT,

	/**
	 * The invalid certificate should be accepted on a short-term basis, e.g.
	 * for the duration of the session, or until the current JVM stops.
	 * .
	 */
	ACCEPT_TEMPORARILY,

	/**
	 * The invalid certificate should be accepted on a long-term basis, e.g. by
	 * adding the certificate to a custom KeyStore and persisting it to disk.
	 */
	ACCEPT_PERMANENTLY;

}

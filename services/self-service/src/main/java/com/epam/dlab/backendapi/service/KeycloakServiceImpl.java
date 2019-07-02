package com.epam.dlab.backendapi.service;

import com.epam.dlab.backendapi.SelfServiceApplicationConfiguration;
import com.epam.dlab.exceptions.DlabException;
import com.google.inject.Inject;
import org.keycloak.representations.AccessTokenResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public class KeycloakServiceImpl implements KeycloakService {

	private static final String URI = "http://52.11.45.11:8080/auth/realms/DLAB_bhliva/protocol/openid-connect/token";
	private final Client httpClient;
	private final SelfServiceApplicationConfiguration conf;

	@Inject
	public KeycloakServiceImpl(Client httpClient, SelfServiceApplicationConfiguration conf) {
		this.httpClient = httpClient;
		this.conf = conf;
	}

	@Override
	public AccessTokenResponse getToken(String code) {
		return requestToken(accessTokenRequestForm(code));
	}

	@Override
	public AccessTokenResponse refreshToken(String refreshToken) {
		return requestToken(refreshTokenRequestForm(refreshToken));
	}

	private AccessTokenResponse requestToken(Form requestForm) {
		final Response response = httpClient.target(URI).request()
				.header(HttpHeaders.AUTHORIZATION, "Basic c3NzOjM3MzM4Y2M1LTc3ZjktNDdmOS05ZDk1LTVjYjcxNmI5MTExOA==")
				.post(Entity.form(requestForm));
		if (response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
			throw new DlabException("can not get token");
		}
		return response.readEntity(AccessTokenResponse.class);
	}

	private Form accessTokenRequestForm(String code) {
		return new Form()
				.param("grant_type", "authorization_code")
				.param("code", code);
	}

	private Form refreshTokenRequestForm(String refreshToken) {
		return new Form()
				.param("grant_type", "refresh_token")
				.param("refresh_token", refreshToken);
	}
}

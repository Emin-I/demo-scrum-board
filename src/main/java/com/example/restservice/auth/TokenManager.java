package com.example.restservice.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.restservice.models.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Component
public class TokenManager implements Serializable {

	private static final long serialVersionUID = 238752434L;

	public static final int JWT_TOKEN_VALIDITY = 55 * 60 * 1000;

	@Value("${jwt.secret}")
	private String secretKey;// = //Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public String generateToken(UserModel user) throws Exception {
		Map<String, Object> claims = new HashMap<>();
		try {
			return doGenerateToken(claims, user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private String doGenerateToken(Map<String, Object> claims, String username)
			throws NoSuchAlgorithmException, InvalidKeyException {
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuer("Emin Kara")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY)).signWith(getKey()).compact();
	}

	private SecretKeySpec getKey() throws NoSuchAlgorithmException, InvalidKeyException {
		byte[] hash = secretKey.getBytes(StandardCharsets.UTF_8);
		Mac sha256Hmac = Mac.getInstance("HmacSHA256");
		SecretKeySpec secretKey = new SecretKeySpec(hash, "HmacSHA256");
		sha256Hmac.init(secretKey);
		return secretKey;
	}

	public boolean validateToken(String token, UserModel user) {

		try {
			return user.getUsername().equals(this.getUsernameFromToken(token)) && !this.isTokenExpired(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getUsernameFromToken(String token) throws Exception {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) throws Exception {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) throws Exception {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) throws Exception {
		try {
			return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean isTokenExpired(String token) {
		try {
			return this.getExpirationDateFromToken(token).before(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
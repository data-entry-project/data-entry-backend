package com.example.dataentryproject.base.service;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.dataentryproject.base.dao.UserRepository;
import com.example.dataentryproject.base.dto.UserDetailDto;
import com.example.dataentryproject.base.entity.UserDetail;
import com.example.dataentryproject.base.exception.DataException;
import com.example.dataentryproject.base.util.CacheManager;
import com.example.dataentryproject.base.util.Messages;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Messages messages;
	
	//@Autowired
	//private CacheManager cacheManager;

	@Override
	public UserDetailDto authenticate(UserDetailDto authenticationDetail) {

		UserDetail userDetail = userRepository.findByEmailAndPassword(authenticationDetail.getUserName());

		// if
		// (userDetail.getUserName().equals(authenticationDetail.getUserName())&&userDetail.getPassword().equals(authenticationDetail.getPassword()))
		// {}
		UserDetailDto ud = new UserDetailDto();
		if (userDetail != null && authenticationDetail.getPassword().equals(userDetail.getPassword())) {
			ud.setUserName(userDetail.getUserName());

			final SecureRandom secureRandom = new SecureRandom(); // threadsafe
			final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); // threadsafe

			byte[] randomBytes = new byte[24];
			secureRandom.nextBytes(randomBytes);
		//	base64Encoder.encodeToString(randomBytes);
			ud.setToken(base64Encoder.encodeToString(randomBytes));
			return ud;
		} else {
			// throw new DataException(HttpStatus.BAD_REQUEST,
			// messages.get("Invalid_User"));
			throw new DataException(HttpStatus.BAD_REQUEST, messages.get("Invalid_User"));
		}
	}

	
	
//	private String generateToken(String userName) {
		/*
		 * // LOGGER.info("Entered into generate token"); // String verifier =
		 * userDto.getUserId() + userDto.getUserSalt(); byte[] encryptedAccessToken =
		 * null; try { // LOGGER.debug("Encrypt password"); // encryptedAccessToken =
		 * authenticationUtil.encrypt(userDto.getPassword(), verifier); // String
		 * encryptedAccessTokenBase64Encoded =
		 * Base64.getEncoder().encodeToString(encryptedAccessToken); // int tokenLength
		 * = encryptedAccessTokenBase64Encoded.length(); String tokenToSavedInCache =
		 * encryptedAccessTokenBase64Encoded.substring(0, tokenLength / 2); String
		 * tokenSharedWithClient =
		 * encryptedAccessTokenBase64Encoded.substring(tokenLength / 2, tokenLength); //
		 * LOGGER.debug("Entered entry to cache"); AuthenticationDetail
		 * authenticationDetail = createAuthenticationDetail(userDto,
		 * tokenToSavedInCache, tokenSharedWithClient);
		 * cacheManager.put(AppConstants.AUTHENTICATION_CACHE, tokenSharedWithClient,
		 * authenticationDetail);
		 * 
		 * @SuppressWarnings("unchecked") List<String> tokenList =
		 * cacheManager.get(AppConstants.USER_CACHE, userDto.getUserName(), List.class);
		 * if (tokenList == null || tokenList.isEmpty()) { tokenList = new
		 * ArrayList<String>(); } tokenList.add(tokenSharedWithClient);
		 * cacheManager.put(AppConstants.USER_CACHE, userDto.getUserName(), tokenList);
		 * // LOGGER.info("Exit from generate token"); setView(authenticationDetail,
		 * user);
		 * 
		 * if (user.getPrivatePolicy() == null) {
		 * authenticationDetail.setPolicyContent(PrivatePolicyMapper.toDto(
		 * privatePolicyRepository.findPolicy())); } else {
		 * authenticationDetail.setPolicyAccepted(userDto.isPolicyAccepted()); }
		 * authenticationDetail.setIsPremium(user.getIsPremium()); return
		 * authenticationDetail;
		 * 
		 * } catch (InvalidKeySpecException e) {
		 * LOGGER.error("Failed to issue secure access token " +
		 * e.getLocalizedMessage()); throw new PPSException(HttpStatus.UNAUTHORIZED,
		 * messages.get("INVALID_LOGIN_CREDENTIAL")); }
	//	 */
	//}
	
	
	@Override
	public void logout(String token) {
		// TODO Auto-generated method stub
		
	}
}

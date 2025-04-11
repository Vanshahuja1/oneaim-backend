package com.one.aim.helper;

import java.util.ArrayList;
import java.util.List;

import com.one.aim.constants.ErrorCodes;
import com.one.aim.rq.UserRq;
import com.one.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserHelper {

	public static List<String> validateUser(UserRq rq) {

		if (log.isDebugEnabled()) {
			log.debug("Executing validateUser(UserRq) ->");
		}

		List<String> errors = new ArrayList<>();
		try {
			if (Utils.isEmpty(rq.getUserName())) {
				log.error(ErrorCodes.EC_REQUIRED_USERNAME);
				errors.add(ErrorCodes.EC_REQUIRED_USERNAME);
			}
			String email = Utils.getValidString(rq.getEmail()).toLowerCase();
			if (Utils.isEmpty(rq.getEmail())) {
				log.error(ErrorCodes.EC_REQUIRED_EMAIL);
				errors.add(ErrorCodes.EC_REQUIRED_EMAIL);
			} else if (!Utils.isValidEmail(email)) {
				log.error(ErrorCodes.EC_INVALID_EMAIL);
				errors.add(ErrorCodes.EC_INVALID_EMAIL);
			}
			if (Utils.isEmpty(rq.getService())) {
				log.error(ErrorCodes.EC_REQUIRED_SERVICE);
				errors.add(ErrorCodes.EC_REQUIRED_SERVICE);
			}
			if (Utils.isEmpty(rq.getMessage())) {
				log.error(ErrorCodes.EC_REQUIRED_MESSAGE);
				errors.add(ErrorCodes.EC_REQUIRED_MESSAGE);
			}
			if (Utils.isEmpty(rq.getPhoneNo())) {
				log.error(ErrorCodes.EC_REQUIRED_PHONENO);
				errors.add(ErrorCodes.EC_REQUIRED_PHONENO);
			}
			if (Utils.isEmpty(rq.getDate())) {
				log.error(ErrorCodes.EC_REQUIRED_DATE);
				errors.add(ErrorCodes.EC_REQUIRED_DATE);
			}
			if (Utils.isEmpty(rq.getTimezone())) {
				log.error(ErrorCodes.EC_REQUIRED_TIMEZONE);
				errors.add(ErrorCodes.EC_REQUIRED_TIMEZONE);
			}
		} catch (Exception e) {
			log.error("Exception in validateUser(UserRq) - " + e);
			errors.add(ErrorCodes.EC_INVALID_INPUT);
		}
		return errors;
	}

}

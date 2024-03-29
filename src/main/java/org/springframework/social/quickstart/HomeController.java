/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.quickstart;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Simple little @Controller that invokes Facebook and renders the result.
 * The injected {@link Facebook} reference is configured with the required authorization credentials for the current user behind the scenes.
 * @author Keith Donald
 */
@Controller
public class HomeController {

	private final Facebook facebook;
	
	@Inject
	public HomeController(Facebook facebook) {
		this.facebook = facebook;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		// List<Reference> friends = facebook.friendOperations().getFriends();
		// model.addAttribute("friends", friends);
		
		FacebookProfile userProfile = facebook.userOperations().getUserProfile();
		String email = userProfile.getEmail();
		
		String gender = userProfile.getGender();
		String firstName = userProfile.getFirstName();
		String lastName = userProfile.getLastName();
		String middleName = userProfile.getMiddleName();
		String homeTown = "";
		if(userProfile.getHometown() != null){
			homeTown = userProfile.getHometown().getName();
		}
		String birthDay = userProfile.getBirthday();
		String facebookId = userProfile.getId();
		
		model.addAttribute("email", email);
		model.addAttribute("gender", gender);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("middleName", middleName);
		model.addAttribute("homeTown", homeTown);
		model.addAttribute("birthDay", birthDay);
		model.addAttribute("facebookId", facebookId);
		
		return "home";
	}

}

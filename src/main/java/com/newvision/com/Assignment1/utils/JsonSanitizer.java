package com.newvision.com.Assignment1.utils;

public class JsonSanitizer {

	public static String sanitizeJson(String jsonString) {
		String wellFormedJson = com.google.json.JsonSanitizer.sanitize(jsonString);
		return wellFormedJson;
	}
}


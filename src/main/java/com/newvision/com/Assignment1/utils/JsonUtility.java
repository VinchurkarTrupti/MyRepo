package com.newvision.com.Assignment1.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.owasp.encoder.Encode;
import org.springframework.web.util.HtmlUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtility {
	public static  JsonNode clean(JsonNode node) {
		if(node.isValueNode()) { // Base case - we have a Number, Boolean or String
		if(JsonNodeType.STRING == node.getNodeType()) {
		// Escape all String values
		return JsonNodeFactory.instance.textNode(HtmlUtils.htmlEscape(node.asText()));
		} else {
		return node;
		}
		} else { // Recursive case - iterate over JSON object entries
		ObjectNode clean = JsonNodeFactory.instance.objectNode();
		for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
		Map.Entry<String, JsonNode> entry = it.next();
		// Encode the key right away and encode the value recursively
		clean.set(HtmlUtils.htmlEscape(entry.getKey()), clean(entry.getValue()));
		}
		return clean;
		}
		}
	 public static Whitelist whitelist = Whitelist.basicWithImages();

	    /** Configure the filter parameters and do not format the code */
	    private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);
	    static {
	        // Some styles are implemented using style in rich text editing
	        // For example, the red font style="color:red;"
	        // So you need to add style attributes to all tags
	        whitelist.addAttributes(":all", "style");
	    }

	   
	
	
public static String clean(String content) {
    return Jsoup.clean(content, "", whitelist, outputSettings);
}

public static String escape(String s) {
    StringBuilder builder = new StringBuilder();
    boolean previousWasASpace = false;
    for( char c : s.toCharArray() ) {
        if( c == ' ' ) {
            if( previousWasASpace ) {
                builder.append("&nbsp;");
                previousWasASpace = false;
                continue;
            }
            previousWasASpace = true;
        } else {
            previousWasASpace = false;
        }
        switch(c) {
            case '<': builder.append("&lt;"); break;
            case '>': builder.append("&gt;"); break;
            case '&': builder.append("&amp;"); break;
            case '\n': builder.append("<br>"); break;
            // We need Tab support here, because we print StackTraces as HTML
            case '\t': builder.append("&nbsp; &nbsp; &nbsp;"); break;  
            default:
                if( c < 128 ) {
                    builder.append(c);
                } else {
                    builder.append("&#").append((int)c).append(";");
                }    
        }
    }
    return builder.toString();
}
public static String txtToHtml(String s) {
    StringBuilder builder = new StringBuilder();
    boolean previousWasASpace = false;
    for (char c : s.toCharArray()) {
        if (c == ' ') {
            if (previousWasASpace) {
                builder.append("&nbsp;");
                previousWasASpace = false;
                continue;
            }
            previousWasASpace = true;
        } else {
            previousWasASpace = false;
        }
        switch (c) {
            case '<':
                builder.append("&lt;");
                break;
            case '>':
                builder.append("&gt;");
                break;
            case '&':
                builder.append("&amp;");
                break;
            
            case '\n':
                builder.append("<br>");
                break;
            // We need Tab support here, because we print StackTraces as HTML
            case '\t':
                builder.append("&nbsp; &nbsp; &nbsp;");
                break;
            default:
                builder.append(c);

        }
    }
    String converted = builder.toString();
    String str = "(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:\'\".,<>?«»“”‘’]))";
    Pattern patt = Pattern.compile(str);
    Matcher matcher = patt.matcher(converted);
    converted = matcher.replaceAll("<a href=\"$1\">$1</a>");
    return converted;
}		


}

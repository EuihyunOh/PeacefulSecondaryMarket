package psm.controllers;

import java.util.Map;

public interface PsmController {
	String execute(Map<String, Object> model) throws Exception;
}

package time.no.see.service.resource;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import are.you.ok.model.Menu_S;

public interface Sys_ResourceService {

	List<Menu_S> resourceHasPermission(String permissions) throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException;
	
}

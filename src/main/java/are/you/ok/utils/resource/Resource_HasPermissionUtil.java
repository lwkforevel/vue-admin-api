package are.you.ok.utils.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import are.you.ok.model.ResourceAndPermission;
import are.you.ok.model.resources.ResourceTree;

public class Resource_HasPermissionUtil {
	
	
	public List<ResourceAndPermission> extraPermissions(String permissions) throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException {
		System.out.println(permissions);
		ObjectMapper objectMapper = new ObjectMapper();
		List<ResourceTree> resourceTrees = objectMapper.readValue(permissions, new TypeReference<List<ResourceTree>>() {});
		List<ResourceAndPermission> resourceAndPermissions = resourceTrees.stream().map(
				resource ->{
					List<String> permission = resource.getPermission();
					String name = resource.getName();
					Set<String> combinePermission = combinePermission(permission, name);
					ResourceAndPermission resourceAndPermission = new ResourceAndPermission();
					resourceAndPermission.setId(resource.getId());
					resourceAndPermission.setPermission(combinePermission);
					return resourceAndPermission;
							}
								).collect(Collectors.toList());
		return resourceAndPermissions;
	}
	
	
	
	
	private Set<String> combinePermission(List<String> permissions,String name) {
		Stream<String> stream = permissions.stream();
		Set<String> user_permissions = stream.map(new strFunction(name)).collect(Collectors.toSet());		
		return user_permissions;
	}
	
	
	public void convertJSON() throws JsonProcessingException {
		List<ResourceTree> finalT = new ArrayList<ResourceTree>();
		
		ResourceTree orginationResource = new ResourceTree();
		orginationResource.setId(11);
		orginationResource.setName("organization");
		List<String> orgination_list = new ArrayList<String>();
		orgination_list.add("update");
		orginationResource.setPermission(orgination_list);
		finalT.add(orginationResource);
		
		ResourceTree userResource = new ResourceTree();
		userResource.setId(21);
		userResource.setName("user");
		List<String> user_list = new ArrayList<String>();
		user_list.add("view");
		userResource.setPermission(user_list);
		finalT.add(userResource);
		
		ResourceTree resourceResource = new ResourceTree();
		resourceResource.setId(31);
		resourceResource.setName("resource");
		List<String> resource_list = new ArrayList<String>();
		resource_list.add("update");
		resourceResource.setPermission(resource_list);
		finalT.add(resourceResource);
		
		ResourceTree roleResource = new ResourceTree();
		roleResource.setId(41);
		roleResource.setName("role");
		List<String> role_list = new ArrayList<String>();
		role_list.add("create");
		role_list.add("delete");
		roleResource.setPermission(role_list);
		finalT.add(roleResource);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writeValueAsString(finalT);
		System.out.println(writeValueAsString);
	}
	
}

class strFunction implements Function<String, String>{
	
	private String name;
	
	@Override
	public String apply(String permission) {
		String finalName = name + ":" + permission;
		return finalName;
	}
	public strFunction(String name) {
		super();
		this.name = name;
	}
	
}

package time.no.see.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import are.you.ok.model.resources.ResourceTree;

public class MenuTest {
	
	@Test
	public void perseJSON() throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException {
		String data = "[{\"id\":11,\"name\":\"organization\",\"permission\":[\"update\"]},{\"id\":21,\"name\":\"user\",\"permission\":[\"view\"]},{\"id\":31,\"name\":\"resource\",\"permission\":[\"update\"]},{\"id\":41,\"name\":\"role\",\"permission\":[\"create\",\"delete\"]}]";
		ObjectMapper objectMapper = new ObjectMapper();
		List<ResourceTree> resourceTrees = objectMapper.readValue(data, new TypeReference<List<ResourceTree>>() {});
		for (ResourceTree resourceTree : resourceTrees) {
			/*
			 * 查詢出來滿足條件的菜單數據 //如果全部菜單權限都沒有直接pass
			 */

			List<String> permissions = resourceTree.getPermission();
			List<String> user_permissions = parsePermission(permissions, resourceTree);

			System.out.println(user_permissions);

			// 最终判断

			// 最后保存符合条sts_Resource

			//
			// 調用hasPermission方法
		}

	}
	
	
	
	
	private List<String> parsePermission(List<String> permissions,ResourceTree resourceTree) {
		Stream<String> stream = permissions.stream();
		List<String> user_permissions = stream.map(new strFunction(resourceTree)).collect(Collectors.toList());		
		return user_permissions;
	}
	
	@Test
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
	
	private ResourceTree resourceTree;
	@Override
	public String apply(String t) {
		String name = resourceTree.getName();
		String finalName = name + ":" + t;
		return finalName;
	}
	public strFunction(ResourceTree resourceTree) {
		super();
		this.resourceTree = resourceTree;
	}
	
}

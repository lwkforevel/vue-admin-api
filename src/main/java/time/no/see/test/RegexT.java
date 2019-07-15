package time.no.see.test;

public class RegexT {
	
	public static void main(String[] args) {
		String path = "/api/vue-admin-api/success";
		String regex = "^api";
		String replace = path.replace(regex, "");
		System.out.println(replace);
		
	}
	
	

	
}

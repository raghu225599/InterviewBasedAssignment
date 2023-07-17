package servicelayerfactory;

import servicelayer.IBlogPostService;
import servicelayer.BlogPostServiceImpl;

public class ServiceLayerFactory {
	
	private ServiceLayerFactory() {}
	
	private static IBlogPostService blogPostService=null;
	public static IBlogPostService getBlogPostService() {
		if(blogPostService==null)
			blogPostService=new BlogPostServiceImpl();
		return blogPostService;
	}
}

package servicelayer;

import java.util.ArrayList;

import blogpostdto.BlogPostObj;

public interface IBlogPostService {
	
	public String addBlogPost(BlogPostObj blogPostObj);
	
	public ArrayList<BlogPostObj> searchBlogPost();
}

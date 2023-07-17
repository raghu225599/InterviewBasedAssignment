package databaseaccesslayer;
import java.util.ArrayList;

import blogpostdto.BlogPostObj;
public interface IBlogPostDao {
	//operations to be implemented
	public String addBlogPost(BlogPostObj blogPostObj);
	
	public ArrayList<BlogPostObj> searchBlogPost();
}

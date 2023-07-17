package servicelayer;

import java.util.ArrayList;

import blogpostdto.BlogPostObj;
import databaseaccesslayer.IBlogPostDao;
import databaseaccesslayerfactory.DatabaseAccessLayerFactory;

public class BlogPostServiceImpl implements IBlogPostService {
	
	IBlogPostDao blogPostDao=DatabaseAccessLayerFactory.getBlogPostDao();
	
	@Override
	
	public String addBlogPost(BlogPostObj blogPostObj) {
		return blogPostDao.addBlogPost(blogPostObj);
	}

	@Override
	public ArrayList<BlogPostObj> searchBlogPost() {
		return blogPostDao.searchBlogPost();
	}
}

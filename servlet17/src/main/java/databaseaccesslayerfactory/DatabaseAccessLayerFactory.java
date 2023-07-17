package databaseaccesslayerfactory;
import databaseaccesslayer.IBlogPostDao;
import databaseaccesslayer.BlogPostDaoImpl;
public class DatabaseAccessLayerFactory {
	private DatabaseAccessLayerFactory() {}
	
	private static IBlogPostDao blogPostDao=null;
	public static IBlogPostDao getBlogPostDao() {
		if(blogPostDao==null)
			blogPostDao=new BlogPostDaoImpl();
		return blogPostDao;
	}
}

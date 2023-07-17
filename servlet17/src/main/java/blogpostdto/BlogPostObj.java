package blogpostdto;
import java.io.Serializable;
public class BlogPostObj implements Serializable{
	
	private static final long serialVersionUID=1L;
	private Integer id;
	private String title;
	private String description;
	private String content;
	private String message;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BlogPostObj [title=" + title + ", description=" + description + ", content=" + content + "]";
	}
	
}

package databaseaccesslayer;

import java.sql.Connection;
import jdbconnectivity.CommonJdbc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import blogpostdto.BlogPostObj;

import java.sql.ResultSet;

public class BlogPostDaoImpl implements IBlogPostDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String addBlogPost(BlogPostObj blogPostObj) {

		int rowCount = -1;
		try {
			connection = CommonJdbc.getJdbcConnection();
			System.out.println("connection is: "+connection);
			if (connection != null) {
				String sqlInsertQuery = "INSERT INTO blogpostobj(`title`,`description`,`content`) VALUES(?,?,?)";
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				if (blogPostObj.getTitle() != null) {
					pstmt.setString(1, blogPostObj.getTitle());
				}
				if (blogPostObj.getDescription() != null) {
					pstmt.setString(2, blogPostObj.getDescription());
				}
				if (blogPostObj.getContent() != null) {
					pstmt.setString(3, blogPostObj.getContent());
				}
			}

			if (pstmt != null) {
				rowCount = pstmt.executeUpdate();
				System.out.println("rowCount for add form:" + rowCount);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		try {
			CommonJdbc.closeResources(connection, pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (rowCount == 1)
			return "success";
		else
			return "failure";
	}

	@Override
	public ArrayList<BlogPostObj> searchBlogPost() {
		ArrayList<BlogPostObj> blogPostArrayList = new ArrayList<>();
		BlogPostObj blogPostObj = null;
		try {
			connection = CommonJdbc.getJdbcConnection();

			String sqlSelectQuery = "SELECT title,description,content FROM blogpostobj";

			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {
				while (resultSet.next()) {
					blogPostObj = new BlogPostObj();
					blogPostArrayList.add(blogPostObj);
					blogPostObj.setTitle(resultSet.getString("title"));
					blogPostObj.setDescription(resultSet.getString("description"));
					blogPostObj.setContent(resultSet.getString("content"));
					blogPostObj.setMessage("success");
				}
			}
			CommonJdbc.closeResources(connection, pstmt, null);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blogPostArrayList;
	}

}

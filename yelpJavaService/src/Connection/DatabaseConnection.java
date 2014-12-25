package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DatabaseConnection {
	
	Connection con = null;
	static ResultSet rs;
	java.sql.PreparedStatement stmt = null;
	
	DatabaseConnection(){	
		
		try {	
		  ConnectionPoolManager connectionPoolManager= new ConnectionPoolManager();
		
		  	con = connectionPoolManager.getConnectionFromPool();
		  	//stmt = con.createStatement();		
				/*Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yelp","vinay","admin");
				stmt = con.createStatement();*/
				if(!con.isClosed())
					System.out.println("Successfully Connected!!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

	//Sign up insert all user's details
		public boolean insertSignUpDetails(String fname, String lname, String email, String pswd)  throws SQLException{
			boolean validateinsertion = false;
			int rows;
		
				String query = "Insert into user_details values(?, ?, ?, ?)";
				stmt = con.prepareStatement(query);
				stmt.setString(1, fname);
				stmt.setString(2, lname);
				stmt.setString(3, email);
				stmt.setString(4, pswd);
				rows=stmt.executeUpdate();
				if(rows > 0){
					validateinsertion=true;
				}
		
			return validateinsertion;
		}
		
		
		//validate user while signing in..
		public boolean validatesignIn(String email,String pswd) throws SQLException{

			// To fetch user details
			String getUser = "select * from user_details where email=? and pswd=?";
			stmt = con.prepareStatement(getUser);
			stmt.setString(1, email);
			stmt.setString(2, pswd);
			boolean valid=false;
			ResultSet rs= stmt.executeQuery();
			if(rs.next()){
				valid=true;
			}

			return valid;
		}
		
		//get distinct catgories list..
		public  String[] getDistinctCategories() throws SQLException{
			ArrayList<String> categories= new ArrayList<String>();
			String getCat = "select distinct(category) from yelp.cat_name_list";
			stmt = con.prepareStatement(getCat);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				categories.add(rs.getString(1));
			}
				
			String[] categoriesArray= categories.toArray(new String[categories.size()]);
			/*String[] categoriesArray= new String[categories.size()];
			int i=0;
			for (Iterator iterator = categories.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				categoriesArray[i]=string;
				i++;
			}*/
				return categoriesArray;
		}
		
		//check category exists or not
			public  boolean isCategoryExists(String category,String name) throws SQLException{
				
				String getCat = "select * from yelp.cat_name_list where category=? and name=?";
				stmt = con.prepareStatement(getCat);
				stmt.setString(1, category);
				stmt.setString(2, name);
				boolean categoryExists=false;
				ResultSet rs= stmt.executeQuery();
				if(rs.next()){
					categoryExists=true;
				}

				return categoryExists;
			}
			
		// insert last login time..
		public boolean insertLastLoginTime(String email, String dateTime) throws SQLException{
			String insertTime="insert into yelp.time_stamp values(?,?)";
			stmt = con.prepareStatement(insertTime);
			stmt.setString(1, email);
			stmt.setString(2, dateTime);
			int rows= stmt.executeUpdate();
			if(rows>0){
				return true;
			}
			else{
				return false;
			}
		}
		
		
		// update last login time..
		public boolean updateLastLoginTime(String email, String dateTime) throws SQLException{
			String updateTime= "update  yelp.time_stamp set login_time = ? where email =?";
			stmt = con.prepareStatement(updateTime);
			stmt.setString(1, dateTime);
			stmt.setString(2, email);
			int rows= stmt.executeUpdate();
			if(rows>0){
				return true;
			}
			else{
				return false;
			}
		}
		
		//get last login time of the user..
		public  String  getLastLoginTime(String email)throws SQLException{
			String lastLoginTime=null;
			String getTime = "select * from yelp.time_stamp where email=?";
			stmt = con.prepareStatement(getTime);
			stmt.setString(1, email);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				lastLoginTime=rs.getString("login_time");
			}
				
				return lastLoginTime;
		}
		
		//set last login time of the user..
		public  boolean  setLastLoginTime(String email, String time)throws SQLException{
			String lastLoginTime=time;
			boolean validateInsertion=false;
			String insertTime="insert into yelp.time_stamp values(?,?)";
			stmt = con.prepareStatement(insertTime);
			stmt.setString(1, email);
			stmt.setString(2, lastLoginTime);
			int rows= stmt.executeUpdate();
			if(rows>0){
				validateInsertion=true;
			}
				
				return validateInsertion;
		}
		

		
		// get all reviews corresponding to selected category name..
		public Review[] getAllReviews(String name) throws SQLException{
			ArrayList<Review> reviews = new ArrayList<Review>();
			String fetchreviews="select * from yelp.user_name_rating_review where name=?";
			stmt = con.prepareStatement(fetchreviews);
			stmt.setString(1, name);
			ResultSet rs= stmt.executeQuery();
			

			while(rs.next()){
				
				Review review = new Review();
				review.name=rs.getString("name");
				review.rating=rs.getString("Rating");
				review.review=rs.getString("Review");
				review.fname=rs.getString("fname");
				review.lname=rs.getString("lname");
				review.description=rs.getString("description");
				reviews.add(review);

			}
			System.out.println("In your method");
			
			Review[] reviewsArray= reviews.toArray(new Review[reviews.size()]);
			/*Review[] reviewsArray= new Review[reviews.size()];
			int i=0;
				for (Iterator iterator = reviews.iterator(); iterator.hasNext();) {
					Review review = (Review) iterator.next();
					reviewsArray[i]=review;
					System.out.println(review.rating);
					System.out.println(review.description);
					i++;
				}*/
				return reviewsArray;
			
		}
		
		// get all reviews corresponding to selected user's fname and lname..
		public Review[] getUserReviews(String fname, String lname) throws SQLException{
			List<Review> reviews = new ArrayList<Review>();
			String fetchreviews="select * from yelp.user_name_rating_review where fname=? and lname=?";
			stmt = con.prepareStatement(fetchreviews);
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				
				Review review = new Review();
				review.name=rs.getString("name");
				review.rating=rs.getString("Rating");
				review.review=rs.getString("Review");
				review.fname=rs.getString("fname");
				review.lname=rs.getString("lname");
				review.description=rs.getString("description");
				reviews.add(review);
			}
			
			Review[] reviewsArray= reviews.toArray(new Review[reviews.size()]);
		/*	Review[] reviewsArray= new Review[reviews.size()];
			int i=0;
			for (Iterator iterator = reviews.iterator(); iterator.hasNext();) {
				Review review = (Review) iterator.next();
				reviewsArray[i]=review;
				i++;
			}*/
			
				return reviewsArray;
			
		}
		
		// delete selected review..
		public boolean deleteReview(String fname, String lname, String name) throws SQLException{
			String deletereview="delete from yelp.user_name_rating_review where name=? and fname=? and lname=?";
			stmt = con.prepareStatement(deletereview);
			stmt.setString(1, name);
			stmt.setString(2, fname);
			stmt.setString(3, lname);
			int rows= stmt.executeUpdate();
			if(rows>0){
				return true;
			}
			else{
				return false;
			}
		}
		
		
		// insert category name in parent table cat_name_list..
		public boolean insertCategoryName(String category, String name) throws SQLException{
			String submitQuery1= "insert into yelp.cat_name_list values(?,?)";
			stmt = con.prepareStatement(submitQuery1);
			stmt.setString(1, category);
			stmt.setString(2, name);
			int rows= stmt.executeUpdate();
			if(rows>0){
				return true;
			}
			else{
				return false;
			}
		}
		
		// insert review in child table user_name_rating_review..
		public boolean insertReview(String name, String rating, String review, String fname, String lname, String description) throws SQLException{
			String submitQuery2= "insert into yelp.user_name_rating_review values(?,?,?,?,?,?)";
			stmt = con.prepareStatement(submitQuery2);
			stmt.setString(1, name);
			stmt.setString(2, rating);
			stmt.setString(3, review);
			stmt.setString(4, fname);
			stmt.setString(5, lname);
			stmt.setString(6, description);
			int rows= stmt.executeUpdate();
			if(rows>0){
				return true;
			}
			else{
				return false;
			}
		}
		
		
		// update selected review..
		public boolean updateReview(String description, String rating, String review, String fname, String lname, String name) throws SQLException{
			String update="update yelp.user_name_rating_review set description=?, Rating=?, Review=? where fname=? and lname=? and name=?";
			stmt = con.prepareStatement(update);
			stmt.setString(1, description);
			stmt.setString(2, rating);
			stmt.setString(3, review);
			stmt.setString(4, fname);
			stmt.setString(5, lname);
			stmt.setString(6, name);
			int rows= stmt.executeUpdate();
			if(rows > 0){
				return true;
			}
			else{
				return false;
			}
		}
		
		//get user details
		public UserDetails getUserDetails(String email, String pswd) throws SQLException{
			UserDetails userDetails = new UserDetails();
			String getUser = "select * from user_details where email=? and pswd=?";
			stmt = con.prepareStatement(getUser);
			stmt.setString(1, email);
			stmt.setString(2, pswd);
			ResultSet rs= stmt.executeQuery();
			
			if(rs.next()){
				
				userDetails.fname=rs.getString("fname");
				userDetails.lname=rs.getString("lname");
				userDetails.email=rs.getString("email");
				userDetails.pswd=rs.getString("pswd");
			}
				return userDetails;
		}
		
		//get Category names
		public  Category[] getCatNames(String category) throws SQLException{
			ArrayList<Category> categoryNames= new ArrayList<Category>();
			String getCatNames = "select * from yelp.cat_name_list where category=?";
			stmt = con.prepareStatement(getCatNames);
			stmt.setString(1, category);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				Category categoryObj =new Category();
				categoryObj.category=rs.getString(1);
				categoryObj.name=rs.getString(2);
				categoryNames.add(categoryObj);
			}
				
			Category[] categoryNamesArray= categoryNames.toArray(new Category[categoryNames.size()]);
			/*Category[] categoryNamesArray= new Category[categoryNames.size()];
			int i=0;
			for (Iterator iterator = categoryNames.iterator(); iterator.hasNext();) {
				Category cat = (Category) iterator.next();
				categoryNamesArray[i]=cat;
				i++;
			}*/
				return categoryNamesArray;
		}
		

	}

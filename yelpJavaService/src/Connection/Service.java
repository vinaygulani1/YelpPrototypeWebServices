package Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

@WebService
public class Service {	
	DatabaseConnection db=new DatabaseConnection();
	
	public boolean signUp(String fname, String lname, String email, String pswd) throws SQLException
	{
		/**This space is left for validation and manipulation of 
		input values entered by the user as a part of the server side validation*/
		return  db.insertSignUpDetails(fname,lname,email, pswd);
		//this value is returned to the calling servlet
	}	
	
	public boolean signIn(String email, String pswd) throws SQLException{
		return db.validatesignIn(email, pswd);
	}
	
		//get distinct catgotries list..
		public  String[] getDistinctCategories() throws SQLException{
				return db.getDistinctCategories();
		}
		
		// insert last login time..
		public boolean insertLastLoginTime(String email, String dateTime) throws SQLException{
			return db.insertLastLoginTime(email, dateTime);
		}
		
		
		// update last login time..
		public boolean updateLastLoginTime(String email, String dateTime) throws SQLException{
			return db.updateLastLoginTime(email, dateTime);
		}
		
		//get last login time of the user..
		public  String  getLastLoginTime(String email)throws SQLException{
			return db.getLastLoginTime(email);
		}
		
		// get all reviews corresponding to selected category name..
		public Review[] getAllReviews(String name) throws SQLException{
				return db.getAllReviews(name);
			
		}
		
		// get all reviews corresponding to selected user's fname and lname..
		public Review[] getUserReviews(String fname, String lname) throws SQLException{
			return db.getUserReviews(fname, lname);
			
		}
		
		// delete selected review..
		public boolean deleteReview(String fname, String lname, String name) throws SQLException{
			return db.deleteReview(fname, lname, name);
		}
		
		
		// insert category name in parent table cat_name_list..
		public boolean insertCategoryName(String category, String name) throws SQLException{
			return db.insertCategoryName(category, name);
		}
		
		// insert review in child table user_name_rating_review..
		public boolean insertReview(String name, String rating, String review, String fname, String lname, String description) throws SQLException{
			return db.insertReview(name, rating, review, fname, lname, description);
		}
		
		
		// update selected review..
		public boolean updateReview(String description, String rating, String review, String fname, String lname, String name) throws SQLException{
			return db.updateReview(description, rating, review, fname, lname, name);
		}
	
		//get user details
		public UserDetails getUserDetails(String email, String pswd) throws SQLException{
				return db.getUserDetails(email, pswd);
		}
		

		//get Category names
		public  Category[] getCatNames(String category) throws SQLException{
				return db.getCatNames(category);
		}
		
		//set last login time of the user..
		public  boolean  setLastLoginTime(String email, String time)throws SQLException{
				return db.setLastLoginTime(email, time);
		}
		
		//check category exists or not
		public  boolean isCategoryExists(String category,String name) throws SQLException{
			return db.isCategoryExists(category, name);
		}
	
}

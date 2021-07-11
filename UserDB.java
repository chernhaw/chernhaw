package ch.data;

import java.sql.*;
/*
 * 
 *    Column   |            Type             | Collation | Nullable | Default 
------------+-----------------------------+-----------+----------+---------
 userid     | integer                     |           | not null | 
 email      | character varying(50)       |           |          | 
 firstname  | character varying(50)       |           |          | 
 lastname   | character varying(50)       |           |          | 
 grant_date | timestamp without time zone |           |          | 
Indexes:
    "user_pkey" PRIMARY KEY, btree (userid)
insert into public.user values (4, 'chernhaw@mail.com', 'Tong','Chern', '2021-05-02')                                                                        ;          


 * 
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class UserDB {
	
	
	

	public static int insert (String email, String firstName, String lastName)  {
		
		
		String dbURL = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "postgres";
		
		//get a connection
		System.out.println(" preparing to populate user.user with "
				+ "\n email:"+email+
				"\n firstname:" +firstName+
				"\n lastname:" +lastName);
		
		PreparedStatement ps = null;
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbURL,username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int min = 1;
		int max = 10000;
		
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	      System.out.println("Random value "+random_int);
	      
	      LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "Singapore" ) );
	      
	      System.out.print(todayLocalDate);
	      
	      java.sql.Date sqlDate = java.sql.Date.valueOf( todayLocalDate.toString() );
	     
	      
//	      insert into public.user values (4, 'chernhaw@mail.com', 'Tong','Chern', '2021-05-02')  
	      //(random_int+",'chernhaw21@mail.com','Chern', 'Haw', "+sqlDate);
		String query = "INSERT INTO public.user values (?,?,?,?,?)";
			try {
				ps = connection.prepareStatement(query);
				ps.setInt(1,  random_int);
				ps.setString(2,  email);
				ps.setString(3,  firstName);
				ps.setString(4,  lastName);
				ps.setDate(5, sqlDate);
				
				
				return ps.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println(e);
				return 0;
			} finally {
				try {
					ps.close();
					connection.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}		
			
	}
	
	public static int updatebyEmail(User user) {
		String dbURL = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "postgres";
		
		//get a connection
		
		PreparedStatement ps = null;
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbURL,username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = "update public.user set "
						+"firstname = ?, "
						+"lastname = ? "
						+"where email = ?";
		
		try {
			ps = connection.prepareStatement(query);
		
			ps.setString(1,  user.getFirstname());
			ps.setString(2,  user.getLastname());
			ps.setString(3,  user.getEmail());
			System.out.println(user.getEmail());
			System.out.println(user.getLastname());
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
			return 1;
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				System.out.println(e);
				return 1;
			}
			
		}
		
			
	}
	
	public static User getUserByEmail(String email) {
		String dbURL ="jdbc:postgresql://localhost:5432/mydb";
		String username ="postgres";
		String password ="postgres";
		ResultSet rs = null;
		
		PreparedStatement ps = null;
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = "select * from public.user where email= ?";
		
		try {
			ps=connection.prepareStatement(query);
			ps.setString(1,  email);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				
				User user = new User();;
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setLastname(rs.getString("lastname"));
				user.setFirstname(rs.getString("firstname"));
				user.setGrant_date(rs.getDate("grant_date"));
				return user;
				
			}
		} catch (SQLException e1) {
			e1.getStackTrace();
			
		}
		return null;
	}
	
	public static User getUserById(int id) {
		String dbURL = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "postgres";
		ResultSet rs = null;
		
		//get a connection
		
		PreparedStatement ps = null;
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbURL,username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = "select * from public.user  "
						+ "  where userid = ?";
		
		try {
			ps = connection.prepareStatement(query);
		
			ps.setInt(1,  id);
			rs=ps.executeQuery();
			
			
			
//			userid     | integer                     |           | not null | 
//			 email      | character varying(50)       |           |          | 
//			 firstname  | character varying(50)       |           |          | 
//			 lastname   | character varying(50)       |           |          | 
//			 grant_date | timestamp without time zone |
			if(rs.next()) {
				User user = new User();;
				user.setUserid(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setLastname(rs.getString("lastname"));
				user.setFirstname(rs.getString("firstname"));
				user.setGrant_date(rs.getDate("grant_date"));
				return user;
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		}
		return null;
		
			
	}
	
	public static int updatebyId(User user, int id) {
		String dbURL = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "postgres";
		
		//get a connection
		
		PreparedStatement ps = null;
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbURL,username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = "update public.user set "
						+"firstname = ?, "
						+"lastname = ?, "
						+"email = ? "
						+"where userid=?";
		
		try {
			ps = connection.prepareStatement(query);
		
			ps.setString(1,  user.getFirstname());
			ps.setString(2,  user.getLastname());
			ps.setString(3,  user.getEmail());
			ps.setInt(4,  user.getUserid());
			System.out.println(user.getEmail());
			System.out.println(user.getLastname());
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
			return 1;
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				System.out.println(e);
				return 1;
			}
			
		}
		
			
	}
}

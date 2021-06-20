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

	public static int insert (User User)  {
		
		
		
		
		//get a connection
		String dbURL = "jdbc:postgresql://localhost:5432/mydb";
		String username = "postgres";
		String password = "postgres";
		
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
		int max = 100;
		
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
				ps.setString(2,  User.getEmail());
				ps.setString(3,  User.getFirstname());
				ps.setString(4,  User.getLastname());
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
}

package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
/**19. Create a Java program that uses Hibernate to insert data into a MySQL database
table. The program should use Hibernate to map the table to a Java object and then
insert the data into the table. After inserting the data, the program should retrieve it
from the database and display it on the console.
*/
public class SaveGetApp {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			if(session!=null)
				transaction = session.beginTransaction();
			if(transaction!=null) {
				Student student=new Student();
				student.setSid(18);
				student.setSname("kohli");
				student.setSaddress("RCB");
				flag=true;
				session.save(student);
			}
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object saved to database");
			}else {
				transaction.rollback();
				System.out.println("Object not saved to database");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}

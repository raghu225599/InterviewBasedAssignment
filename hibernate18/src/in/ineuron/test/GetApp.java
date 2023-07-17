package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
/**18. Create a Java program that uses Hibernate to connect to a MySQL database and
retrieve data from a table. The program should use Hibernate to map the table to a
Java object and then display the data on the console.
*/
public class GetApp {
	public static void main(String[] args) {
		Session session=null;
		int id=18;
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				Student student=session.get(Student.class,id);
				if(student!=null)
				System.out.println(student);
				else
				System.out.println("RECORD NOT FOUND FOR GIVEN ID:: "+id);
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}

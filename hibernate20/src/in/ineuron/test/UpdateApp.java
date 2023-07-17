package in.ineuron.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;
/**20. The program should use Hibernate to map the table to a Java object and then update
the data in the table. After updating the data, the program should retrieve it from the
database and display it on the console.
*/
public class UpdateApp {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Scanner scanner=new Scanner(System.in);
		Integer sid=null;
		Student student=null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			System.out.print("enter sid to search if record exists for updation or not");
			sid=scanner.nextInt();
			student=session.get(Student.class,sid);
			System.out.println(student);
			if(session!=null)
				transaction = session.beginTransaction();
			if(transaction!=null && student!=null) {
				student.setSid(sid);
				System.out.print("enter sname to update");
				student.setSname(scanner.next());
				System.out.print("enter saddress to update");
				student.setSaddress(scanner.next());
				System.out.print("enter sage to update");
				student.setSage(scanner.nextInt());
				flag=true;
				session.update(student);
			}
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object saved to database");
				if(session!=null) {
					student=session.get(Student.class,sid);
					if(student!=null)
					System.out.println(student);
					else
					System.out.println("RECORD NOT FOUND FOR GIVEN ID:: "+sid);
				}
			}else {
				transaction.rollback();
				System.out.println("Object not saved to database");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			scanner.close();
		}
	}
}

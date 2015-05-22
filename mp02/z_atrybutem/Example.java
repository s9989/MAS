package z_atrybutem;

import java.util.Date;

public class Example {
	
	 public static void main(String[] args) {
		 
		 User user1 = new User("Jan", "Kowalski");
		 User user2 = new User("Anna", "Nowakowska");
		 Stage stage1 = new Stage(1, "Wizualizacja projektu");
		 Stage stage2 = new Stage(2, "Opracowanie projektu");
		 
		 Task task1 = new Task(user1, stage1, 
				 new Date((new Date()).getTime()-(1000*60*60*24)), 
				 new Date((new Date()).getTime()+(1000*60*60*24))
		 );
		 
		 Task task2 = new Task(user2, stage2, 
				 new Date((new Date()).getTime()-(1000*60*60*24)), 
				 new Date((new Date()).getTime()-(1000))
		 ); 
		 
		 System.out.println(task1 + " - " + ( task1.isComplete() ? "wykonane" : "niewykonane"));
		 System.out.println(task2 + " - " + ( task2.isComplete() ? "wykonane" : "niewykonane"));
		 
		 
	 }
	
}

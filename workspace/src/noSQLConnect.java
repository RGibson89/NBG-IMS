import redis.clients.jedis.Jedis;

public class noSQLConnect {

	public static void main(String[] args) {
	//connects to the redis server at the given ip address
	Jedis jedis = new Jedis("192.168.1.133", 6379);
	
	System.out.println("Connection to server sucessfully");
    //check whether server is running or not
    System.out.println("Server is running: "+jedis.ping());
    
System.out.println("				   		    _._                             ");                     
System.out.println("					   _.-``__ ''-._                   ");                          
System.out.println("				  _.-``    `.  `_.  ''-._           ");
System.out.println("			  .-`` .-```.  ```/    _.,_ ''-._         ");                          
System.out.println("			 (    '      ,       .-`  | `,    )     ");
System.out.println("			 |`-._`-...-` __...-.``-._|'` _.-'|     ");
System.out.println("			 |    `-._   `._    /     _.-'    |     ");
System.out.println("			  `-._    `-._  `-./  _.-'    _.-'                    ");               
System.out.println("			 |`-._`-._    `-.__.-'    _.-'_.-'|                ");                  
System.out.println("			 |    `-._`-._        _.-'_.-'    |             ");      
System.out.println("			  `-._    `-._`-.__.-'_.-'    _.-'           ");                        
System.out.println("			 |`-._`-._    `-.__.-'    _.-'_.-'|       ");                           
System.out.println("			 |    `-._`-._        _.-'_.-'    |    ");                              
System.out.println("			  `-._    `-._`-.__.-'_.-'    _.-'  ");                                 
System.out.println("				  `-._    `-.__.-'    _.-'   ");                                    
System.out.println("					  `-._        _.-'    ");                                       
System.out.println("						  `-.__.-'     ");
    
String value = jedis.get("foo");
    
    
    
    
    
    
    
    
    
//
//    		+ " ________________"
//    		+ "|	 OH			|"
//    		+ "|	O	O		|"
//    		+ "|   O	 O		|"
//    		+ "|  O		  O     |"
//    		+ "| O		   O    |"
//    		+ "|W___________O___|"
    		
    		
	}   
}
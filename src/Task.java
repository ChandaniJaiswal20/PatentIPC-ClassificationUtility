import java.net.URL;



public class Task implements Runnable{
	
	IpcVersions ipc	=	null;
	
	String name=null;
	
	URL individualURL	=	null; 
	
	Task(IpcVersions ipc,String name,URL individualURL){
	
		this.ipc	=	ipc;
		this.name	=	name;	
		this.individualURL	=	individualURL;
	}
	
	
	
	public String getName(){
		
		
		return name;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		System.out.println("Doing task::"+getName());
		System.out.println("task individualURL::"+individualURL);
		ipc.parseSymbolDescription(individualURL);
		
	}
	
	
	
	
	
	

}

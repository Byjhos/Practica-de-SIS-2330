import java.io.*;
import java.util.*;

class Alumno
{
	public int ci;
	public String nombre;
	private File arch;
	public Alumno()
		{
			arch=new File("F:\\lista.txt");
		}

	public void mostrar()
	{   
			try
    	{
    		int i=1;
    		Scanner in=new Scanner (arch);
    		while(in.hasNextLine())
    		{
    			ci=in.nextInt();
    	 		nombre=in.nextLine();
    			System.out.println(i+" "+ci+" "+nombre);
    			i++;
    		}
    		in.close();
    	   System.out.println("El Nª total de alumnos es = a " +contar());	
   		}   
    	catch (Exception ex)
    	{
    		System.out.println("Error");
    	}
    	
	}

    public String BuscarPorCi(int pci)
    {
    	try 
    	{
    		Scanner in=new Scanner(arch);
    		String res="";
    		while(in.hasNextLine())
    		{
    			ci=in.nextInt();
    			nombre=in.nextLine();
    			if(ci==pci)
    			{
    				res=nombre;
    				break;
    			}
    		}
    		in.close();
    		return res;
    	}
    	catch (Exception ex)
    	{
    		System.out.println("Error");
    		return "";
    	}	   		
    } 
	private int contar()
	{
		try
		{
			int c=0;
			Scanner in=new Scanner (arch);
    		while(in.hasNextLine())
    		{
    			in.nextLine();
    			c++;
    		}
    		in.close();
    		return c;
		}
		catch (Exception ex)
    	{
    		System.out.println("Error");
    		return -1; 
    	}
	}
	public void Buscar(String par)
	{
		try
		{
			Scanner in=new Scanner (arch);
    		while(in.hasNextLine())
    		{
    			ci=in.nextInt();
    			nombre=in.nextLine();
    			if(nombre.toUpperCase().contains(par.toUpperCase()))
    			{
    				System.out.println(ci+" "+nombre);
    				
    			}
    		}
		}
		catch (Exception ex)
    	{
    		System.out.println("Error");
    		 
    	}
	}
public void Bpromedio()
  {
  		try
    	{
    		int i=1;
    		Calificacion sup=new Calificacion();
    		Scanner in=new Scanner (arch);
      	
      		while(in.hasNextLine())
    		{    	 		
			    ci=in.nextInt();
			    nombre=in.nextLine();
    	 	 	Double promedio =sup.PromedioCa(ci);  	 		
      	 	    
      	 	  
      	 	    System.out.println(i+" "+nombre+" "+promedio);
     			
     		    
     			 if(promedio>65)
     			 {     			 	 
     			 			 	System.out.println("el mejor es ");
     			 			 	 System.out.println(nombre+" "+promedio);
     			 }
     			 
     			i++;
    		}
    		
       		in.close();
       		
       	}   
    	catch (Exception ex)
    	{
    		System.out.println("Error");
    	}
  } 
};
class Calificacion 
{
  public String obs;
  public String materia;
  public double nota;
  public int ci;
  
  		private File arch;
	
		public Calificacion()
		{
			arch=new File("F:\\calificaciones.txt");
			
		}	
  public void listar()
  {
  		try
    	{
    		int i=1;
    		Scanner in=new Scanner (arch);
    		while(in.hasNextLine())
    		{
    			
    	 		materia=in.next();
    	 		nota=in.nextDouble();
    	 		ci=in.nextInt();
    			System.out.println(i+" "+materia+" "+nota+" "+ci+" ");
    			i++;
    		}
    		in.close();
   		}   
    	catch (Exception ex)
    	{
    		System.out.println("Error");
    	}
  }
 public double PromedioCa(int pop)
    {
    	try 
    	{        
    		Scanner in=new Scanner(arch);
    		double promedios;
    		double p=0;  		
    		while(in.hasNextLine())
    		{
    			materia=in.next();
       			nota=in.nextDouble();
    			ci=in.nextInt();
                        
    			if(ci==pop)
    			{
    				p=nota+p;    				
    			}	
       		}
       		promedios=p/5;
			in.close();
			return promedios;
    	}
    	   		
    	catch (Exception ex)
    	{
    		System.out.println("Error");
    		return 0;
    	}	
    		
    }
   
  public void PlanillaCalifiaciones()
  {
  		try
    	{
    		int i=1;
    		Alumno choji=new Alumno();
    		Scanner in=new Scanner (arch);
    		int conta=0,contr=0;
    		while(in.hasNextLine())
    		{
     	 		materia=in.next();
    	 		nota=in.nextDouble();
    	 		ci=in.nextInt();
    	 		
    	 		String nombre =choji.BuscarPorCi(ci);  	 		
    	 		if (nota>=51)
    	 		{
    	 		 
    	 		 obs="Aprovado";
    	 		  conta++;	
    	 		}		
    	 		else 
    	 		{
    	 			obs="Reprovado";
    	 			contr++;
    	 		}
     	 	 System.out.println(i+" "+nombre+" "+materia+" "+nota+" "+ci+" "+obs);
     		
     			i++;
    		}
    		System.out.println("los alumnos que aprobados fueron " + conta);
    		System.out.println("los alumnos que reprovado fueron" + contr);
    		in.close();
   		}   
    	catch (Exception ex)
    	{
    		System.out.println("Error");
    	}
  }
   
};
public class archivo 
{   
    public static void main(String[] args)
    {
    	Alumno jota=new Alumno();
    	String bus;
    	System.out.print("Buscar nombre:");
    	Scanner in=new Scanner (System.in);
    	bus=in.nextLine();
    	if(bus.trim().equals(""))
    		jota.mostrar();
    	else
    		jota.Buscar(bus);          
        Calificacion jao = new Calificacion();
	    jao.listar();
	    jao.PlanillaCalifiaciones();
	    Alumno prom = new Alumno();
	    prom.Bpromedio();
	}		
}
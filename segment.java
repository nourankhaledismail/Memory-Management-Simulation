/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

/**
 *
 * @author hadeer
 */
public class Segment extends Object {
    
   public String  name;
   public int startingadd;
   public int size; 
   public String processname;
   public boolean type ; //false=Hole
  
           
   public Segment()
   {} 
     
   public Segment(String name , int startingadd , int size , boolean type,String processname )
   {
       this.name = name; 
       this.size=size;
       this.startingadd=startingadd; 
       this.processname = processname ;
       this.type=true;
       
   }
  
  public Segment (String name,int startingadd , int size )
  {
        this.size=size;
        this.name= name ;
       this.startingadd=startingadd; 
  }

   
    
}

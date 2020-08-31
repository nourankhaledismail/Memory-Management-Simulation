/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import javax.swing.*;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author hadeer
 */
public class Algorithm extends Segment {
    ArrayList<Segment> Segment=new ArrayList<Segment>();
    ArrayList<Segment> Segment1=new ArrayList<Segment>();
   // ArrayList<Segment> m=new ArrayList<Segment>(); 
   
       
    int textarealines;
    int noofs;

    public Segment[] arrs1= new Segment[Segment.size()];
    Segment[][]p=new Segment[textarealines][arrs1.length];
    public Segment[][] allocation (int textarealines){
        Segment[][]p=new Segment[textarealines][arrs1.length];
        for (int i=0;i<textarealines;i++){
            for(int j=0; j< arrs1.length;j++){
                p[i][j].startingadd=arrs1[j].startingadd;
                p[i][j].size=arrs1[j].size;
                p[i][j].name=arrs1[j].name;
                p[i][j].processname=arrs1[j].processname;
            }
        }
        return p ;
    }
    public ArrayList<Segment> dealloaction ( String x, ArrayList<Segment> arrm )

        {
          for(int i=0;i< arrm.size();i++){

              if (arrm.get(i).processname==x ){
                  arrm.get(i).type = false;
                  arrm.get(i).processname = null;
                  arrm.get(i).name = "h";
              }}
     return arrm;   }
//    public ArrayList<Segment> dealloaction ( String x, ArrayList<Segment> arrm )
//
//        {
//
//           // int lolo;
//            //lolo=x.size();
//          for(int i=0;i< arrm.size();i++){
//             
//
//              if (arrm.get(i).processname==x){
//                  arrm.get(i).type = false;
//                  arrm.get(i).processname = null;
//                  arrm.get(i).name = "h";
//              
//              }}
//     return arrm;   }

    
    public ArrayList<Segment> addhole (int startingadd , int size ,String name )
    {
        Segment h = new Segment ();
        h.name=name;
        h.processname=null;
        h.size=size;
        h.type=false;
        h.startingadd=startingadd;
        ArrayList<Segment> hole=new ArrayList<Segment>(); 
        hole.add(h);  
       // Segment[] arr = new Segment[hole.size()]; 
       // arr = hole.toArray(arr); 
       // return arr;
       return hole;
        
        
    }
      public ArrayList<Segment> addsegment (int startingadd , int size ,String name, String processname  )
    {
         Segment s = new Segment ();
        s.name=name;
        s.processname=processname;
        s.size=size;
        s.type=true;
        s.startingadd=startingadd;
        ArrayList<Segment> Segment=new ArrayList<Segment>(); 
        Segment.add(s);  
       // Segment[] arrs1 = new Segment[noofs]; 
       // arrs1 = Segment.toArray(arrs1); 
        // return arrs1;
        return Segment;
         
    }
        
    
    
       class MyComparator implements Comparator<Segment>{
		@Override
		public int compare(Segment o1, Segment o2) {
			return (o1.startingadd - o2.startingadd);
		}	
	}
    public ArrayList<Segment>  bestFit(int memorysize ,ArrayList<Segment> segment,ArrayList<Segment> hole,int ddd,ArrayList<Integer> AN ){
         ArrayList<Integer> allocation=new ArrayList<Integer>();
         ArrayList<Integer> np=new ArrayList<Integer>();
        Segment m1[] = new Segment[memorysize];
        int count=0;
        int ay7aga=0;
        int no=0;
        for (int i = 0; i < allocation.size(); i++) {
            int x =-1;
            allocation.add(i, x);
        }
         for (int i = 0; i < segment.size(); i++) {
            int count1 = 0;
                if (segment.get(i).size > memorysize) {
                    JOptionPane.showMessageDialog(null, "Suitable space not found as segment size is bigger than memory size");
                    segment.remove(i);}
                else if (segment.get(i).size <= memorysize) {
                    for ( int j = 0; j < hole.size(); j++) {
                    if (hole.get(j).size < segment.get(i).size) {
                        ++count1;
                        continue;
                    }
                }
            }
            if (count == hole.size()) {
                segment.remove(i);
                JOptionPane.showMessageDialog(null, "Suitable space not found!!!");
            }
        }
         ArrayList<os.Segment> segment1 = segment;
         if(ddd==0){
         
        for (int i = 0 ; i<segment1.size(); i++)
            
        {   if(segment1.get(i).size<=memorysize)
              {int bestfit=-1;
              int c=0;
            for (int j=0; j<hole.size(); j++)
            {
                if(hole.get(j).size >= segment1.get(i).size )
                {
                    if(bestfit==-1)
                        bestfit=j;
                    else if (hole.get(bestfit).size > hole.get(j).size)
                        bestfit=j;
                }
                 else if(hole.get(j).size <segment1.get(i).size) {
                        ++c;
                      }
                }
                if (c==hole.size()){
                    segment1.remove(i);
                    i--;
                }
            
            if (bestfit != -1)
            {  // allocation[i]=bestfit;
                allocation.add(i, bestfit);
                hole.get(bestfit).size-=segment1.get(i).size;
                segment1.get(i).startingadd=hole.get(bestfit).startingadd;
                hole.get(bestfit).startingadd+=segment1.get(i).size;
            }
             }
        }
         }
         else
        {
            for(int k=0;k<AN.size();k++){
              ay7aga+=AN.get(k);
              np.add(ay7aga);
            }
            for(int mm=0;mm<np.size();mm++){
            for (int i = np.get(0)-no ; i<segment1.size(); i++)
        {   
            if(segment1.get(i).size<=memorysize)
              {int bestfit=-1;
              int c=0;
            for (int j=0; j<hole.size(); j++)
            {
                if(hole.get(j).size >= segment1.get(i).size )
                {
                    if(bestfit==-1)
                        bestfit=j;
                    else if (hole.get(bestfit).size > hole.get(j).size)
                        bestfit=j;
                }
                 else if(hole.get(j).size <segment1.get(i).size) {
                        ++c;
                      }
                }
                if (c==hole.size()){
                    segment1.remove(i);
                    i--;
                    ++no;
                }
            
            if (bestfit != -1)
            {  // allocation[i]=bestfit;
            //    allocation.add(i, bestfit);
                hole.get(bestfit).size-=segment1.get(i).size;
                segment1.get(i).startingadd=hole.get(bestfit).startingadd;
                hole.get(bestfit).startingadd+=segment1.get(i).size;
            }
             }
        }
            np.remove(0);
        }
       }
        for (int x=0; x< hole.size();x++){

            if (hole.get(x).size==0){
                hole.remove(x);
            }

        }

        ArrayList<os.Segment> hole1 = hole;
 ArrayList<Segment> memory=new ArrayList<Segment>(); 
        for (Segment x : segment1)
            memory.add(x);
 ArrayList<Segment> m=new ArrayList<Segment>();  
       for(Segment x : hole1)
           m.add(x);
       memory.addAll(m);
       m=null;
      MyComparator  c = new Algorithm().new MyComparator();
      memory.sort(c);
      return memory;
    }
    public ArrayList<Segment> firstFit(int memorysize ,ArrayList<Segment> segment, ArrayList<Segment> hole,int fff, ArrayList<Integer> noofsegments ) {
        ArrayList<Segment> segment1 = new ArrayList<>();
        // int allocation[] = new int[memorysize];
        ArrayList<Integer> allocation = new ArrayList<Integer>();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        int d=0;
        int ccc=0;
        for (int i = 0; i < allocation.size(); i++) {
            int x = -1;
            allocation.add(i, x);
        }
        for (int i = 0; i < allocation.size(); i++)
            allocation.add(i, -1);
        ArrayList<Segment> memory = null;
        for (int i = 0; i < segment.size(); i++) {
            int count = 0;
                if (segment.get(i).size > memorysize) {
                    JOptionPane.showMessageDialog(null, "Suitable space not found as segment size is bigger than memory size");
                    segment.remove(i);}
                else if (segment.get(i).size <= memorysize) {
                    for ( int j = 0; j < hole.size(); j++) {
                    if (hole.get(j).size < segment.get(i).size) {
                        ++count;
                        continue;
                    }
                }
            }
            if (count == hole.size()) {
                segment.remove(i);
                JOptionPane.showMessageDialog(null, "Suitable space not found!!!");
            }
        }
        segment1 = segment;
        if (fff==0){
        for (int m = 0; m < segment1.size(); m++) {
            int c=0;
            if (segment.get(m).size <= memorysize) {
                for (int j = 0; j < hole.size(); j++) {
                    if (hole.get(j).size >= segment1.get(m).size) {
                        hole.get(j).size -= segment1.get(m).size;
                        segment1.get(m).startingadd = hole.get(j).startingadd;
                        hole.get(j).startingadd += segment1.get(m).size;
                        break;
                    }
                    else if(hole.get(j).size <segment1.get(m).size) {
                        ++c;
                      }
                }
                if (c==hole.size()){
                    segment1.remove(m);
                    m--;
                }
                }
        }}
        else
        {
           for ( int ff=0; ff< noofsegments.size();ff++){
              ccc+=noofsegments.get(ff);
              System.out.println(ccc);
              arr.add(ccc);
          }
                 for (int f=0; f<arr.size();f++){
                for (int m = arr.get(0)-d; m < arr.size(); m++) {
                int c=0;
                if (segment1.get(m).size <= memorysize) {
                    for (int j = 0; j < hole.size(); j++) {
                        if (hole.get(j).size >= segment1.get(m).size) {
                            //            allocation.add(m, j);
                            hole.get(j).size -= segment1.get(m).size;
                            segment1.get(m).startingadd = hole.get(j).startingadd;
                            hole.get(j).startingadd += segment1.get(m).size;
                            break;
                        }
                        else if(hole.get(j).size <segment1.get(m).size) {
                            ++c;
                        }
                    }
                    if (c==hole.size()){
                        segment1.remove(m);
                        m--;
                        ++d;
                        JOptionPane.showMessageDialog(null, "Suitable space not found new hole smaller than segment");
                    }
                    }
                }arr.remove(0);
      }
       }





        for (int x=0; x< hole.size();x++) {
            if (hole.get(x).size == 0) {
                hole.remove(x);
            }


        }

        ArrayList<os.Segment> hole1 = hole;
                memory = new ArrayList<Segment>();
                for (Segment x : segment1)
                    memory.add(x);
                ArrayList<Segment> m1 = new ArrayList<Segment>();
                for (Segment x : hole1)
                    m1.add(x);
                memory.addAll(m1);
                //m=null;
                MyComparator c = new Algorithm().new MyComparator();
                memory.sort(c);
                for (int n=0;n<memory.size();n++){
                    for (int o= n+1;o<memory.size();o++){
                        if ((memory.get(n).type==false)&&(memory.get(o).type==false)){
                            if ((memory.get(o).startingadd)==(memory.get(n).startingadd+memory.get(n).size)){
                            memory.get(n).size= memory.get(n).size+memory.get(o).size;
                            memory.remove(o);

                        }
                        break;
                    }
                }}
                

        return memory;}}
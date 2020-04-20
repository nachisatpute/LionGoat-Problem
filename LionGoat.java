
import java.util.ArrayList;
import java.util.HashSet;
/**
 *
 * @author Nachiket
 */

class Solve{
//State:- Lion Goat Grass Boat
// Lion:-a[0]
// Goat:-a[1]
// Grass:-a[2]
// Boat:-a[3]
    
  
    String start="1111";
    String goal="0000";
    String state=start;
        HashSet<String> explored=new HashSet<>(); //Explored List
        HashSet<String> invalid=new HashSet<>();
       
        ArrayList<String> frontier=new ArrayList<>();  //Frontier
        Solve(){
            explored.add(state);
            invalid.add("1100");
            invalid.add("0110");            
            invalid.add("0011");           
            invalid.add("1001");
            
        }
        
        void solvebfs(){
        
            while(!state.equals(goal)){
                
            stateGenerate(state,frontier);
            System.out.println("State: "+state);
                System.out.println("Explored List: "+explored);
                System.out.println("Frontier: "+frontier);
            explored.add(state);
           
            while(true){
          
            state=frontier.get(0);
            frontier.remove(0);
               
            if(!explored.contains(state) && !invalid.contains(state)){
                break;
            }
            
            }
            
            }
            System.out.println("State: "+state);
             System.out.println("Explored List: "+explored);
            System.out.println("Frontier: "+frontier);
        }
        void solvedfs(){
           
            explored.clear();
            frontier.clear();
           
            while(!state.equals(goal)){
               
            stateGenerate(state,frontier);
             System.out.println("State: "+state);
                System.out.println("Explored List: "+explored);
                System.out.println("Frontier: "+frontier);
            explored.add(state);
           
            while(true){
              
            state=frontier.get(frontier.size()-1);
            frontier.remove(frontier.size()-1);
               
            if(!explored.contains(state) && !invalid.contains(state)){
                break;
            }
            
            }
            
            }
             System.out.println("State: "+state);
             System.out.println("Explored List: "+explored);
            System.out.println("Frontier: "+frontier);
            
        }
        
        void stateGenerate(String state,ArrayList s){
            String[] str=state.split("");
         String temp;
            if(str[0].equals("1") && str[3].equals("1")){
                temp="0"+str[1]+str[2]+"0";
                if(!invalid.contains(temp) && !explored.contains(temp) && !s.contains(temp))
                s.add(temp); //Lion and Boat to Right
                
            }
            
            if(str[0].equals("0") && str[3].equals("0")){
                temp="1"+str[1]+str[2]+"1";
                //Lion and Boat to Left
                if(!invalid.contains(temp) && !explored.contains(temp) && !s.contains(temp))
                s.add(temp);
            }
            if(str[1].equals("1") && str[3].equals("1")){
                temp=str[0]+"0"+str[2]+"0";
                 //Goat and Boat to Right
                if(!invalid.contains(temp) && !explored.contains(temp) && !s.contains(temp))
                s.add(temp);
            }
            
            if(str[1].equals("0") && str[3].equals("0")){
                temp=str[0]+"1"+str[2]+"1";
                 //Goat and Boat to Left
                if(!invalid.contains(temp) && !explored.contains(temp) && !s.contains(temp))
                s.add(temp);
            }
            
            if(str[2].equals("1") && str[3].equals("1")){
                //Grass and Boat to Right
                temp=str[0]+str[1]+"0"+"0";
                if(!invalid.contains(temp) && !explored.contains(temp) && !s.contains(temp))
                s.add(temp);
            }
            
            if(str[2].equals("0") && str[3].equals("0")){
                temp=str[0]+str[1]+"1"+"1";
                 //Grass and Boat to Left
                if(!invalid.contains(temp) && !explored.contains(temp) && !s.contains(temp))
                s.add(temp);
            }
            
            if(str[3].equals("0")){
                temp=str[0]+str[1]+str[2]+"1";
                 //Boat to Left
                if(!invalid.contains(temp) && !explored.contains(temp) && !s.contains(temp))
                s.add(temp);
            }
            
        }
}

public class LionGoat {
   
    public static void main(String[] args) {
         System.out.println("State Convention:- ");
         System.out.println("Lion Goat Grass Boat");
         System.out.println(" 1    1     1     1");
         System.out.println("\n");
         
          Solve bfs=new Solve();
          System.out.println("Using BFS:");
          long start = System.currentTimeMillis();
          bfs.solvebfs();    
          long end = System.currentTimeMillis(); 
          float sec = (end - start);
          System.out.println("Time(BFS):"+sec);
          
          
          System.out.println("\nUsing DFS:");
          Solve dfs=new Solve();
          long start2 = System.currentTimeMillis();
          dfs.solvedfs();
          long end2 = System.currentTimeMillis();     
          float sec2 = (end2 - start2);
          System.out.println("Time(DFS): "+sec2);
        
    }
}

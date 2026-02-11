import java.util.ArrayList;
public class ArraylistEx {
    public static void main(String[] args) {
        ArrayList<Integer> intArrl=new ArrayList<Integer>();
        intArrl.add(345);
        intArrl.add(999);
        for(int i=1;i<10;i++)
            intArrl.add(i*i*i);
        for(Integer e: intArrl)
            System.out.println(e);
        intArrl.forEach(e->System.out.println(e));
        System.out.println(intArrl.indexOf(999));
        intArrl.add(1);
        System.out.println(intArrl.lastIndexOf(1));
        intArrl.remove(2);
        ArrayList<Integer> newArrl=new ArrayList<Integer>();
        newArrl.add(3);
        newArrl.add(6);
        newArrl.add(9);
        intArrl.addAll(newArrl);
        for(Integer e: intArrl)
            System.out.println(e);
        ArrayList<String> wordsStringss=new ArrayList<String>();
        wordsStringss.add("Cow");
        wordsStringss.add("Dog");
        for(String ew: wordsStringss)
            System.out.println(ew);
        wordsStringss.forEach(w->{if(w.startsWith("C")) System.out.println(w);});
        wordsStringss.removeIf(w->w.startsWith("C"));
        for(String ew: wordsStringss)            
            System.out.println(ew);

        


        



    }
    
}

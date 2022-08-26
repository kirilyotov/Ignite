package digital.lights.firstweek.monday.third;

public class SimpleSearch implements  StringSearch{

    /**
     * Speed n!
     * @param part Substring to find
     * @param whole String where to search
     * @return -1 if substring does not exist and position of first char of substring
     */
   public int positionOf(String part, String whole){
       if(part == null || whole == null)
           throw new NullPointerException();

       int position = -1;

       for(int i = 0; i < whole.length(); i++){
           boolean isSubstring = true;
           for(int j = 0; j < part.length(); j++){
               if(whole.charAt(i + j) != part.charAt(j)){
                   isSubstring = false;
                   break;
               }
           }
           if(isSubstring){
               position = i;
               break;
           }
       }
        return position;
    }
}

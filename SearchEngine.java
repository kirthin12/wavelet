import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

public class SearchEngine 
{
    String randomWord = " ";
    public String handleRequest(URI url) {
        ArrayList<String> listOfWords = new ArrayList<String>();
        if (url.getPath().equals("/")) 
        {
            String list = "";
            if (listOfWords.size() == 0)
            {
                return " ";
            }
            for (int i = 0; i < listOfWords.size(); i++)
            {
                list = listOfWords.get(i) + " ";
            }
            return list;
        } 
        else 
        {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) 
            {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) 
                {
                    randomWord = parameters[1];
                    listOfWords.add(randomWord);
                    return "";
                }
            }
            return "404 Not Found!";
        }
    }
}

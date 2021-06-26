
import edu.duke.*;

public class Find_Genes4 
{
    public void printUrls(String url) 
    {
        URLResource myurl = new URLResource(url);
        for(String word : myurl.words()) {
            if(word.toLowerCase().indexOf("youtube.com") != -1) 
            {
                int quoteIndex = word.indexOf("\"");
                int lastQouteIndex = word.indexOf("\"", quoteIndex+1);
                System.out.println(word.substring(quoteIndex+1, lastQouteIndex));
                
            }
        }
    }
    
    public void testUrl() 
    {
        printUrls("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }
    
    public static void main() 
    {
        Find_Genes4 url = new Find_Genes4();
        url.testUrl();
    }
}
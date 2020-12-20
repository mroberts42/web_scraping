package com.codetriage.scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.net.URLEncoder;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println("Hello World");
        String searchQuery = "nintendo" ;
        String searchURL = "https://albuquerque.craigslist.org/search/sss?query=nintendo";

        //object from HTMLunit
        WebClient client = new WebClient();


        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);


        try {
            HtmlPage page = client.getPage(searchURL);
            List<HtmlElement> results = (List<HtmlElement>) page.getByXPath("//li[@class='result-row']");
            if(results.isEmpty())
                System.out.println("No results");
            else
            {
                for(HtmlElement x : results)
                {
                    //Null Pointe, itme is empty as is
                    HtmlAnchor item = ((HtmlAnchor) x.getFirstByXPath(".//h3[@class='result-heading']/a"));
                    //System.out.println(x.asXml());

                    System.out.println(item.asText());
                    String url = item.getHrefAttribute();
                    System.out.println(url);
                }
            }

        }catch(Exception e){

            e.printStackTrace();
        }




    }
}


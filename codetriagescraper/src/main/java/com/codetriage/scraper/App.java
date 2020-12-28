package com.codetriage.scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static List<Result> Results;

    public static void main(String[] args )
    {

        System.out.println("Hello World");
        String searchQuery;

        Window w = new Window(320 , 320 , "Scraping Craigslist Albuquerque");

        //Won't Work Yet, no method to set search in Window
        /*
        while(w.getSearch() == null)
        {

        }
        */



        String searchURL = "https://albuquerque.craigslist.org/search/sss?query=nintendo";

        //object from HTMLunit
        WebClient client = new WebClient();


        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        Results = new LinkedList<Result>();


        try {
            HtmlPage page = client.getPage(searchURL);
            List<HtmlElement> results = (List<HtmlElement>) page.getByXPath("//li[@class='result-row']");
            if(results.isEmpty())
                System.out.println("No results");
            else
            {
                for(HtmlElement x : results)
                {
                    HtmlAnchor item = ((HtmlAnchor) x.getFirstByXPath(".//h3[@class='result-heading']/a"));
                    //System.out.println(x.asXml());
                    HtmlSpan price = x.getFirstByXPath(".//span[@class = 'result-price']");

                    //Error: HtmlSpan cannot be cast to java.lang.String
                    //Solution to Sting just prints the
                    //System.out.println(price.asText());

                    //System.out.println(item.asText());
                    //String url = item.getHrefAttribute();
                    //System.out.println(url);
                    Result temp = new Result(item.asText(), BigDecimal.valueOf(0.42), item.getHrefAttribute());

                    Results.add(temp);
                    System.out.println(temp.getPrice().toString());

                }
            }

        }catch(Exception e){

            e.printStackTrace();
        }




    }
}


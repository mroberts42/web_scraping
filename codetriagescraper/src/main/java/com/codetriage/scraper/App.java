package com.codetriage.scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;

import java.math.BigDecimal;
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
        String searchURL = "https://albuquerque.craigslist.org/search/sss?query=";
        String finalUrl;

        Window w = new Window(320 , 320 , "Scraping Craigslist Albuquerque");



        String loop = w.getSearch();
        while(w.getSearch() == null) ;

        searchQuery = w.getSearch();


        finalUrl = searchURL + searchQuery;
        // System.out.println(finalUrl);




        //object from HTMLunit
        WebClient client = new WebClient();


        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        Results = new LinkedList<Result>();


        try {
            HtmlPage page = client.getPage(finalUrl);
            List<HtmlElement> results = (List<HtmlElement>) page.getByXPath("//li[@class='result-row']");
            if(results.isEmpty())
                System.out.println("No results");
            else
            {
                for(HtmlElement x : results)
                {
                    HtmlAnchor item = ( x.getFirstByXPath(".//h3[@class='result-heading']/a"));
                    HtmlSpan price = x.getFirstByXPath(".//span[@class = 'result-price']");

                    Result temp = new Result(item.asText(), new BigDecimal(price.asText().substring(1, price.asText().length())), item.getHrefAttribute());

                    Results.add(temp);
                    System.out.println(temp.toString());

                }
            }

        }catch(Exception e){

            e.printStackTrace();
        }




    }
}


package com.smatt;

import com.smatt.models.Post;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by smatt on 21/04/2017.
 */
public class MyTest {

    Logger logger = Logger.getLogger(SpringBlogApplicationTests.class);

    public MyTest() {}

    @Test
    public void testSumByStream() {
        List<Post> posts = Arrays.asList(
           new Post(1, "Post 1"),
           new Post(2, "post 2"),
           new Post(3, "post 3")
        );
        int result =  posts.stream().collect(Collectors.summingInt(p -> p.getViews()));
        assertEquals(result, 6);
    }

    @Test
    public void testJsoup() {
        String html = "<p>Prodsters is a free invite only community of African Developers, UI / UX Designers, Project managers, Scrum masters, Architects etc. (collectively &ldquo;Talents&rdquo;) who can create their own digital team (&ldquo;team&rdquo;) or join other teams (&ldquo;teams&rdquo;) for paid projects.</p>\n" +
                "<p>Project owners submit projects (&ldquo;the project&rdquo;) through the Site; Prodsters then pick the most suitable team that can work on the project to completion. The Project Owner interacts directly with Prodtsers throughout the life span of the project and not with any team.</p>\n" +
                "<p>It is the sole responsibility of Prodsters to ensure the project is completed and the Project owner is satisfied.</p>\n" +
                "<p>Prodsters is a free invite only community of African Developers, UI / UX Designers, Project managers, Scrum masters, Architects etc. (collectively &ldquo;Talents&rdquo;) who can create their own digital team (&ldquo;team&rdquo;) or join other teams (&ldquo;teams&rdquo;) for paid projects.</p>\n" +
                "<p>Project owners submit projects (&ldquo;the project&rdquo;) through the Site; Prodsters then pick the most suitable team that can work on the project to completion. The Project Owner interacts directly with Prodtsers throughout the life span of the project and not with any team.</p>\n" +
                "<p>It is the sole responsibility of Prodsters to ensure the project is completed and the Project owner is satisfied.</p>\n" +
                "<p>Prodsters is a free invite only community of African Developers, UI / UX Designers, Project managers, Scrum masters, Architects etc. (collectively &ldquo;Talents&rdquo;) who can create their own digital team (&ldquo;team&rdquo;) or join other teams (&ldquo;teams&rdquo;) for paid projects.</p>\n" +
                "<p>Project owners submit projects (&ldquo;the project&rdquo;) through the Site; Prodsters then pick the most suitable team that can work on the project to completion. The Project Owner interacts directly with Prodtsers throughout the life span of the project and not with any team.</p>\n" +
                "<p>It is the sole responsibility of Prodsters to ensure the project is completed and the Project owner is satisfied.</p>\n" +
                "<p>Prodsters is a free invite only community of African Developers, UI / UX Designers, Project managers, Scrum masters, Architects etc. (collectively &ldquo;Talents&rdquo;) who can create their own digital team (&ldquo;team&rdquo;) or join other teams (&ldquo;teams&rdquo;) for paid projects.</p>\n" +
                "<p>Project owners submit projects (&ldquo;the project&rdquo;) through the Site; Prodsters then pick the most suitable team that can work on the project to completion. The Project Owner interacts directly with Prodtsers throughout the life span of the project and not with any team.</p>\n" +
                "<p>It is the sole responsibility of Prodsters to ensure the project is completed and the Project owner is satisfied.</p>";

        Document doc = Jsoup.parse(html);
        Element element = doc.getElementsByTag("p").first();
        logger.info("text of first p \n" + element.html());
    }
}

package HW_2.Task4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Document doc1 = new Document();
        doc1.id = 1;
        Document doc2 = new Document();
        doc2.id = 2;
        Document doc3 = new Document();
        doc3.id = 3;

        List<Document> documents = Arrays.asList(doc1, doc2, doc3);

        DocumentsOrganizer docOrg = new DocumentsOrganizer();
        System.out.println(docOrg.organizeDocuments(documents));
    }

}
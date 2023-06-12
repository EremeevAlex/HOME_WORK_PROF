package HW_2.Task4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentsOrganizer {
    public Map<Integer, Document> organizeDocuments(List<Document> documents) {
        Map<Integer, Document> documentMap = new HashMap<>();
        for (Document element : documents) {
            documentMap.put(element.id, element);
        }
        return documentMap;
    }

}
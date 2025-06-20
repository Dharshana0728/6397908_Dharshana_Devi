import java.util.Scanner;
public class FactoryMethodPatternExample {
    interface Document {
        void open();
    }
    static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a Word document.");
        }
    }
    static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a PDF document.");
        }
    }
    static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening an Excel document.");
        }
    }
    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }
    static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }
    static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }
    static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the type of document you want to open (word/pdf/excel):");
            String input = scanner.nextLine().toLowerCase();

            DocumentFactory factory = null;

            switch (input) {
                case "word":
                    factory = new WordDocumentFactory();
                    break;
                case "pdf":
                    factory = new PdfDocumentFactory();
                    break;
                case "excel":
                    factory = new ExcelDocumentFactory();
                    break;
                default:
                    System.out.println("Invalid document type entered.");
                    break;
            }

            if (factory != null) {
                Document doc = factory.createDocument();
                doc.open();
            }
        }
    }
}

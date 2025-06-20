import java.util.Scanner;

public class FactoryMethodPattern {

    interface Document {
        void open();
    }

    static class WordDocument implements Document {
        public void open() {
            System.out.println(" Opening a Word document.");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println(" Opening a PDF document.");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println(" Opening an Excel document.");
        }
    }

    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    static class WordDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter the type of document to open (word/pdf/excel) or type 'exit' to quit:");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println(" Exiting the document manager. Goodbye!");
                break;
            }

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
                    System.out.println(" Invalid input. Please enter 'word', 'pdf', 'excel', or 'exit'.");
                    continue;
            }

            Document document = factory.createDocument();
            document.open();
        }

        scanner.close();
    }
}
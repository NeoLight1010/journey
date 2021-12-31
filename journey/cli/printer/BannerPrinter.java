package journey.cli.printer;

public class BannerPrinter {
    public static void printBanner(String border, String title) {
        System.out.println(border + " " + title + " " + border);
    }

    public static void printHeader1(String title) {
        printBanner("###########", title);
    }

    public static void printHeader2(String title) {
        printBanner("+++++++++++", title);
    }

    public static void printHeader3(String title) {
        printBanner("-----------", title);
    }
}

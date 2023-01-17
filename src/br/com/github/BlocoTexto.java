package br.com.github;

public class BlocoTexto {

    public static void main(String[] args) {
        String query = """
                SELECT "ORDER_ID", "QUANTITY", "CURRENCY_PAIR" FROM "ORDERS"
                WHERE "CLIENT_ID" = ?
                ORDER BY "DATE_TIME", "STATUS" LIMIT 100;
                """;
    }
}

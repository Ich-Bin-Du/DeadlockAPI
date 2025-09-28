public class prettyJson {
    public static String prettyPrintJson(String json) {
        StringBuilder pretty = new StringBuilder();
        int indentLevel = 0;
        boolean inQuotes = false;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            switch (c) {
                case '"':
                    // toggle quote flag when not escaped
                    if (i > 0 && json.charAt(i - 1) != '\\') {
                        inQuotes = !inQuotes;
                    }
                    pretty.append(c);
                    break;

                case '{':
                case '[':
                    pretty.append(c);
                    if (!inQuotes) {
                        pretty.append("\n");
                        indentLevel++;
                        appendIndent(pretty, indentLevel);
                    }
                    break;

                case '}':
                case ']':
                    if (!inQuotes) {
                        pretty.append("\n");
                        indentLevel--;
                        appendIndent(pretty, indentLevel);
                        pretty.append(c);
                    } else {
                        pretty.append(c);
                    }
                    break;

                case ',':
                    pretty.append(c);
                    if (!inQuotes) {
                        pretty.append("\n");
                        appendIndent(pretty, indentLevel);
                    }
                    break;

                case ':':
                    pretty.append(c);
                    if (!inQuotes) pretty.append(" ");
                    break;

                default:
                    pretty.append(c);
                    break;
            }
        }

        return pretty.toString();
    }

    private static void appendIndent(StringBuilder sb, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            sb.append("    "); // 4 spaces per indent
        }
    }
}

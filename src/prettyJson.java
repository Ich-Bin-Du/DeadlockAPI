public class prettyJson {
    public static String prettyPrintJson(String json) {
        StringBuilder pretty = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            switch (c) {
                case '"':
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
                    }
                    break;

                case '}':
                case ']':
                    if (!inQuotes) {
                        pretty.append("\n");
                        pretty.append(c);
                    } else {
                        pretty.append(c);
                    }
                    break;

                case ',':
                    pretty.append(c);
                    if (!inQuotes) {
                        pretty.append("\n");
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
 }
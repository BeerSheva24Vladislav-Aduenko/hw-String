package telran.strings;

public class Strings {

    public static String[] keywords =  {
        "abstract", "continue", "for", "new", "switch",
        "assert", "default", "goto", "package", "synchronized",
        "boolean", "do", "if", "private", "this",
        "break", "double", "implements", "protected", "throw",
        "byte", "else", "import", "public", "throws",
        "case", "enum", "instanceof", "return", "transient",
        "catch", "extends", "int", "short", "try",
        "char", "final", "interface", "static", "void",
        "class", "finally", "long", "strictfp", "volatile",
        "const", "float", "native", "super", "while"
    };
    public static final String JAVA_VARIABLE_PATTERN = 
        "^(?!(%s)$)(?!_$)[A-Za-z$_][0-9A-Za-z$_]*$";

    public static String javaVariable() {
        return String.format(JAVA_VARIABLE_PATTERN, String.join("|", keywords));
    }
}
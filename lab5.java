public class StringManipulationDemo
{
    public static void main(String[] args)
    {
        String str = "Hello, World!";
        System.out.println("Original string: " + str);
        
        char charAtIndex4 = str.charAt(4);
        System.out.println("Character at index 4: " + charAtIndex4);
        
        String substring = str.substring(7, 12);
        System.out.println("Substring from index 7 to 12: " + substring);
        
        String str1 = "World";
        String str2 = "world";
        System.out.println("String comparison:");
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2));
        
        String text = "Hello World of Java Programming";
        String wordToFind = "World";
        boolean containsWord = text.contains(wordToFind);
        System.out.println("Does the text contain the word \"World\"? " + containsWord);
        
        String original = " Trim String ";
        System.out.println("Original string with leading and trailing spaces: \"" + original + "\"");
        String trimmed = original.trim();
        System.out.println("Trimmed string: \"" + trimmed + "\"");
        
        String replaceExample = "I like Python, Python is fun!";
        String replaced = replaceExample.replace("Python", "Java");
        System.out.println("String after replacement: " + replaced);
        
        String uppercase = str.toUpperCase();
        System.out.println("Uppercase string: " + uppercase);
        
        String lowercase = str.toLowerCase();
        System.out.println("Lowercase string: " + lowercase);
    }
}

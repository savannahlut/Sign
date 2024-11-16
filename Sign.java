public class Sign 
{
    private String text;
    private int width;

/* The numberOfLines method returns an int representing the number of lines needed to display the
text on the sign. In the previous examples, numberOfLines would return 3, 2, and 1, respectively,
for the sign widths shown in the table. */
    public int numberOfLines()
    {
        int height = text.length() / width;
        if (text.length() % width > 0) height++;
        return height; 
    }

/*The getLines method returns a String containing the message broken into lines separated by
semicolons (;) or returns null if the message is the empty string. The constructor parameter that
contains the message to be displayed will not include any semicolons. As an example, in the first row of the
preceding table, getLines would return "Everything on s;ale, please com;e in" .
No semicolon should appear at the end of the String returned by getLines. */ 
    public String getLines()
    {
        if(0 == text.length()) return null;
        String leftover = text;
        String lines = "";
        while (width < leftover.length())
        {
            lines += leftover.substring(0, width);
            lines += ";";
            leftover = leftover.substring(width);
        } 
        /*vvv Took me years to figure out. Adds text for cases like sign2 */
        lines += leftover;
        return lines;
    }

    public Sign(String text, int width)
    {
        /*uses this keyword*/
        this.text = text;
        this.width = width;
    }
}

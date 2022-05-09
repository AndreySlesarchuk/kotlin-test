package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-09
 */

fun main() {
    /*      https://regexlib.com/CheatSheet.aspx
            https://regex101.com/r/fLntOd/1

            \\d - one digit
            \\w -   one letter
            + - 1 or more
            * - 0 or more
            ? - 0 или 1 characters before a.matches("-?\\d*") minus may/or not before

            ( x|y|a ) - one line out of many strings

            [abc] = (a|b|c) - spaces is important
            [a-zA-Z] - sets - all different letters
            [0-9] = \\d
            [^abc] - we want all characters except [abc]

            .   - any character
            {2}  - figures in curly brackets, a specific number of numbers BEFORE (\\d{2}
            {2, }  - two or more numbers BEFORE (\\d{2, }
            {2,4}  - from 2 to 4 numbers BEFORE

         */
    val a = "-1111"
    println(a.matches("([-+])?\\d*".toRegex()))
    val d = "a12345"
    println(d.matches("[a-zA-Z]*\\d*".toRegex()))
    val e = "hello12345"
    println(e.matches("[^a-cA-C]*\\d*".toRegex()))
    val url = "https://www.google.com"
    val url2 = "https://www.yahoo..org"
    println(url.matches("https://www\\..+\\.(com|org)".toRegex()))
    println(url2.matches("https://www\\..+\\.(com|org)".toRegex()))
    val f = "12345"
    println(f.matches("\\d{2,5}".toRegex()))
}
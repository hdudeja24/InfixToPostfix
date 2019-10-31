* BY HITANSHU DUDEJA
 * LAB 1 - EECS 2500
 * R01410180 */


import java.util.*; //Import util library


public class ExpressionEvaluator {


    //Start of main()
    public static void main(String args[])
    {

        Scanner input = new Scanner (System.in);    //Scanner to get user input

        //Create variable for do-while loop
        int x = 1;  //If user exits change x to 0
       
        //Start of do-while loop -> to exit change value of variable x
        do
        {
            System.out.println("Enter Infix expression: ");
            String testingInput = input.nextLine(); //Get user input and save as string

            if (!testingInput.isEmpty())    //If user doesn't enter an empty line
            {
                String expression = testingInput; //If input is not exit/blank line then save as expression

                //Check if user's expression isn't valid
                if (expression == "S" || expression == " " || expression == "\'")
                    System.out.println("Error! Check your input\n");

                else    //If user input is valid
                {
                    char expArray [] = breakStr(expression);   //Save string as char array
                    //Pass it to InfixToPostfix to get the string PostFix and a blank line
                    System.out.println( "Postfix:\n" + InfixToPostfix(expArray) + "\n");  
                }
            }

            else    //If user enters empty line then exit program
            {

                System.out.println("Exited Program\n"); //Exit message
                x = 0; //Set x to 0 in order to terminate do-while
            }


        } while (x != 0);   //End of do-while loop
       
        input.close();     //Close scanner object
       
    } //End of main()

    //Function to break string into char array
    public static char [] breakStr (String input)
    {
        String inputNoSpaces = input.replaceAll("\\s+",""); //Removes all empty spaces from string

        return inputNoSpaces.toCharArray(); //Returns char array from string with no spaces

    } //End of breakStr ()


    public static String InfixToPostfix (char [] expArray)
    {

        String result = ""; //Create empty string to save final result

        StackLinkedList stack = new StackLinkedList();  //Create stack to store operands

        String errorMsg = "Error! Invalid Expression\n";  //Create error string in case invalid operand is inputted


        for (char c: expArray)  //Iterate through expArray to check each character
        {

            //If character is variable or # add it to the results string
            if (Character.isLetterOrDigit(c)) result += c;

            // If the scanned character is an '(', push it to the stack.
            //If the character is
            //Push '(' to stack
            else if (c == '(') stack.push(c);
            //If operand is ')' then iterate until the '(' is found
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.top() != '(')
                {
                    System.out.println("What is top: " + stack.top() );
                    result += (char)stack.top();
                    stack.pop();

                }

                //If only operand is '(' then return error message
                if (!stack.isEmpty() && stack.top() != '(') return errorMsg;

                else stack.pop();
            }
            else // an operator is encountered
            {

                while (!stack.isEmpty() && Prec(c) <= (Prec((char)stack.top()))){
                    if(stack.top() == '(') return errorMsg;
                    result += (char)stack.top();
                    stack.pop();
                }
                stack.push(c);
            }

        }   //End of for loop

        while (!stack.isEmpty())    //Remove any operators within the stack at the end of result string
        {

            if(stack.top() == '(') return "Invalid Expression";
            result += (char)stack.top();    //Save current top as char and add it to result string
            stack.pop();        //Remove current top after saving into string

        }
        return result;
    }   //End of InfixToPostfix()

    public static int Prec(char ch)
    {
        if (ch == '+' || ch == '-') return 1;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '^') return 3;

        else return -1;

    }
}

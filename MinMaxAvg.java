import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MinMaxAvg
{

    public static void main(String[] args)
    {
        //declaring vars
        Integer numInput;
        String funct;
        List<Integer> inputList = new ArrayList<Integer>();
        boolean error;


        while(true)
        {
            do //getting input, making sure its valid
            {
                numInput = Integer.parseInt(GetInput("\n\nPlease enter a number between -1,000,000 and 1,000,000"));
                if (CheckNumSize(numInput))
                {
                    System.out.println("Number does not comply\n");
                }
            } while(CheckNumSize(numInput));
            inputList.add(numInput);

            do
            {
               error = false;
               funct = GetInput("If you want to find the minimum of all the numbers you've entered so far, type 'min'\nIf you want to find the maximum of all the numbers, type 'max'\nIf you want to find the average of all the numbers, write 'avg'. If you want to quit, type 'quit'");
               funct = funct.toLowerCase();
               if (funct.equals("min"))
               {
                   System.out.println(GetMin(inputList));
               } else if (funct.equals("max"))
               {
                   System.out.println(GetMax(inputList));
               } else if (funct.equals("avg"))
               {
                   System.out.println(GetAvg(inputList));
               } else if (funct.equals("quit"))
               {
                   System.exit(0);
               } else
               {
                   System.out.println("Unrecognised input :(");
                   error = true;
               }
            } while(error);
        }
    }


    public static boolean CheckNumSize(Integer n)
    {
        if ((n >= -1000000) && (n <= 1000000))
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public static Integer GetMin(List<Integer> inList)
    {
        while (inList.size() > 1)
        {
            for (int i = 0; i <= (inList.size() - 1); i++)
            {
                if ((inList.get(i) < inList.get(i + 1)) && (i + 1 <= inList.size()))
                {
                    inList.remove(i + 1);
                }
                else if ((inList.get(i) > inList.get(i + 1)) && (i + 1 <= inList.size()))
                {
                    inList.remove(i);
                }
            }
        }
        return inList.get(0);
    }


    public static Integer GetMax(List<Integer> inList)
    {
        while (inList.size() > 1)
        {
            for (int i = 0; i <= (inList.size() - 1); i++)
            {
                if ((inList.get(i) > inList.get(i + 1)) && (i + 1 <= inList.size()))
                {
                    inList.remove(i + 1);
                }
                else if ((inList.get(i) < inList.get(i + 1)) && (i + 1 <= inList.size()))
                {
                    inList.remove(i);
                }
            }
        }
        return inList.get(0);
    }


    public static double GetAvg(List<Integer> inList)
    {
        Integer total = 0;
        double avg = 0;
        for (Integer e : inList)
            total += e;
        avg = total / inList.size();
        return avg;
    }

    public static String GetInput(String inputText)
    {
        Scanner input = new Scanner(System.in);
        String userInput;
        System.out.println(inputText);
        userInput = input.nextLine();
        return userInput;
    }

}

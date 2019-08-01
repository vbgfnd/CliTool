import java.net.PortUnreachableException;
import java.util.regex.*;

import javax.lang.model.util.ElementScanner6;

class StrTool
{
    private String str;
    private String letter = "abcdefghijklmnopqrstuvwxyz";
    private String[] help_context = 
    {
        "****************************************************************",
        "*Usage:                                                        *",
        "****************************************************************",
        "StrTool help           --display help information",
        "StrTool special        --create special characters",
        "StrTool 25             --create string of specialed length",
        "StrTool 25 abc中文     --create string of specialed length and char",
        "StrTool 25 abc random  --create random string"
    };
    //check illegal para, if illegal,fail
    public boolean CheckPara(String args[])
    {
        //set index to traversing the array which save cli's options
        int index = 0;
        int array_tail = args.length;
        //no more than 4 para
        if(args.length == 0 || args.length >= 4)
        {
            return false;
        }
        //check first para
        String first_para = args[index];
        index++;
        //setting regex pattern to judge that if the first para is number
        String pattern_num = "[1-9][0-9]*";
        if(!Pattern.matches(pattern_num, first_para))
        {
            if(first_para.equals("help") && index == array_tail)
            {
                return true;
            }
            else if(first_para.equals("special") && index == array_tail)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        if(index == array_tail)
        {
            return true;
        }
        else
        {
            //check second para
            String secend_para = args[index];
            index++;
            if(index == array_tail)
            {
                return true;
            }
            else
            {
                String third_para = args[index];
                index++;
                if(third_para.equals("random") && index == array_tail)
                {
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }
    }

    //excute cmd
    public boolean ExcuteCmd(String args[]) throws Exception
    {
        if(CheckPara(args) == false)
        {
            Help();
            return false;
        }
        String first_para = args[0];
        String pattern_num = "[1-9]?[0-9]*";
        if(Pattern.matches(pattern_num, first_para))
        {
            String tmp_str = CreateStrByNum(args);
            System.out.println(tmp_str);
            return true;
        }
        else if(first_para.equals("special"))
        {
            String tmp_str = CreateSpecialChar();
            System.out.println(tmp_str);
            return true;
        }
        else if(first_para.equals("help"))
        {
            Help();
            return true;
        }
        else
        {
            throw new Exception("Error：StrTool help");
        }
    }
    //create string by special number
    private String CreateStrByNum(String args[])
    {
        int index = 0;
        int array_tail = args.length;
        //get the first para
        String first_para = args[index];
        index++;
        int num = Integer.parseInt(first_para);
        if(index == array_tail)
        {
            String tmp_str = "";
            int divisor = letter.length();
            int length = letter.length();
            for(int i = 0; i < num; i++, divisor++)
            {
                tmp_str += letter.charAt(divisor % length);
            }
            return tmp_str;
        }
        //get the second para,achieve the string with special length and special char
        String second_para = args[index];
        index++;
        if(index == array_tail)
        {
            String tmp_str = "";
            int divisor = second_para.length();
            int length = second_para.length();
            for(int i = 0; i < num; i++, divisor++)
            {
                tmp_str += second_para.charAt(divisor % length);
            }
            return tmp_str;
        }
        //get the third para,achieve the random string of special length
        String third_para = args[index];
        int random = (int)(Math.random() * 10);
        String tmp_str = "";
        int divisor = second_para.length();
        int length = second_para.length();
        for(int i = 0; i < num; i++, divisor++)
        {
            random = (int)(Math.random() * 10);
            tmp_str += second_para.charAt(divisor * random % length);
        }
        return tmp_str;


    }
    //create special characters
    private String CreateSpecialChar()
    {
        str = "`~!@#$%^&*()-=_+[]\\{}|;\':\",./<>?";
        return str;
    }
    //display help information
    private boolean Help()
    {
        for(int i = 0; i < help_context.length; i++)
        {
            System.out.println(help_context[i] + "\n");
        }
        return true;
    }
    public static void main(String args[])
    {
        StrTool strtool = new StrTool();
        try
        {
            strtool.ExcuteCmd(args);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}

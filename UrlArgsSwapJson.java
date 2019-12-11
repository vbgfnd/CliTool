import java.net.PortUnreachableException;
import java.util.regex.*;


class UrlArgsSwapJson
{
    private String str;
    private String[] help_context = 
    {
        "****************************************************************",
        "*Usage:                                                        *",
        "****************************************************************",
        "UrlArgsSwapJson xxx                                             ",
    };

    //check illegal para, if illegal, fail
    public boolean CheckPara(String args[])
    {
        return true;
    }

    //excute cmd
    public boolean ExcuteCmd(String args[]) throws Exception
    {
        if(CheckPara(args) == false)
        {
            Help();
            return false;
        }

        //match the para
        //if-else,if-else,xxxxxx
        String strFirstPara = args[0];
        String strTmp = UrlArgsSwapToJson(strFirstPara);
        System.out.println(strTmp);
        return true;

    }

    //swap url para to json
    private String UrlArgsSwapToJson(String url)
    {
        String[] arrString = url.split("/?",2);
        String strFinUrl = arrString[0];
        String strUrlArgs = arrString[1];
        // clean \n
        String strTmp = strUrlArgs.replace("\n","");
        strUrlArgs = strTmp;
        //"=" swapto ":"
        strTmp = strUrlArgs.replace("=",":");
        strUrlArgs = strTmp;
        //"&" swapto ",\n" <----have bug, how about [aaa&bbb]?
        strTmp = strUrlArgs.replace("&" swapto ",\n");
        strUrlArgs = strTmp;

        //if String, add "". if Num/bool/[], not add ""


    }

    //display help information
    private boolean Help()
    {
        return true;
    }

    public static void main(String args[])
    {
        UrlArgsSwapJson url = new UrlArgsSwapJson();
        try
        {
            url.ExcuteCmd(args);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }


}
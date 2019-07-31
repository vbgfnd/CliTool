import java.net.PortUnreachableException;

class StrTool
{
    String str;
    public String CreateStrByNum(int num)
    {
        str = "a";
        for(int x=1; x < num; x++)
        {
            str = str + "a";
        }
        return str;
    }
    public static void main(String args[])
    {
        int num = Integer.parseInt(args[0]);
        StrTool strtool = new StrTool();
        System.out.println(strtool.CreateStrByNum(num));
    }
}

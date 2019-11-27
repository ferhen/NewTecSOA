using System;

namespace calculoFrete_win_x64
{
    class Program
    {
        static void Main(string[] args)
        {
            if (args.Length < 1)
            { 
                Console.WriteLine("No state was entered!");
                return;
            }
            string state = args[0];
            switch (state)
            {
                case "SP":
                    Console.WriteLine("15.00");
                    break;
                case "MG":
                case "PR":
                case "RJ":
                case "SC":
                    Console.WriteLine("29.00");
                    break;
                case "DF":
                case "ES":
                case "GO":
                case "MS":
                case "RS":
                    Console.WriteLine("36.00");
                    break;
                case "AL":
                case "BA":
                case "MT":
                case "PB":
                case "PE":
                case "SE":
                case "TO":
                    Console.WriteLine("47.00");
                    break;
                case "AC":
                case "AM":
                case "AP":
                case "CE":
                case "MA":
                case "PA":
                case "PI":
                case "RN":
                case "RO":
                case "RR":
                    Console.WriteLine("54.00");
                    break;
                default:
                    Console.WriteLine("Invalid state entered!");
                    break;
            }
        }
    }
}

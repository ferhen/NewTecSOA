using System;
using System.IO;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using TCPServer.CreditCards;

class Program
{
    public static void Main()
    {
        VisaServer visaServer = new VisaServer(port: 5010);
        Task.Run(() => visaServer.Start());

        Thread.Sleep(1000);

        MastercardServer mastercardServer = new MastercardServer(port: 5011);
        Task.Run(() => mastercardServer.Start());

        Console.ReadKey();
    }
}
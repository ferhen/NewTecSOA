using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace TCPServer.Comms
{
    public abstract class TCPServerBase
    {
        private readonly int port;
        private readonly ConsoleColor color;
        private TcpListener server;

        public TCPServerBase(int port, ConsoleColor color)
        {
            this.port = port;
            this.color = color;
        }

        protected abstract string ProcessReceivedMessage(string message);

        public void Start()
        {
            try
            {
                IPAddress ipAddress = Dns.GetHostEntry("localhost").AddressList[1];
                server = new TcpListener(ipAddress, port);

                server.Start();

                Listen();
            }
            catch (SocketException ex)
            {
                Console.WriteLine("SocketException: {0}", ex);
            }
            finally
            {
                server.Stop();
            }
        }

        private void Listen()
        {
            Console.ForegroundColor = color;
            Console.WriteLine(this.GetType().Name + " Inicializado");
            Console.WriteLine();

            byte[] bytes = new byte[1024];

            while (true)
            {
                Console.ForegroundColor = color;

                TcpClient client = server.AcceptTcpClient();
                Console.ForegroundColor = color;

                NetworkStream stream = client.GetStream();

                int i;

                while ((i = stream.Read(bytes, 0, bytes.Length)) != 0)
                {
                    Console.ForegroundColor = color;
                    string receivedMessage = Encoding.UTF8.GetString(bytes, 0, i);
                    Console.WriteLine("Received: {0}", receivedMessage.TrimEnd());

                    if (receivedMessage.Contains(Environment.NewLine))
                    {
                        string response = ProcessReceivedMessage(receivedMessage);
                        byte[] msg = Encoding.UTF8.GetBytes(response);
                        stream.Write(msg, 0, msg.Length);

                        Console.WriteLine("Sent: {0}", response);
                        Console.WriteLine();
                        Console.ResetColor();
                        break;
                    }
                }
                client.Close();
            }
        }

        protected string BuildErrorMessage(string erroCode) => $"ERROR {erroCode}";
    }
}

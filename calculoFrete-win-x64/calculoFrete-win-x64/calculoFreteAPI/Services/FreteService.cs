using System.Diagnostics;

namespace calculoFreteAPI.Services
{
    public class FreteService
    {
        public static string applicationPath;
        public FreteService() { }

        public string CalcularFrete(string uf)
        {
            var process = new Process()
            {
                StartInfo = new ProcessStartInfo()
                {
                    FileName = applicationPath,
                    Arguments = uf.ToUpper(),
                    RedirectStandardOutput = true,
                    UseShellExecute = false,
                    CreateNoWindow = true,
                }
            };

            process.Start();
            return process.StandardOutput.ReadToEnd();
        }
    }
}

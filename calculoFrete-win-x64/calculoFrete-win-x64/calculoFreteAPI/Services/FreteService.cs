using calculoFreteAPI.Entities;
using System.Diagnostics;

namespace calculoFreteAPI.Services
{
    public class FreteService
    {
        public static string applicationPath;
        public FreteService() { }

        public Result CalcularFrete(string uf)
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
            float result;
            if (float.TryParse(process.StandardOutput.ReadToEnd(), out result))
                return new Result() { valorFrete = result};
            return new Result() { valorFrete = -1 };
        }
    }
}

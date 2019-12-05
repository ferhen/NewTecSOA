using System;

namespace TCPServer.Models
{
    public class VisaMessageModel
    {
        public string CardNumber { get; set; }
        public string CardName { get; set; }
        public string ExpirationDate { get; set; }
        public string TransactionValue { get; set; }
        public string ReceivedValue { get; set; }
        private string TransactionData;

        public string GetTransactionData()
        {
            string transactionId = Guid.NewGuid().ToString();

            TransactionData += transactionId;
            TransactionData += $":{CardName}";
            TransactionData += $":{CardNumber.Substring(CardNumber.Length - 6)}";
            TransactionData += $":{ExpirationDate}";
            TransactionData += $":{TransactionValue}";
            TransactionData += $":{ReceivedValue}";

            return TransactionData;
        }

        public void ClearTransactionData()
        {
            TransactionData = string.Empty;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace TCPServer.Models
{
    public class MastercardMessageModel
    {
        public string CardNumber { get; set; }
        public string CardName { get; set; }
        public string ExpirationDate { get; set; }
        public string TransactionValue { get; set; }
        public string ReceivedValue { get; set; }
        private string TransactionData;

        public MastercardMessageModel()
        {
            CardNumber = string.Empty;
            TransactionData = string.Empty;
        }

        public string GetTransactionData()
        {
            string transactionId = Guid.NewGuid().ToString();

            TransactionData += transactionId;
            TransactionData += $":{CardNumber.Substring(CardNumber.Length - 6)}";
            TransactionData += $":{TransactionValue}";
            TransactionData += $":{ReceivedValue}";

            return TransactionData;
        }

        public void ClearData()
        {
            CardNumber = string.Empty;
            TransactionData = string.Empty;
        }
    }
}

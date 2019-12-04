using System;
using System.Globalization;
using TCPServer.Comms;
using TCPServer.Models;

namespace TCPServer.CreditCards
{
    public class VisaServer : TCPServerBase
    {
        private enum State
        {
            Iddle,
            PaymentRequested,
            CardNumberReceived,
            CardNameReceived,
            ExpirationDateReceived,
            TransactionValueReceived
        }

        private const float taxValue = 0.05f;
        private const string successCommand = "OK";
        private State currentState;
        private VisaMessageModel visaMessageModel = new VisaMessageModel();

        public VisaServer(int port) : base(port, ConsoleColor.Cyan)
        {
            currentState = State.Iddle;
        }

        protected override string ProcessReceivedMessage(string message)
        {
            string returnMessage;
            bool success = false;

            message = message.Trim();

            switch (currentState)
            {
                case State.Iddle:
                    returnMessage = EvaluatePaymentRequestCommand(message, out success);
                    if (success)
                        currentState = State.PaymentRequested;
                    break;

                case State.PaymentRequested:
                    returnMessage = EvaluateCardNumber(message, out success);
                    if (success)
                    {
                        visaMessageModel.CardNumber = message;
                        currentState = State.CardNumberReceived;
                    }
                    break;

                case State.CardNumberReceived:
                    returnMessage = EvaluateCardName(message, out success);
                    if (success)
                    {
                        visaMessageModel.CardName = message;
                        currentState = State.CardNameReceived;
                    }
                    break;

                case State.CardNameReceived:
                    returnMessage = EvaluateExpirationDate(message, out success);
                    if (success)
                    {
                        visaMessageModel.ExpirationDate = message;
                        currentState = State.ExpirationDateReceived;
                    }
                    break;

                case State.ExpirationDateReceived:
                    returnMessage = EvaluateTransactionValue(message, out success);
                    if (success)
                    {
                        visaMessageModel.TransactionValue = message;
                        visaMessageModel.ReceivedValue = (float.Parse(message, CultureInfo.InvariantCulture) * (1 - taxValue)).ToString("0.00", CultureInfo.InvariantCulture);
                        currentState = State.TransactionValueReceived;
                    }
                    break;

                case State.TransactionValueReceived:
                    returnMessage = EvaluateConfirmationCommand(message, out success);
                    if (success)
                    {
                        currentState = State.Iddle;
                    }
                    break;

                default:
                    returnMessage = BuildErrorMessage("3006");
                    break;
            }
            if (!success)
                currentState = State.Iddle;
            return returnMessage;
        }

        private string EvaluatePaymentRequestCommand(string command, out bool success)
        {
            success = false;
            if (command == "PAY")
            {
                success = true;
                return successCommand;
            }
            else
                return BuildErrorMessage("3000");
        }

        private string EvaluateCardNumber(string cardNumber, out bool success)
        {
            success = false;
            if (cardNumber.Length == 16)
            {
                if (cardNumber.StartsWith("4"))
                {
                    success = true;
                    return successCommand;
                }
                else
                    return BuildErrorMessage("3002");
            }
            else
                return BuildErrorMessage("3001");
        }

        private string EvaluateCardName(string cardName, out bool success)
        {
            success = false;
            if (cardName != "")
            {
                success = true;
                return successCommand;
            }
            else
                return BuildErrorMessage("3003");
        }

        private string EvaluateExpirationDate(string expirationDate, out bool success)
        {
            success = false;
            bool parseSuccess = DateTime.TryParse(expirationDate, out DateTime date);
            if (parseSuccess && date > DateTime.Today)
            {
                success = true;
                return successCommand;
            }
            else
                return BuildErrorMessage("3004");
        }

        private string EvaluateTransactionValue(string transactionValue, out bool success)
        {
            success = false;
            bool parseSuccess = float.TryParse(transactionValue, out float value);
            if (parseSuccess && value > 0)
            {
                success = true;
                return successCommand;
            }
            else
                return BuildErrorMessage("3005");
        }

        private string EvaluateConfirmationCommand(string command, out bool success)
        {
            success = false;
            if (command == "COMMIT")
            {
                success = true;
                string returnMessage = successCommand + Environment.NewLine + visaMessageModel.GetTransactionData();
                visaMessageModel.ClearTransactionData();
                return returnMessage;
            }
            else
                return BuildErrorMessage("3000");
        }
    }
}

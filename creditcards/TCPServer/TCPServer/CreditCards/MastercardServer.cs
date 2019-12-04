using System;
using System.Collections.Generic;
using System.Globalization;
using System.Net.Sockets;
using System.Text;
using TCPServer.Comms;
using TCPServer.Models;

namespace TCPServer.CreditCards
{
    public class MastercardServer : TCPServerBase
    {
        private enum State
        {
            Iddle,
            PaymentRequested,
            FirstCardNumberReceived,
            SecondCardNumberReceived,
            ThirdCardNumberReceived,
            FourthCardNumberReceived,
            CardNameReceived,
            ExpirationDateReceived,
            TransactionValueReceived
        }

        private const float taxValue = 0.03f;
        private const string okCommand = "OK";
        private const string proceedCommand = "PROCEED";
        private State currentState;
        private MastercardMessageModel mastercardMessageModel = new MastercardMessageModel();

        public MastercardServer(int port) : base(port, ConsoleColor.DarkYellow)
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
                    returnMessage = EvaluateCardNumber(message, out success, true);
                    if (success)
                    {
                        mastercardMessageModel.CardNumber += message;
                        currentState = State.FirstCardNumberReceived;
                    }
                    break;
                case State.FirstCardNumberReceived:
                    returnMessage = EvaluateCardNumber(message, out success);
                    if (success)
                    {
                        mastercardMessageModel.CardNumber += message;
                        currentState = State.SecondCardNumberReceived;
                    }
                    break;
                case State.SecondCardNumberReceived:
                    returnMessage = EvaluateCardNumber(message, out success);
                    if (success)
                    {
                        mastercardMessageModel.CardNumber += message;
                        currentState = State.ThirdCardNumberReceived;
                    }
                    break;
                case State.ThirdCardNumberReceived:
                    returnMessage = EvaluateCardNumber(message, out success);
                    if (success)
                    {
                        mastercardMessageModel.CardNumber += message;
                        currentState = State.FourthCardNumberReceived;
                    }
                    break;
                case State.FourthCardNumberReceived:
                    returnMessage = EvaluateCardName(message, out success);
                    if (success)
                    {
                        mastercardMessageModel.CardName = message;
                        currentState = State.CardNameReceived;
                    }
                    break;
                case State.CardNameReceived:
                    returnMessage = EvaluateExpirationDate(message, out success);
                    if (success)
                    {
                        mastercardMessageModel.ExpirationDate = message;
                        currentState = State.ExpirationDateReceived;
                    }
                    break;
                case State.ExpirationDateReceived:
                    returnMessage = EvaluateTransactionValue(message, out success);
                    if (success)
                    {
                        mastercardMessageModel.TransactionValue = message;
                        mastercardMessageModel.ReceivedValue = (float.Parse(message, CultureInfo.InvariantCulture) * (1 - taxValue)).ToString("0.00", CultureInfo.InvariantCulture);
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
            {
                mastercardMessageModel.ClearData();
                currentState = State.Iddle;
            }
            return returnMessage;
        }

        private string EvaluatePaymentRequestCommand(string command, out bool success)
        {
            success = false;
            if (command == "PAYMENT")
            {
                success = true;
                return okCommand;
            }
            else
                return BuildErrorMessage("4000");
        }

        private string EvaluateCardNumber(string cardNumber, out bool success, bool isFirstPart = false)
        {
            success = false;
            if (cardNumber.Length == 4)
            {
                if (isFirstPart)
                {
                    int firstTwoDigits = int.Parse(cardNumber.Substring(0, 2));
                    if (!(firstTwoDigits >= 51 && firstTwoDigits <= 55))
                    {
                        return BuildErrorMessage("4002");
                    }
                    else
                    {

                        success = true;
                        return proceedCommand;
                    }
                }
                else
                {
                    success = true;
                    return proceedCommand;
                }   
            }
            else
                return BuildErrorMessage("4001");
        }

        private string EvaluateCardName(string cardName, out bool success)
        {
            success = false;
            if (cardName != "")
            {
                success = true;
                return proceedCommand;
            }
            else
                return BuildErrorMessage("4003");
        }

        private string EvaluateExpirationDate(string expirationDate, out bool success)
        {
            success = false;
            bool parseSuccess = DateTime.TryParse(expirationDate, out DateTime date);
            if (parseSuccess && date > DateTime.Today)
            {
                success = true;
                return proceedCommand;
            }
            else
                return BuildErrorMessage("4004");
        }

        private string EvaluateTransactionValue(string transactionValue, out bool success)
        {
            success = false;
            bool parseSuccess = float.TryParse(transactionValue, out float value);
            if (parseSuccess && value > 0)
            {
                success = true;
                return proceedCommand;
            }
            else
                return BuildErrorMessage("4005");
        }

        private string EvaluateConfirmationCommand(string command, out bool success)
        {
            success = false;
            if (command == "COMMIT")
            {
                success = true;
                string returnMessage = okCommand + Environment.NewLine + mastercardMessageModel.GetTransactionData();
                mastercardMessageModel.ClearData();
                return returnMessage;
            }
            else
                return BuildErrorMessage("4000");
        }
    }
}

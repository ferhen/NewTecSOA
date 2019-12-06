from flask import Flask, request

from juddi import get_ws_url
from ws_util import get_ws_client, parse_response
from config import JUDDI_QUERY_URL, CEP_SERVICE_USER, CEP_SERVICE_PASSWORD

app = Flask(__name__)


@app.route("/getCep/<cep>")
def getCep(cep):
    ws_url = get_ws_url(JUDDI_QUERY_URL)    
    ws_client = get_ws_client(ws_url + "?wsdl",
        CEP_SERVICE_USER,
        CEP_SERVICE_PASSWORD)
    cep_info = ws_client.service.getCepInfo(cep)
    response = parse_response(cep_info)
    return response

if __name__ == "__main__":
    app.run(debug=True)
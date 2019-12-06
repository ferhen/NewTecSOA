import requests
import suds.client
import suds_requests


def get_ws_client(ws_url, ws_user, ws_password):
    session = requests.Session()
    session.auth = (ws_user, ws_password)
    return suds.client.Client(ws_url, transport=suds_requests.RequestsTransport(session))

def parse_response(cep_info):
    return suds.client.Client.dict(cep_info)

if __name__ == '__main__':
    None
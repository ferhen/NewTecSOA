import requests

def get_ws_url(juddi_url):
    r = requests.get(juddi_url)
    return(r.json()['uriContainer']['uriList'])

if __name__ == "__main__":
    None
# TCP and HTTP Server

This is a simple TCP and HTTP server implemented in Java. The server listens for commands sent over TCP connections and responds accordingly. Additionally, it accepts HTTP requests and provides responses based on the requested commands.

## TCP Server

`telnet 192.168.154.85 1234`

The TCP server handles commands sent over TCP connections. The following commands are supported:

- `{"cmd":"for_man"}`: Retrieves products for men.
- `{"cmd":"for_woman"}`: Retrieves products for women.
- `{"cmd":"sorted_by_name"}`: Retrieves products sorted by name.
- `{"cmd":"sorted_by_price"}`: Retrieves products sorted by price.

To interact with the TCP server, you can establish a TCP connection and send the desired command as a string.

## HTTP Server

The HTTP server handles both GET and POST requests. The available commands are the same as for the TCP server:

- `GET /?cmd=for_man`: Retrieves products for men.
- `GET /?cmd=for_woman`: Retrieves products for women.
- `GET /?cmd=sorted_by_name`: Retrieves products sorted by name.
- `GET /?cmd=sorted_by_price`: Retrieves products sorted by price.
- `POST /`: Accepts a `cmd` parameter in the request body to execute the corresponding command.

### Using GET Requests

To send a GET request to the HTTP server, you can use tools like cURL or a web browser. Here are the cURL examples for the supported commands:

```bash
curl "http://192.168.154.85:8000/?cmd=for_man"
curl "http://192.168.154.85:8000/?cmd=for_woman"
curl "http://192.168.154.85:8000/?cmd=sorted_by_name"
curl "http://192.168.154.85:8000/?cmd=sorted_by_price"
```

Replace `192.168.154.85:8000` with the appropriate IP address and port of your server.

### Using POST Requests

To send a POST request to the HTTP server, you can also use cURL. Here are the cURL examples for the supported commands:

```bash
curl -X POST "http://192.168.154.85:8000" -d "cmd=for_man"
curl -X POST "http://192.168.154.85:8000" -d "cmd=for_woman"
curl -X POST "http://192.168.154.85:8000" -d "cmd=sorted_by_name"
curl -X POST "http://192.168.154.85:8000" -d "cmd=sorted_by_price"
```

Replace `192.168.154.85:8000` with the appropriate IP address and port of your server.

## Disclaimer

Please note that this is a basic implementation provided for demonstration purposes. In a real-world scenario, you would need to handle error cases, validate inputs, and ensure proper security measures are in place.
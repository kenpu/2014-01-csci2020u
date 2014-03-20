from socket import *
import sys

port = 2001
if sys.argv[1:]:
    port = int(sys.argv[1])

main = socket(AF_INET, SOCK_STREAM)
main.bind(('', port))
main.listen(5)

def handle(comm):
    # handle the communicating socket
    print "Waiting for incoming line"
    line = comm.recv(1024)
    print "Server received: %s" % line
    while line:
        if 'bye' in line:
            break
        reply = '(py) you have just said "%s"' % line
        print "sending reply"
        comm.send(reply)
        print "reply sent."
        line = comm.recv(1024)

while True:
    print "Accepting new connection..."
    comm, addr = main.accept()
    print "New connection established."
    handle(comm)
    comm.close()

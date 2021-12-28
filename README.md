This is the server part of the tattle app

It is a Spring Boot application designed to perform book-keeping tasks of chat rooms, users and their memberships.
We have used a Postgres DB for storage purposes.
Although there is a redis container mentioned in the docker compose file the server doesn't directly use it.
Instead client interacts with the redis server directly for chat synchronization.


Since we understand that setup will be time consuming we have dockerized the entire application. 
So you just need a single command to bring the entire stack online ;)

Setup Steps:

1. Install docker

2. Go to directory where the repository is cloned and execute the following:

docker-compose up

Tattle Client repo: https://github.com/JackSparrow999/tattle_client (Checkout the readme as well!)

Happy tattling!

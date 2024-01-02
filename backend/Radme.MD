docker build -t --tag app_backend:latest .

docker-compose up --build -d
docker compose up -d
docker compose down --rmi all
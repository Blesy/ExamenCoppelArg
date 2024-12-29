# Use the official MySQL Docker image
FROM mysql:latest

ADD script.sql /docker-entrypoint-initdb.d/script.sql
RUN chmod -R 775 /docker-entrypoint-initdb.d

# Set the MySQL root password (replace with your desired password)
ENV MYSQL_ROOT_PASSWORD=admin

# Set a non-root user and password (replace with your desired username and password)
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=admin

# (Optional) Create a new database (replace with your desired database name)
ENV MYSQL_DATABASE=store

# Expose the MySQL port
EXPOSE 3306
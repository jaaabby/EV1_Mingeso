FROM postgres:latest

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=0909
ENV POSTGRES_DB=BDMin

COPY bdmingeso.sql /

EXPOSE 5432

COPY restore-database.sh /docker-entrypoint-initdb.d/restore-database.sh

RUN chmod +x /docker-entrypoint-initdb.d/restore-database.sh

#!/bin/bash

create_db_user_pass() {
    psql -Upostgres -dpostgres -c "CREATE USER $2 WITH PASSWORD '$3'"
    psql -Upostgres -dpostgres -c "CREATE DATABASE $1 OWNER=$2"
}

create_db_user_pass jpa_transactional_demo_db  jpa_transactional_demo_user  jpa_transactional_demo_pass
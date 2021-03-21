@echo off

call docker-compose -f docker-compose.yml build
call docker-compose -f docker-compose.yml %*

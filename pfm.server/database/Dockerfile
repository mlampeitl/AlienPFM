FROM postgres
MAINTAINER Michael Lampeitl <michael.lampeitl@alientec.net>

#
# Installing Software
# vim, ip
RUN set -eux; \
	apt-get update; \
	apt-get upgrade -y; \
	apt-get install -y vim iproute2

#
# Create OS user pfm
RUN set -eux; \
	groupadd --gid=1604 pfm; \
	useradd --uid=1604 --gid=1604 --create-home --system pfm

#
# Create OS user pfmtest
RUN set -eux; \
	useradd --uid=1605 --gid=1604 --create-home --system pfmtest

#
# Default DB Name
ENV POSTGRES_DB docker_tmp

#Copy the DB creation script to image
COPY create_db.sql /docker-entrypoint-initdb.d

#!/bin/bash

# Start ssh
/usr/sbin/sshd

# Starts php process in background
/usr/sbin/php-fpm -c /etc/php.ini

# Starts nginx daemon
nginx -g 'daemon off;'

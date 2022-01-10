FROM remote-host

RUN yum -y install epel-release
RUN yum -y update

RUN yum -y install nginx

RUN yum -y install https://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm
RUN yum -y install https://rpms.remirepo.net/enterprise/remi-release-7.rpm
RUN yum -y install yum-utils
RUN yum-config-manager --disable 'remi-php*'				&& \
    yum-config-manager --enable   remi-php73

RUN yum -y update --nobest

RUN yum -y --enablerepo=remi-php73 install 				   \
 php-fpm								   \
 php-cli								   \
 php-mysqlnd							   	   \
 php-soap								   \
 php-xml								   \
 php-zip								   \
 php-json								   \
 php-mbstring							   	   \
 php-zip								   \
 php-gd
					
EXPOSE 80 443

VOLUME /var/www/html /var/log/nginx /var/log/php-fpm /var/lib/php-fpm

COPY ./conf/nginx.conf /etc/nginx/nginx.conf

RUN /usr/sbin/sshd

RUN mkdir -p run/php-fpm

COPY ./bin/start.sh /start.sh

RUN chmod +x /start.sh

CMD /start.sh
